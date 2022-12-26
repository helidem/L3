// même chose que strmserv mais de façon concurrente

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/un.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>

int main(int argc, char** argv) {
    int port, sock, msgsock, rval;
    struct sockaddr_in server, client;
    char buf[1024];
    port = atoi(argv[1]);
    char nom[100];
    struct hostent *hp;
    int longueur = sizeof(client);

    gethostname(nom, 100);

    hp = gethostbyname(nom);
    if (hp == NULL)
    {
        perror("gethostbyname");
        exit(1);
    }
    
    sock = socket(AF_INET, SOCK_STREAM, 0);
    if (sock < 0) {
        perror("opening stream socket");
        exit(1);
    }
    server.sin_family = hp->h_addrtype;
    server.sin_port = htons(port);
    bcopy((char *) hp->h_addr, (char *) &server.sin_addr, hp->h_length);

    // liaison de la socket
    if (bind(sock, (struct sockaddr *) &server, sizeof (server))) {
        perror("binding stream socket");
        exit(1);
    }

   
// écoute de la socket
        listen(sock, 5);
     while(1){
        
        printf("ATTENTE DE CONNEXION...\n");
        msgsock = accept(sock, (struct sockaddr *) &client, &longueur);
        if (msgsock == -1)
            {perror("accept");exit(1);}
        else{
            switch (fork()) {
                case 0: // fils
                    close(sock);
                    printf("JE TRAITE LA CONNEXION...\n");
                    rval = recv(msgsock, buf, 1024, 0);
                    printf("RECUS %d CARACTERES", rval);
                    if(strcmp(buf, "#") == 0) {
                        printf("FIN DE SERVICE\n");
                        exit(0);
                    }
                    else {
                        printf("MESSAGE : %s\n", buf);
                        send(msgsock, buf, rval, 0);
                    }
                    close(msgsock);
                    printf("=====================\n");
                    exit(0);
                    break;
                default: // père
                    close(msgsock);
                    break;
            }
        }
    }

}