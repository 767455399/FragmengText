package com.example.administrator.fragmenttext.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Famous {

    @SerializedName("famous_name")
    @Expose
    private String famousName;
    @SerializedName("famous_saying")
    @Expose
    private String famousSaying;

    /**
     *
     * @return
     * The famousName
     */
    public String getFamousName() {
        return famousName;
    }

    /**
     *
     * @param famousName
     * The famous_name
     */
    public void setFamousName(String famousName) {
        this.famousName = famousName;
    }

    /**
     *
     * @return
     * The famousSaying
     */
    public String getFamousSaying() {
        return famousSaying;
    }

    /**
     *
     * @param famousSaying
     * The famous_saying
     */
    public void setFamousSaying(String famousSaying) {
        this.famousSaying = famousSaying;
    }

}
