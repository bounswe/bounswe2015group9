package com.sweng.universalaccess.objects;

/**
 * Created by burakcoskun on 1/7/16.
 */
public class Tags {
    private int id ,taggings_count;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTaggings_count() {
        return taggings_count;
    }

    public void setTaggings_count(int taggings_count) {
        this.taggings_count = taggings_count;
    }
}
