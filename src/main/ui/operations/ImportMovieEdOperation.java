package ui.operations;

import model.Movie;
import model.MovieEdition;
import model.Movieshelf;
import model.exceptions.EditionAlreadyExistException;
import model.exceptions.IDNotValidException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportMovieEdOperation extends ImportEditionOperation{

    // constructors
    public ImportMovieEdOperation(Movieshelf ms) {
        super(ms, "movie");
    }

    // MODIFIES: this
    // EFFECTS: sets actions when button for this operation is clicked - creates
    //          a dialogue for user to enter info for a movie edition
    //          also sets actions when "Cancel"/"Confirm" in this operation are clicked
    public void actionPerformed(ActionEvent e){
        initializeDialogue("movie");
        confirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Movie m = new Movie(workName.getText(),
                            creatorName.getText(),
                            "",
                            Integer.parseInt(yearOfPublish.getText()));
                    MovieEdition me = new MovieEdition(publisher.getText(),
                            Integer.parseInt(yearOfPublish.getText()),
                            id.getText());
                    shelf.addEdition(m,me);
                    System.out.println("Edition added!");
                }
                catch(EditionAlreadyExistException exc){
                    System.out.println("Sorry, edition not added because it's already there!");
                }
                catch (IDNotValidException exc){
                    System.out.println("Sorry, edition not added: IMDBN should not contain numbers and must be 9-digits long!");
                }
            }
        });
    }
}
