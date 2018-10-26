package model;

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
    // EFFECTS: adds a book to the bookshelf if not already added and returns true,
    //          otherwise returns false
    public boolean add(String name, String author, String genre, int yop){
        Book book = new Book(name, author, genre, yop);
        if (!listOfBooks.contains(book)){
            listOfBooks.add(book);
            return true;
        }
        else{
            return false;
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
                add(entries.get(0),entries.get(1),entries.get(2),Integer.parseInt(entries.get(3)));
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
    // EFFECTS: if book of given edition not on the bookshelf yet then add book & edition
    //          else try to add edition & returns true if addition is successful
    //                                         OR false if not successful
    public boolean addEditionToBookshelf(String bookName, String authorName, String publisher, int yop, String isbn) {
        try{
            BookEdition bookEd = new BookEdition(publisher,yop,isbn);
            Book book = new Book(bookName, authorName);
            for (Book b: listOfBooks){
                if (b.getBookName().equals(bookName) && b.getBookAuthorName().equals(authorName)){
                    return b.addEdition(bookEd);
                }
            }
            listOfBooks.add(book);
            return book.addEdition(bookEd);
        }
        catch (IDNotValidException idNotValidE){
            return false;
        }
    }
}
