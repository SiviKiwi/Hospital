package hospital.healthpersonal;

import hospital.Employee;

public class Nurse extends Employee {
    /**
     * Creates an instance of an employee.
     *
     * @param firstname            The first name of the nurse.
     * @param lastName             The last name of the nurse.
     * @param socialSecurityNumber The social security number of the nurse.
     */
    public Nurse(String firstname, String lastName, String socialSecurityNumber) {
        super(firstname, lastName, socialSecurityNumber);
    }

    /**
     * Gives a printable {@code String} displaying full name and social security number.
     *
     * @return {@code String} nurse's full name and social security number.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
