package exceptions;

public class NoFindAnimalExeption extends RuntimeException {
    public NoFindAnimalExeption(String message){
        super(message);
    }
}
