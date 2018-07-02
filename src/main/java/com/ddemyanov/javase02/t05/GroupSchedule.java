package com.ddemyanov.javase02.t05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupSchedule {

    private ArrayList <Group <Student, Mark>> list;

    GroupSchedule() {
        this.list = new ArrayList <>();
    }

    ArrayList <Group <Student, Mark>> addGroup(Group <Student, Mark> group) {
        list.add(group);
        return this.list;
    }

    List <Group <Student, Mark>> findAllGroupsByStudent(Student student) {
        return list.stream()
                   .filter(group -> group.containsStudent(student))
                   .collect(Collectors.toList());
    }
}
