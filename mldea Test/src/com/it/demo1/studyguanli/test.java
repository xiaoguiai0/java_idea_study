package com.it.demo1.studyguanli;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        ArrayList<Student> list=new ArrayList<>();

        lo:while (true) {
            System.out.println("--------学生管理系统----------");
            System.out.println("1.add-study");
            System.out.println("2.delete-study");
            System.out.println("3.xiugai-study");
            System.out.println("4.look-study");
            System.out.println("5.tuichu");
            System.out.println("write your choose");
            String choice = sc.next();
            switch (choice) {
                case "1":
//                    System.out.println("add");
                    addStudent(list);
                    break;
                case "2":
//                    System.out.println("delete who:");
                    deleteStudent(list);
                    break;
                case "3":
//                    System.out.println("xiugai");
                    xiugai(list);
                    break;
                case "4":
//                    System.out.println("look");
                    queryStudents(list);
                    break;
                case "5":
                    System.out.println("tuichu");
                    break lo;
                default:
                    System.out.println("warnning");
                    break;
            }
        }
    }

    public static void xiugai(ArrayList<Student> list) {
        System.out.println("write sid");
        Scanner sc=new Scanner(System.in);
        String xiusid=sc.next();
        int index=getIndex(list,xiusid);
        if (index == -1){
            System.out.println("no have");
        }else{
            System.out.println("new name");
            String name=sc.next();
            System.out.println("new age");
            int age=sc.nextInt();
            System.out.println("new birthday");
            String birthday=sc.next();
            Student stu=new Student(xiusid,name,age,birthday);
            list.set(index,stu);
            System.out.println("xiu success");
        }
    }

    public static void deleteStudent(ArrayList<Student> list) {
        System.out.println("wirte sid");
        Scanner sc=new Scanner(System.in);
        String deletesid=sc.next();
        int index=getIndex(list,deletesid);
        if (index ==-1){
            System.out.println("no have");
        }else{
            list.remove(index);
            System.out.println("delete success");
        }
    }

    public static void queryStudents(ArrayList<Student> list) {
        if(list.size()==0){
            System.out.println("no people");
            return;
        }
        System.out.println("sid\tname\tage\tbirthday");
        for (int i = 0; i < list.size(); i++) {
            Student stu= list.get(i);
            System.out.println(stu.getSid()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getBirthday());

        }
    }

    public static void addStudent(ArrayList<Student> list) {
        Scanner sc=new Scanner(System.in);
        String sid ;
        while (true) {
            System.out.println("sid:");
             sid = sc.next();
            if (getIndex(list,sid)!=-1){
                System.out.println("have!!!please write again");
            }else{
                break;
            }
        }
        System.out.println("name:");
        String name= sc.next();
        System.out.println("age");
        int age=sc.nextInt();
        System.out.println("birthday:");
        String birthday=sc.next();
        Student stu=new Student(sid,name,age,birthday);
        list.add(stu);
        System.out.println("add success!");
    }

    public static  int getIndex(ArrayList<Student> list,String sid){
        int index=-1;
        for (int i = 0; i < list.size(); i++) {
            Student stu=list.get(i);
            String id=stu.getSid();
            if(id.equals(sid)){
                index=i;
            }
        }
        return index;
    }
}
