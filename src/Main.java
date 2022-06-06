import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();

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

        JOptionPane.showMessageDialog(null, "Login to account, pelase enter credentials");

        String username2 = JOptionPane.showInputDialog(null, "Enter Username: ");
        String password2 = JOptionPane.showInputDialog(null, "Enter Password: ");

        login.loginUser(username2, password2);
        String loginStatus = login.returnLoginStatus();
        JOptionPane.showMessageDialog(null, loginStatus);

    }
}
