package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramStream {
    
    private final List<String> fileLines;

    public AnagramStream(List<String> fileLines) {
        this.fileLines = fileLines;
    }

    public void maximumAnagram() {
        fileLines
                .stream()
                .collect(Collectors.groupingBy(word -> sorted(word)))
                .values()
                .stream()
                .max(Comparator.comparingInt(maximumSize -> maximumSize.size()))
                .ifPresent(anagram ->
                        System.out.println("The longest anagram value " + anagram + " Count: " + anagram.size()));
    }

    private static String sorted(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
