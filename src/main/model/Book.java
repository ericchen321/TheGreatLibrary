package model;

import java.util.ArrayList;
import java.util.List;

public class Book{

    private enum Genre {
        ART, BIOGRAPHY, CLASSICS, FANTASY, HISTORY, FICTION, UNCATAGORIZED
    }
    private String name;
    private Artist author = new Author();
    private List<Edition> editions = new ArrayList<>();
    private int yearOfPublish;
    private Genre genre;

    // constructors
    public Book(){}

    public Book(String name, String author, String genre, int yop){
        this.name = name;
        this.author.setName(author);
        this.yearOfPublish = yop;
        setGenre(genre);
    }

    // setters and getters
    public void setBookName(String name) {
        this.name = name;
    }

    public void setBookAuthorName(String author) {
        this.author.setName(author);
    }

    public void setYearOfPublish(int yOfp) {
        yearOfPublish = yOfp;
    }

    // EFFECTS: returns true if genre set to user specified;
    //                  false if set to uncategorized
    public boolean setGenre(String genre) {
        switch (genre) {
            case "art":
                this.genre = Genre.ART;
                return true;
            case "biography":
                this.genre = Genre.BIOGRAPHY;
                return true;
            case "classics":
                this.genre = Genre.CLASSICS;
                return true;
            case "fantasy":
                this.genre = Genre.FANTASY;
                return true;
            case "history":
                this.genre = Genre.HISTORY;
                return true;
            case "fiction":
                this.genre = Genre.FICTION;
                return true;
            default:
                this.genre = Genre.UNCATAGORIZED;
                return false;
        }
    }

    public String getBookName() {
        return name;
    }

    public String getBookAuthorName() {
        return author.getName();
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public String getGenre(){
        switch (genre) {
            case ART:
                return "art";
            case BIOGRAPHY:
                return "biography";
            case CLASSICS:
                return "classics";
            case FANTASY:
                return "fantasy";
            case HISTORY:
                return "history";
            case FICTION:
                return "fiction";
            default:
                return "uncategorized";
        }
    }

    public String toString(){
        return name + " by " + author.getName() + " published in " + yearOfPublish;
    }


}
