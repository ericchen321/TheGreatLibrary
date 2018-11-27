package ui;

import model.Shelf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public abstract class ShelfUI extends ModuleUI {
    protected Shelf shelf;

    // constructors
    public ShelfUI(Shelf shelf){
        this.shelf = shelf;
    }

    // MODIFIES: this
    // EFFECTS: update browsing area's content AND tell
    //          user content is refreshed
    public void updateBrowsingArea() {
        updateInfoDisplayAreaContent();
        System.out.println("Refreshed!");
    }

    // MODIFIES: this
    // EFFECTS: update content in the browsing area
    protected void updateInfoDisplayAreaContent() {
        panel.remove(0);
        initializeInfoDisplayAreaContent();
    }

    // MODIFIES: this
    // EFFECTSL initializes content in the browsing area: briefly
    //          lists info of works on the shelf
    protected void initializeInfoDisplayAreaContent(){
        final int WORKS_INFO_AREA_BORDER_SIZE_VERTICAL = 50;
        final int WORKS_INFO_AREA_BORDER_SIZE_HORIZONTAL = 10;
        final DefaultListModel listModel = new DefaultListModel();
        reformatAndAdd(shelf.printWorks(),listModel);

        JList infoDisplayArea = new JList(listModel);

        JScrollPane infoDisplayPane = new JScrollPane(infoDisplayArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        infoDisplayPane.setBorder(new EmptyBorder(WORKS_INFO_AREA_BORDER_SIZE_VERTICAL,
                WORKS_INFO_AREA_BORDER_SIZE_HORIZONTAL,
                WORKS_INFO_AREA_BORDER_SIZE_VERTICAL,
                WORKS_INFO_AREA_BORDER_SIZE_HORIZONTAL));
        infoDisplayPane.setPreferredSize(new Dimension(900, 400));
        infoDisplayPane.revalidate();
        infoDisplayPane.repaint();
        panel.add(infoDisplayPane);
        panel.revalidate();
        panel.repaint();
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
