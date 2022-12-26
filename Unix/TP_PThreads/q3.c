#include <stdio.h>

// prototype de la fonction de partitionnement
int partition(int tab[], int premier, int dernier);

void quickSort(int tab[], int premier, int dernier){
    int j;
    if(premier<dernier){
        // partitionnement du tableau
        j = partition(tab, premier, dernier);

        // tri de la partie a gauche du tableau
        quickSort(tab, premier, j-1);

        // tri de la partie a droite du tableau
        quickSort(tab, j+1, dernier);
    }
}

void main() {
    int i, tab[] = {79, 17, 14, 65, 89, 4, 95};
    int indice_max;

    indice_max = (sizeof(tab)/sizeof(int)-1);
    printf("\nTableau non trié : \t");
    for(i=0; i<=indice_max; i++) printf("%d ", tab[i]);
    printf("\n");

    quickSort(tab, 0, indice_max);
    printf("\nTableau trié : \t\t");
    for(i=0;i<=indice_max;i++) printf("%d ", tab[i]);
    printf("\n");
}

int partition (int tab[], int premier, int dernier){
    int pivot, i, j, temp;

    pivot = tab[premier];
    i = premier;
    j = dernier+1;

    while(1){
        do ++i; while(tab[i] <= pivot && i <= dernier);
        do --j; while(tab[j] > pivot);
        if(i >= j) break;
        temp = tab[i]; tab[i] = tab[j]; tab[j] = temp;
    }
    temp = tab[premier]; tab[premier] = tab[j]; tab[j] = temp;
    return j;
}