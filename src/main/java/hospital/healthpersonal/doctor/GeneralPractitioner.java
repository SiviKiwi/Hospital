package hospital.healthpersonal.doctor;

import hospital.Patient;

/**
 * Represents a general practitioner with a first name, last name and a unique social security number.
 *
 * @author Sivert Askeland Laudal
 */
public class GeneralPractitioner extends Doctor {
    /**
     * Creates an instance of a general practitioner.
     *
     * @param firstname            The first name of the general practitioner.
     * @param lastName             The last name of the general practitioner.
     * @param socialSecurityNumber The social security number of the general practitioner.
     */
    public GeneralPractitioner(String firstname, String lastName, String socialSecurityNumber) {
        super(firstname, lastName, socialSecurityNumber);
    }

    /**
     * Method for setting the diagnosis of a given patient.
     *
     * @param patient   {@code Patient} to set diagnosis on.
     * @param diagnosis {@code String} diagnosis to set.
     */
    @Override
    public void setDiagnosis(Patient patient, String diagnosis) {
        patient.setDiagnosis(diagnosis);
    }
}
