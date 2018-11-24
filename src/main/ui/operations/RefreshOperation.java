package ui.operations;

import javax.swing.*;
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
        initializeButtonAppearance();
        button.addActionListener(this);
    }

    // REFERENCE: icon image by Pixel Buhdda from www.flaticon.com
    public void initializeButtonAppearance(){
        super.initializeButtonAppearance("/imgs/refresh-by-Pixel-Buhdda.png");
    }

    // EFFECTS: alerts corresponding module UI for the module being changed
    @Override
    public void actionPerformed(ActionEvent e) {
        setChanged();
        notifyObservers(activeModule);
    }
}
