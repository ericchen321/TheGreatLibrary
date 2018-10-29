package model;

import model.exceptions.BookAlreadyExistException;
import model.exceptions.EditionAlreadyExistException;
import model.exceptions.IDNotValidException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bookshelf implements Loadable, Saveable{
    private List<Book> listOfBooks = new ArrayList<Book>();

    // MODIFIES: This
    // EFFECTS: adds a book to the bookshelf with given name, author, genre (if not
    //          recognized then will be classified as uncategorized), year of publish
    //          if book with same name & author is not on the shelf yet
    //          otherwise does not add the book and throws BookAlreadyExistException
    public Book addBook(String name, String author, String genre, int yop) throws BookAlreadyExistException{
        Book book = new Book(name, author, genre, yop);
        if (!listOfBooks.contains(book)){
            listOfBooks.add(book);
            return book;
        }
        else{
            throw new BookAlreadyExistException();
        }
    }

    // TODO: test & implementation (can throw exception)
    // EFFECTS: if book with given name and author exists
    //          then return the number of editions
    //          else return 0
    public int getEditionSize(String bookName, String authorName){
        for (Book b: listOfBooks){
            if (b.getBookName().equals(bookName) && b.getBookAuthorName().equals(authorName))
                return b.getEditionSize();
        }
        return 0;
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
                catch (BookAlreadyExistException bae){
                    // just chill
                }
            }
        }
        catch(IOException excep){
            excep.printStackTrace();
        }
    }

    // EFFECTS: print books on the shelf to textfile with given path name
    public void printToFile(String pathName) {
        try{
            PrintWriter writer = new PrintWriter(pathName,"UTF-8");
            for (Book b: listOfBooks){
                writer.println(b.getBookName()+"/"+b.getBookAuthorName()+"/"+b.getGenre()+"/"+b.getYearOfPublish());
            }
            writer.close(); //note -- if you miss this, the file will not be written at all.
        }
        catch (IOException excep){
            excep.printStackTrace();
        }
    }

    // REFERECE: modified based upon FileReaderWriter, CPSC 210
    // EFFECTS: split a string by "/", returns substrings
    public static ArrayList<String> splitOnSlash(String line){
        String[] splits = line.split("/");
        return new ArrayList<String>(Arrays.asList(splits));
    }

    // MODIFIES: this
    // EFFECTS: throws IDNotValidException if given ISBN is not valid;
    //          throws IDNotThirteenDigitException if given publish year >= 2007 but given
    //                 ISBN is not 13 digits
    //          else if edition already exists
    //               throws EditionAlreadyExistException if given edition already on the shelf
    //          else if book of given edition not on the bookshelf yet then add book & edition
    //                 & returns edition
    //          else add edition with given information to the given book & update book's publish year
    //                 & returns edition
    public Edition addEdition(String bookName, String authorName, String publisher, int yop, String isbn)
            throws IDNotValidException,EditionAlreadyExistException {
        BookEdition bookEd = new BookEdition(publisher,yop,isbn);
        Book book = new Book(bookName, authorName);
        for(Book b: listOfBooks){
            if (b.equals(book)){
                b.addEdition(bookEd);
                return bookEd;
            }
        }
        listOfBooks.add(book);
        book.addEdition(bookEd);
        return bookEd;
    }
}
