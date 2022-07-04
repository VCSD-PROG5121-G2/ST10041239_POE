import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    
//    Task task = new Task();
//
//    /**
//     * Because all created Tasks are more treated as Obejcts, the respective
//     * TaskItems are created to store the necessary and respective data.
//     * The taskID's are manually generated as if they were in "Main"
//     */
//    String task1ID = task.createTaskID("Login Feature", 0,"Roby Harrison");
//    String task2ID = task.createTaskID("Add Task Feature", 1, "Mike Smith");
//    TaskItem task1 = new TaskItem("Login Feature", 0, "Create login to authenticate users", "Roby Harrison", 8, task1ID, "To Do");
//    TaskItem task2 = new TaskItem("Add Task Feature", 1, "Create Add Task feature to add task users", "Mike Smith", 10, task2ID, "Doing");
//
//    @Test
//    void checkTaskDescription() {
//        // Valid Description
//        String vTaskDescription = task1.getDescription();
//        assertEquals(true, task.checkTaskDescription(vTaskDescription));
//
//        // Invalid Descripton
//        String iTaskDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam quis est a justo volutpat venenatis ut et nibh. Suspendisse potenti. Vivamus molestie dapibus nisi nec aliquam. Ut id ornare nunc. Aliquam varius metus id ligula luctus consectetur. Quisque quis ultrices purus. Nullam suscipit quam at dignissim volutpat. Suspendisse potenti. Maecenas pellentesque feugiat.";
//        assertEquals(false, task.checkTaskDescription(iTaskDescription));
//    }
//
//    @Test
//    void createTaskID() {
//        assertEquals("AD:1:ITH", task2ID);
//    }
//
//    @Test
//    void retrunTotalHours() {
//        /**
//         * Task 1 of "returnTotalHours" test
//          */
//        // Add TaskItems to the Task class
//        task.addTask(task1);
//        task.addTask(task2);
//
//        // Test 1
//        int totalHours1 = task.retrunTotalHours();
//        assertEquals(18, totalHours1);
//
//        /**
//         * Task 2 of "returnTotalHours" test
//         */
//        // Creating appropriate Task data
//        Task newTask = new Task();
//        TaskItem task3 = new TaskItem("Login Feature", 0, "Create login to authenticate users", "Roby Harrison", 10, task1ID, "To Do");
//        TaskItem task4 = new TaskItem("Login Feature",  1,"Create login to authenticate users", "Roby Harrison", 12, task1ID, "To Do");
//        TaskItem task5 = new TaskItem("Login Feature",  2,"Create login to authenticate users", "Roby Harrison", 55, task1ID, "To Do");
//        TaskItem task6 = new TaskItem("Login Feature",  3,"Create login to authenticate users", "Roby Harrison", 11, task1ID, "To Do");
//        TaskItem task7 = new TaskItem("Login Feature", 3,"Create login to authenticate users", "Roby Harrison", 1, task1ID, "To Do");
//
//        // Adding all TaskItems to Task
//        newTask.addTask(task3);
//        newTask.addTask(task4);
//        newTask.addTask(task5);
//        newTask.addTask(task6);
//        newTask.addTask(task7);
//
//        // Assertion Test
//        int totalHours2 = newTask.retrunTotalHours();
//        assertEquals(89, totalHours2);
//
//    }
}