package model;

public class BookEdition implements Edition, Item{
    private int yearOfPublish;
    private String publisher;
    private int ISBN;

    // setters and getters
    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public String getPulisher() {
        return publisher;
    }

    public int getID() {
        return ISBN;
    }
}
