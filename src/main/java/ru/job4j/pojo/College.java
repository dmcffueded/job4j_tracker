package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivan Ivanov");
        student.setGroup("1a");
        student.setDate(new Date());

        System.out.println(student.getName() + " has a group " + student.getGroup() + " by date " + student.getDate());
    }
}