package com.ddemyanov.javase04.t02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Прочитайте файл, содержащий код на языке Java.
 * Определите, какие ключевые слова языка Java это код содержит.
 * Выведите эти слова и их количество в другой файл.
 * Используйте только символьные потоки ввода-вывода.
 */


public class SymbolsReader {

    private static BufferedReader fileReader;
    private static BufferedWriter fileWriter;

    static {
        try {
            fileReader = new BufferedReader(new FileReader("./src/main/resources/se04"));
            fileWriter = new BufferedWriter(new FileWriter("./src/main/resources/se04output"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        StringBuilder sb = readFile();
        keywordsFind(sb);

    }

    private static StringBuilder readFile() throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        String read;

        do {
            read = fileReader.readLine();
            stringBuilder.append(read);
        } while (read != null);

        return stringBuilder;
    }

    private static void keywordsFind(StringBuilder stringBuilder) throws IOException {

        Map <String, Integer> keywords = new HashMap<>();

        String words = "abstract continue for new switch " + "assert default goto package synchronized " + "boolean do if private this " + "break double implements protected throw " + "byte else import public throws " + "case enum instanceof return transient " + "catch extends int short try " + "char final interface static void " + "class finally long strictfp volatile " + "const float native super while";

        for (String word : words.split(" ")) {
            keywords.put(word, 0);
        }

        for (String w : stringBuilder.toString().split("[^\\w]*")) {
            if (keywords.containsKey(w)) {
                int count = keywords.get(w);
                count++;
                keywords.put(w, count);
            }
        }

        for (Map.Entry<String, Integer> pair : keywords.entrySet()){
            fileWriter.write(pair.getKey() + ": " + pair.getValue());
            fileWriter.newLine();
        }
    }
}
