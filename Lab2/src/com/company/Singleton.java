package com.company;

public class Singleton {
    private int instance;
    private static Singleton ob = null;

    private Singleton() {
        this.instance = 0;
    }

    public static Singleton getSingleton(){
        if(ob == null) {
            ob = new Singleton();
        }

        return ob;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "instance=" + instance +
                '}';
    }


}
