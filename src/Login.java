import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    // Private fields to store User's information
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    public Boolean loggedIn = false;

    // Verification control
    public String registerUser(String firstName, String lastName, String username, String password) {
        if (!this.checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }else if (!this.checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a captial letter, a number and a special character.";
        }

        // Account created, and storing values to class fields
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;

        return "Password Successfully captured. Username successfully captured.";
    }

    // Login handler
    public Boolean loginUser(String username, String password) {
        if (username.equals(this.username) && password.equals(password)) {
            this.loggedIn = true;
            return true;
        }

        this.loggedIn = false;
        return false;
    }

    // Signout Handler
    public void signOutUser() {
        this.loggedIn = false;
    }

    // Login Status handler
    public String returnLoginStatus() {
        if (this.loggedIn) {
            return "Welcome " + this.firstName + ", " + this.lastName + ", " + "it is great to see you again";
        }
        return "Username or Password incorreect, please try again.";

    }

    // Username verification
    public boolean checkUserName(String username) {
        if (username.length() <= 5 && username.contains("_")) {
            return true;
        }else {
            return false;
        }
    }

    // Password verification
    public boolean checkPasswordComplexity(String password) {
        // Conditional case variables
        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChacter = false;
        boolean hasEnoughCharacters = false;


        // Regex pattern to ensure password has special Characters
        Pattern specialCharacters = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

        // Looping over password string to ensure Password is formatted correctly
        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);

            if(Character.isUpperCase(character)) {
                hasUpperCase = true;
            }else if (Character.isDigit(character)) {
                hasNumber = true;
            }
        }

        // Cross check with Regex if password has special Chacters
        if (specialCharacters.matcher(password).find()) {
           hasSpecialChacter = true;
        }

        // Ensure password is actually over 8 charcters
        if (password.length() >= 8) {
            hasEnoughCharacters = true;
        }

        return hasUpperCase && hasNumber && hasSpecialChacter && hasEnoughCharacters;
    }

}
