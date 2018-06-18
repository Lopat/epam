package com.ddemyanov.javase05.t02;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * Создать универсальный класс, позволяющий получить значение из любого property-файла.
 * Физическое чтение файла должно происходить один раз.
 * Обработайте следующие исключительные ситуации: нет файла *property, нет ключа в property-файле.
 */
public class PropertyReader {

    private static Scanner scanner = new Scanner(System.in);
    private static Properties property;

    public static void main(String[] args) {

        getPropertyFile();
        getPropFromProperties();

    }

    static void getPropFromProperties() {
        String propName = scanner.nextLine();

        try {
            String prop = property.getProperty(propName);
            if (null == prop) throw new Exception("Property not found");
            System.out.println(prop);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            getPropFromProperties();
        }
    }

    static void getPropertyFile() {

        System.out.println("Write FileName of property to open");
        String fileName = scanner.nextLine();

        FileInputStream fis = null;
        property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/" + fileName + ".properties");
            property.load(fis);
        } catch (IOException e) {
            System.out.println("Not found");
            getPropertyFile();
        }

        for (String s : property.stringPropertyNames()) {
            System.err.printf("%s%n", s);
        }

        try {
            if (null != fis) fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
