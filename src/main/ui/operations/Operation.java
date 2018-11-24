package ui.operations;

import model.Module;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public abstract class Operation implements Observer{
    protected static final int BUTTON_WIDTH = 800;
    protected static final int BUTTON_HEIGHT = 150;
    protected static final String BUTTON_FONTNAME = "Arial";
    protected static final int BUTTON_FONTTYPE = Font.PLAIN;
    protected static final int BUTTON_FONTSIZE = 40;
    protected JButton button;
    protected Module activeModule;

    // setters and getters
    public JButton getButton() {
        return button;
    }

    // MODIFIES: this
    // EFFECTS: instantiates a button with given title
    //          referring to the operation
    protected void createButton(String title){
        button = new JButton(title);
    };

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

    @Override
    public void update(Observable o, Object arg) {
        activeModule = (Module) arg;
    }
}
