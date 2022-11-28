// fils j'attends puis j'envoie
// pere j'envois puis j'attends
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <errno.h>

// affich mask

// attente signal

void reception_signal(int sig) {
    int expediteur;
    if(mon_numero==nb_processus)
        expediteur = 1;
    else
        expediteur = mon_numero+1;
    
    printf("\n%sP%d: Recu signal de P%d", tab, mon_numero, expediteur);
    affich_mask("\t- Masque: ", NULL);
    nb_signaux_recus++;
    return;
}

void envoi_signal(int numero_processus, int destinataire){
    sigset_t set_signaux;

    printf("%sP%d: Envoi signal à P%d", tab, mon_numero, destinataire);
    affich_mask("\t- Masque: ", NULL);
    if(kill(P))
}


int main(int argc, char *argv[]) {
    int n = atoi(argv[1]);
    int m = atoi(argv[2]);
    int mon_numero;
    action.sa_handler = traitement_signal;
    sigemptyset(&action.sa_mask);
    if(sigaction(SIGUSR1, &action, NULL) == -1) {
        perror("sigaction");
        exit(1);
    }

    for(i=2;i<=n;i++){
        // ici sigusr1 est bloqué dans le masque courant
        // le signal sigusr1 est masqué chez le père
if(P[i]==0){
        nb_signaux_recus = 0;
        mon_numero=i;
        destinataire = i-1;
        printf("\tP%d",mon_numero);
        
        for(i=1;i<=m;i++){
            envoi
        }
    }
    }
}