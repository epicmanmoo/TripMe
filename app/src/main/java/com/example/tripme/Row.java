package com.example.tripme;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Row {

    private List<Element> elements = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
