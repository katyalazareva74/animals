package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveLoad implements OutInput {

    public void save(Object zoo) {
        try (ObjectOutputStream savezo = new ObjectOutputStream(new FileOutputStream("data1.dat"))) {
            savezo.writeObject(zoo);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error ObjectOutputStream");
        }
    }

    public Object load() {
        Object zoo = new Object();
        try (ObjectInputStream zooInput = new ObjectInputStream(new FileInputStream("data1.dat"))) {
            zoo = zooInput.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error ObjectOutputStream");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        return zoo;
    }
}
