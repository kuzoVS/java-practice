import java.util.Scanner;

public class Main {
    static final int CURRENT_YEAR = 2026;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        checkAge();
        processArray();
        printMultiplicationTable();
    }

    static void checkAge() {
        int birthYear;
        while (true) {
            System.out.print("Введите год рождения: ");
            birthYear = scanner.nextInt();
            if (birthYear > CURRENT_YEAR) {
                System.out.println("Ошибка: год из будущего. Попробуйте снова.");
            } else {
                break;
            }
        }

        int age = CURRENT_YEAR - birthYear;
        if (age < 18) {
            System.out.println("Вы несовершеннолетний");
        } else if (age <= 65) {
            System.out.println("Вы взрослый");
        } else {
            System.out.println("Вы пенсионер");
        }
    }

    static void processArray() {
        int[] numbers = {3, 8, 15, 4, 7, 10, 21, 6, 9, 12};

        System.out.print("Элементы массива: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        int evenSum = 0;
        int oddCount = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenSum += number;
            } else {
                oddCount++;
            }
        }
        System.out.println("Сумма чётных элементов: " + evenSum);
        System.out.println("Количество нечётных элементов: " + oddCount);
    }

    static void printMultiplicationTable() {
        for (int row = 1; row <= 5; row++) {
            for (int column = 1; column <= 5; column++) {
                System.out.printf("%d * %d = %-4d", row, column, row * column);
            }
            System.out.println();
        }
    }
}
