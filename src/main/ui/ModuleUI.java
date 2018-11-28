package ui;

import model.Artwork;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class ModuleUI extends Observable implements Observer{
    protected JPanel panel;
    protected final int INFO_AREA_BORDER_SIZE_VERTICAL = 50;
    protected final int INFO_AREA_BORDER_SIZE_HORIZONTAL = 10;

    // constructors
    public ModuleUI(){
        panel = new JPanel();
    }

    // setters and getters
    public JPanel getTab() {
        return panel;
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
    protected abstract void updateInfoDisplayAreaContent();

    // MODIFIES: this
    // EFFECTS: initializes content in the browsing area: briefly
    //          lists info of entries in the module
    protected abstract void resetInfoDisplayAreaContent();

    // EFFECTS: returns an array of strings with each representing a work on the
    //          given Iterable of artworks
    protected String[] artworkIterableToStrings(Iterable<Artwork> artworkIterable) {
        ArrayList<String> str_works = new ArrayList<>();

        for (Artwork aw: artworkIterable){
            str_works.add(aw.toString());
        }

        String[] strs = new String[str_works.size()];
        return str_works.toArray(strs);
    }

}
