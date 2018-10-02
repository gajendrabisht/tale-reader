package com.pbs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TaleReader {

    /**
     * To return a map of word and their corresponding occurrences in the given stream of string
     *
     * @param inputStream stream of string to read
     * @return map of every word and it's corresponding number of occurrences in the input
     */
    public Map<String, Integer> read(Stream<String> inputStream) {

        Map<String, Integer> wordOccurrencesMap = new HashMap<>();
        inputStream.flatMap(i -> Arrays.stream(i.split("\\s+")))
                .map(String::toLowerCase)
                .forEach(word -> {
                    if (wordOccurrencesMap.containsKey(word)) {
                        wordOccurrencesMap.put(word, wordOccurrencesMap.get(word) + 1);
                    } else {
                        wordOccurrencesMap.put(word, 1);
                    }
                });
        return wordOccurrencesMap;
    }

    /**
     * Print output of :
     * Total number of words found in the file
     * Table with all words sorted by their occurrences in descending order
     *
     * @param inputFilePath Input file path
     */
    public void printOutput(Path inputFilePath) {
        try {
            Map<String, Integer> wordOccurrencesMap = read(Files.lines(inputFilePath));
            System.out.println(String.format("Total number of words found in the file : %d", wordOccurrencesMap.entrySet().stream().mapToInt(entry -> entry.getValue()).sum()));
            wordOccurrencesMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(i -> System.out.println(String.format(" %s : It has been found %d times", i.getKey(), i.getValue())));
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("Unable to find input file : %s", inputFilePath), e);
        }
    }

}
