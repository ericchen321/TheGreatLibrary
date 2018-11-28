package ui.operations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExportArtworksOperation extends Operation implements ActionListener {

    // constructors
    // MODIFIES: this
    // EFFECTS: creates a button for this operation;
    //          initialize the button's appearance;
    //          set up behavior when the button is clicked
    public ExportArtworksOperation(){
        createButton("Export");
        initializeButtonAppearance("/imgs/export-by-geotatah.png"); // REFERENCE: icon image by geotatah from www.flaticon.com
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
