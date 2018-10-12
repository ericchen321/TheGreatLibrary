package ui.operations;

import javax.swing.*;
import java.awt.*;

public abstract class Operation {
    protected static final int BUTTON_WIDTH = 800;
    protected static final int BUTTON_HEIGHT = 150;
    protected static final String BUTTON_FONTNAME = "Arial";
    protected static final int BUTTON_FONTTYPE = Font.PLAIN;
    protected static final int BUTTON_FONTSIZE = 40;
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
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setFont(new Font(BUTTON_FONTNAME, BUTTON_FONTTYPE, BUTTON_FONTSIZE));
    }
}
