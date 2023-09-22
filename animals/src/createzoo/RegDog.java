package createzoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import classes.Camel;
import classes.Cat;
import classes.Dog;
import classes.Dogan;
import classes.Donkey;
import classes.Hamster;
import classes.Horse;
import exceptions.NoAddAnimalExeption;
import exceptions.NoAddCommandExeption;
import exceptions.NoFindAnimalExeption;

public class RegDog implements Serializable, Reganimal{
    private int id;
    private List<Dogan> reganimal;

    public RegDog(List<Dogan> ranimal) {
        this.reganimal = ranimal;
    }

    public RegDog() {
        this.reganimal = new ArrayList<>();
    }

    public List<Dogan> getRegistry() {
        return reganimal;
    }

    public boolean addanimal(String str) throws NoAddAnimalExeption {
        String[] s1 = str.split(" ");
        if (s1.length != 3)
            throw new NoAddAnimalExeption("Не удалось поселить животное в зоопарк!");
        Dogan an = null;
        switch (s1[2]) {
            case "cat":
                an = new Cat(s1[0], Integer.parseInt(s1[1]));
                an.addCommands("walk");
                break;
            case "dog":
                an = new Dog(s1[0], Integer.parseInt(s1[1]));
                an.addCommands("voice");
                break;
            case "hamster":
                an = new Hamster(s1[0], Integer.parseInt(s1[1]));
                an.addCommands("chew");
                break;
            case "camel":
                an = new Camel(s1[0], Integer.parseInt(s1[1]));
                an.addCommands("go");
                break;
            case "horse":
                an = new Horse(s1[0], Integer.parseInt(s1[1]));
                an.addCommands("run");
                break;
            case "donkey":
                an = new Donkey(s1[0], Integer.parseInt(s1[1]));
                an.addCommands("go-go");
                break;
            default:
                throw new NoAddAnimalExeption("Не удалось поселить животное в зоопарк!");
        }
        an.setId(id++);
        reganimal.add(an);
        return true;
    }
   public Iterator<Dogan> iterator() {
        return new AnimalIterator(this.reganimal);
    }
    public Dogan findan(String str) throws NoFindAnimalExeption{
        for (Dogan item : reganimal) {
            if (item.getNickname().equals(str)) {
                return item;
            }
        }
        throw new NoFindAnimalExeption("Не удалось найти животное в этом зоопарке");
    }
    public Dogan addnewcommand (Dogan a, String str1) throws NoAddCommandExeption {
        if(a!=null & str1 !=""){
            a.addCommands(str1);
         }
         else{
            throw new NoAddCommandExeption("Не удалось научить животное новой команде!");
         }
        return a;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.reganimal);
        return str.toString();
    }
}
