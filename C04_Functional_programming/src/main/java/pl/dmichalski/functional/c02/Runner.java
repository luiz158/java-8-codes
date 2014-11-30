package pl.dmichalski.functional.c02;

import java.util.Arrays;
import java.util.List;

/**
 * Find the double of the first even number greater than 3
 * Author: Daniel
 */
public class Runner {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

//        traditionalWay(values);
        java8Way(values);
    }

    private static void java8Way(List<Integer> values) {
        System.out.println(
                values.stream()
                        .filter(Runner::isGreaterThan3)
                        .filter(Runner::isEven)
                        .map(Runner::doubleIt)
                        .findFirst()
                        .get());
    }

    private static void traditionalWay(List<Integer> values) {
        int result = 0;
        for (int e : values) {
            if (e > 3 && e % 2 == 0) {
                result = e * 2;
                break;
            }
        }
        System.out.println(result);
    }

    public static boolean isGreaterThan3(int number) {
        System.out.println("isGreaterThan3 " + number);
        return number > 3;
    }


    private static boolean isEven(int number) {
        System.out.println("isEven " + number);
        return number % 2 == 0;
    }

    private static int doubleIt(int number) {
        System.out.println("doubleIt " + number);
        return number * 2;
    }

}
