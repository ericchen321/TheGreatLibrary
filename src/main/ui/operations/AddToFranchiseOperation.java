package ui.operations;

import model.Bookshelf;
import model.Movieshelf;
import ui.BookshelfUI;
import ui.FranchiseHubUI;
import ui.MovieshelfUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddToFranchiseOperation extends Operation implements ActionListener {
    private JFrame addToFranchiseDialogue;
    private JButton cancel = new JButton("cancel");
    private JButton confirm = new JButton("confirm");
    private JTextField franchiseNameField = new JTextField();
    private BookshelfUI bookshelfUI;
    private MovieshelfUI movieshelfUI;
    private FranchiseHubUI franchiseHubUI;

    // constructors
    // MODIFIES: this
    // EFFECTS: creates a button for this operation;
    //          initialize the button's appearance;
    //          set up behavior when the button is clicked
    public AddToFranchiseOperation(){
        createButton("To Franchise");
        initializeButtonAppearance();
        button.addActionListener(this);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToFranchiseDialogue.dispose();
            }
        });
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(activeModule instanceof Bookshelf){
                    franchiseHubUI.addToHub(franchiseNameField.getText(),bookshelfUI.extractSelectedArtworks());
                    System.out.println("Books added to franchise you named!");
                }
                else if (activeModule instanceof Movieshelf){
                    franchiseHubUI.addToHub(franchiseNameField.getText(),movieshelfUI.extractSelectedArtworks());
                    System.out.println("Movies added to franchise you named!");
                }
            }
        });
    }

    // setters and getters
    public void setBookshelfUI(BookshelfUI bookshelfUI) {
        this.bookshelfUI = bookshelfUI;
    }

    public void setMovieshelfUI(MovieshelfUI movieshelfUI) {
        this.movieshelfUI = movieshelfUI;
    }

    public void setFranchiseHubUI(FranchiseHubUI franchiseHubUI) {
        this.franchiseHubUI = franchiseHubUI;
    }

    // REFERENCE: icon image by Freepik from www.flaticon.com
    public void initializeButtonAppearance(){
        super.initializeButtonAppearance("/imgs/add-by-Freepik.png");
    }

    // EFFECTS: prompts user to enter a name for the franchise
    @Override
    public void actionPerformed(ActionEvent e) {
        initializeDialogue();
    }

    // EFFECTS: opens a dialogue to prompt user to enter the franchise's name
    private void initializeDialogue() {
        final int ADD_TO_FRANCHISE_DIALOGUE_WIDTH = 400;
        final int ADD_TO_FRANCHISE_DIALOGUE_HEIGHT = 100;
        final int ROW_NUM = 2;
        final int COL_NUM = 1;
        final int HORIZ_SPACING = 2;
        final int VERTI_SPACING = 2;

        addToFranchiseDialogue = new JFrame("Add to franchise");
        addToFranchiseDialogue.setLayout(new BorderLayout());
        addToFranchiseDialogue.setMinimumSize(new Dimension(ADD_TO_FRANCHISE_DIALOGUE_WIDTH, ADD_TO_FRANCHISE_DIALOGUE_HEIGHT));
        addToFranchiseDialogue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addToFranchiseDialogue.setLocationRelativeTo(null);
        addToFranchiseDialogue.setVisible(true);
        addToFranchiseDialogue.setLayout(new GridLayout(ROW_NUM,COL_NUM,HORIZ_SPACING,VERTI_SPACING));
        addToFranchiseDialogue.add(new JLabel("Franchise Name"));
        addToFranchiseDialogue.add(franchiseNameField);
        addToFranchiseDialogue.add(cancel);
        addToFranchiseDialogue.add(confirm);
    }
}
