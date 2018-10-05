package model;

public class BookEdition extends Edition{
    private long ISBN;

    // constructors
    public BookEdition(){}

    // TODO: need tests
    public BookEdition(String publisher, int yop, long ISBN){
        super(publisher, yop);
        this.ISBN = ISBN;
    }

    public long getID() {
        return ISBN;
    }
}
