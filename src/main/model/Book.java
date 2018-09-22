package model;

public class Book {
    private enum Genre {
        ART, BIOGRAPHY, CLASSICS, FANTASY, HISTORY, FICTION, UNCATAGORIZED
    }
    private String name;
    private Author author = new Author();
    private int yearOfPublish;
    private Genre genre;

    // constructors
    public Book(){

    }

    // TODO: Need tests!!!!!
    public Book(String name, String author, String genre, int yop){
        this.name = name;
        this.author.setAuthorName(author);
        this.yearOfPublish = yop;
        this.genre = resolveGenre(genre);
    }

    // setters and getters
    public void setBookName(String name) {
        this.name = name;
    }

    public void setBookAuthorName(String author) {
        this.author.setAuthorName(author);
    }

    public void setYearOfPublish(int yOfp) {
        yearOfPublish = yOfp;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getBookName() {
        return name;
    }

    public String getBookAuthorName() {
        return author.getAuthorName();
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public String getGenre(){
        switch (genre) {
            case ART:
                return "art";
            case BIOGRAPHY:
                return "biography";
            case CLASSICS:
                return "classics";
            case FANTASY:
                return "fantasy";
            case HISTORY:
                return "history";
            case FICTION:
                return "fiction";
            default:
                return "uncategorized";
        }
    }

    // TODO: need tests!!!!!
    // MODIFIES: new Genre enum
    // EFFECTS: converts genre from string to enumeration
    public Genre resolveGenre(String genre){
        switch (genre) {
            case "art":
                return Genre.ART;
            case "biography":
                return Genre.BIOGRAPHY;
            case "classics":
                return Genre.CLASSICS;
            case "fantasy":
                return Genre.FANTASY;
            case "history":
                return Genre.HISTORY;
            case "fiction":
                return Genre.FICTION;
            default:
                return Genre.UNCATAGORIZED;
        }
    }

    public String toString(){
        return name + " by " + author + " published in " + yearOfPublish;
    }


}
