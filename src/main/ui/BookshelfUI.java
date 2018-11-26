package ui;

import model.Bookshelf;

public class BookshelfUI extends ShelfUI {

    // constructors
    public BookshelfUI(Bookshelf bookshelf){
        super(bookshelf);
        initializeInfoDisplayAreaContent();
    }

}
