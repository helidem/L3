/* affiche les variables d'environnement */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char **argv, char* envp[]){
    int i = 0;
    for(;*envp != NULL; *envp++){
        printf("%s\n", *envp);
    }
}