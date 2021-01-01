package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task2and3Test {


    @DisplayName("Тест с копированием массивов")
    @ParameterizedTest
    @MethodSource("data")
    public void paramTestNumbersAfter4 (int[] numbers, int[] newArr) {
        Assertions.assertArrayEquals(newArr, Task2and3.numbersAfter4(numbers));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 4, 5, 6, 7, 8, 4, 8, 9, 8}, new int[]{8, 9, 8}),
                Arguments.arguments(new int[]{1, 4, 5, 6, 7, 8, 4, 8, 9, 8}, new int[]{4, 8, 9, 8}),
                Arguments.arguments(new int[]{5, 4, 1, 6, 2, 8, 7, 5, 3, 1}, new int[]{1, 6, 2, 8, 7, 5, 3, 1})
        );
    }


    @DisplayName("Тест с копированием массивов на ошибку")
    @ParameterizedTest
    @MethodSource("data1")
    public void ExceptionOfNumbersAfter4(int[] numbers) {
        Assertions.assertThrows(RuntimeException.class, () -> Task2and3.numbersAfter4(numbers));
    }

    static Stream<Arguments> data1() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 5, 6, 7}),
                Arguments.arguments(new int[]{1, 5, 6, 4})

        );
    }


    @DisplayName("Тест с проверкой на 1 и 4")
    @ParameterizedTest
    @MethodSource("data2")
    public void arrayOf1and4Test(int[] arrayOf1and4) {
        Assertions.assertTrue(Task2and3.arrayOf1and4(arrayOf1and4));
    }

    static Stream<Arguments> data2() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}),
                Arguments.arguments(new int[]{4, 4, 4, 4, 4, 4}),
                Arguments.arguments(new int[]{1, 4, 1, 4, 1, 4}),
                Arguments.arguments(new int[]{1, 4, 5, 4, 1, 4})
        );
    }

}