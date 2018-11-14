package model;

import model.exceptions.RatingNotValidException;
import model.exceptions.SameWorkAsPreviousException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Rating {
    private double rating;
    private Artwork artwork;

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
    public void setRating(double r) throws RatingNotValidException {
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
    public void setArtwork(Artwork aw) throws SameWorkAsPreviousException{
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

    // MODIFIES: this
    // EFFECTS: set this's corresponding work to undefined
    public void removeWork() {
        artwork = null;
    }

    public double getRating(){
        return rating;
    }

    public Artwork getArtwork() {
        return artwork;
    }

    // REQUIRES: this's artwork has already been set
    // MODIFIES: this
    // EFFECTS: if this's registered artwork is a book then fetch from Goodreads
    //          else fetch from IMDB
    public void fetch() throws IOException{
        if (artwork instanceof Book){
            fetchFromGoodreads();
        }
        else{
            fetchFromImdb();
        }
    }

    // MODIFIES: this
    // EFFECTS: assigns the top entry's average rating from Goodreads
    //          to this rating
    private void fetchFromGoodreads() throws IOException{
        BufferedReader br = null;

        try {
            String artWorkName = splitAndRecombineName(artwork.getName());
            String theURL = GoodreadsApi.SEARCH_PREFIX + GoodreadsApi.KEY + "&q=" + artWorkName;
            URL url = new URL(theURL);

            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = br.readLine()) != null) {
                if(line.contains("<average_rating>")){
                    this.rating = extractRatingFromGoodreads(line);
                    break;
                }
            }

        }
        finally {

            if (br != null) {
                br.close();
            }
        }
    }

    // EFFECTS: returns given string in the format acceptable for Goodread's api
    //          ex) "" -> ""
    //          ex) "LOL" -> "LOL"
    //          ex) "Harry Potter" -> "Harry+Potter"
    private String splitAndRecombineName(String original) {
        String[] originalSplit = original.split(" ");
        if (originalSplit.length == 0 || originalSplit.length == 1){
            return original;
        }
        else{
            StringBuilder sb = new StringBuilder();
            sb.append(originalSplit[0]);
            for (int i=1; i<originalSplit.length; i++){
                sb.append("+" + originalSplit[i]);
            }
            return sb.toString();
        }
    }

    // REQUIRES: given String follows the format "...<...>Rating<...>..."
    // EFFECTS: returns numerical rating embedded in the given line
    private double extractRatingFromGoodreads(String line) {
        int startPos = 0;
        int endPos = 0;

        for(int i=0; i<line.length(); i++){
            if(line.charAt(i) == '>') {
                startPos = i + 1;
                break;
            }
        }

        for(int i=startPos; i<line.length();i++){
            if(line.charAt(i) == '<') {
                endPos = i - 1;
                break;
            }
        }

        String rating = line.substring(startPos, endPos+1);
        return Double.parseDouble(rating);
    }

    // TODO
    private void fetchFromImdb() {
    }
}
