package com.kenzie.app;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {
    @JsonProperty("original")
    private String original;
    @JsonProperty("medium")
    private String medium;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
