package model;

import model.exceptions.IDNotValidException;

import java.util.ArrayList;
import java.util.List;

public class Book{

    private enum Genre {
        ART, BIOGRAPHY, CLASSICS, FANTASY, HISTORY, FICTION, UNCATAGORIZED
    }
    private String name;
    private Artist author = new Author();
    private List<BookEdition> editions = new ArrayList<>();
    private int yearOfPublish;
    private Genre genre;

    // constructors
    public Book(){}

    // TODO: need test
    public Book(String name, String author){
        this.name = name;
        this.author.setName(author);
        setGenre("uncategorized");
    }

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

    // EFFECTS: return the number of editions
    public int getEditionSize(){
        return editions.size();
    }

    // TODO: test and implementation
    // REQUIRES: given edition is an edition of this book
    // MODIFIES: this
    // EFFECTS: if given edition's publish year is earlier than current
    //          publish year of the book then update to the earlier publish year
    //          and return true
    //          else do not update this book's publish year and return false
    private boolean updateYearOfPub(BookEdition ed){
        return false; // stub
    }

    // TODO: test
    // REQUIRES: given edition is an edition of this book
    // MODIFIES: this
    // EFFECTS: if given edition exists then do not add, and return false
    //          else add given edition and return true
    public boolean addEdition(BookEdition bookEd) {
        for (BookEdition e: editions){
            if (e.getID().equals(bookEd.getID()))
                return false;
        }
        editions.add(bookEd);
        return true;
    }

    public String toString(){
        return name + " by " + author.getName() + " published in " + yearOfPublish;
    }


}
