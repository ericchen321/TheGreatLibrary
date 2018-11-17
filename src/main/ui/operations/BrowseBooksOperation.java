package ui.operations;

import model.Artwork;
import model.Bookshelf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class BrowseBooksOperation extends BrowseArtworksOperation {

    public BrowseBooksOperation(Bookshelf bookshelf) {
        super(bookshelf);
    }

    // MODIFIES: this
    // EFFECTS: set action when button for this operation is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        final int DISPLAY_BOOKS_DIALOGUE_WIDTH = 1000;
        final int DISPLAY_BOOKS_DIALOGUE_HEIGHT = 600;
        final int BOOKS_INFO_AREA_ROW_NUM = 800;
        final int BOOKS_INFO_AREA_COL_NUM = 600;
        final int BOOKS_INFO_AREA_BORDER_SIZE_VERTICAL = 50;
        final int BOOKS_INFO_AREA_BORDER_SIZE_HORIZONTAL = 10;

        JFrame displayBooksDialogue = new JFrame("Browse Books");
        displayBooksDialogue.setLayout(new BorderLayout());
        displayBooksDialogue.setMinimumSize(new Dimension(DISPLAY_BOOKS_DIALOGUE_WIDTH, DISPLAY_BOOKS_DIALOGUE_HEIGHT));
        displayBooksDialogue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayBooksDialogue.setLocationRelativeTo(null);
        displayBooksDialogue.setVisible(true);
        JList infoDisplayArea = new JList(shelf.printWorks());

        JScrollPane infoDisplayPane = new JScrollPane(infoDisplayArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        infoDisplayPane.setBorder(new EmptyBorder(BOOKS_INFO_AREA_BORDER_SIZE_VERTICAL,
                BOOKS_INFO_AREA_BORDER_SIZE_HORIZONTAL,
                BOOKS_INFO_AREA_BORDER_SIZE_VERTICAL,
                BOOKS_INFO_AREA_BORDER_SIZE_HORIZONTAL));

        displayBooksDialogue.add(infoDisplayPane);
    }
}
