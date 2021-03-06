package ui;

import model.*;
import ui.operations.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TheGreatLibraryUI extends JFrame{
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;
    private BookshelfUI bookshelfUI;
    private MovieshelfUI movieshelfUI;
    private FranchiseHubUI franchiseHubUI;
    private Bookshelf bookshelf = new Bookshelf();
    private Movieshelf movieshelf = new Movieshelf();
    private FranchiseHub franchiseHub = new FranchiseHub();
    private ActiveModuleObservable activeModuleObservable = new ActiveModuleObservable();

    // MODIFIES: This;
    //           Bookshelf object
    //           Book objects
    // EFFECTS: constructs the Great Library
    public TheGreatLibraryUI(){
        super("The Great Library 2019");
        printWelcomeMsg();
        initializeGraphics();
    }

    // REFERENCE: https://docs.oracle.com/javase/tutorial/uiswing/components/tabbedpane.html
    // MODIFIES: this
    // EFFECTS:  draws the JFrame window for The Great Library,
    //           lists available operations for books, movies, franchises
    //           draws tabbed panes for books, movies, franchises
    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        Operation importArtworks = new ImportArtworksOperation();
        Operation importEdition = new ImportEditionOperation();
        Operation refresh = new RefreshOperation();
        Operation addToFranchise = new AddToFranchiseOperation();
        Operation exportArtworks = new ExportArtworksOperation();

        activeModuleObservable.addObserver(importArtworks);
        activeModuleObservable.addObserver(importEdition);
        activeModuleObservable.addObserver(refresh);
        activeModuleObservable.addObserver(addToFranchise);
        activeModuleObservable.addObserver(exportArtworks);
        activeModuleObservable.setActiveModule(bookshelf);

        JToolBar toolBar = new JToolBar("Operations");
        toolBar.add(importArtworks.getButton());
        toolBar.add(exportArtworks.getButton());
        toolBar.add(importEdition.getButton());
        toolBar.add(refresh.getButton());
        toolBar.add(addToFranchise.getButton());
        toolBar.setPreferredSize(new Dimension(WIDTH, HEIGHT/4));
        add(toolBar, BorderLayout.PAGE_START);

        bookshelfUI = new BookshelfUI(bookshelf);
        refresh.addObserver(bookshelfUI);
        ((AddToFranchiseOperation) addToFranchise).setBookshelfUI(bookshelfUI);
        movieshelfUI = new MovieshelfUI(movieshelf);
        ((AddToFranchiseOperation) addToFranchise).setMovieshelfUI(movieshelfUI);
        refresh.addObserver(movieshelfUI);
        franchiseHubUI = new FranchiseHubUI(franchiseHub);
        refresh.addObserver(franchiseHubUI);
        ((AddToFranchiseOperation) addToFranchise).setFranchiseHubUI(franchiseHubUI);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Explore Books", bookshelfUI.getTab());
        tabbedPane.addTab("Explore Movies",movieshelfUI.getTab());
        tabbedPane.addTab("Explore Franchises", franchiseHubUI.getTab());
        // REFERENCE: www.java2s.com/Tutorial/Java/0240__Swing/ListeningforSelectedTabChanges.htm
        tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                switch(sourceTabbedPane.getTitleAt(index)){
                    case "Explore Books":
                        activeModuleObservable.setActiveModule(bookshelf);
                        break;
                    case "Explore Movies":
                        activeModuleObservable.setActiveModule(movieshelf);
                        break;
                    case "Explore Franchises":
                        activeModuleObservable.setActiveModule(franchiseHub);
                        break;
                }
            }
        });
        add(tabbedPane);
        tabbedPane.revalidate();
        tabbedPane.repaint();
    }

    // EFFECTS: print the welcome message
    public void printWelcomeMsg(){
        System.out.println("Welcome to The Great Library!");
        System.out.println("This is a semi-GUI-based personal library manager.");
    }

    // EFFECTS: star TheGreatLibraryUI app
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e){
            System.out.println("UI style initialization failure");
        }
        TheGreatLibraryUI theGreatLibraryUI = new TheGreatLibraryUI();
    }
}
