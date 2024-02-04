package amalitech;

import java.util.Scanner;

public class FizzBuzzChallenge {

    public static boolean divisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }

    public static boolean divisibleByBoth(int number, int divisor1, int divisor2) {
        return divisibleBy(number, divisor1) && divisibleBy(number, divisor2);
    }

    public static void calculateFizzBuzz(int number) {
        if (divisibleByBoth(number, 5, 3)) {
            System.out.println("FizzBuzz");
        } else if (divisibleBy(number, 5)) {
            System.out.println("Fizz");
        } else if (divisibleBy(number, 3)) {
            System.out.println("Buzz");
        } else {
            System.out.println(number);
        }
    }

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Number 1:");
        int number = scanner.nextInt();
        calculateFizzBuzz(number);

        System.out.println("Number 2:");
        int numberTwo = scanner.nextInt();
        calculateFizzBuzz(numberTwo);

        System.out.println("Number 3:");
        int numberThree = scanner.nextInt();
        calculateFizzBuzz(numberThree);

    }
}