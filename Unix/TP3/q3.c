#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <time.h>

int main(int argc, char* argv[]){
    int nb_lus;



    // ouverture du fichier
    int fd = open(argv[1], O_RDONLY);
    if(fd == -1)
    {
        perror("open");
        exit(-1);
    }


    // verifier si le fichier est regulier
    struct stat buf;
    fstat(fd, &buf);
    if (!S_ISREG(buf.st_mode)){
        printf("Le fichier n'est pas régulier\n");
        exit(-1);
    }
    
    // verifier que le fichier destinataire n'existe pas (o_excl)
    int fd2 = open(argv[2], O_CREAT|O_RDWR | O_EXCL, 0666);
    if(fd2 == -1){
        perror("open");
        exit(-1);
    }


    // lecture de l'octet et ecriture de cet octet dans l'autre fichier (append)
    int taille_buffer = atoi(argv[3]);
    char* buffer;
    buffer = malloc(taille_buffer);
    for(nb_lus=read(fd, buffer, taille_buffer); nb_lus>0; nb_lus=read(fd, buffer, taille_buffer)){
        write(fd2, buffer, nb_lus); // nblus au lieu de taille_buffer car on ne sait pas si on a lu tout le buffer
    }

    // fermeture des fichiers
    close(fd);
    close(fd2);

    // plus le buffer est grand, moins le temps d'execution est grand. On fait moins appel au primitives system d'entrée sortie


}