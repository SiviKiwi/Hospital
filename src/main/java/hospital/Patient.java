package hospital;

public class Patient extends Person implements Diagnosable {

    private String diagnosis = "";

    /**
     * Creates an instance of a patient.
     *
     * @param firstname            The first name of the person.
     * @param lastName             The last name of the person.
     * @param socialSecurityNumber The social security number of the person.
     */
    protected Patient(String firstname, String lastName, String socialSecurityNumber) {
        super(firstname, lastName, socialSecurityNumber);
    }

    /**
     * Method for getting the diagnosis of the person.
     *
     * @return {@code String} diagnosis of the person.
     */
    protected String getDiagnosis() {
        return this.diagnosis;
    }

    /**
     * Method for setting the diagnosis of the person.
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
     * @return {@code String} persons full name and social security number.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
