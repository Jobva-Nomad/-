package ПотокиВводаВывода.Task_2;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class SortNames {
    public static void main(String[] args) {
        String inputFileName = "listNames.txt";
        String outputFileName = "sortedNames.txt";

        try {
            List<String> names = Files.readAllLines(Paths.get(inputFileName));
            Collections.sort(names);
            Files.write(Paths.get(outputFileName), names);
            System.out.println("Имена отсортированы и результат записан в " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}