package hospital.healthpersonal.doctor;

import hospital.Patient;

public class Surgeon extends Doctor {
    /**
     * Creates an instance of a surgeon.
     *
     * @param firstname            The first name of the surgeon.
     * @param lastName             The last name of the surgeon.
     * @param socialSecurityNumber The social security number of the surgeon.
     */
    public Surgeon(String firstname, String lastName, String socialSecurityNumber) {
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
