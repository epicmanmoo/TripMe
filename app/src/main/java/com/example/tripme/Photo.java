package com.example.tripme;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Photo {

    private Integer height;
    private List<String> htmlAttributions = null;
    private String photoReference;
    private Integer width;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Photo withHeight(Integer height) {
        this.height = height;
        return this;
    }

    public List<String> getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(List<String> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    public Photo withHtmlAttributions(List<String> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
        return this;
    }

    public String getPhotoReference() {
        return photoReference;
    }

    public void setPhotoReference(String photoReference) {
        this.photoReference = photoReference;
    }

    public Photo withPhotoReference(String photoReference) {
        this.photoReference = photoReference;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Photo withWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Photo withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}