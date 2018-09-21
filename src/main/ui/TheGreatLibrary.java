package ui;

import model.Book;
import java.util.*;

public class TheGreatLibrary {
    private List<Book> listOfBooks = new ArrayList<Book>();
    private Scanner scanner = new Scanner(System.in);
    private String operation;

    // MODIFIES: This; Book objects
    // EFFECTS: constructs the Great Library
    public TheGreatLibrary(){
        printWelcomeMsg();

        while (true) {
            System.out.println("Please select an operation:");
            System.out.println("1: Add a book");
            System.out.println("2: Show all books");
            System.out.println("3: Quit");
            operation = scanner.nextLine();
            if (operation.equals("1")){
                addBooks();
            }
            else if (operation.equals("2")){
                printAllBooks();
            }
            else if (operation.equals("3")){
                break;
            }
            else{
                System.out.println("Invalid operation selected!");
            }
        }
    }

    // EFFECTS: print the welcome message
    public void printWelcomeMsg(){
        System.out.println("Welcome to The Great Library!");
        System.out.println("This is a personal library manager.");
        System.out.println("---------------------------------------------");
    }

    // MODIFIES: This;
    //           book;
    // EFFECTS: add books to the library
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

    // EFFECTS: print all books in the library
    public void printAllBooks(){
        System.out.println(listOfBooks);
    }

    // EFFECTS: star TheGreatLibrary app
    public static void main(String[] args) {
        new TheGreatLibrary();
    }
}
