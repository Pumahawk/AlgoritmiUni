#Classe BinaryTree<K,V> extends Dictionary<K,V>#

La classe deve estendere la classe Dictionary.  
L'albero deve essere rispettare le seguenti condizioni:

+ Ogni elemento dell'albero viene chiamato *nodo* e deve contenere un valore chiave di tipo generico K, una informazione di tipo generico V,
un puntatore ad un nodo sinistro, un puntatore ad un nodo destro.
+ Ogni nodo deve avere la chiave maggiore rispetto alla chiave puntata dal puntatore sinistro
e minore o uguale alla chiave del nodo puntato dal puntatore destro.

##Inner private class Content##

La classe content viene utilizzata per unire in un unico oggetto la chiave e il valore assegnato

###Attributi

+ public K key;
+ public V value;
 
##Attributi##

+ private int **size**;
+ private BinaryNode<Content, BinaryNode> **root**; ???????????PROBLEMA CON BINARYNODE?????????????

##Metodi##

- private **leftRotation(BinaryNode(K,V))**;
- private **rightRotation(BinaryNode(K,V))**;
- public Enumeration<V> **elements()**;
- public V **get(Object)**;
- public boolean **isEmpty()**;
- public Enumeration<K> **keys()**;
- public V **put(K,V)**;
- public V **remove(Object)**;
- public int **size()**;

##Descrizione degli attributi##

##Descrizione dei metodi##