package com.it.demo1.oo;

public class tsetStudent {
    public static void main(String[] args) {
        Student stu=new Student();
        stu.setName("zs");
        stu.setAge(20);
        stu.show();
        Student stu2=new Student("ks",20);
        stu2.show();
    }
}
