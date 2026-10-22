import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskManager.run();

        List<String> words = List.of("listen", "silent", "enlist", "hello", "world", "cat", "act", "tac");
        System.out.println(AnagramGrouper.groupAnagrams(words));

        String text = "java is great java is powerful python is great too but java is java";
        System.out.println(WordFrequency.topWords(text, 3));

        NumberStatistics.run();
    }
}
