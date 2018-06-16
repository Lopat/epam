package com.ddemyanov.javase04.t01;

import sun.text.normalizer.UTF16;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Прочитайте файл, содержащий код на языке Java.
 * Определите, какие ключевые слова языка Java это код содержит.
 * Выведите эти слова и их количество в другой файл.
 * Используйте только байтовые потоки ввода-вывода.
 */

public class ByteReader {

    public static void main(String[] args) {

        byte[] file;

        try(InputStream fis = new FileInputStream("C:\\Users\\Дмитрий\\Desktop\\английский.txt");
            OutputStream fos = new FileOutputStream("file2"))
        {
            file = new byte[fis.available()];
            while(fis.read() != -1){
                fis.read(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Integer> keywordsFind(byte[] file){

        Map<String, Integer> keywords = new HashMap <>();

        String s = new String(file, Charset.forName("UTF-8"));
        String words ="abstract	continue for new switch" +
                " assert	default	goto	package	synchronized" +
                "boolean	do	if	private	this" +
                "break	double	implements	protected	throw" +
                "byte	else	import	public	throws" +
                "case	enum	instanceof	return	transient" +
                "catch	extends	int	short	try" +
                "char	final	interface	static	void" +
                "class	finally	long	strictfp volatile" +
                "const	float	native	super	while";

        for(String word : words.split(" ")){
            if (keywords.containsKey(word)){
                int k = keywords.get(word);
                keywords.put(word, ++k);
            }
            else
                keywords.put(word, 1);
        }

        return keywords;
    }
}
