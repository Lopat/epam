package com.ddemyanov.javase02.t06;

import com.ddemyanov.javase02.t07.MyAnno;

@MyAnno("Atomic")
public class NuclearSubmarine {

    private final Engine engine;

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
