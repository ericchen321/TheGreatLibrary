package ui;

import model.Bookshelf;

import java.util.*;

public class TheGreatLibrary {
    private Scanner scanner = new Scanner(System.in);
    private Bookshelf bookshelf = new Bookshelf();
    private String operation;

    // MODIFIES: This;
    //           Bookshelf object
    //           Book objects
    // EFFECTS: constructs the Great Library
    public TheGreatLibrary(){
        printWelcomeMsg();

        while (true) {
            System.out.println("Please select an operation:");
            System.out.println("1: Add a book");
            System.out.println("2: Show all books");
            System.out.println("3: Export books to text file");
            System.out.println("4: Import books from text file");
            System.out.println("5: Quit");
            operation = scanner.nextLine();
            if (operation.equals("1")){
                bookshelf.addBooksUI();
            }
            else if (operation.equals("2")){
                bookshelf.printAllBooks();
            }
            else if (operation.equals("3")){
                bookshelf.exportBooks();
            }
            else if (operation.equals("4")){
                bookshelf.importBooks();
            }
            else if (operation.equals("5")){
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

    // EFFECTS: star TheGreatLibrary app
    public static void main(String[] args) {
        new TheGreatLibrary();
    }
}
