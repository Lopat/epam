package com.ddemyanov.javase05.t01;

import lombok.SneakyThrows;
import lombok.val;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Разработать приложение, позволяющее просматривать файлы и каталоги файловой системы,
 * а также создавать и удалять текстовые файлы.
 * Для работы с текстовыми файлами необходимо реализовать функции записи, дозаписи в файл.
 * Требуется определить исключения для каждого слоя приложения и корректно их обрабатывать.
 */
public class FilePathsViewer {

    private static File currentDir;
    private static Scanner scanner;


    static {
        currentDir = new File("/");
        scanner = new Scanner(System.in);
    }

    private static void readInput() {
        open(scanner.nextLine());
    }

    private static void showCurrentFolder() {

        System.out.println("~~~~~(" + currentDir.getAbsolutePath() + ")~~~~~~");
        String[] list = currentDir.list();

        if (list != null) {
            for (String s : list) { System.out.println(s); }
        }
        System.out.println("~~~~~~~~~~~~~~~");

        readInput();
    }

    @SneakyThrows
    private static void open(String input) {

        if (input.startsWith("!")) {

            if (input.equals("!up")) {

                File directory = currentDir.getParentFile();
                if (null != directory) {
                    currentDir = currentDir.getParentFile();
                }
                else { System.out.println("You have reached top level folder"); }
            }
            else if (input.startsWith("!cr")) {
                createFile(input);
            }
            else if (input.startsWith("!del")) {
                deleteFile(input);
            }
            else if (input.startsWith("!wr")) {
                writeToFile(input);
            }
            else if (input.startsWith("!ex")) {
                return;
            }

            showCurrentFolder();
        }
        else {

            val file = new File(currentDir.getAbsolutePath() + "\\" + input);
            System.out.println(file.getAbsolutePath() + " TRYING TO OPEN");

            if (!file.exists()) {
                System.out.println("Such filepath or file not exist!");
            }
            else {

                if (file.isDirectory()) {
                    currentDir = file;
                }

                if (file.isFile()) {
                    readFile(input);
                }

                showCurrentFolder();
            }
        }
    }


    public static void main(String[] args) {
        showCurrentFolder();
    }

    private static void writeToFile(String input) throws IOException {

        val pattern = Pattern.compile("^!wr ([\\w\\d]+.txt) ([\\s\\d\\w \\\\\\-@#№$%^&*()_|!?/~`;:\"'.,]+)");
        val matcher = pattern.matcher(input);

        if (matcher.find()) {

            String fileName = matcher.group(1);
            String toWrite = matcher.group(2);

            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter(currentDir.getAbsolutePath() + "\\" + fileName))) {
                writer.write(toWrite);
                writer.flush();
                System.out.println("~~~WRITING SUCCESSFULL~~~");
            }
        }
    }

    @SneakyThrows
    private static void createFile(String input) throws IOException {

        input = input.replace("!cr ", "")
                     .trim();
        val file = new File(currentDir.getAbsolutePath() + "\\" + input);
        boolean created = file.createNewFile();
        if (!created) { throw new FileNotFoundException("Error creating file"); }
    }

    @SneakyThrows
    static void deleteFile(String input) throws FileNotFoundException {

        input = input.replace("!del ", "")
                     .trim();
        val file = new File(currentDir.getAbsolutePath() + "\\" + input);
        if (file.exists()) { file.delete(); }
        else { throw new FileNotFoundException("File not found"); }
    }

    @SneakyThrows
    static void readFile(String input) {

        try (val reader = new BufferedReader(new FileReader(currentDir.getAbsolutePath() + "\\" + input))) {

            String fromFile;

            System.out.println("~~~~~FILE START~~~~~");
            while ((fromFile = reader.readLine()) != null) {
                System.out.println(fromFile);
            }
            System.out.println("~~~~~~FILE END~~~~~~");
        }
    }
}
