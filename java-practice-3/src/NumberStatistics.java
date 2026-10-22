import java.util.ArrayList;
import java.util.List;

public class NumberStatistics {
    public static void run() {
        List<Integer> numbers = new ArrayList<>(List.of(4, 2, 7, 2, 9, 4, 1, 7, 3, 9));
        System.out.println("Исходный список: " + numbers);

        List<Integer> uniqueNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }
        System.out.println("Уникальные элементы: " + uniqueNumbers);

        for (Integer unique : uniqueNumbers) {
            int occurrences = 0;
            for (Integer number : numbers) {
                if (number.equals(unique)) {
                    occurrences++;
                }
            }
            String word = (occurrences >= 2 && occurrences <= 4) ? "раза" : "раз";
            System.out.println(unique + " - " + occurrences + " " + word);
        }

        int max = numbers.get(0);
        int min = numbers.get(0);
        int sum = 0;
        for (int number : numbers) {
            if (number > max) max = number;
            if (number < min) min = number;
            sum += number;
        }
        double average = (double) sum / numbers.size();

        System.out.println("Максимум: " + max);
        System.out.println("Минимум: " + min);
        System.out.println("Сумма: " + sum);
        System.out.println("Среднее: " + average);
    }
}
