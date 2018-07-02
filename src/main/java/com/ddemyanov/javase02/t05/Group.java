package com.ddemyanov.javase02.t05;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Group <S extends Student, M extends Mark> {

    Discipline discipline;
    Map <Student, M> students = new HashMap<>();

    Group(Discipline discipline) {
        this.discipline = discipline;
    }

    public Map<Student, M> addStudent(S student, M mark){
        students.put(student, mark);
        return this.students;
    }

    public boolean containsStudent(Student s){
        return students.containsKey(s);
    }
}
