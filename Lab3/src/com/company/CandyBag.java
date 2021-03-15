package com.company;

import java.util.ArrayList;
import java.util.List;

public class CandyBag {
    private List<CandyBox> candyBoxes = new ArrayList<>();

    public List<CandyBox> getCandyBoxes() {
        return candyBoxes;
    }

    public void setCandyBoxes(List<CandyBox> candyBoxes) {
        this.candyBoxes = candyBoxes;
    }

    public void addBox(CandyBox box){
        candyBoxes.add(box);
    }


}
