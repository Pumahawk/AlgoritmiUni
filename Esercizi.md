# Laboratorio di algoritmi

## Esercizio 1

Implementare i seguenti algoritmi di ordinamento:

- Insertion Sort
- Quick Sort
- Merge Sort
- Heap Sort

Ogni algoritmo va implementato in modo tale da poter essere utilizzato su
un generico tipo ```T```. L'implementazione degli algoritmi deve permettere di
specificare il criterio secondo cui ordinare i dati. *Suggerimento*: Usare
l'interfaccia java.util.Comparator (o, nel caso di una implementazione C,
un puntatore a funzione).

### Unit testing

Implementare gli unit-test degli algoritmi secondo le indicazioni
suggerite nel documento [Unit Testing](http://fixme.com).

### Confronti

Il file "Data/records.csv" contiene alcuni record da ordinare. Ogni record è
descritto su una riga e contiene i seguenti campi:

- id: (tipo:intero) identificatore univoco del record;
- field1: tipo stringa (conterrà caratteri ascii standard, i valori possono contenere
  spazi, ma non virgole)
- field2: (tipo intero)
- field3: (tipo floating point)

Il formato è un CSV standard: i campi sono separati da virgole; i record sono
separati da "\n".

Si ordinino i dati contenuti nel file `Data/sorting.csv` in ordine non decrescente,
secondo i valori contenuti nei tre campi "field" (i.e., è necessario ripetere
l'ordinamento tre volte, una volta per ciascun campo).

Si misurino i tempi di risposta e si crei una breve relazione in cui si riportano
i risultati ottenuti insieme a un loro commento. I risultati sono quelli
che vi sareste aspettati? Se sì, perché? Se no, fate delle ipotesi circa il
motivo per cui gli algoritmi non funzionano come vi aspettate e verificatele.


## Esercizio 2

Si consideri la classe definizione del tipo di dato astratto Dizionario. Si
implementi il tipo di dato astratto utilizzando gli alberi di ricerca "semplici"
e almeno una tra le seguenti strutture dati:

- Alberi Rosso Neri
- Tabelle Hash

Ogni implementazione deve permettere di usare tipi generici sia per il tipo chiave,
sia per il tipo valore.

### Unit Testing

Implementare gli unit-test degli algoritmi secondo le indicazioni
suggerite nel documento [Unit Testing](http://fixme.com).

### Confronti

Si inseriscano i dati contenuti nel file `Data/records.csv` nei dizionari
implementati. Si ripeta questa operazione usando come chiave i tre campi presenti
nel file (in tutti i casi il "valore" è l'intero record).

Si misurino i tempi di risposta in modo da poter rispondere alle seguenti domande:

  - come varia il tempo di inserimento al crescere del numero di record inseriti?
  - come varia il tempo di accesso al crescere del numero di record inseriti?

Si crei una breve relazione a commento dei risultati ottenuti. I risultati
sono quelli che vi sareste aspettati? Se sì, perché? Se no, fate delle
ipotesi circa il motivo per cui gli algoritmi non funzionano come vi aspettate
e verificatele.


## Esercizio 3

Si implementi la struttura dati Grafo diretto in modo che sia ottimale per
dati sparsi.

Il file "italian_dist_graph.csv" contiene le distanze in metri tra varie
località italiane e una frazione delle località a loro più vicine.
Il formato è un CSV standard: i campi sono separati da virgole; i record sono
separati da "\n".

Ogni record contiene i seguenti dati:

- località 1: (tipo stringa) nome della località "sorgente". La stringa può
  contenere spazi, non può contenere virgole;
- località 2: (tipo stringa) nome della località "destinazione". La stringa
  può contenere spazi, non può contenere virgole;
- distanza: (tipo float) distanza in metri tra le due località

*Note:*

- il file descrive un grafo non diretto come se fosse diretto:(per ogni coppia
  di località il file contiene con lo stesso peso l'arco di andata e l'arco
  di ritorno); questa informazione è importante da tener presente, ma non
  dovrebbe avere implicazioni sulla vostra implementazione (i.e., potete
  trattarlo come fosse un grafo diretto).
- il file è stato creato a partire da un dataset poco accurato. I dati
  riportati contengono inesattezze e imprecisioni.

### Unit Testing

Implementare gli unit-test degli algoritmi secondo le indicazioni
suggerite nel documento [Unit Testing](http://fixme.com).

### Analisi grafo e cammini minimi

Scrivere un programma che permetta di:

- trovare il cammino minimo tra due località; si assuma che gli archi
  riportati nel file "italian_dist_graph.csv" siano connessioni percorribili;
- determinare la dimensione di ogni componente fortemente connessa del grafo.
  Suggerimento: il problema è risolvibile banalmente se si sfrutta il fatto
  che il grafo in questione è, nella sostanza, non diretto.

### Controlli

Una implementazione corretta della ricerca del cammino minimo dovrebbe
riportare un cammino minimo tra "torino" e "catania" lungo ~1207.68Km.

Qual'è il cammino minimo tra "torino" e "borsoi"?
