package graphs;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

/** Test del grafo applicato al file csv consegnato dal professore */
public class GraphTest {

    static Graph<String> citta;

    @BeforeClass
    public static void setUpBeforeClass() {
	GraphTest.citta = ReadCSV.getGraph("Data" + File.separator + "italian_dist_graph.csv");
    }

    @Test
    public void test() {
	String torino = "torino";
	String catania = "catania";
	citta.stampaPercorso(torino, catania);
	assertEquals(citta.distanzaMinima(torino, catania) == 1207680.2f, true);
    }

}
