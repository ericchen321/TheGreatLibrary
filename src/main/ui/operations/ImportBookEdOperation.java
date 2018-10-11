package ui.operations;

import model.Bookshelf;

import javax.swing.*;
import java.awt.event.ActionEvent;

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

        // TODO: implementation
        public void actionPerformed(ActionEvent e) {
            System.out.println("Holy cow!");
        }
    }
}
