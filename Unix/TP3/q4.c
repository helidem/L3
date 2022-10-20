#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <time.h>

#define STD_ERR 2

int main(int argc, char* argv[]){
    int fdErr;

    if(argc != 2)
    {
        fprintf(stderr, "Usage: %s <fichier>\n", argv[0]);
        exit(-1);
    }

    // ouverture du fichier
    fdErr = open(argv[1], O_WRONLY | O_CREAT | O_TRUNC, 0666);
    if(fdErr == -1)
    {
        perror("open");
        exit(-1);
    }

    // redirection de la sortie standard vers le fichier
    // fermerture de la sortie standard des erreurs

    if(close(STD_ERR) == -1){ // si on utilise dup2, on a pas besoin de fermer la sortie standard des erreurs
        perror("close STD_ERR");
        exit(-1);
    }
    
    if(dup(fdErr) == -1){ // il cherche la premiere place libre dans la table des descripteurs de fichiers
        perror("dup");
        exit(-1);
    }

    fprintf(stderr, "Bonjour\n");
}