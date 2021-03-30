package com.company;

public class OutTask implements Task {

    private String mesaj;
    public OutTask(String mesaj) {
        System.out.println("OutTask");
    }

    @Override
    public void execute() {

    }
}
