package common;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class LinesExtractor {

    public List<String> readLinesFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = lineNumberReader.readLine()) != null) {
                lines.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}