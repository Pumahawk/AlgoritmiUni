# Unit Testing

I test automatici sono pezzi di software che vengono scritti con l'obbiettivo
di verificare  se una porzione di una applicazione è corretta (secondo qualche
criterio di corretteza definito nel test stesso). Quando le porzioni testate
sono piccole e autocontenute esse vengono chiamate "unit" e il test automatico
di esse è detto "unit testing". Cosa sia una unit non è definito con precisione,
in alcuni contesti può essere una classe, in altri può essere un metodo, etc.

I test automatici in genere predispongono un input, invocano la unit e
verificano che l'output (o l'eventuale side-effect) sia corretto. La verifica
è fatta per mezzo di asserzioni che indicano quale sia il risultato atteso,
quando tali asserzioni falliscono viene interrotto il test e restituito un
messaggio d'errore appropriato.

Affinché gli unit test possano essere efficaci è necessario che godano delle
seguenti proprietà:

- i test devono essere focalizzati: uno unit-test deve testare un singolo caso
  d'uso di una singola unit. Un test che prende in considerazione più unit o più
  casi d'uso è meno utile perché eventuali problemi sono più difficilmente
  ricollegabili a una porzione ristretta di codice.

  Esempi di test correttamente focalizzati:
    - test di un metodo di sort su un array vuoto
    - test di un metodo di sort su un array dato
    - test di un metodo di sort su un array con tutti elementi uguali

  Esempi di test non correttamente focalizzati:
    - test di un metodo di sort
    - test del funzionamento di più metodi contemporaneamente

  In genere un test poco focalizzato si riconosce perché contiene più asserzioni.
  Prima di scrivere uno unit test contenente più asserzioni è bene verificare
  l'opportunità di procedere in questa direzione.

- i test devono essere indipendenti: l'ordine di esecuzione dei test non deve
  influire sul loro risultato. JUnit impone questa caratteristica ricaricando
  l'intera classe in memoria prima di eseguire ciascun metodo di test e eseguendo
  i test in ordine casuale.

  L'indipendenza dei test è importante perché in caso contrario un baco potrebbe
  essere nascosto dall'esecuzione di un test precedente. Inoltre il debugging
  dei problemi diventa più complicato perché è necessario prendere in
  considerazione tutto il contesto.

- i test non devono richiedere l'intervento umano: i test devono essere automatici,
  non devono richiedere che un essere umano ispezioni il valore di una variabile
  o ispezioni quanto stampato a video. Un test che passa non deve generare nessun
  output degno di attenzione, un test fallito deve permettere di risalire
  velocemente alla porzione di codice da esaminare.

  Non scrivere pertanto nulla su console durante un test.

Si noti che scrivere i test di unità è diverso dallo scrivere un programma di
prova per il proprio software. Gli unit test sono pensati per essere eseguiti
automaticamente e non richiedere attenzione da parte dell'utente.

## Unit testing in Java

La libreria di unit testing più usata in ambito Java è JUnit. Un test in JUnit
è un metodo marcato con l'annotazione ```@Test```. Tali metodi possono usare
un certo numero di funzioni messe a disposizione dalla libreria per verificare
la correttezza del programma. Ad esempio:

```Java
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

class TestSorting {
  @Test
  void testSortEmptyArray() {
    MySortingAlgorithm sorter = new MySortingAlgorithm();
    int[] a = {};
    assertArrayEqual( {}, sorter.sort(a) );
  }

  @Test
  void testSortNullArray() {
    MySortingAlgorithm sorter = new MySortingAlgorithm();
    int[] a = null;
    assertArrayEqual( null, sorter.sort(a) );
  }

  ...
}
```

JUnit provvederà ad eseguire i test in ordine casuale ricaricando la classe
prima di ogni singolo test. Nel caso in questione quest'ultima operazione non
influisce sul risultato. Le cose sarebbero state però diverse caso la classe di
test avesse memorizzato i dati in qualche variabile di istanza (o di classe).

## Unit test in C

Purtroppo nel caso del C non c'è un'unica libreria che può essere definita
"standard" e in genere usare tali librerie richiede l'installazione di software
aggiuntivo. Date queste difficoltà è ammesso utilizzare un programma ad-hoc
per effettuare il test a patto che si scrivano le funzioni di test prestando
attenzione ai punti indicati sopra. Chi volesse utilizzare qualche libreria
è libero di farlo.

Esempio di programma di test in C:

```C
#include <assert.h>
#include <stdlib.h>
#include "my_sorter.h"

void test_sort_empty_array() {
  int a[] = {};
  assert( a == my_sorter(a, 0) );
}

void test_sort_null_array() {
  int* a = NULL;
  assert( NULL == my_sorter(a, 0) );
}

...

int main(int argc, char** argv) {
  test_sort_empty_array();
  test_sort_null_array();
  ...
}

```

Si noti che la funzione ```assert``` usata nell'esempio non è stata pensata per
fare unit testing in C e fornisce solo funzionalità molto limitate in questo
senso. Dati i vincoli e i problemi spiegati sopra un'implementazione lungo
la linea mostrata sarà considerata pienamente accettabile.
