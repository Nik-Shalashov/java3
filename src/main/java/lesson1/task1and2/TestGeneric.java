package lesson1.task1and2;

import java.util.ArrayList;

public class TestGeneric <T> {

    private T[] mas;

    public TestGeneric(T... mas) {
        this.mas = mas;
    }


    public T get(int index) {
        return mas[index];
    }

    public int getLength () {
        int masLength = mas.length;
        return masLength;
    }

    public void replace(int index1, int index2) {
        T buffer = mas[index1];
        mas[index1] = mas[index2];
        mas[index2] = buffer;
    }

    public void createArrayList(ArrayList<T> list) {
        for (T t : mas) {
            list.add(t);
        }
    }

    public void showMas() {
        for (T ma : mas) {
            System.out.print(ma + " ");
        }
        System.out.println();
    }
}
