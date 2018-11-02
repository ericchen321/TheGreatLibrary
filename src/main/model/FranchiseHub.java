package model;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class FranchiseHub {

    private Map<String, Set<Artwork>> franchises;

    // constructors
    public FranchiseHub(){
        franchises = new HashMap<>();
    }

    // REQUIRES: given artwork has not been added to franchise
    //           of given name yet
    // MODIFIES: this
    // EFFECTS: add given artwork to franchise of given name
    public void addToFranchise(String name, Artwork aw){
        if(!franchises.containsKey(name)){
            franchises.put(name, new HashSet<Artwork>());
        }

        franchises.get(name).add(aw);
    }

    // EFFECTS: returns true if the given franchise contains the given work
    //          false otherwise
    public boolean searchWork(String name, Artwork aw) {
        return franchises.get(name).contains(aw);
    }

    // TODO: get rid of the requires clause
    // REQUIRES: franchise with given name exists in the hub
    // EFFECTS: get the number of works in the given franchise
    public int getWorkSize(String name) {
        return franchises.get(name).size();
    }
}
