package ui.operations;

import model.Shelf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ImportEditionOperation extends Operation implements ActionListener{
    protected Shelf shelf;
    protected JButton cancel = new JButton("Cancel");
    protected JButton confirm = new JButton("Confirm");
    protected JTextField workName = new JTextField();
    protected JTextField creatorName = new JTextField();
    protected JTextField publisher = new JTextField();
    protected JTextField yearOfPublish = new JTextField();
    protected JTextField id = new JTextField();

    // constructors
    public ImportEditionOperation(Shelf s, String type){
        shelf = s;
        createButton("Import an edition for a " + type);
        initializeButtonAppearance();
        button.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: sets actions when button for this operation is clicked;
    //          also sets actions when "Cancel"/"Confirm" is clicked
    public abstract void actionPerformed(ActionEvent e);

    // REQUIRES: given String must be "book" or "movie"
    protected void initializeDialogue(String type){
        final int ADD_EDITION_DIALOGUE_WIDTH = 400;
        final int ADD_EDITION_DIALOGUE_HEIGHT = 200;
        final int ROW_NUM = 6;
        final int COL_NUM = 4;
        final int HORIZ_SPACING = 2;
        final int VERTI_SPACING = 2;

        JFrame addEditionDialogue = new JFrame("Add edition");
        addEditionDialogue.setLayout(new BorderLayout());
        addEditionDialogue.setMinimumSize(new Dimension(ADD_EDITION_DIALOGUE_WIDTH, ADD_EDITION_DIALOGUE_HEIGHT));
        addEditionDialogue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addEditionDialogue.setLocationRelativeTo(null);
        addEditionDialogue.setVisible(true);
        addEditionDialogue.setLayout(new GridLayout(ROW_NUM,COL_NUM,HORIZ_SPACING,VERTI_SPACING));
        addEditionDialogue.add(new JLabel((type.equals("book")? "Book":"Movie") + " Name"));
        addEditionDialogue.add(workName);
        addEditionDialogue.add(new JLabel((type.equals("book")? "Author":"Director") +" Name"));
        addEditionDialogue.add(creatorName);
        addEditionDialogue.add(new JLabel("Publisher"));
        addEditionDialogue.add(publisher);
        addEditionDialogue.add(new JLabel("Year Published"));
        addEditionDialogue.add(yearOfPublish);
        addEditionDialogue.add(new JLabel(type.equals("book")? "ISBN":"IMDBN"));
        addEditionDialogue.add(id);
        addEditionDialogue.add(cancel);
        addEditionDialogue.add(confirm);
    }
}
