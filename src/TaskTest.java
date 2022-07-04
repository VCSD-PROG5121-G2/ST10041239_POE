import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    
    Task task = new Task();

    /**
     * Creates valid IDs
     * Adds tasks to Task
     */
    String task1ID = task.createTaskID("Login Feature", 0,"Roby Harrison");
    String task2ID = task.createTaskID("Add Task Feature", 1, "Mike Smith");

    @Test
    void checkTaskDescription() {

        // Valid Description
        String vTaskDescription = "Create login to authenticate users";
        assertEquals(true, task.checkTaskDescription(vTaskDescription));

        // Invalid Descripton
        String iTaskDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam quis est a justo volutpat venenatis ut et nibh. Suspendisse potenti. Vivamus molestie dapibus nisi nec aliquam. Ut id ornare nunc. Aliquam varius metus id ligula luctus consectetur. Quisque quis ultrices purus. Nullam suscipit quam at dignissim volutpat. Suspendisse potenti. Maecenas pellentesque feugiat.";
        assertEquals(false, task.checkTaskDescription(iTaskDescription));
    }

    @Test
    void createTaskID() {
        assertEquals("AD:1:ITH", task2ID);
    }

    @Test
    void retrunTotalHours() {
        /**
         * Task 1 of "returnTotalHours" test
         */
        task.addTask("Login Feature", 0, "Create login to authenticate users", "Roby Harrison", 8, "To Do", task1ID);
        task.addTask("Add Task Feature", 1, "Create Add Task feature to add task users", "Mike Smith", 10, "Doing", task2ID);

        // Test 1
        int totalHours1 = task.retrunTotalHours();
        assertEquals(18, totalHours1);

        /**
         * Task 2 of "returnTotalHours" test
         */
        // Creating appropriate Task data & adding it to the "newTask"
        Task newTask = new Task();
        newTask.addTask("Login Feature", 0, "Create login to authenticate users", "Roby Harrison", 10, task1ID, "To Do");
        newTask.addTask("Login Feature",  1,"Create login to authenticate users", "Roby Harrison", 12, task1ID, "To Do");
        newTask.addTask("Login Feature",  2,"Create login to authenticate users", "Roby Harrison", 55, task1ID, "To Do");
        newTask.addTask("Login Feature",  3,"Create login to authenticate users", "Roby Harrison", 11, task1ID, "To Do");
        newTask.addTask("Login Feature", 3,"Create login to authenticate users", "Roby Harrison", 1, task1ID, "To Do");

        // Assertion Test
        int totalHours2 = newTask.retrunTotalHours();
        assertEquals(89, totalHours2);
    }
}