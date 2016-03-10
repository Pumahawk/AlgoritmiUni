#ifndef __SELECTION_SORT_H_KEIXJ4PDU3__
#define __SELECTION_SORT_H_KEIXJ4PDU3__

typedef int (*CompFunction)(void*, void*);

/*
 * Implementa il selection selection_sort sul posto
 * array: l'array da ordinare
 * compare: funzione per valutare l'ordine di due elementi dell'array
 */
void selection_sort(void** array, int size, CompFunction compare);


#endif
