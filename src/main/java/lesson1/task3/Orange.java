package lesson1.task3;

public class Orange implements Fruits{

    double weight;

    public Orange(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

}
