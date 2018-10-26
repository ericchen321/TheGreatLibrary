package model;

import java.util.HashSet;
import java.util.Set;

public class Author extends Artist{
    private Set<Book> books = new HashSet<Book>();

    // constructors
    public Author(String name){
        super(name);
    }

    public String getArtistType(){
        return "author";
    }

    // MODIFIES: this
    // EFFECTS: add given book to author's list of books if not added yet
    public void addBook(Book book){
        if(!books.contains(book)){
            books.add(book);
            book.setBookAuthorName(name);
        }
    }

    // EFFECTS: returns true if this author has authored the given book
    //                  false if not
    public boolean searchBook(Book book){
        return books.contains(book);
    }
}
