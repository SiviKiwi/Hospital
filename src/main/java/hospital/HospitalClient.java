package hospital;

import hospital.exception.RemoveException;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class HospitalClient {
    public static void main(String[] args) {
        //Creates a Hospital method and fills it with test data.
        Hospital hospital = new Hospital("St. Olavs Hospital");
        HospitalTestData.fillRegisterWithTestData(hospital);

        //Gets the department "Akutten" from the hospital.
        Department akutten = hospital.getDepartments()
                .stream()
                .filter(department -> department.getDepartmentName().equals("Akutten"))
                .collect(Collectors.toList()).get(0);

        // Tries to get a person with SSN: "12345678918" from the register
        Person person = null;
        try {
            person = akutten.getPerson("12345678918");
        } catch (InstanceNotFoundException instanceNotFoundException) {
            instanceNotFoundException.printStackTrace();
        }
        //Prints information about the department and the employees and patients in it.
        System.out.println(akutten.toString());

        //Tries to remove the Person from the department
        try {
            akutten.remove(person);
        } catch (RemoveException removeException) {
            removeException.printStackTrace();
        }

        //Prints the Department info again to see if the person was removed
        System.out.println(akutten.toString());

        //Tries to remove the person again, expecting a remove exception.
        try {
            akutten.remove(person);
        } catch (RemoveException removeException) {
            removeException.printStackTrace();
        }
    }
}
