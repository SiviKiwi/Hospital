package hospital.healthpersonal;

import hospital.Employee;

/**
 * Represents a nurse with a first name, last name and a unique social security number.
 *
 * @author Sivert Askeland Laudal
 */
public class Nurse extends Employee {
    /**
     * Creates an instance of a nurse.
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
