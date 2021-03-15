package com.company;

import java.util.Objects;

public class Area {
    private CandyBag candyBag;
    private int number;
    private String street;

    public Area() {
        this.street = "";
        this.number = 0;
        this.candyBag = new CandyBag();
    }

    public Area(CandyBag candyBag, int number, String street) {
        this.candyBag = candyBag;
        this.number = number;
        this.street = street;
    }

    public void printAdress(){
       System.out.println("Strada " + street + ", numarul " + number);

        candyBag.getCandyBoxes().forEach(System.out::println);
//        for (CandyBox box : candyBag.getCandyBoxes() ) {
//            System.out.println(box);
//        }


    }
}
