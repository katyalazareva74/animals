package service;

import java.util.List;

import classes.Dogan;
import createzoo.Reganimal;
import file.OutInput;
import file.SaveLoad;



public class RegistryService implements Service {

    private Reganimal reganimal;
    private OutInput saveload;


    public RegistryService(Reganimal regan) {
        this.reganimal = regan;
        this.saveload=new SaveLoad();
    }
    public List<Dogan> showreganimal() {
        return reganimal.getRegistry();
    }

    public boolean addAnimal(String str) {
        return reganimal.addanimal(str);
    }

    public Dogan fanimal(String str) {
        return reganimal.findan(str);
    }

    @Override
    public Dogan addnewco(Dogan a, String str) {
        return reganimal.addnewcommand(a, str);
    }
    public void saveanimals() {
        saveload.save(this.reganimal);

    }


}
