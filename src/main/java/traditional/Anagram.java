package traditional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {
    private List<String> fileLines;

    public Anagram(List<String> fileLines) {
        this.fileLines = fileLines;
    }

    public void maximumAnagram() {
        AnagramsExtractor anagramsExtractor=new AnagramsExtractor(fileLines);
        Collection<List<String>> values = anagramsExtractor.anagrams().values();
        int maximumSize = 0;
        List<String> maxAnagrams = new ArrayList<>();
        for (List<String> anagramsList : values) {
            if (maximumSize < anagramsList.size()) {
                maximumSize = anagramsList.size();
                maxAnagrams = anagramsList;
            }
        }
        System.out.println("The longest anagram value " + maxAnagrams + " Count: " + maximumSize);
    }
}

class AnagramsExtractor {
    private List<String> fileLines;

    public AnagramsExtractor(List<String> fileLines) {
        this.fileLines = fileLines;
    }

    Map<String, List<String>> anagrams() {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String line : fileLines) {
            if (!anagrams.containsKey(sorted(line))) {
                List<String> stringList = new ArrayList<>();
                stringList.add(line);
                anagrams.put(sorted(line), stringList);
            } else {
                anagrams.get(sorted(line)).add(line);
            }
        }
        return anagrams;
    }

    private static String sorted(String word) {
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
