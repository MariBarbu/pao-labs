package com.company;

import java.util.Random;

public class RandomTask implements Task {

    public RandomTask() {

        Random rand = new Random();
        int nr = rand.nextInt();

        System.out.println("RandomTask number " + nr);
    }

    @Override
    public void execute() {

    }
}
