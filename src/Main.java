import javax.swing.*;

public class Main {
    // "Global" classes for Main to access
    static Login login = new Login();
    static Task task = new Task();

    static boolean reportMenuOpen = false;

    public static void main(String[] args) {
        // Signup and Login User
//        SignUpHandler();
//        LoginHandler();

        // Loop to manage the Choices of the user
        while (login.returnLoginStatus() != "Username or Password incorreect, please try again.") {

            // Using a string to stop the program from crashing when non-numeric values are inputted
            String userOption = JOptionPane.showInputDialog(null, "Welcome to EasyKanban.\nEnter your choice:\n\n1: Add Task\n2:Show Report\n3:Quit\n\n");

            // Used an Swtich statment as it less verbose than an If statement
            switch (userOption) {
                case "1":
                    TaskCreationHandler();
                    break;
                case "2":
                    reportMenuOpen = true;
                    ReportHandler();
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Thank you for using EasyKanban\n\nSee you next time!");
                    login.signOutUser();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input, please try again.");
            }
        }
    }

    // Sign Up Handler
    private static void SignUpHandler() {
        // Prompt for First Name and Last Name
        String firstName = JOptionPane.showInputDialog(null, "Enter First Name: ");
        String lastName = JOptionPane.showInputDialog(null, "Enter Last Name: ");

        while(true) {
            // Prompt for Username and Password
            String username = JOptionPane.showInputDialog(null, "Enter Username: ");
            String password = JOptionPane.showInputDialog(null, "Enter Password: ");

            String registerStatus = login.registerUser(firstName, lastName, username, password);
            JOptionPane.showMessageDialog(null, registerStatus);

            if(registerStatus.equals("Password Successfully captured. Username successfully captured.")) {
                break;
            }

            continue;
        }
    }

    // Login Handler
    private static void LoginHandler() {
        JOptionPane.showMessageDialog(null, "Login to account, pelase enter credentials");

        // Controlled loop so User can attempt multiple Logins
        do {
            // Capture Username and Password
            String username = JOptionPane.showInputDialog(null, "Enter Username: ");
            String password = JOptionPane.showInputDialog(null, "Enter Password: ");

            // Login User and print the Login status
            login.loginUser(username, password);
            String loginStatus = login.returnLoginStatus();
            JOptionPane.showMessageDialog(null, loginStatus);

        }while(login.returnLoginStatus() == "Username or Password incorreect, please try again.");
    }

    // Task Creation Handler
    private static void TaskCreationHandler() {
        int amountOfTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the amount of Tasks you wish to create"));

        // Controlled loop to repeat Task creations based on the amount of Tasks wished to be created by the User
        for (int i = 0; i < amountOfTasks; i++) {
            // Capturing of core data
            String taskStatus;
            String taskName = JOptionPane.showInputDialog(null, "Please enter the Name of the Task");
            String taskDeveloper = JOptionPane.showInputDialog(null, "Please enter the First and Last Name of the Developer assigned to the Task");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the estimated Duration of the Task"));

            // Ensure that the entered Task Status is valid
            while(true) {
                taskStatus = JOptionPane.showInputDialog(null, "Please enter the Status of the Task from the options:\n\n(1)To Do\n(2)Done\n(3)Doing\n\n");

                if (taskStatus.equals("To Do") || taskStatus.equals("Done") || taskStatus.equals("Doing")) {
                    break;
                }

                JOptionPane.showMessageDialog(null, "Invalid Status Entered please try again");
                continue;
            }

            String taskDescription = JOptionPane.showInputDialog(null, "Please enter the Description of the Task");

            // Ensuring the Task Description is valid
            while (!task.checkTaskDescription(taskDescription)) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                taskDescription = JOptionPane.showInputDialog(null, "Please enter the Description of the Task");
            }

            // Generating a respective TaskID for the newly created Task
            String taskID = task.createTaskID(taskName, i, taskDeveloper);

            // Calling Task class to add Task Details to respective arrays
            task.addTask(taskName, i,taskDescription, taskDeveloper, taskDuration, taskStatus, taskID);
            JOptionPane.showMessageDialog(null, "Task successfully captured");

            // Print the Task details of the currently created
            String details = task.printTaskDetails(i);
            JOptionPane.showMessageDialog(null, details);
        }

        // Displaying the total hours of created Tasks
        int totalHours = task.retrunTotalHours();
        JOptionPane.showMessageDialog(null, "Total Hours for Tasks entered: " + totalHours);
    }

    // Report Menue Handler
    public static void ReportHandler() {
       while(reportMenuOpen) {
           // Using a string to stop the program from crashing when non-numeric values are inputted
           String userOption = JOptionPane.showInputDialog(null, "Welcome To Report.\nEnter your choice:\n\n1: Display Done Tasks\n2: Show Longest Task\n3: Search by Task Name\n4: Find all Tasks associated by Developer\n5: Remove Task by Task Name\n6: Display Reports\n7: Go Back");

           // Used an Swtich statment as it less verbose than an If statement
           switch (userOption) {
               case "1":
                   task.findFinishedTasks();
                   break;
               case "2":
                   task.findLongestTask();
                   break;
               case "3":
                   searchByTaskNameHandler();
                   break;
               case "4":
                    searchByDeveloperHandler();
                   break;
               case "5":
                    deleteTaskHandler();
                   break;
               case "6":
                   task.displayAllTasks();
                   break;
               case "7":
                   reportMenuOpen = false;
                   break;
               default:
                   JOptionPane.showMessageDialog(null, "Invalid input, please try again.");
           }
       }
    }

    // Handles Front End functionality of "task.findByTaskName"
    public static void searchByTaskNameHandler() {
        while (true) {
            String taskName = JOptionPane.showInputDialog(null, "Please enter a valid Task Name: ");
            boolean found = task.findByTaskName(taskName);

            if(found) {
                break;
            }else {
                JOptionPane.showMessageDialog(null, "Couldn't find task of Task Name: " + taskName);
                continue;
            }
        }
    }

    // Handles Front End functionality of "task.findByDeveloper"
    public static void searchByDeveloperHandler() {
        while (true) {
            String developerName = JOptionPane.showInputDialog(null, "Please enter a valid Developer name: ");
            boolean found = task.findByDeveloper(developerName);

            if(found) {
                break;
            }else {
                JOptionPane.showMessageDialog(null, "Couldn't find task associated with Developer: " + developerName);
                continue;
            }
        }
    }

    // Handles Front End functionality of "task.deleteTask"
    public static void deleteTaskHandler() {
        while (true) {
            String taskName = JOptionPane.showInputDialog(null, "Please enter a valid Task Name: ");
            boolean deleted = task.deleteTask(taskName);

            if (deleted) {
                break;
            }else {
                continue;
            }
        }
    }
}
