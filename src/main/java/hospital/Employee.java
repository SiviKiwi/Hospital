package hospital;

public class Employee extends Person {

    /**
     * Creates an instance of an employee.
     *
     * @param firstname            The first name of the employee.
     * @param lastName             The last name of the employee.
     * @param socialSecurityNumber The social security number of the employee.
     */
    public Employee(String firstname, String lastName, String socialSecurityNumber) {
        super(firstname, lastName, socialSecurityNumber);
    }

    /**
     * Gives a printable {@code String} displaying full name and social security number.
     *
     * @return {@code String} employee's full name and social security number.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
