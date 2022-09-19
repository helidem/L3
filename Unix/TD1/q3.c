#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
    pid_t pid = fork();
    
    if(pid==-1){
        perror("fork");
        exit(1);
    }
    
    int x = 7;
        if(pid!=0){
            for(int i = 0; i < atoi(argv[1]); i++){
                printf("PERE valeur i = %d\n", x);
                printf("adresse de i = %p\n", &x);
                x--;
            }
            
        } else {
            for(int i = 0; i < atoi(argv[1]); i++){
    
            printf("        FILS valeur i = %d\n", x);
            printf("        adresse de i = %p\n", &x);
        }
    }
    

    return 0;
}