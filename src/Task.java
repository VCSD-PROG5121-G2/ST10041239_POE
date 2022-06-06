import java.util.ArrayList;
import java.util.List;

public class Task {
    // List of all the created Tasks
    // https://javahungry.blogspot.com/2020/04/append-array-java.html
    private List<TaskItem> taskItems = new ArrayList<TaskItem>();

    public void addTask(TaskItem task) {
        taskItems.add(task);
    }

    // Ensures the Task Description is no more than 50 characters.
    // Returns True if Description is valid, False if Description is invalid
    public Boolean checkTaskDescription(String description) {
        if (description.length() > 50) {
            return false;
        }

        return true;
    }

    // Generates the approriate Task ID for created Task
    public String createTaskID(String name, int number, String developerDetails) {
        // Approrite shorted values of the Task Name and Developer Details
        // https://howtodoinjava.com/java/string/get-last-4-characters/#:~:text=For%20example%2C%20to%20get%20last,length()%20%2D%202)%20.
        String nameSub = name.substring(0, 2).toUpperCase();
        String devSub = developerDetails.substring(developerDetails.length() - 3).toUpperCase();

        String id = nameSub + ":" + number + ":" + devSub;

        return id;
    }
}
