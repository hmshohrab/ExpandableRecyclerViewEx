package com.example.expandablerecyclerviewex.Models;


import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * @author SHOHRAB
 * @date 29-Jul-19
 */
public class NewsPaperModel  implements Serializable {

@SerializedName("name")
    private String name;
@SerializedName("headlines")
    private List headlines;
@SerializedName("is_Expanded")
    private boolean is_Expanded = false;


    @Override
    public String toString() {
        String ok = (new GsonBuilder().serializeNulls().create().toJson(this));

        return  ok;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getHeadlines() {
        return headlines;
    }

    public void setHeadlines(List headlines) {
        this.headlines = headlines;
    }

    public boolean isIs_Expanded() {
        return is_Expanded;
    }

    public void setIs_Expanded(boolean is_Expanded) {
        this.is_Expanded = is_Expanded;
    }


}
