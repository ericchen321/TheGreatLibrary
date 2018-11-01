package model;

import model.exceptions.WorkAlreadyExistException;
import model.exceptions.EditionAlreadyExistException;
import model.exceptions.IDNotValidException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bookshelf extends Shelf{

    // MODIFIES: This
    // EFFECTS: if book with same name & author is not on the shelf yet
    //          adds a book to the bookshelf with given name, author, genre (if not
    //          recognized then will be classified as uncategorized), year of publish
    //          AND returns this book
    //          otherwise does not add the book and throws WorkAlreadyExistException
    public Book addBook(String name, String author, String genre, int yop) throws WorkAlreadyExistException {
        Book book = new Book(name, author, genre, yop);
        super.addWork(book);
        return book;
    }

    // TODO: test
    // EFFECTS: if book with given name and author exists
    //          then return the number of editions
    //          else return 0
    public int getEditionSize(String bookName, String authorName){
        return super.getEditionSize(new Book(bookName, authorName));
    }

    // MODIFIES: this
    // EFFECT: write books in text file with given path name to the shelf
    public void loadFromFile(String pathName){
        try{
            List<String> lines = Files.readAllLines(Paths.get(pathName));
            for (String line : lines){
                ArrayList<String> entries = splitOnSlash(line);
                try{
                    addBook(entries.get(0),entries.get(1),entries.get(2),Integer.parseInt(entries.get(3)));
                }
                catch (WorkAlreadyExistException bae){
                    // just chill
                }
            }
        }
        catch(IOException excep){
            excep.printStackTrace();
        }
    }

    // MODIFIES: this
    // EFFECTS: throws IDNotValidException if given ISBN is not valid;
    //          throws IDNotThirteenDigitException if given publish year >= 2007 but given
    //                 ISBN is not 13 digits
    //          else if edition already exists
    //               throws EditionAlreadyExistException
    //          else if book of given edition not on the bookshelf yet then add book & edition
    //                 & returns edition
    //          else add edition with given information to the given book & update book's publish year
    //                 & returns edition
    public void addEdition(String bookName, String authorName, String publisher, int yop, String isbn)
            throws IDNotValidException,EditionAlreadyExistException {
        BookEdition bookEd = new BookEdition(publisher,yop,isbn);
        Book book = new Book(bookName, authorName);
        super.addEdition(book, bookEd);
    }
}
