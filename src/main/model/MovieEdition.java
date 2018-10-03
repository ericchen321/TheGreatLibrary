package model;

public class MovieEdition implements Edition, Item{
    private int yearOfPublish;
    private String publisher;
    private int IMDBN;

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public String getPulisher() {
        return publisher;
    }

    public int getID() {
        return IMDBN;
    }
}
