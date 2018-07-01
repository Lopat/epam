package com.ddemyanov.javase06.t03;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

/**
 * Определена иерархия классов
 * class MedicalStaff{}
 * class Doctor extends MedicalStaff{}
 * class Nurse extends MedicalStaff{}
 * class HeadDoctor extends Doctor{}
 * Укажите корректные и некорректные операторы. Дайте ответу пояснение.
 * Doctor doctor1 = new Doctor();
 * Doctor doctor2 = new MedicalStaff();
 * Doctor doctor3 = new HeadDoctor();
 * Object object1 = new HeadDoctor();
 * HeadDoctor doctor5 = new Object();
 * Doctor doctor6 = new Nurse();
 * Nurse nurse = new Doctor();
 * Object object2 = new Nurse();
 * List<Doctor> list1= new ArrayList<Doctor>();
 * List<MedicalStaff> list2 = new ArrayList<Doctor>();
 * List<Doctor> list3 = new ArrayList<MedicalStaff>();
 * List<Object> list4 = new ArrayList<Doctor>();
 * List<Object> list5 = new ArrayList<Object>();
 */
public class CollectionsRefs {

    public static void main(String[] args) {

        Doctor doctor1 = new Doctor(); //ссылка Doc -> объект Doc. Все верно
//        Doctor doctor2 = new MedicalStaff(); ссылка Doctor может ссылаться либо на Doctor, либо объект подкласса.
        Doctor doctor3 = new HeadDoctor(); //ссылка Doc -> объект подкласса. Все верно
        Object object1 = new HeadDoctor(); // Ссылки Object могут ссылаться на любой объект. Все верно
//        HeadDoctor doctor5 = new Object(); ссылка HeadDoctor может ссылаться либо на HeadDoctor, либо объект подкласса.
//        Doctor doctor6 = new Nurse(); Nurse и Doctor находятся в разных ветках иерархии наследования, хоть и наследники от MedStaff
//        Nurse nurse = new Doctor(); Nurse и Doctor находятся в разных ветках иерархии наследования, хоть и наследники от MedStaff
        Object object2 = new Nurse(); // Ссылки Object могут ссылаться на любой объект. Все верно
        List <Doctor> list1 = new ArrayList <>(); //ArrayList - реализация List, жденерики совпадают. Все верно
//        List <MedicalStaff> list2 = new ArrayList <Doctor>(); несовпадение по Generic типам
//        List <Doctor> list3 = new ArrayList <MedicalStaff>(); несовпадение по Generic типам
//        List <Object> list4 = new ArrayList <Doctor>(); несовпадение по Generic типам
        List <Object> list5 = new ArrayList <>(); //ArrayList - реализация List, дженерики совпадают. Все верно
    }
}
