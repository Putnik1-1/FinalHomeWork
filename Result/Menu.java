import java.util.InputMismatchException;
import java.util.Scanner;
import DataBase.*;
import Animal.*;
public class Menu {
    private final database database;
    private final Scanner scanner;

    public Menu(database database) {
        this.database = database;
        scanner = new Scanner(System.in);
    }
    // метод вывода информации в консоль
    public void displayMenu() {
        while (true) {
            try {
                System.out.println("Меню:");
                System.out.println("1. Добавить новое животное");
                System.out.println("2. Показать список всех животных");
                System.out.println("3. Просмотреть список команд животного ");
                System.out.println("4. Просмотр списка животных по дате рождения");
                System.out.println("5. Обучить животное новой команде");
                System.out.println("6. Изменить породу животного");
                System.out.println("7. Удаление животного из базы данных");
                System.out.println("0. Выход");
                System.out.print("Выберите пункт меню: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addNewAnimal();
                    case 2 -> database.displayAllAnimals();
                    case 3 -> displayAnimalCommands();
                    case 4 -> database.displayAnimalsByBirthdate();
                    case 5 -> teachNewCommand();
                    case 6 -> toNewBreed();
                    case 7 -> toDeletedAnimal();
                    case 0 -> {
                        System.out.println("Программа завершена.");
                        return;
                    }
                    default -> System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: неверный формат ввода. Попробуйте снова.");
                scanner.nextLine(); // Очистка буфера сканера после ошибочного ввода
            }
        }
    }


    private void addNewAnimal() {
        System.out.println("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.println("Ввведите цвет животного: ");
        String color = scanner.nextLine();
        System.out.println("Введите день рождение животного: ");
        String birthdate = scanner.nextLine();
        System.out.println("Ввведите породу животного: ");
        String breed = scanner.nextLine();
        System.out.println("Ввведите возраст животного: ");
        String age = scanner.nextLine();
        System.out.println("Введите список команд через запятую: ");
        String skills = scanner.nextLine();

        System.out.println("Выберите класс животного:");
        System.out.println("1. Собака");
        System.out.println("2. Кошка");
        System.out.println("3. Верблюд");
        System.out.println("4. Хомяк");
        System.out.println("5. Конь");
        int animalClass = scanner.nextInt();
        scanner.nextLine();

        Animal animal;
        switch (animalClass) {
            case 1 -> animal = new Dog(name, skills, color, breed, age, birthdate);
            case 2 -> animal = new Cat(name, skills, color, breed, age, birthdate);
            case 3 -> animal = new Camel(name, skills, color, breed, age, birthdate);
            case 4 -> animal = new Hamster(name, skills, color, breed, age, birthdate);
            case 5 -> animal = new Horse(name, skills, color, breed, age, birthdate);
            default -> {
                System.out.println("Неверный выбор класса животного.");
                return;
            }
        }

        database.addAnimal(animal);
        System.out.println("Животное успешно добавлено в базу данных.");
    }

    private void displayAnimalCommands() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();

        database.displayAnimalCommands(name);
    }

    private void teachNewCommand() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        System.out.println("Введите новые команды через запятую:");
        String command = scanner.nextLine();

        database.teachNewCommand(name, command);
        System.out.println("Команда успешно добавлена для животного.");
    }
    private void toNewBreed() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        System.out.println("Введите новую породу животного:");
        String changeBreed = scanner.nextLine();

        database.toChangeBreed(name, changeBreed);
        System.out.println("Порода успешно добавлена для животного.");
    }
    private void toDeletedAnimal(){
        System.out.println("Введите имя животного: ");
        String name = scanner.nextLine();
        database.deleteAnimal(name);
    }

}