package ui.operations;

import model.Bookshelf;
import model.exceptions.EditionAlreadyExistException;
import model.exceptions.ISBNNotThirteenDigitException;
import model.exceptions.IDNotValidException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportBookEdOperation extends Operation {
    private Bookshelf bookshelf;
    private JButton cancel = new JButton("Cancel");
    private JButton confirm = new JButton("Confirm");

    // constructors
    public ImportBookEdOperation(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
        createButton("Import an edition for a book");
        initializeButtonAppearance();
        setButtonsActions();
    }

    // MODIFIES: this
    // EFFECTS: set actions for each button of this operation
    private void setButtonsActions() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int ADD_EDITION_DIALOGUE_WIDTH = 400;
                final int ADD_EDITION_DIALOGUE_HEIGHT = 200;
                final int ROW_NUM = 6;
                final int COL_NUM = 4;
                final int HORIZ_SPACING = 2;
                final int VERTI_SPACING = 2;
                JTextField bookName = new JTextField();
                JTextField authorName = new JTextField();
                JTextField publisher = new JTextField();
                JTextField yearOfPublish = new JTextField();
                JTextField isbn = new JTextField();


                JFrame addEditionDialogue = new JFrame("Add edition");
                addEditionDialogue.setLayout(new BorderLayout());
                addEditionDialogue.setMinimumSize(new Dimension(ADD_EDITION_DIALOGUE_WIDTH, ADD_EDITION_DIALOGUE_HEIGHT));
                addEditionDialogue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addEditionDialogue.setLocationRelativeTo(null);
                addEditionDialogue.setVisible(true);
                addEditionDialogue.setLayout(new GridLayout(ROW_NUM,COL_NUM,HORIZ_SPACING,VERTI_SPACING));
                addEditionDialogue.add(new JLabel("Book Name"));
                addEditionDialogue.add(bookName);
                addEditionDialogue.add(new JLabel("Author Name"));
                addEditionDialogue.add(authorName);
                addEditionDialogue.add(new JLabel("Publisher"));
                addEditionDialogue.add(publisher);
                addEditionDialogue.add(new JLabel("Year Published"));
                addEditionDialogue.add(yearOfPublish);
                addEditionDialogue.add(new JLabel("ISBN"));
                addEditionDialogue.add(isbn);
                addEditionDialogue.add(cancel);
                addEditionDialogue.add(confirm);
                confirm.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            bookshelf.addEdition(bookName.getText(),
                                    authorName.getText(),
                                    publisher.getText(),
                                    Integer.parseInt(yearOfPublish.getText()),
                                    isbn.getText());
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
        });
    }
}
