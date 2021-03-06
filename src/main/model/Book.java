package model;

import model.exceptions.EditionAlreadyExistException;
import java.io.IOException;

public class Book extends Artwork {

    // FIXME: takes care of the DEFAULT_PUBLISH_YEAR
    // constructors
    // EFFECTS: constructs a book with given name and author's name;
    //          this book's genre is set to uncategorized;
    //          this book's publish year is set to given year
    //          add this book to the author's list of works
    public Book(String name, String author, int yop){
        super(name, "", yop);
        this.creator = new Author(author);
        this.creator.addWork(this);
    }

    // EFFECTS: constructs a book with given name, author, year of publish;
    //          if given genre can be recognized then set the book to given genre,
    //          otherwise set book's genre to be uncategorized;
    //          add this book to the author's works
    public Book(String name, String author, String genre, int yop){
        super(name, genre, yop);
        this.creator = new Author(author);
        this.creator.addWork(this);
    }

    // setters and getters

    // MODIFIES: this
    // EFFECTS: if given author does not have same name
    //          then remove this book from current author's books
    //          AND set book's author to given one
    //          AND add this book to given author's work
    //          else if given author has the same name but is not the current one
    //          then throws SameCreatorAsPreviousException
    //          else (given is the current) does nothing
    public void setAuthor(Author author) {
        super.setCreator(author);
    }

    public String getAuthorName() {
        return super.getCreatorName();
    }

    public Author getAuthor(){
        return (Author) super.getCreator();
    }

    // REQUIRES: given edition is an edition of this book
    // MODIFIES: this
    // EFFECTS: if given edition exists then do not add, and throws EditionAlreadyExistException
    //          else add given edition, register this book for given edition,
    //          update this's publish year, and return true
    public void addEdition(Edition bookEd) throws EditionAlreadyExistException{
        super.addEdition(bookEd);
    }

    // TODO: tests
    // MODIFIES: this
    // EFFECTS: fetches rating from Goodreads
    public void fetchRating() throws IOException{
        this.rating.fetch();
    }
}
