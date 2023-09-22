package exceptions;

public class NoAddCommandExeption extends RuntimeException{
    public NoAddCommandExeption (String message) {
        super(message);
    }
}
