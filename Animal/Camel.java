package Animal;

public class Camel extends Pack{
    public Camel(String name, String skills, String color, String breed, String age, String birthdate) {
        super(name, skills, color, breed, age, birthdate);
    }

    @Override
    public void displayCommands() {
        System.out.println("Список команд для Верблюда: ");
        System.out.println(getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + ", " + command;
        setSkills(updatedSkills);
        System.out.println("Верблюд " + getName() + " научил новые команды: " + command);
    }
    @Override
    public  void toChangeBreed(String changeBreed){
        String toChangeBreed = getBreed() + ", " + changeBreed;
        setBreed(toChangeBreed);
        System.out.println("Верблюду " + getName() + " изменили породу: " + changeBreed);
    }
}