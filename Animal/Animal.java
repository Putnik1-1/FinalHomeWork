package Animal;

public abstract class Animal {
    private String name;
    private String skills;
    private String color;
    private String breed;
    private String age;
    private String birthdate;


    public Animal(String name, String skills, String color, String breed, String age, String birthdate) {
        this.name = name;
        this.skills = skills;
        this.color = color;
        this.breed = breed;
        this.age = age;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }


    public String getSkills() {
        return skills;
    }

    public String getColor() {
        return color;
    }

    public String getBreed() {
        return breed;
    }

    public String getAge() {
        return age;
    }

    public void setBreed(String toChangeBreed) {
        this.breed = toChangeBreed;
    }

    public void setSkills(String updatedSkills) {
        this.skills = updatedSkills;
    }


    public String getBirthdate() {
        return birthdate;
    }


    public abstract void displayCommands();

    public abstract void teachNewCommand(String command);
    public abstract void toChangeBreed(String changeBreed);

}