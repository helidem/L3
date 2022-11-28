#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <errno.h>
#include <pthread.h>

struct thread_data {
    int thread_id;
    char *message;
};


void *Affiche(void* thread_id) { // code du thread
    struct thread_data *data;
    data = (struct thread_data*) thread_id;
    printf("%s je suis le thread %ld\n", data->message, data->thread_id);
    pthread_exit(NULL);
}


int main(int argc, char** argv){
    int n = atoi(argv[1]);
    pthread_t threads[n];
    int rc;
    long t;
    char tab[n+1];
    tab[0] = ' ';
    struct thread_data thread_data_array[n];

    for(t = 0; t < n; t++){
        tab[t-1] = '\t';tab[t] = '\0';
        printf("Creation du thread %ld\n", t);
        thread_data_array[t].thread_id = t;
        thread_data_array[t].message = tab;
        rc = pthread_create(&threads[t], NULL, Affiche, (void *) &thread_data_array[t]);
        if (rc){
            printf("Erreur lors de la creation du thread %ld\n", t);
            exit(-1);    
    }
}
    pthread_exit(NULL);
}