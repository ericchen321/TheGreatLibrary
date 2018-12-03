package model;

import model.exceptions.SameCreatorAsPreviousException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Artist {
    protected String name;
    private Set<Artwork> works = new HashSet<Artwork>();

    // constructors
    public Artist(String name){
        this.name = name;
    }

    // getters and setters
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    // TODO: need tests
    // EFFECTS: returns the type of this
    //          artist: author/director/cast/etc
    public abstract String getArtistType();

    // MODIFIES: this, artwork
    // EFFECTS: if given work has creator with same name but the creator is not this
    //          then throws SameCreatorAsPreviousException
    //          otherwise add given work to this artist's works AND set given work's creator to this
    public void addWork(Artwork artwork){
        if(artwork.getCreator().equals(this) && artwork.getCreator()!=this){
            throw new SameCreatorAsPreviousException();
        }

        if(!works.contains(artwork)){
            works.add(artwork);
            artwork.setCreator(this);
        }
    }

    // TODO: tests
    // EFFECTS: remove given work from the artist's works if exists
    //          otherwise does nothing
    public void removeWork(Artwork artwork){
        works.remove(artwork);
    }

    // TODO: question related to mutating field in objects in a hashSet
    // EFFECTS: returns true if this artist has created the given work
    //                  false if not
    public boolean searchWork(Artwork artwork){
        for(Artwork aw: works){
            assert (works.contains(aw));
            if (aw.equals(artwork))
                return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artist)) return false;
        Artist artist = (Artist) o;
        return Objects.equals(name, artist.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
