/*
Ecrire le programme d'un shell simplifié capable d’exécuter, en premier plan ou en
arrière plan, n’importe quelle commande entrée par l’utilisateur avec un nombre
arbitraire de paramètres.
Fonctions utiles:
 fork,
 wait,
 exit,
 execvp,
 fgets,
 strtok,
 strrchr,
 strlen,
 strcpy,
 malloc.
*/

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

main() {
    char cmd[80];
    int etatfils, i, pid;
    char *cmd2[80];
    printf("> ");
    while (fgets(cmd, 79, stdin) != NULL) {
        char *token = strtok(cmd, " ");
        int i = 0;
        while (token != NULL) {
            cmd2[i] = token;
            token = strtok(NULL, " ");
            i++;
        }
        // on enleve le retour chariot
        cmd2[i - 1][strlen(cmd2[i - 1]) - 1] = '\0';
        if ((pid = fork()) != 0) { // PERE
            wait(&etatfils);
            printf("Code de retour = %d\n", WEXITSTATUS(etatfils));
            printf("> ");
        } else { // FILS
            cmd2[i] = '\0';
            execvp(cmd2[0], cmd2);
            perror("Erreur à l'execl");
            exit(1);
        }
    } //while
} //main