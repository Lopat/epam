package com.ddemyanov.javase02.t05;

import lombok.val;

import java.util.List;

/**
 * Разработайте приложение, позоляющее формировать группы студентов по разным дисциплинам.
 * Состав групп может быть разным.
 * Каждая дисциплина в отдельности определяет, целыми или вещественными будут оценки.
 * Необходимо найти группы, в которые входит студент Х и сравнить его оценки.
 * Для организации перечня дисциплин можно использовать перечисление.
 */
public class Main {

    public static void main(String[] args) {
        val s = new Student("Dmitry", "Demyanov");

        val group = new Group <Student, Mark>(Discipline.ART);
        val mark = RealMark.NOT_CREDITED;
        group.addStudent(s, mark);

        val group1 = new Group <Student, Mark>(Discipline.MATH);
        val mark1 = WholeMark.FOUR;
        group1.addStudent(s, mark1);

        val schedule = new GroupSchedule();
        schedule.addGroup(group);
        schedule.addGroup(group1);

        for (Group g : schedule.findAllGroupsByStudent(s)) {
            System.out.println(g);
        }


    }
}
