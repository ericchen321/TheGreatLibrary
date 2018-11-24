package ui;

import ui.operations.Operation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public abstract class ModuleUI implements Observer{
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
