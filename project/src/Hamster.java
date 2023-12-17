import java.time.LocalDate;
import java.util.Set;

public class Hamster extends Pet {
    public Hamster(String name, LocalDate birthday) {
        super(name, birthday, TypeAnimal.Hamster);
    }

    public Hamster(String name, LocalDate birthday, Set<String> commands) {
        super(name, birthday, commands, TypeAnimal.Hamster);
    }
}