package com.company;

public class Merci extends CandyBox {

    private int length;

    public Merci() {
        this.length = 0;
    }

    public Merci(Flavor flavor, String origin, int length) {
        super(flavor, origin);
        this.length = length;
    }

    @Override
    public double getVolume() {

        return length^3;
    }

    @Override
    public String toString() {
        return "This " + this.getOrigin() + " " + this.getFlavor() + " has volume " + getVolume();
    }


}
