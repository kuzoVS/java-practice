import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    public static List<String> topWords(String text, int count) {
        Map<String, Integer> frequency = new LinkedHashMap<>();
        for (String word : text.toLowerCase().split("\\s+")) {
            if (!word.isEmpty()) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        List<String> words = new ArrayList<>(frequency.keySet());
        words.sort((first, second) -> frequency.get(second) - frequency.get(first));
        return words.subList(0, Math.min(count, words.size()));
    }
}
