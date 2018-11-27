package ui.operations;

import model.Bookshelf;
import model.Movieshelf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddToFranchiseOperation extends Operation implements ActionListener {
    JButton cancel = new JButton("cancel");
    JButton confirm = new JButton("confirm");
    JTextField franchiseNameField = new JTextField();

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
                setChanged();
                notifyObservers(franchiseNameField.getText());
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
