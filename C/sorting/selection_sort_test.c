#include <stdlib.h>
#include <stdio.h>
#include <assert.h>
#include "selection_sort.h"


int compare_long_int(void* ptr1, void* ptr2) {
  long int el1 = (long int) ptr1;
  long int el2 = (long int) ptr2;

  if(el1<el2) {
    return -1;
  }

  if (el1 == el2) {
    return 0;
  }

  return 1;
}


void test_selection_sort_on_null_array() {
  long int* array = NULL;
  selection_sort((void**) array, 0, compare_long_int);

  assert(1);
}


void test_selection_sort_on_full_array() {
  long int array[5] = { 11, 4, 1, 8, 10 };
  selection_sort((void**) array, 5, compare_long_int);
  for(int i=0; i<4; ++i) {
    assert(array[i] <= array[i+1]);
  }
}


int main(int argc, char const *argv[]) {
  test_selection_sort_on_null_array();
  test_selection_sort_on_full_array();

  return 0;
}
