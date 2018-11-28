package ui;

import model.Artwork;
import model.FranchiseHub;

import java.util.List;
import java.util.Observable;

public class FranchiseHubUI extends ModuleUI{
    private FranchiseHub franchiseHub;

    // constructors
    public FranchiseHubUI(FranchiseHub franchiseHub){
        super();
        this.franchiseHub = franchiseHub;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof ShelfUI){
            List<Artwork> aws = (List<Artwork>) arg;
            for (Artwork aw: aws){
                franchiseHub.addToFranchise((String) arg, aw);
            }
            System.out.println("Selected works added to the franchise you named!");
        }
    }
}
