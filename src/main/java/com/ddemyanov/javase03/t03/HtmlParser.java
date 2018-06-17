package com.ddemyanov.javase03.t03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Pattern;

/**
 * Регулярные выражения Необходимо определить в тексте статьи * (html-файл), ссылается ли автор на рисунки
 * последовательно или нет, а также выделить все предложения, в которых встречаются ссылки на рисунки. Для разбора
 * текста использовать регулярные выражения. Статья приведена в приложении к данному файлу заданий.
 */


public class HtmlParser {

//    public static void main(String[] args) {
//        try {
//            URL url = new URL("https://ru.pinterest.com/");
//            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//            String line;
//
////            //<a href="sample.html"><img src="images/sample.gif" width="50" height="50" alt="Пример"></a>
//            Pattern pattern = Pattern.compile("<[^>]+>");
//
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}