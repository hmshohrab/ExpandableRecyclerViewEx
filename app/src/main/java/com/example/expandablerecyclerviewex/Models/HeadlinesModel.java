package com.example.expandablerecyclerviewex.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author SHOHRAB
 * @date 29-Jul-19
 */
public class HeadlinesModel implements Serializable {

    @SerializedName("title")
    private String title;
    @SerializedName("short_description")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
