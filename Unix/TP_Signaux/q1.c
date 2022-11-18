#include    <stdio.h>
#include    <stdlib.h>
#include    <string.h>
#include    <ctype.h>


int main(int argc, char *argv[])
{
    int pid = atoi(argv[1]);
    int sig = atoi(argv[2]);
    int nbsig = atoi(argv[3]);
    char* str = strsignal(atoi(argv[2]));
    
    
    // b) la plupart du temps le processus est terminé

    for(int i = 0; i < nbsig; i++)
    {
        kill(pid, sig);
        printf("Signal \"%s\" envoye\n", str);
    }

    return 0;
}