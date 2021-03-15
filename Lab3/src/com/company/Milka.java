package com.company;

import java.util.Objects;

public class Milka extends CandyBox {

    private int radius;
    private int height;

    public Milka() {
        super();
        this.radius = 0;
        this.height = 0;
    }

    public Milka(Flavor flavor, String origin, int radius, int height) {
        super(flavor, origin);
        this.radius = radius;
        this.height = height;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public double getVolume() {
       return Math.PI*radius*radius*height;
    }

    @Override
    public String toString() {
        return "This " + this.getOrigin() + " " + this.getFlavor() + " has volume " + getVolume();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Milka)) return false;
        Milka milka = (Milka) o;
        return getRadius() == milka.getRadius() && getHeight() == milka.getHeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRadius(), getHeight());
    }
}
