package Graphs;

public class EdgeWeight implements DoubleWeight {

    private double value;

    public EdgeWeight(double value) {
	this.value = value;
    }

    @Override
    public double getAsDouble() {
	return this.value;
    }

    @Override
    public String toString() {
	return value + "";
    }
}
