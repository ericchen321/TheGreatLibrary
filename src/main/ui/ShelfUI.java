package ui;

import javax.swing.*;

public abstract class ShelfUI {
    protected JPanel panel;

    // EFFECTS: interactive loop for the shelf
    public abstract void shelfMainMenu();

    // EFFECTS: return a tab
    public JPanel getTab() {
        return panel;
    }
}
