package lesson1.task3;

public class Main {

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox.addFruit(new Apple(1.2));
        appleBox.addFruit(new Apple(1.0));
        appleBox.addFruit(new Apple(1.4));

        orangeBox.addFruit(new Orange(1.3));
        orangeBox.addFruit(new Orange(2.1));
        orangeBox.addFruit(new Orange(1.0));
        orangeBox.addFruit(new Orange(0.8));

        appleBox.showFruits();
        orangeBox.showFruits();

        appleBox.compare(orangeBox);

        Box<Apple> newAppleBox = new Box<>();
        appleBox.replaceFruits(newAppleBox);

        appleBox.showFruits();
        newAppleBox.showFruits();
    }

}
