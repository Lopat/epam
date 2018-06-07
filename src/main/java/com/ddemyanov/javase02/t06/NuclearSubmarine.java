package com.ddemyanov.javase02.t06;

public class NuclearSubmarine {

    private Engine engine;

    NuclearSubmarine() {
        engine = new Engine();
    }

    public void sail(){
        engine.start();
        System.out.println("Sailing away...");
    }

    private class Engine {
        void start(){
            System.out.println("Engine started");
        }
    }


}
