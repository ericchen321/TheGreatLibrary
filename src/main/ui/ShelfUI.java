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

    // constructors
    public ShelfUI(Shelf shelf){
        super();
        this.shelf = shelf;
    }

    @Override
    // MODIFIES: this
    // EFFECTS: update content in the browsing area
    protected void updateInfoDisplayAreaContent() {
        panel.remove(0);
        resetInfoDisplayAreaContent();
    }

    @Override
    // MODIFIES: this
    // EFFECTS: initializes content in the browsing area: briefly
    //          lists info of entries in the module
    protected void resetInfoDisplayAreaContent(){
        final DefaultListModel listModel = new DefaultListModel();

        String[] worksOnShelf = artworkIterableToStrings(shelf);
        for (int i=0; i<worksOnShelf.length; i++){
            String artWorkStringInHtml = artWorkStringToHtml(worksOnShelf[i]);
            listModel.addElement(artWorkStringInHtml);
        }
        displayEntries = new JList(listModel);

        JScrollPane infoDisplayPane = new JScrollPane(displayEntries, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        infoDisplayPane.setBorder(new EmptyBorder(INFO_AREA_BORDER_SIZE_VERTICAL,
                INFO_AREA_BORDER_SIZE_HORIZONTAL,
                INFO_AREA_BORDER_SIZE_VERTICAL,
                INFO_AREA_BORDER_SIZE_HORIZONTAL));
        infoDisplayPane.setPreferredSize(new Dimension(900, 400));
        infoDisplayPane.revalidate();
        infoDisplayPane.repaint();
        panel.add(infoDisplayPane);
        panel.revalidate();
        panel.repaint();
    }



    // EFFECTS: return a list of selected artworks in the browsing area
    public List<Artwork> extractSelectedArtworks(){
        int[] selectedIndicies = displayEntries.getSelectedIndices();
        ArrayList<Artwork> artworks = new ArrayList<>();

        for (int i=0; i<selectedIndicies.length;i++){
            String workString = (String) displayEntries.getModel().getElementAt(i);
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
