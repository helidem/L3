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
    int fd2 = open(argv[1], O_RDWR);
    // lecture/ecriture dans ce fichier

    write(fd,"ab",2*sizeof(char));
    int cur = lseek(fd, 0, SEEK_CUR);
    printf("cur: %d\n", cur);
    write(fd,"cd",2*sizeof(char));
    cur = lseek(fd, 0, SEEK_CUR);
    printf("cur: %d\n", cur);

    
    

    //write(fd2,"EF",2*sizeof(char));
    int cur2 = lseek(fd2, 0, SEEK_CUR);
    cur = lseek(fd, 0, SEEK_CUR);

    printf("cur: %d\n", cur);
    printf("cur2: %d\n", cur2);
    
    
}