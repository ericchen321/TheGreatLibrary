package ui.operations;

import model.Movieshelf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportMoviesOperation extends Operation implements ActionListener {
    private Movieshelf movieshelf;

    // constructors
    public ImportMoviesOperation(Movieshelf ms){
        this.movieshelf = ms;
        createButton("Import Movies");
        initializeButtonAppearance();
        button.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: set action when button for this operation is clicked
    public void actionPerformed(ActionEvent e) {
        movieshelf.loadFromFile("input-movies.txt");
        System.out.println("Movies imported!");
    }
}
