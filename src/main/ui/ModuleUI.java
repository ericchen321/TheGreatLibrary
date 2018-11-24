package ui;

import ui.operations.Operation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class ModuleUI{
    protected JPanel panel;
    protected List<Operation> operations;

    // constructors
    public ModuleUI(){
        panel = new JPanel();
        operations = new ArrayList<>();
    }

    // setters and getters
    public JPanel getTab() {
        return panel;
    }
}
