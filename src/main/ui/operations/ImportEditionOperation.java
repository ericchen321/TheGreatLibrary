package ui.operations;

import model.*;
import model.exceptions.EditionAlreadyExistException;
import model.exceptions.IDNotValidException;
import model.exceptions.ISBNNotThirteenDigitException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportEditionOperation extends Operation implements ActionListener{
    protected JButton cancel = new JButton("Cancel");
    protected JButton confirm = new JButton("Confirm");
    protected JTextField workName = new JTextField();
    protected JTextField creatorName = new JTextField();
    protected JTextField publisher = new JTextField();
    protected JTextField yearOfPublish = new JTextField();
    protected JTextField id = new JTextField();

    // constructors
    public ImportEditionOperation(){
        createButton("Import edition");
        initializeButtonAppearance();
        button.addActionListener(this);
    }

    @Override
    // REFERENCE: https://stackoverflow.com/questions/4801386/how-do-i-add-an-image-to-a-jbutton
    //            icon made by Icon Pond at flaticon.com
    public void initializeButtonAppearance(){
        super.initializeButtonAppearance();
        ImageIcon icon = createImageIcon("/imgs/import-ed.png");
        button.setIcon(icon);
        button.setVerticalTextPosition(AbstractButton.BOTTOM);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setHorizontalAlignment(AbstractButton.CENTER);
    }

    // MODIFIES: this
    // EFFECTS: sets actions when button for this operation is clicked;
    //          also sets actions when "Cancel"/"Confirm" is clicked
    public void actionPerformed(ActionEvent e){
        if (activeModule instanceof Bookshelf){
            initializeDialogue("book");
            confirm.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Book b = new Book(workName.getText(),
                                creatorName.getText(),
                                "",
                                Integer.parseInt(yearOfPublish.getText()));
                        BookEdition be = new BookEdition(publisher.getText(),
                                Integer.parseInt(yearOfPublish.getText()),
                                id.getText());
                        ((Bookshelf) activeModule).addEdition(b,be);
                        System.out.println("Edition added!");
                    }
                    catch(EditionAlreadyExistException exc){
                        System.out.println("Sorry, edition not added because it's already there!");
                    }
                    catch (ISBNNotThirteenDigitException exc){
                        System.out.println("Sorry, edition not added: You need to use the 13-digit ISBN! Or check your publish year!");
                    }
                    catch (IDNotValidException exc){
                        System.out.println("Sorry, edition not added: ISBN can only be 10 or 13 digits!");
                    }
                }
            });
        }
        else if (activeModule instanceof Movieshelf){
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
                        ((Movieshelf) activeModule).addEdition(m,me);
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
        else{
            System.out.println("Operation not supported!");
        }
    }

    // REQUIRES: given String must be "book" or "movie"
    protected void initializeDialogue(String type){
        final int ADD_EDITION_DIALOGUE_WIDTH = 400;
        final int ADD_EDITION_DIALOGUE_HEIGHT = 200;
        final int ROW_NUM = 6;
        final int COL_NUM = 4;
        final int HORIZ_SPACING = 2;
        final int VERTI_SPACING = 2;

        JFrame addEditionDialogue = new JFrame("Add edition");
        addEditionDialogue.setLayout(new BorderLayout());
        addEditionDialogue.setMinimumSize(new Dimension(ADD_EDITION_DIALOGUE_WIDTH, ADD_EDITION_DIALOGUE_HEIGHT));
        addEditionDialogue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addEditionDialogue.setLocationRelativeTo(null);
        addEditionDialogue.setVisible(true);
        addEditionDialogue.setLayout(new GridLayout(ROW_NUM,COL_NUM,HORIZ_SPACING,VERTI_SPACING));
        addEditionDialogue.add(new JLabel((type.equals("book")? "Book":"Movie") + " Name"));
        addEditionDialogue.add(workName);
        addEditionDialogue.add(new JLabel((type.equals("book")? "Author":"Director") +" Name"));
        addEditionDialogue.add(creatorName);
        addEditionDialogue.add(new JLabel("Publisher"));
        addEditionDialogue.add(publisher);
        addEditionDialogue.add(new JLabel("Year Published"));
        addEditionDialogue.add(yearOfPublish);
        addEditionDialogue.add(new JLabel(type.equals("book")? "ISBN":"IMDBN"));
        addEditionDialogue.add(id);
        addEditionDialogue.add(cancel);
        addEditionDialogue.add(confirm);
    }
}
