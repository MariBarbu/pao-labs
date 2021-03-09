package com.company;

public class Main {

    public static void main(String[] args) {

        // ex1
        System.out.println("Exercitiul 1: ");
        Person p1 = new Person();
        Person p2 = new Person ("James", "William", 27, 1, Type.MASCULIN);

        System.out.println(p1);
        System.out.println(p2);


        //ex2
        System.out.println("Exercitiul 2: ");

        Room r1 = new Room(1, "Bedroom", "Parquet");
        Room r2 = new Room();

        System.out.println(r1);
        System.out.println(r2);

        //ex3
        System.out.println("Exercitiul 3: ");

        Subject s1 = new Subject(r1, 33, p2);
        Subject s2 = new Subject();

        System.out.println(s1);
        System.out.println(s2);

        //ex4
        System.out.println("Exercitiul 4: ");

        Singleton n1 = Singleton.getSingleton();
        Singleton n2 = Singleton.getSingleton();

        System.out.println(n1 == n2); // afiseaza True pentru ca cele doua obiecte au aceeasi referinta
    }
}



