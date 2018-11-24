package ui;

import model.Bookshelf;
import model.Shelf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

public class BookshelfUI extends ModuleUI {
    final int BOOKS_INFO_AREA_BORDER_SIZE_VERTICAL = 50;
    final int BOOKS_INFO_AREA_BORDER_SIZE_HORIZONTAL = 10;
    private Bookshelf bookshelf;

    // constructors
    public BookshelfUI(Bookshelf bs){
        super();
        bookshelf = bs;
        initializeInfoDisplayAreaContent();
    }

    @Override
    public void update(Observable o, Object arg) {
        updateInfoDisplayAreaContent();
        System.out.println("Refreshed!");
    }

    private void initializeInfoDisplayAreaContent(){
        final DefaultListModel listModel = new DefaultListModel();
        reformatAndAdd(bookshelf.printWorks(),listModel);

        JList infoDisplayArea = new JList(listModel);

        JScrollPane infoDisplayPane = new JScrollPane(infoDisplayArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        infoDisplayPane.setBorder(new EmptyBorder(BOOKS_INFO_AREA_BORDER_SIZE_VERTICAL,
                BOOKS_INFO_AREA_BORDER_SIZE_HORIZONTAL,
                BOOKS_INFO_AREA_BORDER_SIZE_VERTICAL,
                BOOKS_INFO_AREA_BORDER_SIZE_HORIZONTAL));
        infoDisplayPane.setPreferredSize(new Dimension(900, 400));
        panel.add(infoDisplayPane);
        infoDisplayPane.revalidate();
        infoDisplayPane.repaint();
    }

    private void updateInfoDisplayAreaContent() {
        panel.remove(0);
        initializeInfoDisplayAreaContent();
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
