package model;

public interface Edition {

    // EFFECTS: get the year in which the edition is published
    public String getYearOfPublish();

    // EFFECTS: get the name of the publisher of the edition
    public String getPulisher();

    // EFFECTS: get a unique ID for the edition
    public int getID();
}
