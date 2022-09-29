#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#define NB_ARGUMENT 16

int main(int argc, char **argv, char* envi[]){

    // transmis sous la forme d'un tableau de chaînes de caractères avec execv
    /* char *argv_exec[NB_ARGUMENT]; int indice;

    if(argc < 2){
        printf("Usage : programme commande liste_argument\n");
        exit(1);
    }

    for(indice = 0; indice < argc; indice++){
        argv_exec[indice] = argv[indice + 1];
    }
    argv_exec[indice]=NULL;
    execvp(argv_exec[0], argv_exec); // on utilise la fonction execvp pour lancer la commande en regardant le PATH
    // ou tout simplement : execv(argv[1],&argv[1]);
    exit(2);*/

    // transmis sous la forme d'une chaîne de caractères avec execl
  /*  if(argc < 2){
        printf("Usage : programme commande liste_argument\n");
        exit(1);
    }
    execl(argv[1], argv[1], NULL); // execute uniquement les programmes dans le répertoire courant
    perror(argv[1]);
    exit(2);*/
    
    // printf("%s\n",env[atoi(argv[1])]);
    // premier cas : conservation du même environnement
    // execve(argv[1], &argv[1], environ);

    // loop through environment
    

    char *env[3];
    env[0] = "test=1";
    env[1] = NULL;
    
    execle("./affiche", "affiche", NULL, env);
}