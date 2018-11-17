package ui.operations;

import model.Book;
import model.BookEdition;
import model.Bookshelf;
import model.exceptions.EditionAlreadyExistException;
import model.exceptions.ISBNNotThirteenDigitException;
import model.exceptions.IDNotValidException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportBookEdOperation extends ImportEditionOperation{

    // constructors
    public ImportBookEdOperation(Bookshelf bs) {
        super(bs, "book");
    }

    // MODIFIES: this
    // EFFECTS: sets actions when button for this operation is clicked - creates
    //          a dialogue for user to enter info for a book edition
    //          also sets actions when "Cancel"/"Confirm" in this operation are clicked
    public void actionPerformed(ActionEvent e){
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
                    shelf.addEdition(b,be);
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
}
