#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#define MAX_THREADS 26
#define MAX_TAB 75
#define EVER (;;)

char caractere_tab[MAX_TAB];
int frequence

void 

void *ThreadLecteur(void *thread_iter) {
    struct thread_param *mes_param;
    long nb_iter;
    int i, i_car;
    int the_car;

    nb_iter = (long)thread_iter;
    for(i = 1; i<=nb_iter;i++) {
        for(i_car=0;i_car<MAXTAB;i_car++) {
            if(caractere_tab[i_car] > 'A'-1) {
                frequence_tab[caractere_tab[i_car]-'A'+1]++;
                printf("%c", caractere_tab[i_car]);
            }
        }
        printf("\n");
    }
    pthread_exit(NULL);
}



int main(int argc, char** argv) {
    int r, nb_thread;
    long i, nb_iter, total = 0;
    pthread_attr_t attr;
    pthread_t tid;

    if(argc != 3) {
        fprintf(stderr, "nombre d'arguments incorrect\n");
        exit(1);
    }

    nb_thread = atoi(argv[1]);
    nb_iter = atoi(argv[2]);
    printf("DEBUT MAIN\n");

    for(i=1; i<MAX_THREADS+1; i++) frequence_tab[i] = 0;

    // creation des threads qui ecrivent
    pthread_attr_init(&attr);
    pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_DETACHED);

    for(i=1; i<=nb_thread && i<MAX_THREAD;i++) {
        r = pthread_create(&tid, &attr, ThreadEcrivain, (void *)i);
        if(r) {
            fprintf(stderr, "erreur lors de la creation du thread %ld\n", i);
            exit(1);
        }
    }

    // creation du thread qui lit
    pthread_attr_init(&attr);
    pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_JOINABLE);
    r = pthread_create(&tid, &attr, ThreadLecteur, (void *)nb_iter);
    if(r) {
        fprintf(stderr, "erreur lors de la creation du thread lecteur\n");
        exit(1);
    }

    // affiche les statistiques
    for(i=1; i<=nb_thread;i++) {
        printf("%c : %d\n", 64+i, frequence_tab[i]);
        total += frequence_tab[i];
    }
    printf("total : %ld\n", total);
}