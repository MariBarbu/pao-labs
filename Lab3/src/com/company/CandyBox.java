package com.company;

public abstract class CandyBox {
    final private Flavor flavor;
    final private String origin;

    public CandyBox() {
        this.flavor = Flavor.VANILLA;
        this. origin = "icecream";
    }

    public CandyBox(Flavor flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    public String getOrigin() {
        return origin;
    }

    public abstract double getVolume ();

    @Override
    public String toString() {
        return "CandyBox{" +
                "flavor=" + flavor +
                ", origin='" + origin + '\'' +
                '}';
    }
}
