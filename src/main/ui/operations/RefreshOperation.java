package ui.operations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RefreshOperation extends Operation implements ActionListener{

    // constructors
    // MODIFIES: this
    // EFFECTS: creates a button for this operation;
    //          initialize the button's appearance;
    //          set up behavior when the button is clicked
    public RefreshOperation(){
        createButton("Refresh");
        initializeButtonAppearance("/imgs/refresh-by-Pixel-Buhdda.png"); // REFERENCE: icon image by Pixel Buhdda from www.flaticon.com
        button.addActionListener(this);
    }

    // EFFECTS: alerts corresponding module UI for the module being changed
    @Override
    public void actionPerformed(ActionEvent e) {
        setChanged();
        notifyObservers(activeModule);
    }
}
