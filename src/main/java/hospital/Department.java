package hospital;

import javax.management.InstanceAlreadyExistsException;
import java.util.HashMap;
import java.util.Objects;

/**
 * Represents a department with a department name.
 * The department class is a register for employees and patients affiliated with that department
 */
public class Department {
    private String departmentName;
    private HashMap<String, Employee> employees;
    private HashMap<String, Patient> patients;

    /**
     * Creates an instance of a department containing a hashmap for patients and a hasmap for employees.
     *
     * @param departmentName {@code String} name of the department.
     */
    public Department(String departmentName) {
        if (departmentName.isBlank()) {
            throw new IllegalArgumentException("Department name can't be blank or null!");
        }

        this.departmentName = departmentName;
        employees = new HashMap<>();
        patients = new HashMap<>();
    }

    /**
     * Method for getting the name of the department.
     *
     * @return {@code String} name of the department.
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Method for setting the name of the department.
     *
     * @param departmentName {@code String} department name to set.
     */
    public void setDepartmentName(String departmentName) {
        if (departmentName.isBlank()) {
            throw new IllegalArgumentException("Department name can't be blank or null!");
        }
        this.departmentName = departmentName;
    }

    /**
     * Method for getting the hashmap where employees are stored.
     *
     * @return {@code HashMap} containing all employees affiliated with the department.
     */
    public HashMap<String, Employee> getEmployees() {
        return employees;
    }

    /**
     * Method for adding an employee to the register.
     *
     * @param employee {@code Employee} object to add.
     */
    public void addEmployee(Employee employee) throws InstanceAlreadyExistsException {
        if (checkForPerson(employee)) {
            throw new InstanceAlreadyExistsException("An instance of this Employee already exist in the register");
        }
        employees.put(employee.getSocialSecurityNumber(), employee);
    }

    /**
     * Method for getting the hashmap where patients are stored.
     *
     * @return {@code HashMap} containing all patients affiliated with the department.
     */
    public HashMap<String, Patient> getPatients() {
        return patients;
    }

    /**
     * Method for adding a patient to the register.
     *
     * @param patient {@code Patient} object to add.
     */
    public void addPatient(Patient patient) throws InstanceAlreadyExistsException {
        if (checkForPerson(patient)) {
            throw new InstanceAlreadyExistsException("An instance of this Patient already exist in the register");
        }
        patients.put(patient.getSocialSecurityNumber(), patient);
    }

    /**
     * Checks if a person is already stored in the register.
     *
     * @param person {@code Person} looked for in the register.
     * @return True if in register, false if not.
     */
    private boolean checkForPerson(Person person) {
        boolean personInRegister = false;
        if (person instanceof Employee) {
            personInRegister = employees.containsKey(person.getSocialSecurityNumber());
        } else if (person instanceof Patient) {
            personInRegister = patients.containsKey(person.getSocialSecurityNumber());
        }
        return personInRegister;
    }

    /**
     * Checks if given this department is equal to another department by comparing the names.
     *
     * @param o {@code Department} to check if equal
     * @return True if equal, false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentName.equals(that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName);
    }

    /**
     * Creates a string representation of the department and all patients and employees in it.
     *
     * @return {@code String} representation of the department and all patients and employees in it.
     */
    @Override
    public String toString() {
        StringBuilder departmentString = new StringBuilder();
        departmentString.append("Department: ").append(departmentName)
                .append("\nEmployees:\n");
        employees.values()
                .forEach(employee -> departmentString.append("\n").append(employee.toString()).append("\n"));
        departmentString.append("Patients:\n");
        patients.values()
                .forEach(patient -> departmentString.append("\n").append(patient.toString()).append("\n"));

        return departmentString.toString();
    }
}