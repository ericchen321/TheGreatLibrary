package ui.operations;

import model.Module;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public abstract class Operation extends Observable implements Observer{
    protected static final int BUTTON_WIDTH = 180;
    protected static final int BUTTON_HEIGHT = 150;
    protected static final String BUTTON_FONTNAME = "Arial";
    protected static final int BUTTON_FONTTYPE = Font.PLAIN;
    protected static final int BUTTON_FONTSIZE = 20;
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
        button = new JButton();
        button.setText(title);
    };

    // REFERENCE: "Simple Drawing Player" from CPSC 210
    //            https://stackoverflow.com/questions/4801386/how-do-i-add-an-image-to-a-jbutton
    // MODIFIES: this
    // EFFECTS:  initializes the button's size, text, icon
    protected void initializeButtonAppearance(String path) {
        button.setBorderPainted(true);
        button.setFocusPainted(true);
        button.setContentAreaFilled(true);
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setFont(new Font(BUTTON_FONTNAME, BUTTON_FONTTYPE, BUTTON_FONTSIZE));
        ImageIcon icon = createImageIcon(path);
        button.setIcon(icon);
        button.setVerticalTextPosition(AbstractButton.BOTTOM);
        button.setHorizontalTextPosition(AbstractButton.CENTER);

    }

    // REFERENCE: modified based on docs.oracle.com/javase/tutorial/uiswing/components/icon.html
    // EFFECTS: returns an ImageIcon with image of given path,
    //          or null if the path was invalid
    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        activeModule = (Module) arg;
    }
}
