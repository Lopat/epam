package com.ddemyanov.javase03.t02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TreeSet;

/**
 * Приложение в виде списка вопросов под номерами, выбрав номер вопроса, можно узнать на него ответ.
 * Приложение позволяет выбрать английский или русский язык для отображение информации.
 */
public class QuestionsLIst {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        Locale locale = selectLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("Bundle", locale);
        displayQuestions(bundle);
        System.out.println(bundle.getString("st"));
        String read;

        while (!"exit".equalsIgnoreCase(read = reader.readLine())) {

            boolean exist = bundle.containsKey("a" + read);
            if (exist) {
                System.out.println(bundle.getString("a" + read));
            } else System.out.println(bundle.getString("no"));

        }
    }

    static Locale selectLocale() throws IOException {

        System.out.println("Print RU or ENG to select language | Напечатайте RU или ENG для выбора языка");

        String lang = reader.readLine();

        while (true) {
            if ("RU".equalsIgnoreCase(lang)) {
                System.out.println("Выбран русский язык");
                return new Locale("ru", "RU");
            } else if ("ENG".equalsIgnoreCase(lang)) {
                System.out.println("English language selected");
                return new Locale("en", "US");
            } else {
                selectLocale();
            }
        }

    }

    static void displayQuestions(ResourceBundle bundle) {
        TreeSet <String> properties = new TreeSet <>(bundle.keySet());
        for (String prop : properties) {
            if (prop.startsWith("question")) {
                System.out.println(bundle.getString(prop));
            }
        }
    }
}
