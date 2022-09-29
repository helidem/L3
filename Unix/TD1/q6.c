#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

void fin_A(){
    printf("Fonction A terminee\n");
}

void fin_B(){
    printf("Fonction B terminee\n");
}


int main(int argc, char *argv[]) {
    printf("Debut du programme\n");
    atexit(fin_A);
    atexit(fin_B);

    printf("Fin du programme "); // pas de \n donc pas de vidage du stdout
    //fflush(stdout); // on vide le stdout
    // exit(EXIT_SUCCESS);
    _exit(EXIT_SUCCESS);
}