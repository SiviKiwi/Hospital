package hospital;

public class Patient extends Person implements Diagnosable {

    private String diagnosis = "";

    /**
     * Creates an instance of a patient.
     *
     * @param firstname            The first name of the patient.
     * @param lastName             The last name of the patient.
     * @param socialSecurityNumber The social security number of the patient.
     */
    protected Patient(String firstname, String lastName, String socialSecurityNumber) {
        super(firstname, lastName, socialSecurityNumber);
    }

    /**
     * Method for getting the diagnosis of the patient.
     *
     * @return {@code String} diagnosis of the patient.
     */
    protected String getDiagnosis() {
        return this.diagnosis;
    }

    /**
     * Method for setting the diagnosis of the patient.
     *
     * @param diagnosis {@code String} diagnosis to set.
     */
    @Override
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * Gives a printable {@code String} displaying full name and social security number.
     *
     * @return {@code String} patient's full name and social security number.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
