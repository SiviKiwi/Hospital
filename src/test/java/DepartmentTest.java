import hospital.Department;

import hospital.Person;
import hospital.healthpersonal.Nurse;
import org.junit.jupiter.api.*;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class DepartmentTest {

    @Test
    @DisplayName("Create Department with valid Input")
    public void createDepartmentValidInput() {
        Department department = new Department("Test Department");
        assertNotNull(department);
    }

    @Test
    @DisplayName("Create Department with invalid Input")
    public void createDepartmentInvalidInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Department department = new Department("");
        });
        String expectedMessage = "Department name can't be blank or null!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Nested
    public class DepartmentMethodTest {
        private Department department;

        @BeforeEach
        public void setup() {
            this.department = new Department("Test Department");
        }

        @AfterEach
        public void removeObjects() {
            this.department.getEmployees().clear();
        }

        @Test
        @DisplayName("Test person()-method with invalid input")
        public void createPersonWithInvalidInput() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new Nurse("", "Lastname", "12345678910");
            });
            String expectedMessage = "Parameters cannot be blank or null!";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

        @Test
        @DisplayName("Test person()-method with invalid SSN")
        public void createPersonWithInvalidSSN() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new Nurse("Firstname", "Lastname", "1234");
            });
            String expectedMessage = "socialSecurityNumber must be exactly 11 characters long";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

        @Test
        @DisplayName("Test addEmployee()-method using valid input")
        public void testAddEmployeeWithValidInput() throws InstanceAlreadyExistsException {
            Nurse nurse = new Nurse("Test", "Person", "12345678910");
            this.department.addEmployee(nurse);
            assertTrue(this.department.getEmployees().containsKey(nurse.getSocialSecurityNumber()));
        }

        @Test
        @DisplayName("Test addEmployee()-method using null input")
        public void testAddEmployeeWithNullInput() throws InstanceAlreadyExistsException {
            Exception exception = assertThrows(NullPointerException.class, () -> {
                this.department.addEmployee(null);
            });
            String expectedMessage = "Can't add null to register!";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

        @Test
        @DisplayName("Test addEmployee()-method with valid input but the Employee already exists")
        public void testAddEmployeeWithExistingEmployee() {
            Nurse nurse = new Nurse("Inga", "Lykke", "12345678917");
            Exception exception = assertThrows(InstanceAlreadyExistsException.class, () -> {
                this.department.addEmployee(nurse);
                this.department.addEmployee(nurse);
            });
            String expectedMessage = "An instance of this Employee with this SSN already exist in the register";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

        @Test
        @DisplayName("Test setDepartmentName()-method using valid input")
        public void testSetDepartmentNameValidInput() {
            String newDepartmentName = "New name";
            this.department.setDepartmentName(newDepartmentName);
            assertEquals(newDepartmentName, this.department.getDepartmentName());

        }

        @Test
        @DisplayName("Test setDepartmentName()-method using Invalid input")
        public void testSetDepartmentNameInvalidInput() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                this.department.setDepartmentName("");
            });
            String expectedMessage = "Department name can't be blank or null!";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

        @Test
        @DisplayName("Test getPerson()-method using valid input")
        public void testGetPersonValidInput() throws InstanceNotFoundException {
            String ssn = "12345678910";
            Nurse nurse = new Nurse("Test", "Person", ssn);
            this.department.getEmployees().put(ssn, nurse);

            assertEquals(nurse, this.department.getPerson(ssn));
        }

        @Test
        @DisplayName("Test getPerson()-method using invalid input")
        public void testGetPersonInvalidInput() {
            String ssn = "12345678910";
            Exception exception = assertThrows(InstanceNotFoundException.class, () -> {
                this.department.getPerson(ssn);
            });

            String expectedMessage = "No person with that SSN in the register.";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

}
