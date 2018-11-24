package ui;

import model.Module;

import java.util.Observable;

public class ActiveModuleObservable extends Observable{
    private Module activeModule;

    // setters and getters
    public void setActiveModule(Module m){
        activeModule = m;
        setChanged();
        notifyObservers(activeModule);
    }
}
