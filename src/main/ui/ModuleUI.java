package ui;

import ui.operations.Operation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ModuleUI {
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

    // MODIFIES: this
    // EFFECTS: adds all available operations to the shelf's panel
    //          and adds each operation's button to the panel of the shelf
    public abstract void addOperations();
}
