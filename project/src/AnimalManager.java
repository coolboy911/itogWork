import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AnimalManager {
    private ArrayList<Animal> register;

    public AnimalManager() {
        register = new ArrayList<>();
    }

    public void loadAnimals() throws IOException {
        File file = new File("C:\\Users\\user\\Desktop\\Animals.txt");
        if (!file.exists()) {
            Files.createFile(Paths.get(file.toURI()));
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            register.add(Animal.parse(line));
        }
        br.close();
    }

    public void saveAnimals() throws IOException {

        FileWriter writer = new FileWriter(
                "C:\\Users\\user\\Desktop\\Animals.txt",
                false);

        for (Animal animal : register) {
            writer.append(animal.toString() + "\n");
        }

        writer.flush();
        writer.close();
    }

    public ArrayList<Animal> getRegister() {
        return register;
    }

    public void addAnimal(Animal animal) {
        register.add(animal);
    }
}