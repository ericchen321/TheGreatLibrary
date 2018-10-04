package model;

public interface Shelf {

    // EFFECTS: print all books/movies on the shelf
    public void printAll();

    // MODIFIES: this
    // EFFECTS: adds a book/movie to the shelf if not already added and returns true,
    //          otherwise returns false
    public boolean add(String name, String artist, String genre, int yop);

    // MODIFIES: This
    // EFFECTS: add books/movies to the shelf by scanning inputs from keyboard
    public void addUI();
}
