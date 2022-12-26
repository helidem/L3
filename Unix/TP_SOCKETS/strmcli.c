/*
le client invite l'utilisateur à entrer une chaine de charactères. il se connecte ensuite au serveur puis il envoie la chaine de charactères entrée par l'utilsiateur? enin il se termine.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/un.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>

#define MAX 80

int main(int argc, char** argv) {
    // argv[1] = nom de la machine du serveur
    // argv[2] = numéro de port du serveur


    int port = atoi(argv[2]);
    char message[MAX];
    struct hostent *hp;
    hp = gethostbyname(argv[1]);
    if(hp == NULL) {
        perror("erreur lors de la recherche de l'adresse IP du serveur");
        exit(1);
    }


    struct sockaddr_in serveur;
    serveur.sin_family = hp->h_addrtype;
    serveur.sin_port = htons(port);
    bcopy(hp->h_addr, &serveur.sin_addr, hp->h_length);
    int sock, r;

    // demande de la chaine de charactères à envoyer
    printf("Entrez une chaine de charactères: ");
    fgets(message, MAX, stdin);

    // creation de la socket
    sock = socket(AF_INET, SOCK_STREAM, 0);
    if(sock < 0) {
        perror("erreur lors de la creation de la socket");
        exit(1);
    }

    // connexion au serveur
    r = connect(sock, (struct sockaddr *)&serveur, sizeof(serveur));
    if(r < 0) {
        perror("erreur lors de la connexion au serveur");
        exit(1);
    }

    // envoi de la chaine de charactères
    r = send(sock, message, strlen(message), 0);

    // fermeture de la socket


    exit(0);    
}