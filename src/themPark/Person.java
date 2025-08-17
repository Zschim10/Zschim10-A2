package themPark;

public abstract class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Person() {
        this(0, "", "", 0);
    }

    public Person(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName != null ? firstName : "";
        this.lastName = lastName != null ? lastName : "";
        this.age = Math.max(0, age);
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
        this.firstName = firstName != null ? firstName : "";
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName != null ? lastName : "";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age can't be negative");
        this.age = age;
    }

    public String getFullName() {
        return (firstName + " " + lastName).trim();
    }

    @Override
    public String toString() {
        return "ID:" + id + " | " + getFullName() + " | Age:" + age;
    }
}
