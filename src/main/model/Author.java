package model;

import model.exceptions.SameAuthorAsPreviousException;

import java.util.HashSet;
import java.util.Set;

/*INVARIANTS: every book in the author's authored
* book list should always be authored by this author*/
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
    // EFFECTS: if given book has author with same name but the author is not this
    //          then throws SameAuthorAsPreviousException
    //          otherwise add given book to this author's books AND set given book's author to this
    public void addBook(Book book){
        if(book.getAuthor().equals(this) && book.getAuthor()!=this){
            throw new SameAuthorAsPreviousException();
        }

        if(!books.contains(book)){
            books.add(book);
            book.setAuthor(this);
        }
    }

    // TODO: tests
    // EFFECTS: remove given book from the author's books if exists
    //          otherwise does nothing
    public void removeBook(Book book){
        books.remove(book);
    };

    // TODO: question related to mutating field in objects in a hashSet
    // EFFECTS: returns true if this author has authored the given book
    //                  false if not
    public boolean searchBook(Book book){
        for(Book b: books){
            assert (books.contains(b));
            if (b.equals(book))
                return true;
        }
        return false;
    }
}
