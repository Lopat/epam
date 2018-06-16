package com.ddemyanov.javase03.t01;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Необходимо создать класс Crazy Logger, ведущий журнал лога, используя как накопитель объект StringBuilder.
 * Логгер должен содержать методы поиска определеннной информации в логе с ее возможностью вывода в поток вывода.
 * Информацию логгер хранит в форматированном виде: dd-mm-YYYY : hh-mm - message;
 */

public class CrazyLogger {

    private StringBuilder sb;

    CrazyLogger() {
        this.sb = new StringBuilder();
    }

    public void log(String message) {

        Calendar c = new GregorianCalendar();
        sb.append(String.format(" %1$td-%1$tm-%1$tY : %1$tH-%1$tM - %2$s %n", c, message));
    }

    public void printLog() {
        System.out.println(sb);
    }
}
