package model;

public class Director extends Artist{

    public Director(String name) {
        super(name);
    }

    public String getArtistType(){
        return "director";
    }
}
