package ui;

public class TheGreatLibrary {

    // constructor
    public TheGreatLibrary(){
        printWelcomeMsg();
        printIntro();
    }

    // print the welcome message
    public void printWelcomeMsg(){
        System.out.println("Welcome to The Great Library!");
    }

    // print the intro
    public void printIntro(){
        System.out.println("This is a personal library manager.");
    }

    // star TheGreatLibrary app
    public static void main(String[] args) {
        new TheGreatLibrary();
    }
}
