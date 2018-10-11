package ui.operations;

import model.Bookshelf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ImportOperation extends Operation {

    protected abstract class ImportOpActionListener implements ActionListener {
        Bookshelf bookshelf;

        public ImportOpActionListener(Bookshelf bookshelf){
            this.bookshelf = bookshelf;
        }

        public abstract void actionPerformed(ActionEvent e);
    }
}
