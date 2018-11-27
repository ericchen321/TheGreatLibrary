package ui;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public abstract class ModuleUI extends Observable implements Observer{
    protected JPanel panel;

    // constructors
    public ModuleUI(){
        panel = new JPanel();
    }

    // setters and getters
    public JPanel getTab() {
        return panel;
    }

}
