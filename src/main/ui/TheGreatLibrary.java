package ui;

import model.Bookshelf;
import java.util.*;
import javax.swing.*;

public class TheGreatLibrary {
    private static final String DIVIDER = "---------------------------------------------";
    private Scanner scanner = new Scanner(System.in);
    private Bookshelf bookshelf = new Bookshelf();
    private String operation;

    // TODO: implementation
    // REFERENCE: "Clown Game" from CPSC 210 assignment
    // EFFECTS: create and setup the window
    private static void theGreatLibraryGUI(){
        //Create and set up the window.
        JFrame frame = new JFrame("The Great Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new TGLPanel(false, false, false, false, false));

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    // MODIFIES: This;
    //           Bookshelf object
    //           Book objects
    // EFFECTS: constructs the Great Library
    public TheGreatLibrary(){
        printWelcomeMsg();

        while (true) {
            System.out.println(DIVIDER);
            System.out.println("Please select an operation:");
            System.out.println("1: Add a book/movie");
            System.out.println("2: Show all books & movies");
            System.out.println("3: Scan books & movies from file");
            System.out.println("4: Print books & movies to file");
            System.out.println("5: Quit");
            System.out.println(DIVIDER);
            operation = scanner.nextLine();
            if (operation.equals("1")){
                bookshelf.addUI();
            }
            else if (operation.equals("2")){
                bookshelf.printAll();
            }
            else if (operation.equals("3")){
                bookshelf.scanFromFile("input-books.txt");
            }
            else if (operation.equals("4")){
                bookshelf.printToFile("output-books.txt");
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
    }

    // EFFECTS: star TheGreatLibrary app
    public static void main(String[] args) {
        /*
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                theGreatLibraryGUI();
            }
        });
        */
        TheGreatLibrary theGreatLibrary = new TheGreatLibrary();
    }
}
