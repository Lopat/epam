package com.ddemyanov.javase07.t01.var1;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * В текстовом (или xml) файле содержится информация о переводах средств со счета на счет.
 * Создайте приложение, позволяющее в параллельном режиме обработать эту информацию
 * (счета с приложении представляются собой объекты).
 * Синхронизируйте код приложения используя ключевое слово synchronized (1 вариант)
 * Синхронизируйте код приложения используя библиотеку java.util.concurrent (2 вариант).
 */
public class SynchBank extends Thread{

    // TODO: 22.07.2018
//    Проблема! Синхронизация за счет блокировки счета при операциях перечисления денег.
//    Треды работают в параллели, но отработавшие операции не удаляются.
//    Таким образом, каждая операция вполняется столько раз, сколько тредов запущено.

    public volatile ArrayList<Deposit> list;
    private static final File file = new File("C:\\Users\\Дмитрий\\epam\\src\\main\\resources\\operations.txt");

    SynchBank(ArrayList<Deposit> list) {
        this.list = list;
    }

    @SneakyThrows
    private void performActions() {

//        synchronized (file){

            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;

            while ((s = br.readLine()) != null){
                Pattern pattern = Pattern.compile("(dep[0-9]+) (dep[0-9]+) ([0-9]+)");
                Matcher matcher = pattern.matcher(s);

                if(matcher.find()){

                    sendCashTo(findDeposit(matcher.group(1)),
                               findDeposit(matcher.group(2)),
                               Long.parseLong(matcher.group(3)));
                    System.out.println("SEND " + Thread.currentThread().getName());
                    Thread.currentThread().wait(100);
                }
            }
//        }
    }

    private void sendCashTo(Deposit sender, Deposit receiver, long cash){

        synchronized (sender) { //без обработки дедлока!

            synchronized (receiver) {

                long senderCash = sender.getCash();
                long receiverCash = receiver.getCash();

                receiver.setCash(receiverCash + cash);
                sender.setCash(senderCash - cash);
            }
        }
    }

    @Override
    public void run() {
        performActions();
    }

    private Deposit findDeposit(String id){

        Deposit x = null;
        for (Deposit d : list){
            if (d.getId().equals(id))
                x = d;
        }
        return x;
    }
}