#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <time.h>

int main(int argc, char* argv[]){
    // creation du fichier vide
    int fd;

    fd = open(argv[1], O_RDWR | O_CREAT | O_TRUNC, 0644);
    if(fd == -1){
        perror("open");
        exit(-1);
    }

    // position de la tete courante de lecture/ecriture à la 10000eme place

    int place = lseek(fd, 10000, SEEK_SET);
    printf("Offset retourné par lseek : %d\n",place);   
    // ecriture du caractere 'b'
    char c = 'b';
    write(fd,&c, sizeof(char));

}