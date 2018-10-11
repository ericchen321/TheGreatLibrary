package ui;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TheGreatLibrary extends JFrame{
    private static final String DIVIDER = "---------------------------------------------";
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;
    private BookshelfUI bookshelfUI = new BookshelfUI();
    private MovieshelfUI movieshelfUI = new MovieshelfUI();
    private Scanner scanner = new Scanner(System.in);

    private String operation;

    // TODO: refactored app constructor for GUI
    // MODIFIES: This;
    //           Bookshelf object
    //           Book objects
    // EFFECTS: constructs the Great Library
    public TheGreatLibrary(){
        super("The Great Library 2019");
        printWelcomeMsg();
        initializeGraphics();

    }

    // REFERENCE: https://docs.oracle.com/javase/tutorial/uiswing/components/tabbedpane.html
    // MODIFIES: this
    // EFFECTS:  draws the JFrame window for The Great Library,
    //           draws tabbed panes for books, movies,
    //           lists available operations for books, movies
    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        bookshelfUI.addOperations();
        movieshelfUI.addOperations();
        JTabbedPane tabbedPane = new JTabbedPane();
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
