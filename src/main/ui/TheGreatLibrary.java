package ui;

import model.Bookshelf;
import model.FranchiseHub;
import model.Movieshelf;

import java.awt.*;
import javax.swing.*;

public class TheGreatLibrary extends JFrame{
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;
    private BookshelfUI bookshelfUI;
    private MovieshelfUI movieshelfUI;
    private FranchiseHubUI franchiseHubUI;
    private Bookshelf bookshelf = new Bookshelf();
    private Movieshelf movieshelf = new Movieshelf();
    private FranchiseHub franchiseHub = new FranchiseHub();

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
        bookshelfUI = new BookshelfUI(bookshelf);
        movieshelfUI = new MovieshelfUI(movieshelf);
        franchiseHubUI = new FranchiseHubUI(bookshelf, movieshelf);
        bookshelfUI.addOperations();
        movieshelfUI.addOperations();
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Explore Books", bookshelfUI.getTab());
        tabbedPane.addTab("Explore Movies",movieshelfUI.getTab());
        tabbedPane.addTab("Explore Franchises", franchiseHubUI.getTab());
        add(tabbedPane);
    }

    // EFFECTS: print the welcome message
    public void printWelcomeMsg(){
        System.out.println("Welcome to The Great Library!");
        System.out.println("This is a semi-GUI-based personal library manager.");
    }

    // EFFECTS: star TheGreatLibrary app
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e){
            System.out.println("UI style initialization failure");
        }
        TheGreatLibrary theGreatLibrary = new TheGreatLibrary();
    }
}
