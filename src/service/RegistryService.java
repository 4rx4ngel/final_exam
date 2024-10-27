package service;
import domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RegistryService {
    private List<Animal> animals;

    public RegistryService() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void addNewAnimal(int animalType, String name, String dateOfBirth, List<String> commands) {
        Animal newAnimal = null;
        switch (animalType) {
            case 1:
                newAnimal = new Dog(name, dateOfBirth, commands);
                break;
            case 2:
                newAnimal = new Cat(name, dateOfBirth, commands);
                break;
            case 3:
                newAnimal = new Hamster(name, dateOfBirth, commands);
                break;
            case 4:
                newAnimal = new Horse(name, dateOfBirth, commands);
                break;
            case 5:
                newAnimal = new Camel(name, dateOfBirth, commands);
                break;
            case 6:
                newAnimal = new Donkey(name, dateOfBirth, commands);
                break;
            default:
                System.out.println("Неверный тип животного.");
        }
        if (newAnimal != null) {
            animals.add(newAnimal);
            System.out.println("Новое животное успешно добавлено в реестр.");
        }
    }

    public void listAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("Реестр животных пуст.");
            return;
        }

        System.out.println("Список всех животных:");
        for (Animal animal : animals) {
            System.out.println("Имя: " + animal.getName() + ", Тип: " + animal.getType());
            listAnimalCommands(animal.getName());
            System.out.println();
        }
    }

    public void listAnimalCommands(String name) {
        Animal animal = findAnimalByName(name);
        if (animal != null) {
            System.out.println("Команды для " + name + ":");
            for (String command : animal.getCommands()) {
                System.out.println(command);
            }
        } else {
            System.out.println("Животное с именем " + name + " не найдено.");
        }
    }

    public boolean deleteAnimalByName(String name) {
        Animal animal = findAnimalByName(name);
        if (animal != null) {
            animals.remove(animal);
            System.out.println("Животное с именем " + name + " успешно удалено из реестра.");
            return true;
        } else {
            System.out.println("Животное с именем " + name + " не найдено.");
            return false;
        }
    }

    public Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    public int getTotalAnimalsCount() {
        return animals.size();
    }

    public void listAnimalsByDateOfBirth() {
        Collections.sort(animals, Comparator.comparing(Animal::getDateOfBirth));

        System.out.println("Список животных по дате рождения:");
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " (" + animal.getDateOfBirth() + ")");
        }
    }
}