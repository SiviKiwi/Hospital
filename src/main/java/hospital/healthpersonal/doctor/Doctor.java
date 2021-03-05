package hospital.healthpersonal.doctor;

import hospital.Employee;
import hospital.Patient;

/**
 * Represents a doctor with a first name, last name and a unique social security number.
 *
 * @author Sivert Askeland Laudal
 */
public abstract class Doctor extends Employee {
    /**
     * Creates an instance of a doctor.
     *
     * @param firstname            The first name of the doctor.
     * @param lastName             The last name of the doctor.
     * @param socialSecurityNumber The social security number of the doctor.
     */
    protected Doctor(String firstname, String lastName, String socialSecurityNumber) {
        super(firstname, lastName, socialSecurityNumber);
    }

    public abstract void setDiagnosis(Patient patient, String diagnosis);
}
