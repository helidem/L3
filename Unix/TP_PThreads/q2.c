#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <errno.h>
#include <pthread.h>

#define MAX_THREADS 26

struct thread_param {
    int thread_id;
};

struct thread_param t_thread_param[MAX_THREADS];
char tableauMessage[75];
int j = 0;
int k = 0;
int nbLectures;

void *Ecrire(void* threadmess) { // code du thread ecrivain
    struct thread_param *mes_param;
    mes_param = (struct thread_param*) threadmess;
    while (1)
    {
        if(j == 75) {
            j = 0;
        }
        tableauMessage[j] = 'A' + mes_param->thread_id - 1;
    }
}

void *Lire(void* thread_id) { // code du thread lecteur
    for(int l = 0; i < 75; l++) {
        printf("%c", tableauMessage[l]);
        k++;
        if(k == nbLectures) {
            pthread_exit(NULL);
        }
    }
}

int main(int argc, char** argv){
    int nbThreads = atoi(argv[1]);
    nbLectures = atoi(argv[2]);
    int i = 1;
    int r;
    void *status;
    // 1) declaration de la variable de type pthread_attr_t
    pthread_attr_t attr;
    pthread_t threads[MAX_THREADS];
    printf("DEBUT MAIN\n");
    // 2) initialisation de la variable attr
    pthread_attr_init(&attr);
    // 3) positionnement de l'etat de la variable attr a DETACHED
    pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_DETACHED);
    for(i;&& i<=nbThreads; i++){
        t_thread_param[i].thread_id = i;
    
        // 4) creation des threads
        r = pthread_create(&threads[i], &attr, Ecrire, (void *) &t_thread_param[i]);
    }

    // creation du thread de lecture
    pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_JOINABLE);
    r = pthread_create(&threads[i], &attr, Lire, (void *) &t_thread_param[i]);


    // 5) destruction de la variable attr
    pthread_attr_destroy(&attr);


    r=pthread_join(threads[i], &status);
    if (r) {
        printf("ERROR; return code from pthread_join() is %d\n", r);
        exit(-1);
    }


    printf("FIN MAIN\n");
}