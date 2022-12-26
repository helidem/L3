#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/un.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>

int main(int argc, char** argv) {
    int port = atoi(argv[1]);
    int sock, r;
    struct sockaddr_in serveur, client;
    char message[80];
    char nom[80];
    struct hostent *hp;
    int lg = sizeof(client);

    gethostname(nom, 80);

    hp = gethostbyname(nom);
    if(hp == NULL) {
        perror("erreur lors de la recherche de l'adresse IP du serveur");
        exit(1);
    }

    serveur.sin_family = hp->h_addrtype;
    serveur.sin_port = htons(port);
    bcopy(hp->h_addr, &serveur.sin_addr, hp->h_length);

    // creation de la socket
    sock = socket(AF_INET, SOCK_STREAM, 0);
    if(sock < 0) {
        perror("erreur lors de la creation de la socket");
        exit(1);
    }

    // liaison de la socket
    r = bind(sock, (struct sockaddr *)&serveur, sizeof(serveur));
    if(r < 0) {
        perror("erreur lors de la liaison de la socket");
        exit(1);
    }

    // mise en attente de connexion
    r = listen(sock, 5);
    if(r < 0) {
        perror("erreur lors de la mise en attente de connexion");
        exit(1);
    }

    while(1) {
        printf("ATTENTE D'UNE CONNEXION...\n");
        // acceptation de la connexion
        r = accept(sock, (struct sockaddr *)&client, &lg);
        if(r < 0) {
            perror("erreur lors de l'acceptation de la connexion");
            exit(1);
        }
        printf("JE TRAITE LA CONNEXION QUI VIEN D'ARRIVER DE %d:%d\n", inet_ntoa(client.sin_addr), client.sin_port);
        // reception du message
        r = recv(r, message, 80, 0);
        if(r < 0) {
            perror("erreur lors de la reception du message");
            exit(1);
        }
	
        //printf("%s\n", gethostbyname(client.sin_addr));
        printf("RECUS %d CARACTERES", r);
        
        if(strcmp(message, "#") == 0) {
            printf("FIN DE SERVICE\n");
            exit(0);
        }

        printf("%s\n", message);
	close(r);
        printf("====================================\n");
    }

}