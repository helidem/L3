// programme qui crée un fichier en lecture/écriture. si le fichier existe deja, une erreur doit etre retournée

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/types.h>

int main(int argc, char* argv[]){
    if(argc!=2){
        printf("usage: %s <nom_fichier>", argv[0]);
        exit(1);
    }

    if(open(argv[1], O_CREAT | O_RDONLY, 0755)==-1){
        perror("open");
        exit(1);
    }
}