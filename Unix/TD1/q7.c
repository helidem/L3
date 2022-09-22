#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {

    printf("%ld\n",sysconf(_SC_CLK_TCK));

    // nombre de ticks écoulés sur la machine : 
    struct x tms;
    clock_t t = times(&x);

    printf("%ld", x.tms_utime);
}