import javax.swing.*;

public class Main {
    static Login login = new Login();

    public static void main(String[] args) {
        // Signup and Login User
//        SignUpHandler();
//        LoginHandler();

        while (login.returnLoginStatus() != "Username or Password incorreect, please try again.") {
            // Using a string to stop the program from crashing when non-numeric values are inputted
            String userOption = JOptionPane.showInputDialog(null, "Welcome to EasyKanban.\nEnter your choice:\n\n1: Add Task\n2:Show Report\n3:Quit\n\n");

            switch (userOption) {
                case "1":
                    int amountOfTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the amount of Tasks you wish to create"));
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "You've quite bye!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input, please try again.");
            }
        }
    }

    // Sign Up Handler
    public static void SignUpHandler() {
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
    public static void LoginHandler() {
        JOptionPane.showMessageDialog(null, "Login to account, pelase enter credentials");

        String username2 = JOptionPane.showInputDialog(null, "Enter Username: ");
        String password2 = JOptionPane.showInputDialog(null, "Enter Password: ");

        login.loginUser(username2, password2);
        String loginStatus = login.returnLoginStatus();
        JOptionPane.showMessageDialog(null, loginStatus);
    }

    //
}
