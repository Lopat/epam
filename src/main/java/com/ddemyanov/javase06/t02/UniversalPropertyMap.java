package com.ddemyanov.javase06.t02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Создать “универсальный” класс, позволяющий получить значение из любого properties-
 * файла. Физическое чтение файла должно происходить только один раз. Результаты чтения
 * храните в коллекции типа Map. Ответьте на вопрос: как ведет себя map-коллекция если в нее
 * добавить элемент с ключом, который уже присутствует?
 */
public class UniversalPropertyMap {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String file = readUserInput();
        Map<String,String> m = getProperties(file);

        for(Map.Entry<String, String > pair : m.entrySet()){
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }

    static String readUserInput() throws IOException {
        return  reader.readLine();
    }

    static Map <String, String> getProperties(String path) throws IOException {

        Map<String, String> propMap = new HashMap <>();
        File file = new File(path);
        Properties properties = new Properties();

        if(file.exists() && file.isFile() && file.getPath().endsWith(".properties")){

            try(FileReader fileReader = new FileReader(path)) {

                properties.load(fileReader);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("File not exist");
        }

        for(String name: properties.stringPropertyNames()){

            propMap.put(name, properties.getProperty(name));

        }

        return propMap;
    }
}
