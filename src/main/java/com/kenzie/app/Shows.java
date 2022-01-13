package com.kenzie.app;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Shows {
    @JsonProperty("show")
    private Show show;
    @JsonProperty("score")
    private double score;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
