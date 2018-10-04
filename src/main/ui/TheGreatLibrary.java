package ui;

import java.util.*;
import javax.swing.*;

public class TheGreatLibrary {
    private static final String DIVIDER = "---------------------------------------------";
    private ShelfUI bookshelfUI = new BookshelfUI();
    private ShelfUI movieshelfUI = new MovieshelfUI();
    private Scanner scanner = new Scanner(System.in);

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
            System.out.println("1: Manage books");
            System.out.println("2: Manage movies");
            System.out.println("3: Quit");
            System.out.println(DIVIDER);
            operation = scanner.nextLine();
            if (operation.equals("1")){
                bookshelfUI.shelfMainMenu();
            }
            else if (operation.equals("2")){
                movieshelfUI.shelfMainMenu();
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
    }

    // EFFECTS: star TheGreatLibrary app
    public static void main(String[] args) {
        // TODO: add GUI later
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
