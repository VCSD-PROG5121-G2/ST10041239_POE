import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Task {
    /**
     * Lines 10, and 14 were Adapted from a Java Hungry blog post on 5/06/2022
     * Blog: https://javahungry.blogspot.com/2020/04/append-array-java.html
     */
    private List<TaskItem> taskItems = new ArrayList<TaskItem>(); // List of all the created Tasks

    // Appends Task to the taskItem array
    public void addTask(TaskItem task) {
        taskItems.add(task);
    }

    /**
     * Ensures the Task Description is no more than 50 characters.
     * Returns True if Description is valid, False if Description is invalid
     */
    public Boolean checkTaskDescription(String description) {
        if (description.length() >= 50) {
            return false;
        }

        return true;
    }

    // Generates the approriate Task ID for created Task
    public String createTaskID(String name, int number, String developerDetails) {
        /**
         * Lines 37 & 38 were adopted from a HowToDoInJava blog post on 05/06/2022
         * Blog Post: https://howtodoinjava.com/java/string/get-last-4-characters/#:~:text=For%20example%2C%20to%20get%20last,length()%20%2D%202)%20.
         */
        // Approrite shorted values of the Task Name and Developer Details
        String nameSub = name.substring(0, 2).toUpperCase();
        String devSub = developerDetails.substring(developerDetails.length() - 3).toUpperCase();

        String id = nameSub + ":" + number + ":" + devSub;

        return id;
    }

    // Prints out the full details of the Task passed in
    public String printTaskDetails(TaskItem task) {
        String taskDetails = "Here are your Task's details:\n\nStatus: " + task.getStatus() + "\nDeveloper Details: " + task.getDeveloperDetails() + "\nTask Number: " + task.getNumber() + "\nName: " + task.getName() + "\nDescription: " + task.getDescription() + "\nID: " + task.getID() + "\nDuration: " + task.getDuration() + "hrs";
        return taskDetails;
    }

    // Retruns the total hours/duration of the Task items in taskItems array
    public int retrunTotalHours() {
        int totalHours = 0;

        for (int i = 0; i < this.taskItems.toArray().length; i++) {
            /**
             * Line 58 was adopted from a Javapoint blog post on 05/06/2022
             * Blog Post: https://www.javatpoint.com/java-list
             */
            totalHours += taskItems.get(i).getDuration();
        }

        return totalHours;
    }
}
