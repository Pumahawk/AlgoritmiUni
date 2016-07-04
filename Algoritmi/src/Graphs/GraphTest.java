package Graphs;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

public class GraphTest {
    
    static Graph<String> citta;

    @BeforeClass
    public static void setUpBeforeClass() {
	GraphTest.citta = FIleTest.getGraph("Data" + File.separator + "italian_dist_graph.csv");
    }

    @Test
    public void test() {
	citta.stampaPercorso("torino", "catania");
    }

}
