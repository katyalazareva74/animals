package createzoo;

import java.util.Iterator;
import java.util.List;

import classes.Dogan;

public interface Reganimal extends Iterable<Dogan> {
    List<Dogan> getRegistry();

    Iterator<Dogan> iterator();

    boolean addanimal(String str);

    Dogan findan(String str);

    Dogan addnewcommand(Dogan a, String str1);
}
