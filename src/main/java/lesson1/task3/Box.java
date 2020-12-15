package lesson1.task3;

import java.util.ArrayList;

public class Box <F extends Fruits> {

    private ArrayList<F> box;
    private double weightOfBox = 0;

    public Box() {
        this.box = new ArrayList<F>();
    }

    public void addFruit(F fruit) {
        box.add(fruit);
        weightOfBox += fruit.getWeight();
    }

    public double getWeightOfBox() {
        return weightOfBox;
    }

    public boolean compare(Box<?> anotherBox) {
        if (Math.abs(weightOfBox - anotherBox.getWeightOfBox()) < 0.0000000000000000000001) {
            System.out.println("The weight of the boxes is the same");
            return true;
        }else {
            System.out.println("The weight of the boxes is NOT the same");
            return false;
        }
    }

    public void replaceFruits(Box<F> newBox) {
        for (F f : box) {
            newBox.addFruit(f);
        }
        box.clear();
        weightOfBox = 0;
    }

    public void showFruits() {

        System.out.println("Weight of this box: " + weightOfBox);
        System.out.println("Weight of each fruit in the box:");
        for (F f : box) {
            System.out.printf(f.getWeight() + "; ");
        }
        System.out.println();
    }
}
