package ui.operations;

import model.Movieshelf;
import model.exceptions.EditionAlreadyExistException;
import model.exceptions.IDNotValidException;
import model.exceptions.ISBNNotThirteenDigitException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportMovieEdOperation extends Operation implements ActionListener{
    private Movieshelf movieshelf;
    private JButton cancel = new JButton("Cancel");
    private JButton confirm = new JButton("Confirm");

    // constructors
    public ImportMovieEdOperation(Movieshelf ms) {
        movieshelf = ms;
        createButton("Import an edition for a movie");
        initializeButtonAppearance();
        button.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: sets actions when button for this operation is clicked;
    //          also sets actions when buttons in this operation are clicked
    public void actionPerformed(ActionEvent e){
        final int ADD_EDITION_DIALOGUE_WIDTH = 400;
        final int ADD_EDITION_DIALOGUE_HEIGHT = 200;
        final int ROW_NUM = 6;
        final int COL_NUM = 4;
        final int HORIZ_SPACING = 2;
        final int VERTI_SPACING = 2;
        JTextField movieName = new JTextField();
        JTextField directorName = new JTextField();
        JTextField publisher = new JTextField();
        JTextField yearOfPublish = new JTextField();
        JTextField imdbn = new JTextField();


        JFrame addEditionDialogue = new JFrame("Add edition");
        addEditionDialogue.setLayout(new BorderLayout());
        addEditionDialogue.setMinimumSize(new Dimension(ADD_EDITION_DIALOGUE_WIDTH, ADD_EDITION_DIALOGUE_HEIGHT));
        addEditionDialogue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addEditionDialogue.setLocationRelativeTo(null);
        addEditionDialogue.setVisible(true);
        addEditionDialogue.setLayout(new GridLayout(ROW_NUM,COL_NUM,HORIZ_SPACING,VERTI_SPACING));
        addEditionDialogue.add(new JLabel("Movie Name"));
        addEditionDialogue.add(movieName);
        addEditionDialogue.add(new JLabel("Director Name"));
        addEditionDialogue.add(directorName);
        addEditionDialogue.add(new JLabel("Publisher"));
        addEditionDialogue.add(publisher);
        addEditionDialogue.add(new JLabel("Year Published"));
        addEditionDialogue.add(yearOfPublish);
        addEditionDialogue.add(new JLabel("IMDBN"));
        addEditionDialogue.add(imdbn);
        addEditionDialogue.add(cancel);
        addEditionDialogue.add(confirm);
        confirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    movieshelf.addEdition(movieName.getText(),
                            directorName.getText(),
                            publisher.getText(),
                            Integer.parseInt(yearOfPublish.getText()),
                            imdbn.getText());
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
