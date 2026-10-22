import java.util.Arrays;
import java.util.Scanner;

public class ArrayEditor {
    public static void run(Scanner scanner) {
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Массив: " + Arrays.toString(numbers));
        System.out.println("1 — добавить элемент");
        System.out.println("2 — удалить элемент");
        System.out.print("Ваш выбор: ");
        int choice = scanner.nextInt();

        if (choice != 1 && choice != 2) {
            System.out.println("Неверный выбор. Введите 1 или 2");
            return;
        }

        if (choice == 1) {
            System.out.print("Введите число для добавления: ");
            int newValue = scanner.nextInt();
            numbers = Arrays.copyOf(numbers, numbers.length + 1);
            numbers[numbers.length - 1] = newValue;
        } else {
            System.out.print("Введите индекс для удаления: ");
            int indexToRemove = scanner.nextInt();
            if (indexToRemove < 0 || indexToRemove > numbers.length - 1) {
                System.out.println("Ошибка: индекс выходит за границы массива");
                return;
            }
            int[] result = new int[numbers.length - 1];
            for (int i = 0, j = 0; i < numbers.length; i++) {
                if (i != indexToRemove) {
                    result[j++] = numbers[i];
                }
            }
            numbers = result;
        }

        System.out.println("Обновлённый массив: " + Arrays.toString(numbers));
    }
}
