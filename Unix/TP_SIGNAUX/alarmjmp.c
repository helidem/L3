#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <errno.h>
#include <setjmp.h>

sigjmp_buf env;
unsigned int sec = 2;

void traitement_signal(int signal) {
    sec++;
    siglongjmp(env, 1);
}

int main(int argc, char ** argv) {
    int tab[5];
    int tentatives[5];
    int temps[5];
    int fin = 0;
    int i = 0;
    struct sigaction action;
    action.sa_handler = traitement_signal;
    sigemptyset( & action.sa_mask);
    sigaddset( & action.sa_mask, SIGALRM);
    if (sigaction(SIGALRM, & action, NULL) == -1) {
        perror("sigaction");
        exit(1);
    }

    for (int i = 0; i < 5; i++) {
        tentatives[i] = 0;
    }
    int s;
    for (int i = 0; i < 5;) {
        //printf("[DEBUG] Dans le while\n");
        tentatives[i]++;
        s = sigsetjmp(env, 1);
        //if (s == 0) {
            int restant = alarm(sec);
            printf("\nEntrez la valeur %d: ", i + 1);
            if (scanf("%d", & tab[i]) == 1) {
                alarm(0);
                temps[i] = sec;
                i++;
                sec = 2;
            }
 //       }
    }
    printf("Voici les valeurs que vous avez entrées et le nombre de tentatives associées:\n");
    for (int j = 0; j < 5; j++) {
        printf("Valeur %d: %d, tentatives: %d, temps %d\n", j + 1, tab[j], tentatives[j], temps[j]);
    }
    return 0;
}