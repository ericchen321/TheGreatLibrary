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

    // EFFECTS: prompts user to put selected works in the active
    //          Shelf UI to a franchise
    @Override
    public void actionPerformed(ActionEvent e) {
        initializeDialogue();
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(activeModule instanceof Bookshelf){
                    franchiseHubUI.addToHub(franchiseNameField.getText(),bookshelfUI.extractSelectedArtworks());
                }
                else if (activeModule instanceof Movieshelf){
                    franchiseHubUI.addToHub(franchiseNameField.getText(),movieshelfUI.extractSelectedArtworks());
                }
            }
        });
    }

    // EFFECTS: opens a dialogue to prompt user to enter the franchise's name
    private void initializeDialogue() {
        final int ADD_TO_FRANCHISE_DIALOGUE_WIDTH = 400;
        final int ADD_TO_FRANCHISE_DIALOGUE_HEIGHT = 100;
        final int ROW_NUM = 2;
        final int COL_NUM = 1;
        final int HORIZ_SPACING = 2;
        final int VERTI_SPACING = 2;

        JFrame addEditionDialogue = new JFrame("Add to franchise");
        addEditionDialogue.setLayout(new BorderLayout());
        addEditionDialogue.setMinimumSize(new Dimension(ADD_TO_FRANCHISE_DIALOGUE_WIDTH, ADD_TO_FRANCHISE_DIALOGUE_HEIGHT));
        addEditionDialogue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addEditionDialogue.setLocationRelativeTo(null);
        addEditionDialogue.setVisible(true);
        addEditionDialogue.setLayout(new GridLayout(ROW_NUM,COL_NUM,HORIZ_SPACING,VERTI_SPACING));
        addEditionDialogue.add(new JLabel("Franchise Name"));
        addEditionDialogue.add(franchiseNameField);
        addEditionDialogue.add(cancel);
        addEditionDialogue.add(confirm);
    }
}
