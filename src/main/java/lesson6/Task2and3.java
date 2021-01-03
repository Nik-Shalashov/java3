package lesson6;

import java.util.Arrays;

public class Task2and3 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 54, 1, 78, 2, 3, 6, 4, 3, 987, 65};
        int[] arrayOf1and4 = {4, 4, 4, 4, 1, 4, 1, 4, 4, 4, 4};
        numbersAfter4(numbers);
        System.out.println(arrayOf1and4(arrayOf1and4));
    }

    public static boolean arrayOf1and4(int[] arrayOf1and4) {

        boolean markerOf1 = false;
        boolean markerOf4 = false;
        boolean markerOf1or4 = true;

        for (int i : arrayOf1and4) {
            if (i == 1) markerOf1 = true;
            if (i == 4) markerOf4 = true;
            if (i != 1 && i != 4) markerOf1or4 = false;
        }

        if (markerOf1 == true && markerOf4 == true && markerOf1or4 == true) return true;
        else return false;
    }

    public static int[] numbersAfter4(int[] numbers) throws RuntimeException {

        int keyNumber = 0;
        boolean markerOf4 = false;

        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] != 4) continue;
            if (numbers[i] == 4) {
                markerOf4 = true;
                keyNumber = i;
                break;
            }
        }

        if (!markerOf4) throw new RuntimeException("Here's no number 4!");

        int[] newArr = Arrays.copyOfRange(numbers, keyNumber + 1, numbers.length);;

        System.out.println(Arrays.toString(newArr));
        return newArr;
    }

}
