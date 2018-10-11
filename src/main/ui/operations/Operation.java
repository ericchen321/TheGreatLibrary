package ui.operations;

import javax.swing.*;
import java.awt.*;

public abstract class Operation {
    protected static final int BUTTONWIDTH = 800;
    protected static final int BUTTONHEIGHT = 150;
    protected static final String BUTTONFONTNAME = "Arial";
    protected static final int BUTTONFONTTYPE = Font.PLAIN;
    protected static final int BUTTONFONTSIZE = 40;
    protected JButton button;

    // setters and getters
    public JButton getButton() {
        return button;
    }

    // MODIFIES: this
    // EFFECTS: instantiates a button with a title
    //          referring to the operation
    protected abstract void createButton();

    // REFERENCE: "Simple Drawing Player" from CPSC 210
    // MODIFIES: this
    // EFFECTS:  initializes the button used for this tool
    protected void initializeButtonAppearance() {
        button.setBorderPainted(true);
        button.setFocusPainted(true);
        button.setContentAreaFilled(true);
        button.setPreferredSize(new Dimension(BUTTONWIDTH, BUTTONHEIGHT));
        button.setFont(new Font(BUTTONFONTNAME, BUTTONFONTTYPE, BUTTONFONTSIZE));
    }
}
