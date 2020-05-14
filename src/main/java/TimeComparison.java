import common.LinesExtractor;
import stream.AnagramStream;
import traditional.Anagram;

import java.util.List;

public class TimeComparison {
    private static final String FILE_NAME = "wordlist.txt";

    public static void main(String[] args) {
        List<String> linesExtractor = new LinesExtractor().readLinesFromFile(FILE_NAME);

        AnagramStream anagramStream = new AnagramStream(linesExtractor);
        long startStream = System.nanoTime();
        anagramStream.maximumAnagram();
        long endStream = System.nanoTime();

        System.out.println("Took: " + ((endStream - startStream) / 1000000) + "ms");

        Anagram anagram = new Anagram(linesExtractor);
        long start = System.nanoTime();
        anagram.maximumAnagram();
        long end = System.nanoTime();

        System.out.println("Took: " + ((end - start) / 1000000) + "ms");
    }
}
