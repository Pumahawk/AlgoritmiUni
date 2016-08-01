package orderalgorithm;

import java.util.Comparator;

/**
 * Classe contenente la riga di un file csv
 *
 */
public class RecordCSV {
    public String s;
    public Integer i;
    public Float f;

    public enum Type {
	STRING, INTEGER, FLOAT
    }

    public RecordCSV(String string, Integer integer, Float fl) {
	this.s = string;
	this.f = fl;
	this.i = integer;
    }

    /**
     * Rstituisce un comparatore in grado di comparare i recordcsv in base al
     * parametro type
     * 
     * @param type
     * @return
     */
    public static Comparator<RecordCSV> getComparator(Type type) {
	switch (type) {
	case STRING:
	    return (RecordCSV a, RecordCSV b) -> a.s.compareTo(b.s);
	case INTEGER:
	    return (RecordCSV a, RecordCSV b) -> a.i.compareTo(b.i);
	case FLOAT:
	    return (RecordCSV a, RecordCSV b) -> a.f.compareTo(b.f);
	}
	return null;
    }

}
