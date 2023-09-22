package service;

import java.util.List;

import classes.Dogan;



public interface Service {
    List<Dogan> showreganimal();
    Dogan fanimal(String str);
    boolean addAnimal(String str);
    Dogan addnewco(Dogan a, String str);
    void saveanimals();
}
