package com.kenzie.app;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating {
    @JsonProperty("average")
    private double average;

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
