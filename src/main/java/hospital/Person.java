package hospital;

import java.io.Serializable;

/**
 * Represents a person with a first name, last name and a unique social security number.
 *
 * @author Sivert Askeland Laudal
 */
public abstract class Person implements Serializable {
    private String firstname;
    private String lastName;
    private String socialSecurityNumber;

    /**
     * Creates an instance of Person.
     *
     * @param firstname            The first name of the person.
     * @param lastName             The last name of the person.
     * @param socialSecurityNumber The social security number of the person.
     */
    protected Person(String firstname, String lastName, String socialSecurityNumber) {
        if (firstname.isBlank() || lastName.isBlank() || socialSecurityNumber.isBlank()){
            throw new IllegalArgumentException("Parameters cannot be blank or null!");
        } else if (socialSecurityNumber.length() != 11){
            throw new IllegalArgumentException("socialSecurityNumber must be exactly 11 characters long");
        }

        this.firstname = firstname;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * Method for getting the first name of the person.
     *
     * @return {@code String} first name of the person.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Method for setting the first name of the person.
     *
     * @param firstname {@code String} first name to set.
     */
    public void setFirstname(String firstname) {
        if (firstname.isBlank()){
            throw new IllegalArgumentException("firstName cannot be blank or null!");
        }
        this.firstname = firstname;
    }

    /**
     * Method for getting the last name of the person.
     *
     * @return {@code String} last name of the person.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method for setting the last name of the person.
     *
     * @param lastName {@code String} last name to set.
     */
    public void setLastName(String lastName) {
        if (firstname.isBlank()){
            throw new IllegalArgumentException("lastName cannot be blank or null!");
        }
        this.lastName = lastName;
    }

    /**
     * Method for getting the social security number of the person.
     *
     * @return {@code String} social security number of the person.
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * Method for setting the social security number of the person.
     *
     * @param socialSecurityNumber {@code String} social security number to set.
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        if (socialSecurityNumber.isBlank()){
            throw new IllegalArgumentException("socialSecurityNumber cannot be blank or null!");
        }else if (socialSecurityNumber.length() != 11){
            throw new IllegalArgumentException("socialSecurityNumber must be exactly 11 characters long!");
        }
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * Method for getting the full name of the person as a {@code String} in the format: "last name, first name".
     *
     * @return {@code String} person's full name.
     */
    public String getFullName() {
        return this.lastName + ", " + this.firstname;
    }

    /**
     * Gives a printable {@code String} displaying full name and social security number.
     *
     * @return {@code String} person's full name and social security number.
     */
    @Override
    public String toString() {
        return "Name : " + getFullName() + "\n" +
                "SSN : " + this.socialSecurityNumber;
    }


}
