package model;

public abstract class Artist {
    protected String name;

    // getters
    public String getName(){
        return name;
    }

    // setters
    public void setName(String name){
        this.name = name;
    }

    // TODO: need tests
    // EFFECTS: return the type of artist: artist/author/director/cast
    abstract public String getArtistType();
}
