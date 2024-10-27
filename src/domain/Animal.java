package domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private String name;
    private String dateOfBirth;
    List<String> commands;

    public Animal(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public abstract List<String> listCommands();

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String newCommand) {
        commands.add(newCommand);
    }

    public abstract String getType();
}