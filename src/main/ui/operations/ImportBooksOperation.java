package ui.operations;

import model.Bookshelf;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class ImportBooksOperation extends ImportOperation {
    // constructors
    public ImportBooksOperation(Bookshelf bookshelf){
        createButton();
        initializeButtonAppearance();
        setButtonAction(bookshelf);
    }

    // MODIFIES: this
    // EFFECTS: instantiates a button with a title
    //          referring to the operation
    protected void createButton() {
        button = new JButton("Import Books");
    }

    // MODIFIES: this
    // EFFECTS: set action when button for import operation is clicked
    private void setButtonAction(Bookshelf bookshelf){
        ImportOpActionListener buttonAL = new ImportBookActionListener(bookshelf);
        button.addActionListener(buttonAL);
    }

    private class ImportBookActionListener extends ImportOpActionListener {
        public ImportBookActionListener(Bookshelf bookshelf) {
            super(bookshelf);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            bookshelf.loadFromFile("input-books.txt");
            System.out.println("Books imported!");
        }
    }


}
