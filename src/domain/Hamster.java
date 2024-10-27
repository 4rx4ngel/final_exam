package domain;

import java.util.List;

public class Hamster extends Pets{
    public Hamster(String name, String dateOfBirth, List<String> commands) {
        super(name, dateOfBirth, commands);
    }

    @Override
    public List<String> listCommands() {
        return getCommands();
    }

    @Override
    public String getType() {
        return "Hamster";
    }
}