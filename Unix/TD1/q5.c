#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {
    // création de 5 processus
      for(int i=0;i<5;i++)
    {
        if(fork() == 0)
        {
            // dans le fils
            // on va rentrer dans une boucle assez longue pour permettre l'observation
            sleep(10);
            exit(i);
            
        }
    }
    // dans le père
    // le père attend la fin de tous les fils et affiche combien de fils restent, le pid du fils terminé 
    // et la valeur du exit : 
    for(int i=0;i<5;i++)
    {
        int status;
        int pid = wait(&status);
        if(WIFSIGNALED(status) != 0){
            printf("Le fils s'est terminé anormalement, signal %d\n", WTERMSIG(status));

        } else {
            printf("Le fils avec le pid %d est terminé avec la valeur du exit : %d \n",pid, WEXITSTATUS(status));
        }
        
        printf("Il reste %d fils \n", 4-i);
    }
   
}