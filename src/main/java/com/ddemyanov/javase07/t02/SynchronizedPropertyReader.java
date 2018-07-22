package com.ddemyanov.javase07.t02;

import lombok.SneakyThrows;
import lombok.val;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Создать “универсальный” класс, позволяющий получить значение из любого propFile-файла.
 * Физическое чтение файла должно происходить только один раз.
 * Учтите ситуацию, когда несколько потоков одновременно обращаются к одному и тому же файлу.
 */

class SynchronizedPropertyReader extends Thread{

    private final File propFile;

    SynchronizedPropertyReader(File propFile) {
        this.propFile = propFile;
    }

    @SneakyThrows
    ArrayList<String> readProps(){

        val list = new ArrayList<String>();
        val properties = new Properties();

        synchronized (propFile) {

            properties.load(SynchronizedPropertyReader.class.getResourceAsStream("/" + propFile.getName()));
        }

        for(String name : properties.stringPropertyNames()){

            list.add(name + " = " + properties.getProperty(name));
        }

        return list;
    }

    @Override
    public void run() {
        readProps().forEach(System.out::println);
    }
}