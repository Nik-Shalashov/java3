package lesson1.task1and2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        TestGeneric<Integer> mas = new TestGeneric<>(1, 8, 9, 7, 6, 5, 4);
        TestGeneric<String> mas1 = new TestGeneric<>("r", "erer", "sdsd");


        mas.showMas();
        mas1.showMas();

        try {
            mas.replace(1, 6);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        try {
            mas1.replace(0, 2);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }


        mas.showMas();
        mas1.showMas();

        ArrayList<Integer> arrayList = new ArrayList<>();
        mas.createArrayList(arrayList);

        System.out.println(arrayList);
    }



}
