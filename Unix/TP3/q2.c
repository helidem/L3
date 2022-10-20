#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <time.h>


char *typeFichier(mode_t *st_mode){
    char* ptr;
    if (S_ISREG(*st_mode)) ptr = "regular";
else if (S_ISDIR(*st_mode)) ptr = "directory";
else if (S_ISCHR(*st_mode)) ptr = "character special";
else if (S_ISBLK(*st_mode)) ptr = "bloc special";
else if (S_ISFIFO(*st_mode)) ptr = "fifo";
else if (S_ISLNK(*st_mode)) ptr = "symbolic link";
else if (S_ISSOCK(*st_mode)) ptr = "socket";
else ptr = "** unknown mode **";

return ptr;
}


int main(int argc, char* argv[]){
    if(argc != 2)
    {
        printf("usage : ./programme <nom du fichier>\n");
        exit(-1);
    }

    struct stat buf;

    // ouverture du fichier
    int fd = open(argv[1], O_RDONLY);
    if(fd == -1)
    {
        perror("open");
        exit(-1);
    }

    // recuperation des informations du fichier
    if(fstat(fd, &buf) == -1)
    {
        perror("fstat");
        exit(-1);
    }

    // type de fichier
    char *type = typeFichier(&buf.st_mode);
    
    // numero d'inode
    ino_t inode = buf.st_ino;

    // la protection
    mode_t protection = buf.st_mode;

    // le nombre de liens physiques
    nlink_t nbLiens = buf.st_nlink;

    // l'uid du proprietaire
    uid_t uidProprietaire = buf.st_uid;

    // l'id du groupe
    gid_t idGroupe = buf.st_gid;

    // la taille du fichier
    off_t tailleFichier = buf.st_size;

    // la taille de bloc
    long tailleBloc = buf.st_blocks;

    // l'heure du dernier acces
    time_t heure = buf.st_atime;

    // formattage heure dans un format lisible avec ctime()
    char *heureLisible = ctime(&heure);

    // affichage des informations
    printf("inode : %d\n", inode);
    printf("protection : %d\n", protection);
    printf("nombre de liens : %d\n", nbLiens);
    printf("uid proprietaire : %d\n", uidProprietaire);
    printf("id groupe : %d\n", idGroupe);
    printf("taille du fichier : %d\n", tailleFichier);
    printf("taille de bloc : %d\n", tailleBloc);
    printf("heure du dernier acces : %s", heureLisible);
    printf("type de fichier : %s\n", type);

    // fermeture du fichier
    close(fd);

}