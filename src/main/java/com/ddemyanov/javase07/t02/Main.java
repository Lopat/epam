package com.ddemyanov.javase07.t02;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File properties = new File("/Bundle_en_US.properties");

        new SynchronizedPropertyReader(properties).start();
        new SynchronizedPropertyReader(properties).start();
        new SynchronizedPropertyReader(properties).start();
        new SynchronizedPropertyReader(properties).start();
        new SynchronizedPropertyReader(properties).start();
        new SynchronizedPropertyReader(properties).start();
        new SynchronizedPropertyReader(properties).start();
        new SynchronizedPropertyReader(properties).start();
        new SynchronizedPropertyReader(properties).start();
        new SynchronizedPropertyReader(properties).start();
        new SynchronizedPropertyReader(properties).start();
        new SynchronizedPropertyReader(properties).start();
        new SynchronizedPropertyReader(properties).start();
    }
}
