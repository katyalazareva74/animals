package exceptions;

public class NoAddAnimalExeption extends RuntimeException {
    public NoAddAnimalExeption (String message) {
        super(message);
    }
}
