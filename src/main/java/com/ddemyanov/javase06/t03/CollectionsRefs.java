package com.ddemyanov.javase06.t03;

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
public class CollectionsRefs {}
