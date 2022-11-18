/**
 * @file q1.c
 * @brief Ce fichier contient le code source de la question 1 du tp sur les tubes
 * @author Youcef MEDILEH
 * @version 1.0
*/

/*
Ecrire un programme qui permet à un processus de communiquer des données, entrées par l’utilisateur, à un processus fils via des tubes ordinaires. Le fils affiche les données transmises par son père.
*/


#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[])
{
    int tube[2];
    char message[80];
    char buffer[100];
    printf("Entrez un message pour le communiquer au processus fils : ");
    scanf("%s",&message);

    pipe(tube);

    if(fork()==0){ // fils
        close(tube[1]);
        read(tube[0], buffer, 80);
        printf("Le processus fils a lu : %s\n", buffer);
        // le fils va envoyer un message au père
        write(tube[1], "Bonjour père", 80);
        close(tube[0]);        
    
    } else { // pere
        close(tube[0]);
        write(tube[1], message, 80);
        // attendre 5 secondes
        sleep(5);
        read(tube[0], buffer, 80);
        printf("Le processus père a lu : %s\n", buffer);
        close(tube[1]);
    }
}