package ui;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent;

public class TheGreatLibrary extends JFrame{
    private static final String DIVIDER = "---------------------------------------------";
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;
    private ShelfUI bookshelfUI = new BookshelfUI();
    private ShelfUI movieshelfUI = new MovieshelfUI();
    private Scanner scanner = new Scanner(System.in);

    private String operation;

    // TODO: refactored app constructor for GUI
    // MODIFIES: This;
    //           Bookshelf object
    //           Book objects
    // EFFECTS: constructs the Great Library
    public TheGreatLibrary(){
        /*
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
        */
        super("The Great Library 2019");
        printWelcomeMsg();
        initializeGraphics();

    }

    // REFERENCE: https://docs.oracle.com/javase/tutorial/uiswing/components/tabbedpane.html
    // MODIFIES: this
    // EFFECTS:  draws the JFrame window for The Great Library,
    //           draws tabbed panes for books, movies, franchises
    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        JTabbedPane tabbedPane = new JTabbedPane();
        BookshelfUI bookshelfUI = new BookshelfUI();
        MovieshelfUI movieshelfUI = new MovieshelfUI();
        tabbedPane.addTab("Explore Books", bookshelfUI.getTab());
        tabbedPane.addTab("Explore Movies",movieshelfUI.getTab());
        add(tabbedPane);
    }

    // EFFECTS: print the welcome message
    public void printWelcomeMsg(){
        System.out.println("Welcome to The Great Library!");
        System.out.println("This is a semi-GUI-based personal library manager.");
    }

    // EFFECTS: star TheGreatLibrary app
    public static void main(String[] args) {
        TheGreatLibrary theGreatLibrary = new TheGreatLibrary();
    }
}
