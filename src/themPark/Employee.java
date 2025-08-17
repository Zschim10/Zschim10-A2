package themPark;

public class Employee extends Person {
    private String employeeId;
    private String jobTitle;

    public Employee() {
        super();
        this.employeeId = "";
        this.jobTitle = "";
    }

    public Employee(int id, String firstName, String lastName, int age, String employeeId, String jobTitle) {
        super(id, firstName, lastName, age);
        this.employeeId = employeeId;
        this.jobTitle = jobTitle;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        // shows basic employee info
        return "[EMP] " + super.toString() + " | EmpID:" + employeeId + " | Title:" + jobTitle;
    }
}
