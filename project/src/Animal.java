import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringJoiner;

public class Animal {

    protected String name;
    protected LocalDate birthday;
    protected Set<String> commands;
    private TypeAnimal type;

    protected Animal() {
    }

    protected Animal(String name, LocalDate birthday, TypeAnimal type) {
        this.name = name;
        this.birthday = birthday;
        this.commands = new LinkedHashSet<>();
        this.type = type;
    }

    protected Animal(String name, LocalDate birthday, Set<String> commands, TypeAnimal type) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public Set<String> getCommands() {
        return commands;
    }

    public Boolean addCommand(String command) {
        return commands.add(command.toLowerCase());
    }

    public TypeAnimal getType() {
        return type;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(";");

        joiner.add(type.name());
        joiner.add(name);
        joiner.add(birthday.toString());

        String commandsAll = "";
        for (String command : commands) {
            if (commandsAll != "")
                commandsAll += ", ";
            commandsAll += command.toLowerCase();
        }
        if (commandsAll == "")
            commandsAll = " ";

        joiner.add(commandsAll);
        joiner.add("");

        return joiner.toString();
    }

    public static Animal parse(CharSequence input) throws RuntimeException {
        String[] split = input.toString().split(";");
        Set<String> commands = new LinkedHashSet<String>();

        if (split.length >= 4) {
            String[] splitCommands = split[3].split(", ");
            for (String command : splitCommands) {
                String commandTrim = command.trim().replaceAll("\\s+", " ");
                if (commandTrim != "");
                    commands.add(commandTrim);
            }
        }

        try {
            split[0] = split[0].trim().replaceAll("\\s+", " ");
            split[1] = split[1].trim().replaceAll("\\s+", " ");
            split[2] = split[2].trim().replaceAll("\\s+", " ");
            String cap = split[0].substring(0, 1).toUpperCase() + split[0].substring(1);
            TypeAnimal type = TypeAnimal.valueOf(cap);
            String name = split[1];
            LocalDate birthday = LocalDate.parse(split[2]);

            switch (type) {
                case Dog:
                    return new Dog(name, birthday, commands);
                case Cat:
                    return new Cat(name, birthday, commands);
                case Hamster:
                    return new Hamster(name, birthday, commands);
                case Horse:
                    return new Horse(name, birthday, commands);
                case Camel:
                    return new Camel(name, birthday, commands);
                case Donkey:
                    return new Donkey(name, birthday, commands);
                default:
                    throw new RuntimeException();
            }

        } catch (Exception e) {
            throw new RuntimeException("Неправильный ввод", e);
        }
    }
}