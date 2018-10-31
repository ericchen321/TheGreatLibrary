package model;

import model.exceptions.EditionAlreadyExistException;
import model.exceptions.SameAuthorAsPreviousException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book{

    private enum Genre {
        ART, BIOGRAPHY, CLASSICS, FANTASY, HISTORY, FICTION, UNCATEGORIZED
    }
    private String name;
    private Author author;
    private List<BookEdition> editions = new ArrayList<>();
    private int yearOfPublish;
    private Genre genre;

    // constructors
    // EFFECTS: constructs a book with given name and author's name;
    //          this book's genre is set to uncategorized;
    //          add this book to the author's list of works
    public Book(String name, String author){
        setName(name);
        this.author = new Author(author);
        this.author.addBook(this);
        setGenre("");
    }

    // EFFECTS: constructs a book with given name, author, year of publish;
    //          if given genre can be recognized then set the book to given genre,
    //          otherwise set book's genre to be uncategorized;
    //          add this book to the author's works
    public Book(String name, String author, String genre, int yop){
        setName(name);
        this.author = new Author(author);
        this.author.addBook(this);
        setYearOfPublish(yop);
        setGenre(genre);
    }

    // setters and getters
    public void setName(String name) {
        this.name = name;
    }

    // MODIFIES: this
    // EFFECTS: if given author does not have same name
    //          then remove this book from current author's books
    //          AND set book's author to given one
    //          AND add this book to given author's work
    //          else if given author has the same name but is not the current one
    //          then throws SameAuthorAsPreviousException
    //          else (given is the current) does nothing
    public void setAuthor(Author author) {
        if (!(this.author == author)) {
            if(this.author.equals(author)){
                throw new SameAuthorAsPreviousException();
            }
            this.author.removeBook(this);
            this.author = author;
            this.author.addBook(this);
        }
    }

    public void setYearOfPublish(int yOfp) {
        yearOfPublish = yOfp;
    }

    // MODIFIES:this
    // EFFECTS: sets this book's genre to given one if genre is recognizable
    //          otherwise sets genre to uncategorized
    public void setGenre(String genre){
        switch (genre) {
            case "art":
                this.genre = Genre.ART;
                break;
            case "biography":
                this.genre = Genre.BIOGRAPHY;
                break;
            case "classics":
                this.genre = Genre.CLASSICS;
                break;
            case "fantasy":
                this.genre = Genre.FANTASY;
                break;
            case "history":
                this.genre = Genre.HISTORY;
                break;
            case "fiction":
                this.genre = Genre.FICTION;
                break;
            default:
                this.genre = Genre.UNCATEGORIZED;
        }
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return author.getName();
    }

    public Author getAuthor(){
        return author;
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

    // MODIFIES: this
    // EFFECTS: updates this's publish year by setting the year to the publish year
    //          of the earliest edition
    private void updateYearOfPub(){
        for (Edition e: editions){
            yearOfPublish = (e.getYearOfPublish() < yearOfPublish)? e.getYearOfPublish():yearOfPublish;
        }
    }

    // REQUIRES: given edition is an edition of this book
    // MODIFIES: this
    // EFFECTS: if given edition exists then do not add, and throws EditionAlreadyExistException
    //          else add given edition, update this's publish year, and return true
    public void addEdition(BookEdition bookEd) throws EditionAlreadyExistException{
        for (BookEdition e: editions){
            if (e.equals(bookEd))
                throw new EditionAlreadyExistException();
        }
        editions.add(bookEd);
        updateYearOfPub();
    }

    public String toString(){
        return name + " by " + author.getName() + " published in " + yearOfPublish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, author);
    }
}
