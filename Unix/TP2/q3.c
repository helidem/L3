/*Le shell

ecrire le programme d'un shell simplifié capable d'exécuter, en premier plan ou en arrière plan, n'importe quelle commande entrée par l'utilisateur avec un nombre arbitraire de paramètres.
Fonctions utiles : 
fork
wait
exit
execvp
fgets
strtok
strrchr
strlen
strcpy
malloc*/
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <errno.h>

#define MAX 256
#define MAX_ARG 16

int main(int argc, char* argv[]){
    char cmd[MAX];
    char *argv_exec[MAX_ARG];
    int indice;
    int pid;
    int statusfils;

    printf("> ");
    while(fgets(cmd, MAX, stdin) != NULL){
        if((pid=fork()) != 0){
            if(strrchr(cmd, '&') == NULL){
                waitpid(pid, &statusfils, 0);
            } else {
                printf("pid du processus fils : %d\n", pid);
            }
            printf("> ");
        } else {
            
        }
    }
}