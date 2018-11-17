package ui.operations;

import model.Bookshelf;
import model.Shelf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class BrowseBooksOperation extends BrowseArtworksOperation {

    public BrowseBooksOperation(Bookshelf bookshelf) {
        super(bookshelf);
    }

    // REFERENCE: https://stackoverflow.com/questions/7306295/swing-jlist-with-multiline-text-and-dynamic-height
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
        final DefaultListModel listModel = new DefaultListModel();
        reformatAndAdd(shelf.printWorks(),listModel);
        ;
        JList infoDisplayArea = new JList(listModel);

        JScrollPane infoDisplayPane = new JScrollPane(infoDisplayArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        infoDisplayPane.setBorder(new EmptyBorder(BOOKS_INFO_AREA_BORDER_SIZE_VERTICAL,
                BOOKS_INFO_AREA_BORDER_SIZE_HORIZONTAL,
                BOOKS_INFO_AREA_BORDER_SIZE_VERTICAL,
                BOOKS_INFO_AREA_BORDER_SIZE_HORIZONTAL));

        displayBooksDialogue.add(infoDisplayPane);
    }

    // EFFECTS: adds each work contained in the string array
    //          to the given listModel after formatting them in html
    private void reformatAndAdd(String[] strings, DefaultListModel listModel) {
        for(String s: strings){
            ArrayList<String> workInfo = Shelf.splitOnSlash(s);
            StringBuilder sb = new StringBuilder();
            sb.append("<html>");
            for(String w: workInfo){
                sb.append(w);
                sb.append("<br>");
            }
            sb.append("</html>");
            listModel.addElement(sb.toString());
        }
    }
}
