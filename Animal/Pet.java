package Animal;

public class Pet extends Animal{
    public Pet(String name, String skills, String color, String breed, String age, String birthdate){
        super(name, skills, color, breed, age, birthdate);
    }

    @Override
    public void displayCommands() {

    }

    @Override
    public void teachNewCommand(String command) {

    }

    @Override
    public void toChangeBreed(String changeBreed) {

    }
}