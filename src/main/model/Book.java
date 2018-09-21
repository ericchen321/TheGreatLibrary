package model;

public class Book {
    private enum Genre {
        ART, BIOGRAPHY, CLASSICS, FANTASY, HISTORY, FICTION, UNCATAGORIZED
    }
    private String name;
    private String author;
    private int yearOfPublish;
    private Genre genre;

    // setters and getters
    public void setBookName(String name) {
        this.name = name;
    }

    public void setBookAuthor(String author) {
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public Genre getGenre(){
        return genre;
    }

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
