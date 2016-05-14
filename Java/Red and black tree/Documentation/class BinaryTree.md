#Classe BinaryTree#

La classe deve estendere la classe Dictionary.  
L'albero deve essere rispettare le seguenti condizioni:

+ Ogni elemento dell'albero viene chiamato *nodo* e deve contenere un valore chiave di tipo generico K, una informazione di tipo generico V,
un puntatore ad un nodo sinistro, un puntatore ad un nodo destro.
+ Ogni nodo deve avere la chiave maggiore rispetto alla chiave puntata dal puntatore sinistro
e minore o uguale alla chiave del nodo puntato dal puntatore destro.

##Implementazione##
 
*Attributi*:

- int **size**; *Numero di nodi dell'albero*
- Pointer **root** *Puntatore al nodo radice dell'albero*;

*Metodi:*

- public Enumeration<V> **elements()**;
- public V **get(Object)**;
- public boolean **isEmpty()**;
- public Enumeration<K> **keys()**;
- public V **put(K,V)**;
- public V **remove(Object)**;
- public int **size()**;
