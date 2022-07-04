import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReportTest {

    Task task = new Task();

    /**
     * Creates valid IDs
     * Adds tasks to Task
     */
    String task1ID = task.createTaskID("Create Login", 0, "Mike Smith");
    String task2ID = task.createTaskID("Create Add Feature", 1, "Mike Smith");
    String task3ID = task.createTaskID("Create Reports", 2, "Samantha Paulson");
    String task4ID = task.createTaskID("Add Arrays", 3, "Glenda Oberholzer");

    // Helper method to Ensure Test Data is added to Task arrays
    void addTestData() {
        // Adding Test data to Task - Modified Harrison to Harrington
        task.addTask("Create Login", 0, "Create login to Authenticate users", "Mike Smith", 5, task1ID, "To Do");
        task.addTask("Create Add Feature", 1, "Create login to Authenticate users", "Edward Harrington", 8, task2ID, "Doing");
        task.addTask("Create Reports", 2, "Create login to Authenticate users", "Samantha Paulson", 2, task3ID, "Done");
        task.addTask("Add Arrays", 3, "Create login to Authenticate users", "Glenda Oberholzer", 11, task4ID, "To Do");
    }

    @Test
    void checkDeveloperArray() {
        addTestData();

        // Ensure "developers" array is correctly populated
        String[] array = new String[] {"Mike Smith", "Edward Harrington", "Samantha Paulson", "Glenda Oberholzer"};

        /**
         * Lines 33 is Adapted from a Geeks For Geeks blog post on 04/07/2022
         * Blog: https://www.geeksforgeeks.org/java-program-to-write-an-array-of-strings-to-the-output-console/#:~:text=We%20cannot%20print%20array%20elements,or%203%2Ddimensional%20array%20etc.
         */
        assertEquals(Arrays.toString(array), Arrays.toString(task.developers.toArray()));
    }

    @Test
    void findLongestTask() {
        addTestData();

        // Ensures correect value is returned when finding the longest task
        assertEquals("Glenda Oberholzer, 11;", task.findLongestTask());
    }

    @Test
    void findByTaskName() {
        addTestData();

//        assertEquals("Mike Smith, Create Login", task.findByTaskName());
    }

}
