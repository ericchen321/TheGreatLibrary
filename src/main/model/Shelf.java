package model;

import model.exceptions.EditionAlreadyExistException;
import model.exceptions.WorkAlreadyExistException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
                writer.println(aw.getName()+"/"+aw.getCreatorName()+"/"+aw.getGenre()+"/"+aw.getYearOfPublish());
            }
            writer.close(); //note -- if you miss this, the file will not be written at all.
        }
        catch (IOException excep){
            excep.printStackTrace();
        }
    }
}
