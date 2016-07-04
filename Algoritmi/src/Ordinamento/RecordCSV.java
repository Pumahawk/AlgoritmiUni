package Ordinamento;

import java.util.Comparator;

public class RecordCSV {
    public String s;
    public Integer i;
    public Float f;

    public enum Type {
	STRING, INTEGER, FLOAT
    }

    /**
     * @param string
     * @param integer
     * @param fl
     */
    public RecordCSV(String string, Integer integer, Float fl) {
	this.s = string;
	this.f = fl;
	this.i = integer;
    }

    /**
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
