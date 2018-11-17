package model;

import model.exceptions.EditionAlreadyExistException;
import model.exceptions.WorkAlreadyExistException;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public abstract class Shelf implements Loadable, Saveable{
    private Set<Artwork> setOfWorks = new HashSet<>();

    // MODIFIES: This
    // EFFECTS: if work with same name & creator is not on the shelf yet
    //          then adds given work to the shelf
    //          otherwise does not add the work and throws WorkAlreadyExistException
    protected void addWork(Artwork work) throws WorkAlreadyExistException {
        if (!setOfWorks.contains(work)){
            setOfWorks.add(work);
        }
        else{
            throw new WorkAlreadyExistException();
        }
    }

    // TODO: test
    // EFFECTS: if work with same name & creator as given work is stored in the shelf
    //          then return the number of its editions
    //          else return 0
    protected int getEditionSize(Artwork work){
        for (Artwork aw: setOfWorks){
            if (aw.equals(work))
                return aw.getEditionSize();
        }
        return 0;
    }

    // REFERECE: modified based upon FileReaderWriter, CPSC 210
    // EFFECTS: split a string by "/", returns substrings
    public static ArrayList<String> splitOnSlash(String line){
        String[] splits = line.split("/");
        return new ArrayList<String>(Arrays.asList(splits));
    }

    // FIXME: may get rid of requires clause later
    // REQUIRES: given edition is an edition of the given work
    // MODIFIES: this
    // EFFECTS: if given work & edition already on the shelf
    //             throws EditionAlreadyExistException
    //          else if given work not on the shelf yet then adds work & edition
    //          else adds given edition to its work & update work's publish year
    public void addEdition(Artwork work, Edition workEd)
            throws EditionAlreadyExistException {
        for(Artwork aw: setOfWorks){
            if (aw.equals(work)){
                aw.addEdition(workEd);
                return;
            }
        }
        setOfWorks.add(work);
        work.addEdition(workEd);
    }

    // EFFECTS: print works on the shelf to textfile with given path name
    public void printToFile(String pathName) {
        try{
            PrintWriter writer = new PrintWriter(pathName,"UTF-8");
            for (Artwork aw: setOfWorks){
                writer.println(aw.toString());
            }
            writer.close(); //note -- if you miss this, the file will not be written at all.
        }
        catch (IOException excep){
            excep.printStackTrace();
        }
    }

    // MODIFIES: this
    // EFFECT: write works in text file with given path name to the
    //         given shelf
    public void loadFromFile(String pathName, Shelf destination){
        try{
            List<String> lines = Files.readAllLines(Paths.get(pathName));
            for (String line : lines){
                ArrayList<String> entries = splitOnSlash(line);
                Artwork addedWork;
                String name = entries.get(0);
                String creatorName = entries.get(1);
                String genre = entries.get(2);
                String yop = entries.get(3);
                String rating;
                try{
                    if(destination instanceof Bookshelf){
                        addedWork = ((Bookshelf)destination).addBook(name,
                                creatorName,
                                genre,
                                Integer.parseInt(yop));
                    }
                    else {
                        addedWork = ((Movieshelf)destination).addMovie(name,
                                creatorName,
                                genre,
                                Integer.parseInt(yop));
                    }
                    if(line.length() == 5){
                        rating = entries.get(4);
                        addedWork.setRating(Integer.parseInt(rating));
                    }
                }
                catch (WorkAlreadyExistException bae){
                    // just chill
                }
            }
        }
        catch(IOException excep){
            excep.printStackTrace();
        }
    }

    // EFFECTS: return an array of string representations of each work
    //          on the shelf
    public String[] printWorks() {
        ArrayList<String> str_works = new ArrayList<>();

        for (Artwork aw: setOfWorks){
            str_works.add(aw.toString());
        }

        String[] strs = new String[str_works.size()];
        return str_works.toArray(strs);
    }
}
