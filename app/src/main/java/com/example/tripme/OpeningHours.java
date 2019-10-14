package com.example.tripme;

import java.util.HashMap;
import java.util.Map;

public class OpeningHours {

    private Boolean openNow;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getOpenNow() {
        return openNow;
    }

    public void setOpenNow(Boolean openNow) {
        this.openNow = openNow;
    }

    public OpeningHours withOpenNow(Boolean openNow) {
        this.openNow = openNow;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public OpeningHours withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}