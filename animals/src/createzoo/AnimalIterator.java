package createzoo;

import java.util.Iterator;
import java.util.List;

import classes.Dogan;

public class AnimalIterator implements Iterator<Dogan> {
    private int index;
    private List<Dogan> reganimal;

    public AnimalIterator(List<Dogan> animal) {
        this.reganimal = animal;
    }

    @Override
    public boolean hasNext() {
        return index < reganimal.size();
    }

    @Override
    public Dogan next() {
        return reganimal.get(index++);
    }
}
