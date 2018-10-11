package ui.operations;

import javax.swing.*;

public abstract class Operation {
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
    }
}
