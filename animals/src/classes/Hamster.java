package classes;


import java.util.ArrayList;
import java.util.List;

public class Hamster extends Dogan {

    private String vidanimal;
    private String typeanimal;
    private List<String> commands;

    public Hamster(String name, int date) {
        super(name, date);
        this.vidanimal = "dog";
        this.typeanimal = "homeanimal";
        this.commands = new ArrayList<>();
    }

    public void addCommands(String comm) {
        commands.add(comm);
    }

    public List<String> getCommands() {
        return commands;
    }

    public String getNickname() {
        return super.getNickname();
    }

    public int getDateBirth() {
        return super.getDateBirth();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\n");
        str.append(getId() + ": ");
        str.append(getNickname() + ": ");
        str.append(getDateBirth() + ": ");
        str.append(this.vidanimal + ": ");
        str.append(this.typeanimal + ": ");
        if (this.commands.size() != 0) {
            for (String item : this.commands) {
                str.append(item + ": ");
            }
        }
        return str.toString();
    }
}
