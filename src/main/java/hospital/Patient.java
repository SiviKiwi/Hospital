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
     * Method for getting the
     * @return
     */
    protected String getDiagnosis() {
        return this.diagnosis;
    }

    @Override
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
