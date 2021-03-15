package com.company;

import java.sql.SQLOutput;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        //ex1

        CandyBox merci1 = new Merci(Flavor.CHOCOLATE, "chocolate", 15 );
        CandyBox merci2 = new Merci(Flavor.PISTACHIOS, "chocolate", 14 );

        CandyBox lindt1 = new Lindt();
        CandyBox lindt2 = lindt1;

        CandyBox milka1 = new Milka (Flavor.VANILLA, "candy", 5, 10 );
        CandyBox milka2 = new Milka (Flavor.VANILLA, "candy", 5, 10 );

        System.out.println(merci1.equals(merci2)); //false
        System.out.println(lindt1.equals(lindt2)); //true
        System.out.println(milka1.equals(milka2)); //true

        //Pentru equals am ales criteriul de echivalenta astfel:
        //Compara atat aroma si originea din superclasa, cat si campurile din fiecare subclasa
        //Daca cele doua obiecte au aceeasi referinta, atunci sunt automat egale




        CandyBag bag = new CandyBag();

        bag.addBox(merci1);
        bag.addBox(merci2);
        bag.addBox(lindt1);
        bag.addBox(lindt2);
        bag.addBox(milka1);
        bag.addBox(milka2);

        Area area = new Area(bag, 6, "I.L. Caragiale");

        area.printAdress();


        //apelare ex2 - palindrom

        System.out.println("Palindrom?");
        palindrom("123cAaC321");

        //apleare ex3 - anagrame

        System.out.println("Anagrame?");
        anagrame("maro", "omar");



    }
    //ex2

    public static void palindrom(String s){
        Boolean ok = true;
        String str = s.toLowerCase(Locale.ROOT);
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1))
            {
                ok = false;
                break;
            }
        }

        System.out.println(ok);
    }

    //ex3

    public static void anagrame(String s1, String s2)
    {
        Boolean ok = true;
        int[] fr = new int[26];
        for (int i = 0; i < 25; i++) {
            fr[i] = 0;

        }

        for (int i = 0; i < s1.length(); i++) {
            fr[s1.charAt(i)-'a'] ++;

        }

        for (int i = 0; i < s1.length(); i++) {
            fr[s2.charAt(i) - 'a'] -- ;

        }

        for (int i = 0; i < s1.length(); i++) {
            if( fr[i] != 0)
            {
                ok = false;
            }

        }

        System.out.println(ok);








    }



}
