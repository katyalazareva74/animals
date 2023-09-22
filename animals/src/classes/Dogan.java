package classes;


import java.io.Serializable;

public abstract class Dogan implements Serializable {
    private String nickname;
    private int dateBirth;
    private int id;

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

    public void addCommands(String co) {
    }

    public void setId(int id) {
        this.id = id;
    }
}
