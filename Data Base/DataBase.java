package DataBase;
import Animal.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.DateFormat;
public class database {
    private final List<Animal> animals;
    private static final String FILE_PATH = "databasetext.txt";

    public database() {
        animals = new ArrayList<>();
        loadDatabase();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        saveDatabase();
    }

    public void displayAnimalCommands(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {

                animal.displayCommands();
                return;
            }

        }
        System.out.println("Животное с именем " + name + " не найдено.");
    }


    public void teachNewCommand(String name, String command) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                String[] commands = command.split(",");
                for (int i = 0; i < commands.length; i++) {
                    String trimmedCommand = commands[i].trim();
                    commands[i] = trimmedCommand;
                }
                animal.teachNewCommand(command);
                saveDatabase();
                System.out.println("Команда успешно добавлена для животного.");
                return;
            }
        }
        System.out.println("Животное с именем " + name + " не найдено.");
    }

    public void toChangeBreed(String name, String changeBreed) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                String[] breeds = changeBreed.split(", ");
                for (int i = 0; i < breeds.length; i++) {
                    String trimBreed = breeds[i].trim();
                    breeds[i] = trimBreed;
                }

                animal.toChangeBreed(changeBreed);
                saveDatabase();
                System.out.println("Порода успешно изменена у животного.");
                return;

            }
            System.out.println("Животное с именем " + name + " не найдено.");
        }
    }


        private void loadDatabase () {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length >= 6) {
                        String className = data[0];
                        String name = data[1];
                        String color = data[2];
                        String breed = data[3];
                        String age = data[4];
                        String birthdate = data[5];
                        String skills = String.join(", ", Arrays.copyOfRange(data, 6, data.length));

                        Animal animal;
                        switch (className) {
                            case "Dog" -> animal = new Dog(name, skills, color, breed, age, birthdate);
                            case "Cat" -> animal = new Cat(name, skills, color, breed, age, birthdate);
                            case "Camel" -> animal = new Camel(name, skills, color, breed, age, birthdate);
                            case "Hamster" -> animal = new Hamster(name, skills, color, breed, age, birthdate);
                            case "Horse" -> animal = new Horse(name, skills, color, breed, age, birthdate);
                            default -> {
                                System.out.println("Неизвестный класс животного: " + className);
                                continue;
                            }
                        }
                        animals.add(animal);
                    } else {
                        System.out.println("Некорректные данные в файле: " + line);
                    }
                }
                System.out.println("База данных успешно загружена.");
            } catch (IOException e) {
                System.out.println("Ошибка при чтении базы данных: " + e.getMessage());
            }
        }
        // Сортировка по дням рождения животных
        public void sortAnimalsByBirthdate () {
            Collections.sort(animals, new Comparator<Animal>() {
                DateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");

                // переопределенный метод сравнения
                @Override
                public int compare(Animal animal1, Animal animal2) {
                    try {
                        Date date1 = dateFormat.parse(animal1.getBirthdate());
                        Date date2 = dateFormat.parse(animal2.getBirthdate());
                        return date1.compareTo(date2);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return 0;
                }
            });
        }

        public void displayAnimalsByBirthdate () {
            sortAnimalsByBirthdate();
            System.out.println("Список животных по дате рождения:");
            for (Animal animal : animals) {
                System.out.println(animal.getName() + " - " + animal.getBirthdate());
            }
        }

        public void displayAllAnimals () {
            try {
                File file = new File(FILE_PATH);
                Scanner fileScanner = new Scanner(file);

                while (fileScanner.hasNextLine()) {
                    String animalData = fileScanner.nextLine();
                    System.out.println(animalData);
                }

                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Файл с данными о животных не найден.");
            }
        }

        private void saveDatabase () {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                for (Animal animal : animals) {
                    String className = animal.getClass().getSimpleName();
                    String name = animal.getName();
                    String color = animal.getColor();
                    String breed = animal.getBreed();
                    String age = animal.getAge();
                    String birthdate = animal.getBirthdate();
                    String skills = animal.getSkills().replaceAll(",\\s+", ",");

                    String line = className + ", " + name + ", " + skills + ", " + birthdate + ", " + color + ", " + breed + ", " + age + " лет";
                    writer.write(line);
                    writer.newLine();
                }
                System.out.println("База данных успешно сохранена.");
            } catch (IOException e) {
                System.out.println("Ошибка при сохранении базы данных: " + e.getMessage());
            }
        }
        public void deleteAnimal (String name){
            for (Animal animal : animals) {
                if (animal.getName().equals(name)) {
                    animals.remove(animal);
                    saveDatabase();
                    System.out.println("Животное успешно удалено из базы данных.");
                    return;
                }
            }
            System.out.println("Животное с именем " + name + " не найдено.");
        }
    }