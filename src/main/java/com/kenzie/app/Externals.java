package com.kenzie.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Externals {
    @JsonProperty("imdb")
    private String imdb;
    @JsonProperty("thetvdb")
    private int thetvdb;

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public int getThetvdb() {
        return thetvdb;
    }

    public void setThetvdb(int thetvdb) {
        this.thetvdb = thetvdb;
    }
}
