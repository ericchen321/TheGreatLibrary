package ui;

import model.Book;
import java.util.*;

public class TheGreatLibrary {
    List<Book> listOfBooks = new ArrayList<Book>();
    Scanner scanner = new Scanner(System.in);

    // constructor
    public TheGreatLibrary(){
        printWelcomeMsg();
        printIntro();
        addBooks();
        printAllBooks();
    }

    // print the welcome message
    public void printWelcomeMsg(){
        System.out.println("Welcome to The Great Library!");
    }

    // print the intro
    public void printIntro(){
        System.out.println("This is a personal library manager.");
    }

    // add books to the library
    public void addBooks(){
        Book book = new Book();

        while (true) {
            System.out.println("Please enter book name:");
            book.setBookName(scanner.nextLine());
            System.out.println("Please enter author's name:");
            book.setBookAuthor(scanner.nextLine());
            System.out.println("Please enter year of publish:");
            book.setYearOfPublish(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Please enter the genre:");
            book.setGenre(book.resolveGenre(scanner.nextLine()));
            System.out.println("Now let's confirm the book's info:");
            System.out.println("book's name: " + book.getBookName());
            System.out.println("book's author: " + book.getAuthor());
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

    // print all books in the library
    public void printAllBooks(){
        System.out.println(listOfBooks);
    }

    // star TheGreatLibrary app
    public static void main(String[] args) {
        new TheGreatLibrary();
    }
}
