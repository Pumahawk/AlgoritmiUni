# Specifiche alberi di ricerca
	
###	Esercizio 2
**Descrizione**: Bisogna implementare una classe albero che estende la classe Dictionary.

**Implementazione della classe Albero<K, V>**
 
*Attributi*:

- int size; *Numero di nodi dell'albero*
- Pointer<K, V> root;

*Metodi:*

- Enumeration<V> elements();
- V get(Object);
- boolean isEmpty();
- Enumeration<K> keys();
- V put(K,V);
- V remove(Object);
- int size();
