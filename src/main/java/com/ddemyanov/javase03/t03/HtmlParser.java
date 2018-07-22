package com.ddemyanov.javase03.t03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Необходимо определить в тексте html-файла, ссылается ли автор на рисунки последовательно или нет,
 * а также выделить все предложения, в которых встречаются ссылки на рисунки.
 * Для разбора текста использовать регулярные выражения.
 * Статья приведена в приложении к данному файлу заданий.
 */

public class HtmlParser {

    public static void main(String[] args) {
        try {
            URL url = new URL("не нашел приложенную к заданию страницу");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;


            Pattern pattern = Pattern.compile(
                    "<a[^>]+href[\\s]?=[\\s]?[\"']([\\w/]+.)(html|htm)[\"']\\s*[^>]*>" +
                    "<img[^>]+src[\\s]?=[\\s]?[\"']([\\w/]+.)(gif|jpg|jpeg|png|bmp)[\"'][^>]*></a>");
            //<a href="sample.html"><img src="images/sample.gif" width="50" height="50" alt="Пример"></a>

            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if(matcher.matches())
                    System.out.println(matcher.group(1) + matcher.group(2) + " = " + matcher.group(3) + matcher.group(4));
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//    String s = "<a href=\"sample.html\"><img src=\"images/sample.gif\" width=\"50\" height=\"50\" alt=\"Пример\"></a>";
//    Matcher m = pattern.matcher(s);
//     if (m.matches()) System.out.println(m.group(1) + m.group(2) + " = " + m.group(3) + m.group(4));