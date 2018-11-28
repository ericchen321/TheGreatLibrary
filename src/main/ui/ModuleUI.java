package ui;

import model.Artwork;
import model.Shelf;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observer;

public abstract class ModuleUI implements Observer{
    protected JPanel panel;
    protected final int INFO_AREA_BORDER_SIZE_VERTICAL = 50;
    protected final int INFO_AREA_BORDER_SIZE_HORIZONTAL = 10;
    protected JList displayEntries;

    // constructors
    public ModuleUI(){
        panel = new JPanel();
        displayEntries = new JList();
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
        ArrayList<String> stringOfWorks = new ArrayList<>();

        for (Artwork aw: artworkIterable){
            stringOfWorks.add(aw.toString());
        }

        String[] strs = new String[stringOfWorks.size()];
        return stringOfWorks.toArray(strs);
    }

    // REQUIRES: given string formatted as "<work name>/<author name>/..."
    // EFFECTS: returns given string representation of an artwork
    //          to HTML format ("<html>...</html>")
    protected String artWorkStringToHtml(String inString){
        ArrayList<String> workInfo = Shelf.splitOn(inString, "/");
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        for (int i=0; i<workInfo.size(); i++){
            sb.append(workInfo.get(i));
            if (i != workInfo.size() - 1)
                sb.append("<br>");
        }
        sb.append("</html>");
        return sb.toString();
    }

    // REQUIRES: given string formatted as "<html>...</html>"
    // EFFECTS: remove the <html> and </html> part of an html-formatted string
    protected String removeHtmlPreAndSuffix(String inString){
        if(inString.length()== 13)
            return "";
        else
            return inString.substring(6, inString.length()-1-6);
    }

}
