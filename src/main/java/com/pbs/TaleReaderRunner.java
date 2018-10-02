package com.pbs;

import java.nio.file.Paths;

public class TaleReaderRunner {

    public static final String INPUT_FILE_PATH = "src/main/resources/input.txt";

    public static void main(String[] args) {
        new TaleReader().printOutput(Paths.get(INPUT_FILE_PATH));
    }
}
