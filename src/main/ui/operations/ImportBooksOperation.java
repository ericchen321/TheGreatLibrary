package ui.operations;

import model.Bookshelf;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        ImportOpButtonListener buttonAL = new ImportOpButtonListener(bookshelf);
        button.addActionListener(buttonAL);
    }

    private class ImportOpButtonListener implements ActionListener {
        Bookshelf bookshelf;

        public ImportOpButtonListener(Bookshelf bookshelf){
            this.bookshelf = bookshelf;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            bookshelf.loadFromFile("input-books.txt");
            System.out.println("Books imported!");
        }
    }
}
