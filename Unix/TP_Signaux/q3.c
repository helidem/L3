// gestionnaire de signaux ANSI C

#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void gestionnaire(int sig)
{
    // ignorer les signaux SIGUSR1 et SIGUSR2
    printf("Signal %d (%s) recu", sig, strsignal(sig));
    printf(" - Ignorer\n");
    return;
}

int main(void)
{
    signal(SIGUSR1, SIG_IGN);
    signal(SIGUSR2, SIG_IGN);

    // boucle infinie
    printf("En attente de signal\n");
    while (1)
    {
        //sleep(1);
    }
    return 0;
}