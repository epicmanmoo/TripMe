package com.example.tripme;

import java.util.HashMap;
import java.util.Map;

public class Viewport {

    private Northeast northeast;
    private Southwest southwest;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Northeast getNortheast() {
        return northeast;
    }

    public void setNortheast(Northeast northeast) {
        this.northeast = northeast;
    }

    public Viewport withNortheast(Northeast northeast) {
        this.northeast = northeast;
        return this;
    }

    public Southwest getSouthwest() {
        return southwest;
    }

    public void setSouthwest(Southwest southwest) {
        this.southwest = southwest;
    }

    public Viewport withSouthwest(Southwest southwest) {
        this.southwest = southwest;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Viewport withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}