package ПотокиВводаВывода;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class RemoveExtraSpaces {
    public static void main(String[] args) {
        String inputFileName = "c";
        String outputFileName = "BorodinoModified.txt";

        try {
            String content = Files.readString(Paths.get(inputFileName));
            String modifiedContent = content.replaceAll("\\s+", " ").trim();
            Files.writeString(Paths.get(outputFileName), modifiedContent);
            System.out.println("Лишние пробелы убраны и результат записан в " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}