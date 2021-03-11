package hospital;

import javax.management.InstanceAlreadyExistsException;
import java.util.HashSet;

/**
 * Represents a hospital with a hospital name.
 * The hospital class is a register for departments affiliated with the hospital.
 */
public class Hospital {
    private final String hospitalName;
    private HashSet<Department> departments;

    /**
     * Creates an instance of a hospital containing a hashset containing departments in the hospital.
     *
     * @param hospitalName {@code String} name of the hospital.
     */
    public Hospital(String hospitalName) {
        if (hospitalName.isBlank()) {
            throw new IllegalArgumentException("Hospital name can't be blank or null!");
        }
        this.hospitalName = hospitalName;
        this.departments = new HashSet<>();
    }

    /**
     * Method for getting the name of the hospital.
     *
     * @return {@code String} name of the hospital.
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * Method for getting the hashset where departments are stored.
     *
     * @return {@code HashMap} containing all departments affiliated with the hospital.
     */
    public HashSet<Department> getDepartments() {
        return departments;
    }

    /**
     * Method for adding a department to the register.
     *
     * @param department {@code Department} object to add.
     */
    public void addDepartment(Department department) throws InstanceAlreadyExistsException {
        if (department == null){
            throw new NullPointerException("Can't add null to register!");
        }else if (departments.contains(department)) {
            throw new InstanceAlreadyExistsException("The department already exist in the register!");
        }
        departments.add(department);
    }

    /**
     * Creates a string representation of the hospital and all departments in it.
     *
     * @return {@code String} representation of the hospital and all departments in it.
     */
    @Override
    public String toString() {
        StringBuilder hospitalString = new StringBuilder();
        hospitalString.append("Hospital name: ").append(this.hospitalName)
                .append("\nDepartments:");
        departments.forEach(department -> hospitalString.append("\n").append(department.getDepartmentName()));

        return hospitalString.toString();
    }
}
