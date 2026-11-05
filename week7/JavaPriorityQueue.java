package week7;

import java.io.*;
import java.util.*;

class Student {


    private String name;
    private double cgpa;
    private int id;

    public Student(String name, double cgpa, int id ){
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }
    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getCGPA(){
        return cgpa;
    }

    public void display(){
        System.out.println(name);
    }
}

class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2){
        int c1 = Double.compare(s2.getCGPA(), s1.getCGPA());
        if(c1 != 0) return c1;

        int c2 = s1.getName().compareTo(s2.getName());
        if(c2 != 0) return c2;

        int c3 = Integer.compare(s1.getID(), s2.getID());
        return c3;
    }
}

public class JavaPriorityQueue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Student>pq = new PriorityQueue<>(new StudentComparator());
        while(n > 0){
            n --;
            String event = sc.next();
            if(event.equals("ENTER")){
                String name = sc.next();
                double cgpa = sc.nextDouble();
                int id = sc.nextInt();

                Student s = new Student(name, cgpa, id);
                pq.add(s);
            }
            else pq.poll();
        }
        if(pq.isEmpty()) System.out.print("EMPTY");
        else{
            while(!pq.isEmpty()){
                pq.poll().display();
            }
        }
    }
}

