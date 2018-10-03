package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bookshelf {
    private static final String SHELFDIVIDER = "=====================";
    private List<Book> listOfBooks = new ArrayList<Book>();
    private Scanner scanner = new Scanner(System.in);


    // EFFECTS: returns the size of the bookshelf
    public int size(){
        return listOfBooks.size();
    }

    // EFFECTS: print all books on the shelf
    public void printAllBooks() {
        System.out.println(SHELFDIVIDER);
        for(Book b:listOfBooks){
            System.out.println(b);
        }
        System.out.println(SHELFDIVIDER);
    }

    // EFFECTS: get the book on the shelf at the given position(0-based index)
    public Book getBook(int pos){
        if (pos>=0 && pos<listOfBooks.size()) {
            return listOfBooks.get(pos);
        }
        return null;
    }

    // MODIFIES: This
    // EFFECTS: adds a book to the bookshelf if not already added and returns true,
    //          otherwise returns false
    public boolean addBook(String name, String author, String genre, int yop){
        Book book = new Book(name, author, genre, yop);
        if (replicaCheck(book)){
            listOfBooks.add(book);
            return true;
        }
        else{
            return false;
        }
    }

    // EFFECTS: retures true if the bookshelf does not have a book with same name,
    //          author, genre, year of publish as the given book
    public boolean replicaCheck(Book book){
        boolean replicaNotFound = true;

        for (Book b: listOfBooks){
            replicaNotFound = !((b.getBookName().equals(book.getBookName()))
                    && (b.getBookAuthorName().equals(book.getBookAuthorName()))
                    && (b.getGenre().equals(book.getGenre()))
                    && (b.getYearOfPublish()==book.getYearOfPublish()));
            if (!replicaNotFound)
                break;
        }
        return replicaNotFound;
    }

    // MODIFIES: This
    // EFFECTS: add books to the bookshelf
    public void addBooksUI(){
        Book book = new Book();

        while (true) {
            System.out.println("Please enter book name:");
            book.setBookName(scanner.nextLine());
            System.out.println("Please enter author's name:");
            book.setBookAuthorName(scanner.nextLine());
            System.out.println("Please enter year of publish:");
            book.setYearOfPublish(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Please enter the genre:");
            book.setGenre(scanner.nextLine());
            System.out.println("Now let's confirm the book's info:");
            System.out.println("book's name: " + book.getBookName());
            System.out.println("book's author: " + book.getBookAuthorName());
            System.out.println("book's publish year:" + book.getYearOfPublish());
            System.out.println("book genre:" + book.getGenre());
            System.out.println("Confirm add to your library? y/n");
            if (scanner.nextLine().equals("y")) {
                listOfBooks.add(book);
                System.out.println("Book added!");
            }
            System.out.println("Want to add another book? y/n");
            if (scanner.nextLine().equals("y")) {
                book = new Book();
            }
            else{
                break;
            }
        }
    }

    // MODIFIES: this
    // EFFECT: write books in text file with given path name to the shelf
    public void scanFromFile(String pathName){
        try{
            List<String> lines = Files.readAllLines(Paths.get(pathName));
            for (String line : lines){
                ArrayList<String> entries = splitOnSlash(line);
                addBook(entries.get(0),entries.get(1),entries.get(2),Integer.parseInt(entries.get(3)));
            }
        }
        catch(IOException excep){
            excep.printStackTrace();
        }
    }

    // TODO: tests & implementation
    // EFFECT: print books on the shelf to textfile with given path name
    public void printToFile(String pathName) {
    }

    // REFERECE: modified based upon FileReaderWriter, CPSC 210
    // EFFECTS: split a string by "/", returns substrings
    public static ArrayList<String> splitOnSlash(String line){
        String[] splits = line.split("/");
        return new ArrayList<String>(Arrays.asList(splits));
    }
}
