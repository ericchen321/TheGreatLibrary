package ui;

import model.Bookshelf;
import ui.operations.ImportBookEdOperation;
import ui.operations.ImportBooksOperation;
import ui.operations.Operation;

public class BookshelfUI extends ModuleUI {
    private Bookshelf bookshelf;

    // constructors
    public BookshelfUI(Bookshelf bs){
        super();
        bookshelf = bs;
    }

    // MODIFIES: this
    // EFFECTS: adds all available operations to the bookshelf
    //          and adds each operation's button to the bookshelf's panel
    public void addOperations() {
        Operation importBookOp = new ImportBooksOperation(bookshelf);
        operations.add(importBookOp);
        this.panel.add(importBookOp.getButton());
        Operation importBookEdOp = new ImportBookEdOperation(bookshelf);
        operations.add(importBookEdOp);
        this.panel.add(importBookEdOp.getButton());
    }

}
