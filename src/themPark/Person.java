package themPark;

public abstract class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Person() {
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
    }

    public Person(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // no negatives allowed
        if (age < 0) throw new IllegalArgumentException("Age can't be negative");
        this.age = age;
    }

    public String getFullName() {
        return (firstName + " " + lastName).trim();
    }

    @Override
    public String toString() {
        // just ID, full name, age
        return "ID:" + id + " | " + getFullName() + " | Age:" + age;
    }
}
