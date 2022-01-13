package com.kenzie.app;

import com.fasterxml.jackson.annotation.JsonProperty;

public class _links {
    @JsonProperty("previousepisode")
    private Previousepisode previousepisode;
    @JsonProperty("self")
    private Self self;

    public Previousepisode getPreviousepisode() {
        return previousepisode;
    }

    public void setPreviousepisode(Previousepisode previousepisode) {
        this.previousepisode = previousepisode;
    }

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }
}
