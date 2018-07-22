package com.ddemyanov.javase07.t03;

import lombok.SneakyThrows;

import java.util.Random;

public class IntegerSetterGetter extends Thread {

    private final SharedResource resource;
    private boolean run;
    private Random rand = new Random();

    IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    void stopThread() {
        run = false;
    }

    public void run() {

        while (run) {
            if (rand.nextBoolean()) {getIntegersFromResource();}
            else {setIntegersIntoResource();}
        }
        System.out.printf("Поток %s завершил работу.%n", getName());

    }

    @SneakyThrows
    private void getIntegersFromResource() {
        Integer number;

        synchronized (resource) {
            System.out.printf("Поток %s хочет извлечь число.%n", getName());
            number = resource.getElement();

            int counter = 0;
            while (number == null && counter < 5) {
                counter++;
                System.out.printf("Поток %s ждет пока очередь заполнится.%n", getName());
                resource.wait(10);
                System.out.printf("Поток %s возобновил работу.%n", getName());
                number = resource.getElement();
            }
            if (number == null) {
                System.out.printf("Поток %s не извлек число.%n", getName());
                setIntegersIntoResource(); //!
            }
            else {
                System.out.printf("Поток %s извлек число %d%n",getName(), number);
            }
        }
    }


    private void setIntegersIntoResource() {
        synchronized (resource) {
            Integer number = rand.nextInt(100);
            resource.setElement(number);
            System.out.printf("Поток %s записал число %d%n", getName(), number);
            resource.notify();
        }
    }
}