package com.ddemyanov.javase07.t01.var1;

import lombok.val;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        val deposits = new ArrayList<Deposit>();

        val dep1 = new SynchDeposit("dep1");
        val dep2 = new SynchDeposit("dep2");
        dep1.setCash(3000);
        dep2.setCash(3000);

        deposits.add(dep1);
        deposits.add(dep2);


        SynchBank one = new SynchBank(deposits);
        SynchBank two = new SynchBank(deposits);
        SynchBank three = new SynchBank(deposits);
        SynchBank four = new SynchBank(deposits);

        one.start();
        two.start();
        three.start();
        four.start();

        try {
            one.join();
            two.join();
            three.join();
            four.join();
        } catch (Exception ex){
            System.err.println("failed");
        }

        for (Deposit d : deposits){
            System.out.println(d.getCash());
        }
    }
}
