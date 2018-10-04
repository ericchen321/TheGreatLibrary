package model;

public interface Saveable {
    // EFFECT: print books/movies on the shelf to textfile with given path name
    public void printToFile(String pathName);
}
