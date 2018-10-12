package ui.operations;

import model.Bookshelf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportBookEdOperation extends ImportOperation {

    public ImportBookEdOperation(Bookshelf bookshelf) {
        createButton();
        initializeButtonAppearance();
        setButtonAction(bookshelf);
    }

    // MODIFIES: this
    // EFFECTS: instantiates a button with a title
    //          referring to the operation
    protected void createButton() {
        button = new JButton("Import an edition for a book");
    }

    // MODIFIES: this
    // EFFECTS: set action when button for import book ed operation is clicked
    private void setButtonAction(Bookshelf bookshelf) {
        ImportOpActionListener buttonAL = new ImportBookEdActionListener(bookshelf);
        button.addActionListener(buttonAL);
    }

    private class ImportBookEdActionListener extends ImportOpActionListener {

        public ImportBookEdActionListener(Bookshelf bookshelf) {
            super(bookshelf);
        }

        // TODO: may need exception handling
        public void actionPerformed(ActionEvent e) {
            final int ADD_EDITION_DIALOGUE_WIDTH = 400;
            final int ADD_EDITION_DIALOGUE_HEIGHT = 200;
            final int ROW_NUM = 6;
            final int COL_NUM = 4;
            final int HORIZ_SPACING = 2;
            final int VERTI_SPACING = 2;
            JTextField bookName = new JTextField();
            JTextField authorName = new JTextField();
            JTextField publisher = new JTextField();
            JTextField yearOfPublish = new JTextField();
            JTextField isbn = new JTextField();
            JButton cancel = new JButton("Cancel");
            JButton confirm = new JButton("Confirm");

            JFrame addEditionDialogue = new JFrame("Add edition");
            addEditionDialogue.setLayout(new BorderLayout());
            addEditionDialogue.setMinimumSize(new Dimension(ADD_EDITION_DIALOGUE_WIDTH, ADD_EDITION_DIALOGUE_HEIGHT));
            addEditionDialogue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addEditionDialogue.setLocationRelativeTo(null);
            addEditionDialogue.setVisible(true);
            addEditionDialogue.setLayout(new GridLayout(ROW_NUM,COL_NUM,HORIZ_SPACING,VERTI_SPACING));
            addEditionDialogue.add(new JLabel("Book Name"));
            addEditionDialogue.add(bookName);
            addEditionDialogue.add(new JLabel("Author Name"));
            addEditionDialogue.add(authorName);
            addEditionDialogue.add(new JLabel("Publisher"));
            addEditionDialogue.add(publisher);
            addEditionDialogue.add(new JLabel("Year Published"));
            addEditionDialogue.add(yearOfPublish);
            addEditionDialogue.add(new JLabel("ISBN"));
            addEditionDialogue.add(isbn);
            addEditionDialogue.add(cancel);
            addEditionDialogue.add(confirm);

            class ConfirmActionListener implements ActionListener{
                private Bookshelf bookshelf;

                public ConfirmActionListener(Bookshelf bookshelf){
                    this.bookshelf = bookshelf;
                }

                public void actionPerformed(ActionEvent e) {
                    if (bookshelf.addEditionToBookshelf(bookName.getText(),
                                                    authorName.getText(),
                            publisher.getText(),Integer.parseInt(yearOfPublish.getText()),Integer.parseInt(isbn.getText()))){
                        System.out.println("Edition added!");
                    }
                    else{
                        System.out.println("Oops, something's wrong, edition not added.");
                    }
                }
            }

            confirm.addActionListener(new ConfirmActionListener(bookshelf));
        }
    }
}
