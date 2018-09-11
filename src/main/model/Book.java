package model;

public class Book {
    public enum Genre {
        ART, BIOGRAPHY, CLASSICS, FANTASY, HISTORY, NONFICTION
    }
    private String name;
    private String author;
    private int yearOfPublish;
    Genre genre;

    public void setBookName(String name) {
        this.name = name;
    }

    public void setBookAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublish(int yOfp) {
        this.yearOfPublish = yOfp;
    }


}
