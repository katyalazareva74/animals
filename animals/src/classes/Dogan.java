package classes;

import java.io.Serializable;
import java.util.List;

public abstract class Dogan implements Serializable {
    private String nickname;
    private int dateBirth;
    private int id;
    List<String> list1;

    public Dogan(String name, int date) {
        this.nickname = name;
        this.dateBirth = date;
    }

    public String getNickname() {
        return nickname;
    }

    public int getDateBirth() {
        return dateBirth;
    }

    public int getId() {
        return id;
    }

    public List<String> getCommands() {
        return list1;
    }

    public void addCommands(String co) {
    }

    public void setId(int id) {
        this.id = id;
    }
}
