#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <errno.h>

unsigned int sec = 2;

void traitement_signal(int signal) {
    // traitement du signal de l'alarme
    // printf("\nVous avez pris trop de temps ! Veuillez entrer la valeur, vous avez plus de temps (%d)\n", sec);
    sec++;
}

int main(int argc, char** argv){
    // programme qui lit 5 données depuis l'entrée standard et les sauvegarde dans un tableau
    // pour chaque donnée, il doit faire une requete à l'utilisateur en affichant un message lui demandant de l'introduire
    // si la donnée n'est pas introduite au bout d'un certain temps, le programme réitère la demande jusqu'à ce que la donnée soit introduite
    // a chaque reiteration, le programme augmente le temps d'attente
    // si la donnée est introduite, le programme passe à la donnée suivante
    // le programme doit utiliser alarm()
    // le programme doit utiliser sigaction()

    int tab[5];
    int tentatives[5];
    int temps[5];
    int fin = 0;
    int i = 0;
    struct sigaction action;
    action.sa_handler = traitement_signal;
    sigemptyset(&action.sa_mask);
    sigaddset(&action.sa_mask, SIGALRM);
    if(sigaction(SIGALRM, &action, NULL) == -1) {
        perror("sigaction");
        exit(1);
    }

    for(int i = 0;i<5;i++){
        tentatives[i] = 0;
        temps[i] = 0;
    }

    while(i<5){
        //printf("[DEBUG] Dans le while\n");
        tentatives[i]++;
        alarm(sec);
        printf("\nEntrez la valeur %d: ", i+1);
        if(scanf("%d", &tab[i]) == 1){
            temps[i] += sec - alarm(0); 
            i++;
            sec = 2;
        }
    }
    printf("Voici les valeurs que vous avez entrées et le nombre de tentatives associées:\n");
    for(int j = 0;j<5;j++){
        printf("Valeur %d: %d, tentatives: %d, temps %d\n", j+1, tab[j], tentatives[j], temps[j]);
    }
    return 0;
}