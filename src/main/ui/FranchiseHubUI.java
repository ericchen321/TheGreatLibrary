package ui;

import model.Artwork;
import model.FranchiseHub;
import ui.operations.RefreshOperation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public class FranchiseHubUI extends ModuleUI{
    private FranchiseHub franchiseHub;

    // constructors
    public FranchiseHubUI(FranchiseHub franchiseHub){
        super();
        this.franchiseHub = franchiseHub;
        resetInfoDisplayAreaContent();
    }

    // MODIFIES: this
    // EFFECTS: if an RefreshOperation sends the message
    //          then updates browsing area's content AND tell
    //          user content is refreshed if activeModule is
    //          of FranchiseHub type
    @Override
    public void update(Observable o, Object activeModule) {
        if (o instanceof RefreshOperation && activeModule instanceof FranchiseHub){
            super.updateBrowsingArea();
        }
    }

    @Override
    protected void updateInfoDisplayAreaContent() {
        panel.remove(0);
        resetInfoDisplayAreaContent();
    }

    @Override
    protected void resetInfoDisplayAreaContent() {
        final DefaultListModel listModel = new DefaultListModel();

        for(Map.Entry<String, Set<Artwork>> franchise: franchiseHub){
            String franchiseString = assembleFranchiseString(franchise);
            franchiseString = reformatFranchiseString(franchiseString);
            listModel.addElement(franchiseString);
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

    private String assembleFranchiseString(Map.Entry<String, Set<Artwork>> franchise) {
        StringBuilder sb = new StringBuilder();
        sb.append(franchise.getKey());
        String[] worksInString = artworkIterableToStrings(franchise.getValue());
        for (String s: worksInString){
            sb.append(s);
        }
        return sb.toString();
    }

    private String reformatFranchiseString(String franchiseString) {
        return franchiseString;
    }

    // EFFECTS: add franchise with given name and artworks to the hub
    public void addToHub(String franchiseName, List<Artwork> artworks) {
        for (Artwork aw: artworks){
            franchiseHub.addToFranchise(franchiseName, aw);
        }
        System.out.println("Works added to franchise you named!");
    }
}
