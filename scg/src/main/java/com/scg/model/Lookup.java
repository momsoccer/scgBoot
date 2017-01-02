package com.scg.model;

/**
 * Created by sungbo on 2016-06-02.
 */
public class Lookup {

    private String name;
    private int id;

    public Lookup() {
    }

    public Lookup(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
