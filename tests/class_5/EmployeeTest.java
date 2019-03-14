package class_5;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EmployeeTest {

    @Test
    public void testObjectCreation() {
        Employee employee = new Employee("John Doe", "pilot", "joh.doe@aol.com", "1123482552", 5_243.34, 41);

        assertEquals(employee.getAge(), 41);
        assertEquals(employee.getPhone(), "81123482552");
    }
}