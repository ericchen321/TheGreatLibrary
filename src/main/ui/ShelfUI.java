package ui;

import model.Artwork;
import model.Shelf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ShelfUI extends ModuleUI{
    protected Shelf shelf;
    private JList workDisplayList;

    // constructors
    public ShelfUI(Shelf shelf){
        this.shelf = shelf;
        workDisplayList = new JList();
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
        resetInfoDisplayAreaContent();
    }

    // MODIFIES: this
    // EFFECTSL initializes content in the browsing area: briefly
    //          lists info of works on the shelf
    protected void resetInfoDisplayAreaContent(){
        final int WORKS_INFO_AREA_BORDER_SIZE_VERTICAL = 50;
        final int WORKS_INFO_AREA_BORDER_SIZE_HORIZONTAL = 10;
        final DefaultListModel listModel = new DefaultListModel();

        String[] worksOnShelf = printAllWorks(shelf);
        reformatAndAdd(worksOnShelf,listModel);
        workDisplayList = new JList(listModel);

        JScrollPane infoDisplayPane = new JScrollPane(workDisplayList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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

    // EFFECTS: returns an array of strings with each representing a work on the shelf
    private String[] printAllWorks(Shelf shelf) {
        ArrayList<String> str_works = new ArrayList<>();

        for (Artwork aw: shelf){
            str_works.add(aw.toString());
        }

        String[] strs = new String[str_works.size()];
        return str_works.toArray(strs);
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

    // EFFECTS: return a list of selected artworks in the browsing area
    public List<Artwork> getSelectedArtworks(){
        int[] selectedIndicies = workDisplayList.getSelectedIndices();
        ArrayList<Artwork> artworks = new ArrayList<>();

        for (int i=0; i<selectedIndicies.length;i++){
            String workString = (String) workDisplayList.getModel().getElementAt(i);
            Artwork aw = buildArtworkFromString(workString);
            Artwork awOnShelf = shelf.getArtwork(aw);
            artworks.add(awOnShelf);
        }

        return artworks;
    }

    // REQUIRES: workString is in format "<html>...</html>";
    //           "..." cannot be empty
    // EFFECTS: return an artwork based on the info in the given string
    protected abstract Artwork buildArtworkFromString(String workString);

    // FIXME: coupling issue with splitOnSplash in Shelf class
    // REFERECE: modified based upon FileReaderWriter, CPSC 210
    // EFFECTS: split a string by "<br>", returns substrings
    public static ArrayList<String> splitOnBreakLine(String line){
        String[] splits = line.split("<br>");
        return new ArrayList<String>(Arrays.asList(splits));
    }
}
