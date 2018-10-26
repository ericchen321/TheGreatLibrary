package model;

import java.util.Objects;

public abstract class Artist {
    protected String name;

    // constructors
    public Artist(String name){
        this.name = name;
    }

    // getters
    public String getName(){
        return name;
    }

    // setters
    public void setName(String name){
        this.name = name;
    }

    // TODO: need tests
    // EFFECTS: return the type of artist: author/director/cast/etc
    public abstract String getArtistType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(name, artist.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
