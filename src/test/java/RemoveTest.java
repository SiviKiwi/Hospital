import hospital.Department;
import hospital.exception.RemoveException;
import hospital.healthpersonal.Nurse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InvalidApplicationException;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveTest {
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
    @DisplayName("Test remove()-method with valid input")
    public void testRemoveWithValidInput() throws RemoveException {
        Nurse nurse = new Nurse("Test", "Person", "12345678910");
        this.department.getEmployees().put(nurse.getSocialSecurityNumber(), nurse);
        assertTrue(this.department.getEmployees().containsValue(nurse));
        this.department.remove(nurse);
        assertFalse(this.department.getEmployees().containsValue(nurse));
    }

    @Test
    @DisplayName("Test remove()-method with invalid input")
    public void testRemoveWithInvalidInput() {
        Nurse nurse = new Nurse("Test", "Person", "12345678910");
        Exception exception = assertThrows(RemoveException.class, () -> {
           this.department.remove(nurse);
        });

    }
}
