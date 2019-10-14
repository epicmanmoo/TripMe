package com.example.tripme;

import java.util.HashMap;
import java.util.Map;

public class PlusCode {

    private String compoundCode;
    private String globalCode;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getCompoundCode() {
        return compoundCode;
    }

    public void setCompoundCode(String compoundCode) {
        this.compoundCode = compoundCode;
    }

    public PlusCode withCompoundCode(String compoundCode) {
        this.compoundCode = compoundCode;
        return this;
    }

    public String getGlobalCode() {
        return globalCode;
    }

    public void setGlobalCode(String globalCode) {
        this.globalCode = globalCode;
    }

    public PlusCode withGlobalCode(String globalCode) {
        this.globalCode = globalCode;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public PlusCode withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}