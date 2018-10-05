package model;

public abstract class Edition {
    protected int yearOfPublish;
    protected String publisher;

    // constructors
    public Edition(){}

    // TODO: need tests
    public Edition(String publisher, int yop){
        this.publisher = publisher;
        this.yearOfPublish = yop;
    }

    // EFFECTS: get the year in which the edition is published
    public int getYearOfPublish(){
        return yearOfPublish;
    }

    // EFFECTS: get the name of the publisher of the edition
    public String getPulisher(){
        return publisher;
    }

    // EFFECTS: get a unique ID for the edition
    public abstract long getID();
}
