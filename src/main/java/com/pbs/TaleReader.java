package com.pbs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TaleReader {

    public Map<String, Integer> read(Stream<String> inputStream) {

        Map<String, Integer> wordOccurrencesMap = new HashMap<>();

        inputStream.flatMap(i -> Arrays.stream(i.split("\\s+"))).forEach(word -> {
            if (wordOccurrencesMap.containsKey(word)) {
                wordOccurrencesMap.put(word, wordOccurrencesMap.get(word) + 1);
            } else {
                wordOccurrencesMap.put(word, 1);
            }
        });
        return wordOccurrencesMap;
    }

}
