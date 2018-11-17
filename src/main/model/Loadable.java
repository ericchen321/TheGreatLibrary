package model;

public interface Loadable {
    // MODIFIES: this
    // EFFECT: write books/movies in text file with given path name to the given shelf
    public void loadFromFile(String pathName, Shelf destination);
}
