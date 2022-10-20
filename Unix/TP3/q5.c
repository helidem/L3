#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <time.h>
#include <fcntl.h>
#include <errno.h>
#include <string.h>
int main(int argc, char* argv[]){
    // programme qui illustre la mise en oeuvre et le fonctionnement des verrous sur les fichiers en utilisant la primitive fcntl
    // ./programme nom_fichier type_verrou debut_zone longueur_zone 

    struct flock verrou;
    int fd;
    fd = open(argv[1], O_RDWR);
    
    // type verrou
    if(strcmp(argv[2],"x")==0){
        verrou.l_type = F_WRLCK;
    } else if (strcmp(argv[2],"s")==0){ // verrou partage
        verrou.l_type = F_RDLCK;
    } else if (strcmp(argv[2], "l")==0) { // livre verrou
        verrou.l_type = F_UNLCK;
    } else {
        fprintf(stderr, "Usage: %s <fichier> <catego> <debut_z> <long_z>\n", argv[2]);
        exit(-1);
    }

    // zone du verrou
    verrou.l_whence = SEEK_SET;
    verrou.l_start = atoi(argv[3]);
    verrou.l_len = atoi(argv[4]);
    int a = 0;
    while (fcntl(fd, F_SETLK, &verrou) == -1){
        if (errno == EACCES || errno == EAGAIN){
            if(a==0)
                {
                    printf(">> Verrou deja pris zone [%d,%d]\n",verrou.l_start,verrou.l_start+verrou.l_len);
                }                
                a++;
            }
            continue;
        }
    
    printf("verrou posé par %d\n",getpid());
    while (1)
    {
        /* code */
    }
    
}