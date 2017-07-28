package com.ajspeller.packtplantsexample.dto;

/**
 * Created by ny2va on 7/27/2017.
 */

public class TreeDTO extends PlantDTO {

    private int maxHeight;
    private String fallColor;

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public String getFallColor() {
        return fallColor;
    }

    public void setFallColor(String fallColor) {
        this.fallColor = fallColor;
    }

    @Override
    public String toString() {
        return "Tree : " + super.toString() + " " + getMaxHeight() + " " + getFallColor();
    }
}
