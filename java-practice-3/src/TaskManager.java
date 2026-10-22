import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\n1 - добавить задачу");
            System.out.println("2 - удалить первую задачу");
            System.out.println("3 - удалить задачу по номеру");
            System.out.println("4 - показать все задачи");
            System.out.println("5 - выход");
            System.out.print("Выбор: ");
            String command = scanner.nextLine().trim();

            switch (command) {
                case "1":
                    System.out.print("Текст задачи: ");
                    tasks.add(scanner.nextLine());
                    break;
                case "2":
                    if (tasks.isEmpty()) {
                        System.out.println("Список пуст");
                    } else {
                        tasks.remove(0);
                    }
                    break;
                case "3":
                    System.out.print("Номер задачи: ");
                    try {
                        int taskNumber = Integer.parseInt(scanner.nextLine().trim());
                        if (taskNumber < 1 || taskNumber > tasks.size()) {
                            System.out.println("Неверный номер");
                        } else {
                            tasks.remove(taskNumber - 1);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный номер");
                    }
                    break;
                case "4":
                    if (tasks.isEmpty()) {
                        System.out.println("Список пуст");
                    }
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Неверная команда");
            }
        }
    }
}
