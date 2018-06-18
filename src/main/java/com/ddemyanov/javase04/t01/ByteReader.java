package com.ddemyanov.javase04.t01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Прочитайте файл, содержащий код на языке Java.
 * Определите, какие ключевые слова языка Java это код содержит.
 * Выведите эти слова и их количество в другой файл.
 * Используйте только байтовые потоки ввода-вывода.
 */

public class ByteReader {

    public static void main(String[] args) throws IOException {

        byte[] file;
        InputStream is = null;
        OutputStream fos = null;

        try {
            is = ByteReader.class.getResourceAsStream("/se04");
            fos = new FileOutputStream("./src/main/resources/se04output");

            file = new byte[is.available()];
            is.read(file);

            Map <String, Integer> map = keywordsFind(file);

            for (Map.Entry <String, Integer> pair : map.entrySet()) {
                fos.write((pair.getKey() + ": " + pair.getValue() + "\n").getBytes());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) is.close();
            if (null != fos) fos.close();
        }
    }

    private static Map <String, Integer> keywordsFind(byte[] file) {

        Map <String, Integer> keywords = new HashMap <>();

        String s = new String(file);

        String words = "abstract continue for new switch " + "assert default goto package synchronized " + "boolean do if private this " + "break double implements protected throw " + "byte else import public throws " + "case enum instanceof return transient " + "catch extends int short try " + "char final interface static void " + "class finally long strictfp volatile " + "const float native super while";

        for (String word : words.split(" ")) {
            keywords.put(word, 0);
        }

        for (String x : new String(file).split("[^\\w]")) {
            if (keywords.containsKey(x)) {
                int count = keywords.get(x);
                count++;
                keywords.put(x, count);
            }
        }

        return keywords;
    }
}
