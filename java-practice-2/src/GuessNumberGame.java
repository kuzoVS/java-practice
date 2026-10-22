import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    static final int MAX_ATTEMPTS = 10;

    public static void play(Scanner scanner) {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;

        System.out.println("Я загадал число от 1 до 100. Угадайте!");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Ваше число: ");
            int guess = scanner.nextInt();

            if (guess < 1 || guess > 100) {
                System.out.println("Ошибка: число должно быть в диапазоне от 1 до 100");
                continue;
            }

            attempts++;
            if (guess < secretNumber) {
                System.out.println("Моё число больше");
            } else if (guess > secretNumber) {
                System.out.println("Моё число меньше");
            } else {
                System.out.println("Поздравляю! Вы угадали!");
                System.out.println("Вы угадали за " + attempts + " попыток");
                return;
            }
        }

        System.out.println("Вы исчерпали все попытки. Загаданное число было " + secretNumber);
    }
}
