#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <errno.h>


void traitement_signal(int sig) {
    printf("Signal %d recu\n", sig);
}


int main(int argc, char *argv[]) {
    int n = atoi(argv[1]);
    int m = atoi(argv[2]);
    pid_t pid;
    pid_t p = getpid();
    sigset_t masque;
    struct sigaction action;

    // installation du gestionnaire de signal pour SIGUSR1
    action.sa_handler = traitement_signal;
    sigemptyset(&action.sa_mask);
    sigaddset(&action.sa_mask, SIGUSR1);
    
        
    if(sigaction(SIGUSR1, &action, NULL) == -1) {
        perror("sigaction");
        exit(1);
    }


    for(int i = 1;i<=n;i++){
        pid = fork();
                
        if(pid==0){
            printf("\tJe suis le fils %d, mon père est %d. n=%d\n", getpid(), getppid(), i);
            if(i==n){
                printf(" et je suis le dernier fils\n");
            }
            // chaque fils envoie un signal à son père SIGUSR1 puis attend un signal SIGUSR1 de son fils
            for(int j = 0;j<m;j++){
                kill(getppid(), SIGUSR1);
            }
        } else {
            // le père attend un signal SIGUSR1 de son fils
        
            printf("Je suis le père %d, mon fils est %d. Je l'attends\n", getpid(), pid);
            sigsuspend(&masque);
            exit(0);
                    
        }
    }



}