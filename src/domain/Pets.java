package domain;

import java.util.List;

public abstract class Pets extends Animal {
    public Pets(String name, String dateOfBirth, List<String> commands) {
        super(name, dateOfBirth);
        this.commands.addAll(commands);
    }

    @Override
    public List<String> listCommands() {
        return commands;
    }
}