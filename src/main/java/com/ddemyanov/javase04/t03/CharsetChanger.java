package com.ddemyanov.javase04.t03;

import java.io.*;
import java.nio.file.Paths;

/**
 * Дан файл, содержащий буквы текст на кириллице.
 * Кодировка файла utf-8.
 * Прочитайте информацию из файла и перепишите ее в файл в кодировкой utf-16.
 */
public class CharsetChanger {

    private static BufferedReader reader;
    private static BufferedWriter writer;

    static {
        try {
            System.out.println(Paths.get("src/main/resources/utf8.txt").toAbsolutePath());

            reader = new BufferedReader(new FileReader("C:\\Users\\Дмитрий\\epam\\src\\main\\resources\\utf8.txt"));
            writer = new BufferedWriter(new FileWriter("C:\\Users\\Дмитрий\\epam\\src\\main\\resources\\utf-16.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        String line;
        while (null != (line = reader.readLine())) {
            String buff = new String(line.getBytes("UTF-8"));
            String toWrite = new String(buff.getBytes("UTF-16"));
            writer.write(toWrite);
        }

        reader.close();
        writer.close();
    }
}
