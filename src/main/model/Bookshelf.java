package model;

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
        if (replicaCheck(book)){
            listOfBooks.add(book);
            return true;
        }
        else{
            return false;
        }
    }

    // EFFECTS: retures true if the bookshelf does not have a book with same name
    //          and author as the given book
    private boolean replicaCheck(Book book){
        boolean replicaNotFound = true;

        for (Book b: listOfBooks){
            replicaNotFound = !((b.getBookName().equals(book.getBookName()))
                    && (b.getBookAuthorName().equals(book.getBookAuthorName())));
            if (!replicaNotFound)
                break;
        }
        return replicaNotFound;
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

    // TODO: need tests and implementation
    // MODIFIES: this
    // EFFECTS: if book not on the shelf yet
    //          then create book & add given edition & return true
    //          else if book already exists but edition not included yet
    //          then add given edition to the book & return true
    //          else do not add edition and return false
    public boolean addEditionToBookshelf(String bookName, String authorName, BookEdition bookEd) {
        return false; // stub
    }
}
