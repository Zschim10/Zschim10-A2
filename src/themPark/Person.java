package themPark;

/**
 * Abstratct class - nop direct input
 * Common behavour for emnployee and visitor
 */
public abstract class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    // default constructor
    public Person() {
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
    }

    // constructor for creating person
    public Person(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.age = age;
    }

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) {
        // age cant be negative
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        this.age = age;
    }

    // method to get full name
    public String getFullName() { return (firstName + " " + lastName).trim(); }

    @Override
    public String toString() {
        return "ID:" + id + " | " + getFullName() + " | Age:" + age;
    }
}
