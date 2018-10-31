package model;

/*INVARIANTS: every book in the author's authored
* book list should always be authored by this author*/
public class Author extends Artist{

    // constructors
    public Author(String name){
        super(name);
    }

    public String getArtistType(){
        return "author";
    }

    // MODIFIES: this
    // EFFECTS: if given book has author with same name but the author is not this
    //          then throws SameCreatorAsPreviousException
    //          otherwise add given book to this author's books AND set given book's author to this
    public void addBook(Book book){
        super.addWork(book);
    }

    // EFFECTS: returns true if this author has authored the given book
    //                  false if not
    public boolean searchBook(Book book){
        return super.searchWork(book);
    }
}
