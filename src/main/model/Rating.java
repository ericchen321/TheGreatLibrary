package model;

import model.exceptions.RatingNotValidException;
import model.exceptions.SameWorkAsPreviousException;

public class Rating {
    protected double rating;
    protected Artwork artwork;

    // constructors
    public Rating(Artwork aw, double r){
        try{
            setArtwork(aw);
        }
        catch (SameWorkAsPreviousException e){}
        setRating(r);
    }

    // REQUIRES: this's artwork is non-null
    // MODIFIES: this
    // EFFECTS: if registered artwork is a book and given rating is in [1, 5]
    //          or if registered artwork is a movie and given rating is in [1, 10]
    //          then set this's rating to the given number
    //          else throws RatingNotValidException
    protected void setRating(double r) throws RatingNotValidException {
        if (artwork instanceof Book && r>=0 && r<=5){
            rating = r;
        }
        else if (artwork instanceof Movie && r>=0 && r<=10){
            rating = r;
        }
        else{
            throw new RatingNotValidException();
        }
    };

    // TODO: tests
    // MODIFIES: this, aw
    // EFFECTS: if this's artwork ain't set yet
    //          then set it to given
    //               AND register this for the given artwork
    //          else if this's artwork equals given but ain't the same
    //          then throws SameWorkAsPreviousException
    //          else if this's artwork is the same as given
    //          then does nothing
    //          else remove this from current artwork's rating
    //               AND set this's artwork to given
    //               AND register this for the given artwork
    protected void setArtwork(Artwork aw) throws SameWorkAsPreviousException{
        if (artwork == null){
            artwork = aw;
            aw.setRating(this);
        }
        else if (!artwork.equals(aw)){
            artwork.removeRating();
            this.artwork = aw;
            aw.setRating(this);
        }
        else if (artwork.equals(aw) && artwork != aw){
            throw new SameWorkAsPreviousException();
        }
    }

    protected double getRating(){
        return rating;
    }

    // MODIFIES: this
    // EFFECTS: set this's corresponding work to undefined
    public void removeWork() {
        artwork = null;
    }
}
