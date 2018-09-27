package model;

import java.io.Serializable;

public class Author implements Serializable{
    private String name;

    // getters
    public String getAuthorName(){
        return name;
    }

    // setters
    public void setAuthorName(String name){
        this.name = name;
    }

}
