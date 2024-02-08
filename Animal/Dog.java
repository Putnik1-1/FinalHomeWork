package Animal;

public class Dog extends Pet{
    public Dog(String name, String skills, String color, String breed, String age, String birthdate) {
        super(name, skills, color, breed, age, birthdate);
    }

    @Override
    public void displayCommands() {
        System.out.println("Список команд для собаки:");
        System.out.println(getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + "," + command;
        setSkills(updatedSkills);
        System.out.println("Собака " + getName() + " научилась новой команде: " + command);
    }
    @Override
    public  void toChangeBreed(String changeBreed){
        String toChangeBreed = getBreed() + "," + changeBreed;
        setBreed(toChangeBreed);
        System.out.println("Собаке " + getName() + " изменили породу: " + changeBreed);
    }
}