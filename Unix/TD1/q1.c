#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    pid_t pid = fork();
    
    if(pid==-1){
        perror("fork");
        exit(1);
    }
    int iter =  atoi(argv[1]);
    for (int i = 0; i < iter; i++) {
        if(pid!=0){
            printf("PERE, mon pid est %d\n", getpid());
            printf("Le pid de mon fils est %d\n", pid);
        } else {
            printf("        FILS, mon pid est %d\n", getpid());
            printf("        Le pid de mon pere est %d\n", getppid());
        }
    }
    return 0;
}