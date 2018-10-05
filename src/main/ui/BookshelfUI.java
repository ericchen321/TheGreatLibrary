package ui;

import model.BookEdition;
import model.Bookshelf;
import model.Loadable;
import model.Saveable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookshelfUI implements ShelfUI {
    private static final String SHELFDIVIDER = "=====================";
    private Bookshelf bookshelf = new Bookshelf();
    private Scanner scanner = new Scanner(System.in);
    private String operation;


    // EFFECTS: interactive loop for the bookshelf
    public void shelfMainMenu() {
        while (true){
            System.out.println(SHELFDIVIDER);
            System.out.println("Please select an operation:");
            System.out.println("1: Add books to the bookshelf");
            System.out.println("2: Import books into the bookshelf");
            System.out.println("3: Export books from the bookshelf");
            System.out.println("4: Add editions for a book");
            System.out.println("5: Exit bookshelf");
            System.out.println(SHELFDIVIDER);
            operation = scanner.nextLine();
            if (operation.equals("1")){
                addBooksUI();
            }
            else if (operation.equals("2")){
                importBooksUI();
            }
            else if (operation.equals("3")){
                exportBooksUI();
            }
            else if (operation.equals("4")){
                addBookEditionUI();
            }
            else if (operation.equals("5")){
                break;
            }
            else{
                System.out.println("Invalid operation selected!");
            }
        }

    }

    // MODIFIES: this
    // EFFECTS: add editions of a book
    private void addBookEditionUI() {
        ArrayList<String> editionInfo = new ArrayList<String>();
        System.out.println("Please enter the book's edition in the following format:");
        System.out.println("book name/author name/publisher/year of publish/ISBN");
        editionInfo = Bookshelf.splitOnSlash(scanner.nextLine());
        BookEdition bookEd = new BookEdition(editionInfo.get(2),
                                            Integer.parseInt(editionInfo.get(3)),
                                            Integer.parseInt(editionInfo.get(4)));
        if(bookshelf.addEditionToBookshelf(editionInfo.get(0), editionInfo.get(1),bookEd)){
            System.out.println("Edition added to the bookshelf!");
        }
        else{
            System.out.println("Edition already exists!");
        }
    }

    // MODIFIES: this
    // EFFECTS: import books from text file to the bookshelf
    private void importBooksUI() {
        Loadable bookshelf = this.bookshelf;
        System.out.println("Please enter the info of books you want to import in input-books.txt");
        System.out.println("Press 'r' to continue");
        if (scanner.nextLine().equals("r")){
            bookshelf.loadFromFile("input-books.txt");
        }
        else{
            System.out.println("Input aborted");
        }

    }

    // MODIFIES: this
    // EFFECTS: export books from bookshelf to text file
    private void exportBooksUI() {
        Saveable bookshelf = this.bookshelf;
        System.out.println("Please make sure export-books.txt exists in your source folder");
        System.out.println("Press 'r' to continue");
        if (scanner.nextLine().equals("r")){
            bookshelf.printToFile("export-books.txt");
        }
        else{
            System.out.println("Export aborted");
        }
    }

    // MODIFIES: This
    // EFFECTS: add book to the bookshelf by scanning inputs from keyboard
    private void addBooksUI(){
        String name;
        String author;
        int yop;
        String genre;

        while (true) {
            System.out.println("Please enter book name:");
            name = scanner.nextLine();
            System.out.println("Please enter author's name:");
            author = scanner.nextLine();
            System.out.println("Please enter year of publish:");
            yop = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Please enter the genre:");
            genre = scanner.nextLine();
            System.out.println("Now let's confirm the book's info:");
            System.out.println("book's name: " + name);
            System.out.println("book's author: " + author);
            System.out.println("book's publish year:" + yop);
            System.out.println("book genre:" + genre);
            System.out.println("Confirm add to your library? y/n");
            if (scanner.nextLine().equals("y")) {
                if (bookshelf.add(name,author,genre,yop)){;
                    System.out.println("Book added!");
                }
                else{
                    System.out.println("Sorry, book already exists! Book not added.");
                }
            }
            System.out.println("Want to add another book? y/n");
            if (scanner.nextLine().equals("n"))
                break;
        }
    }
}
