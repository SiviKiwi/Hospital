import hospital.Department;
import hospital.Hospital;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.management.InstanceAlreadyExistsException;

import static org.junit.jupiter.api.Assertions.*;

public class HospitalTest {
    @Test
    @DisplayName("Create hospital with valid input")
    public void CreateHospitalValidInput() {
        Hospital hospital = new Hospital("Test Hospital");
        assertNotNull(hospital);
    }

    @Test
    @DisplayName("Create hospital with invalid input")
    public void CreateHospitalInvalidInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Hospital hospital = new Hospital("");
        });

        String expectedMessage = "Hospital name can't be blank or null!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Nested
    public class HospitalMethodTest {
        Hospital hospital;

        @BeforeEach
        public void setup() {
            hospital = new Hospital("Test Hospital");
        }

        @AfterEach
        public void removeObjects() {
            this.hospital.getDepartments().clear();
        }

        @Test
        @DisplayName("Test addDepartment-method with valid input")
        public void testAddDepartmentValidInput() throws InstanceAlreadyExistsException {
            Department department = new Department("Test Department");
            this.hospital.addDepartment(department);
            assertTrue(this.hospital.getDepartments().contains(department));
        }

        @Test
        @DisplayName("Test addDepartment-method with null input")
        public void testAddDepartmentNullInput() {
            Exception exception = assertThrows(NullPointerException.class, () -> {
                this.hospital.addDepartment(null);
            });
            String expectedMessage = "Can't add null to register!";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));

        }
        @Test
        @DisplayName("Test addDepartment-method with existing input")
        public void testAddDepartmentExistingInput() {
            Department department = new Department("Test Department");
            Exception exception = assertThrows(InstanceAlreadyExistsException.class, () -> {
                this.hospital.addDepartment(department);
                this.hospital.addDepartment(department);
            });
            String expectedMessage = "The department already exist in the register!";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));

        }
    }

}
