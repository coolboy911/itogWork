import java.time.LocalDate;
import java.util.Set;

public class Pet extends Animal {
    protected Pet(String name, LocalDate birthday, TypeAnimal type) {
        super(name, birthday, type);
    }

    protected Pet(String name, LocalDate birthday, Set<String> commands, TypeAnimal type) {
        super(name, birthday, commands, type);
    }
}