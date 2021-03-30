package com.company;


public class CountOutTask implements Task {

    private static int increment = 0;
    public CountOutTask() {
        increment ++;
        System.out.println("CounterOutTask " + increment);
    }

    @Override
    public void execute() {

    }
}
