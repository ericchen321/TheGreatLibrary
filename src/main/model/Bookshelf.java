package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bookshelf {
    private List<Book> listOfBooks = new ArrayList<Book>();
    private Scanner scanner = new Scanner(System.in);


    // EFFECTS: print all books on the bookshelf
    public void printAllBooks(){
        System.out.println(listOfBooks);
    }

    // EFFECTS: get the book on the shelf at the given position(0-based index)
    public Book getBook(int pos){
        if (pos>=0 && pos<listOfBooks.size()) {
            return listOfBooks.get(pos);
        }
        return null;
    }

    // MODIFIES: This
    // EFFECTS: add a book to the bookshelf, returns true if added successfully
    public boolean addBook(String name, String author, String genre, int yop){
        Book book = new Book(name, author, genre, yop);
        listOfBooks.add(book);
        return true;
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
            book.setGenre(book.resolveGenre(scanner.nextLine()));
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

    // EFFECTS: export the bookshelf to text file
    public void exportBooks(){
        String fileName = "bookShelf";
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listOfBooks);
            oos.close();
            System.out.println("Bookshelf exported");
        }
        catch (IOException excep) {
            excep.printStackTrace();
        }
    }

    // MODIFIES: this
    // EFFECTS: import books from text file
    public void importBooks(){
        String fileName = "bookShelf";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            listOfBooks = (ArrayList) ois.readObject();
            ois.close();
        }
        catch (IOException excep){
            excep.printStackTrace();
        }
        catch(ClassNotFoundException excep){
            excep.printStackTrace();
        }
    }
}
