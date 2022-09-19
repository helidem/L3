#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
    pid_t pid2;
    pid_t p = getpid();
    pid_t pid = fork();
   
    if(pid!=0){ // pere
        pid2 = fork();
    }
    
    if(pid==0) {
        printf("FILS\n");
        printf("pid = %d\n", getpid());
    } else if(pid2==0) {
        printf("FILS2\n");
        pid_t pid3 = fork();
        if (pid3 == 0){
            printf("Je suis %d : F3, le petit-fils de %d : P et le neveu de %d : F1\n", getpid(), p, pid);
        } else {
            printf("Je suis %d : F2, le frère de %d : F1\n", getpid(), pid);
        }
    }
}