#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

pid_t mon_groupe, mon_leader;

void main(int argc, char *argv[]) {
    /*
    mon_leader = getpgrp();
    if(mon_leader == -1) {
        perror("getpgrp");
        exit(EXIT_FAILURE);
    }

    printf("Mon pid est %d, mon leader de mon groupe est %d\n", getpid(), mon_leader);
    */

   pid_t fils;
    fils = fork();
    if(fils == -1) {
        perror("fork");
        exit(EXIT_FAILURE);
    }
    if(fils == 0) {
        // fils

        mon_leader = getpgrp();
        if(mon_leader == -1) {
            perror("getpgrp");
            exit(EXIT_FAILURE);
        }
        printf("Je suis le fils - Mon pid est %d, mon leader de mon groupe est %d", getpid(), mon_leader);
        pause();
        printf("fils - fin du programme");
        fflush(stdout);
        exit(EXIT_SUCCESS);
    }
    else {
        // pere
        mon_leader = getpgrp();
        if(mon_leader == -1) {
            perror("getpgrp");
            exit(EXIT_FAILURE);
        }
        printf("Je suis le père - Mon pid est %d, mon leader de mon groupe est %d\n", getpid(), mon_leader);
        sleep(30);
        printf("pere - fin du programme");
        exit(EXIT_SUCCESS);
    }
}
