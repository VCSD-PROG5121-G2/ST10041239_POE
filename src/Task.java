import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Task {
    /**
     * Lines 10, and 14 were Adapted from a Java Hungry blog post on 5/06/2022
     * Blog: https://javahungry.blogspot.com/2020/04/append-array-java.html
     */
    public List<String> taskIDs = new ArrayList<String>();
    public List<String> taskNames = new ArrayList<String>();
    public List<String> developers = new ArrayList<String>();
    public List<String> taskStatus = new ArrayList<String>();
    public List<Integer> taskDurations = new ArrayList<Integer>();
    public List<String> taskDescriptions = new ArrayList<String>();


    // Appends Task to the taskItem array
    public void addTask(String name, int number, String description, String developerDetails, int duration, String status, String id) {
        taskIDs.add(id);
        taskNames.add(name);
        developers.add(developerDetails);
        taskStatus.add(status);
        taskDurations.add(duration);
        taskDescriptions.add(description);
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
    public String printTaskDetails(int taskNumber) {
        String taskDetails = "Here are your Task's details:\n\nStatus: " + taskStatus.get(taskNumber) + "\nDeveloper Details: " + developers.get(taskNumber) + "\nTask Number: " + taskNumber + "\nName: " + taskNames.get(taskNumber) + "\nDescription: " + taskDescriptions.get(taskNumber) + "\nID: " + taskIDs.get(taskNumber) + "\nDuration: " + taskDurations.get(taskNumber) + "hrs";
        return taskDetails;
    }

    // Retruns the total hours/duration of the Task items in taskItems array
    public int retrunTotalHours() {
        int totalHours = 0;

        for (int i = 0; i < this.taskDurations.toArray().length; i++) {
            /**
             * Line 70 was adapted from 'w3schools' blog post on 03/07/2022
             * Blog Post: https://www.w3schools.com/java/java_arraylist.asp
             */
            totalHours += taskDurations.get(i);
        }

        return totalHours;
    }

    public boolean findFinishedTasks() {
        boolean found = false;

        for (int i = 0; i < this.taskStatus.toArray().length; i++) {
            if (taskStatus.get(i).equals("Done")) {
                found = true;
                JOptionPane.showMessageDialog(null, "Details:\nTask Name: " + taskNames.get(i) + "\nDeveloper: " + developers.get(i)
                        + "\nDuration: " + taskDurations.get(i));
            }
        }

        return found;
    }

    public void findLongestTask() {

        int largest = 0;
        for ( int i = 1; i < taskDurations.toArray().length; i++ )
        {
            if ( taskDurations.get(i) > taskDurations.get(largest) ) largest = i;
        }
//        for (int i = 0; i < this.taskDurations.toArray().length; i++) {
//            if (taskDurations.get(i) > taskDurations.get(i + 1)) {
//                tempLongest = taskDurations.get(i);
//                index = i;
//            }
//        }

        JOptionPane.showMessageDialog(null, "Longest Task Details:\nDeveloper: " + developers.get(largest) + "\nDuration: " + taskDurations.get(largest));
    }

    public boolean findByTaskName(String taskName) {
        boolean found = false;

        for (int i = 0; i < this.taskNames.toArray().length; i++) {
            if (taskNames.get(i).equals(taskName)) {
                found = true;
                JOptionPane.showMessageDialog(null, "Details:\nTask Name: " + taskNames.get(i) + "\nDeveloper: " + developers.get(i)
                        + "\nStatus: " + taskStatus.get(i));
            }
        }

        return found;
    }

    public boolean findByDeveloper(String developer) {
        boolean found = false;

        for (int i = 0; i < this.developers.toArray().length; i++) {
            if (developers.get(i).equals(developer)) {
                found = true;
                JOptionPane.showMessageDialog(null, "Details:\nTask Name: " + taskNames.get(i) +  "\nStatus: " + taskStatus.get(i));
            }
        }

        return found;
    }

    public boolean deleteTask(String taskName) {
        boolean deleted = true;

        for (int i = 0; i < this.taskNames.toArray().length; i++) {
            if (taskNames.get(i).equals(taskName)) {
                deleted = true;
                taskIDs.remove(i);
                taskNames.remove(i);
                developers.remove(i);
                taskStatus.remove(i);
                taskDurations.remove(i);
                taskDescriptions.remove(i);
            }
        }

        return deleted;
    }

    public void displayAllTasks() {
        for (int i = 0; i < this.taskNames.toArray().length; i++) {
            JOptionPane.showMessageDialog(null, "Here are your Task's details:\n\nStatus: " + taskStatus.get(i) + "\nDeveloper Details: "
                    + developers.get(i) +  "\nName: " + taskNames.get(i) + "\nDescription: "
                    + taskDescriptions.get(i) + "\nID: " + taskIDs.get(i) + "\nDuration: " + taskDurations.get(i) + "hrs");
        }
    }
}
