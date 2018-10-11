package ui;

import model.Bookshelf;
import ui.operations.ImportBooksOperation;
import ui.operations.ImportOperation;
import ui.operations.Operation;

import java.util.Scanner;

public class BookshelfUI extends ShelfUI {
    private Bookshelf bookshelf = new Bookshelf();

    // MODIFIES: this
    // EFFECTS: adds all available operations to the bookshelf
    //          and adds each operation's button to the bookshelf's panel
    public void addOperations() {
        Operation importBookOp = new ImportBooksOperation(bookshelf);
        operations.add(importBookOp);
        this.panel.add(importBookOp.getButton());
    }

}
