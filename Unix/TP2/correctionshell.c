#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h> 

#define TAILLE_LIGNE 250
#define TAILLE_ARG 40
#define EVER (;;)

void main(){
    char commande [TAILLE_LIGNE]; // commande tapée par l'utilisateur
    char *arg[TAILLE_ARG]; // tableau de pointeur sur les arguments de la commande
    char *bg; // pour les commandes en arriere plan
    char *redir; // pour les redirections des entrees/sorties
    char *mot; // pointeur vers le mot courant
    int i;
    int pid, code_retour;

    for EVER {
        printf("shell> ");
        fgets(commande, TAILLE_LIGNE, stdin);

        // on enleve le retour chariot
        commande[strlen(commande)-1] = '\0';

        /* = > suppression du & eventuel de la ligne de commande pour lancer */
        /*     une commande en arrière plan */
        if (bg=strrchr(commande, '&')) *bg='\0';

        /* => suppression du > eventuel de la ligne de commande pour rediriger
                la sortie standard */
        if (redir=strrchr(commande, '>')) {
            // analyse de la ligne de commande
            for(i=0,mot=strtok(commande, " ");strcmp(mot,">")!=0;mot=strtok(NULL, " "), i++){
                // preparation des arguments pour execvp
                arg[i] = (char *) malloc(strlen(mot)+1);
                strcpy(arg[i], mot);
            
            }
            printf("redirection\n");
            // on duplique le descripteur de fichier de la sortie standard vers le fichier juste apres le ">"
            
        }

        
        arg[i] = NULL; // la derniere case du tableau doit etre NULL

        if(i>0){
            if(fork()==0){ // fils
                printf("\n");
                execvp(arg[0], arg);
                perror(arg[0]);
                exit(EXIT_FAILURE);
            } else {
                if(bg!=NULL){
                    // arrière plan, wait inutile
                } else {
                    pid=wait(&code_retour);
                }
            }            
        }
    }
}