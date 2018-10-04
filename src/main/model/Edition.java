package model;

public abstract class Edition {
    protected int yearOfPublish;
    protected String publisher;

    // EFFECTS: get the year in which the edition is published
    public int getYearOfPublish(){
        return yearOfPublish;
    }

    // EFFECTS: get the name of the publisher of the edition
    public String getPulisher(){
        return publisher;
    }

    // EFFECTS: get a unique ID for the edition
    public abstract int getID();
}
