package com.company;

import java.util.Objects;

public class Lindt extends CandyBox{

    private int length;
    private int width;
    private int height;

    public Lindt() {
        this.length = 0;
        this.width = 0;
        this.height = 0;
    }

    public Lindt(Flavor flavor, String origin, int length, int width, int height) {
        super(flavor, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public double getVolume() {

        return length*width*height;
    }

    @Override
    public String toString() {
        return "This " + this.getOrigin() + " " + this.getFlavor() + " has volume " + getVolume();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lindt)) return false;
        Lindt lindt = (Lindt) o;
        return getLength() == lindt.getLength() && getWidth() == lindt.getWidth() && getHeight() == lindt.getHeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLength(), getWidth(), getHeight());
    }
}
