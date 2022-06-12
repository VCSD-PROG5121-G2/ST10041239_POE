import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    // Expected Results
    String vRigerStatus = "Password Successfully captured. Username successfully captured.";
    String iPassowrdStatus = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a captial letter, a number and a special character.";

    // Fake User details
    String firstName = "Charles";
    String lastName = "Rossouw";
    String username = "ch_5";
    String fakePassword = "FakePassword123$";
    Login login = new Login();

    /**
     * RegisterUser handles the validation of Username and Password, and set's the "Login" class fields to those values
     * Therefore by recieving the string, "Password Successfully Captured. Username Successfully Captured" it proves that
     * the inputted Username & Password are valid, and the system will subsiquently output, "Welcome _firstname_...." message
     * when calling "returnLoginStatus" method.
     */
    @Test
    void registerUser() {
        //Valid Username
        String vUsername = "kyl_1";
        String vUsernameRegisterStatus = login.registerUser(firstName, lastName, vUsername, fakePassword);
        login.loginUser(vUsername, fakePassword);

        // Ensure correct messages are displayed for Registering/Input validation and for RetrunLoginStatus
        assertEquals(vRigerStatus, vUsernameRegisterStatus);
        assertEquals("Welcome " + firstName + ", " + lastName + ", " + "it is great to see you again", login.returnLoginStatus());

        // Invalid Username
        String iUsername = "kyle!!!!!!!";
        String iUsernameRegisterStatus = login.registerUser(firstName, lastName, iUsername, fakePassword);
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", iUsernameRegisterStatus);

        // Valid Password
        String vPassword = "Ch&&sec@ke99!";
        String vPasswordRegisterStatus = login.registerUser(firstName, lastName, username, vPassword);
        assertEquals(vRigerStatus, vPasswordRegisterStatus);

        // Invalid Password
        String iPassword = "password";
        String iPasswordRegisterStatus = login.registerUser(firstName, lastName, username, iPassword);
        assertEquals(iPassowrdStatus, iPasswordRegisterStatus);
    }

    /**
     * Direct Calls to Username and Password validation checks, thereFore proving the boolean tests
     */
    @Test
    void checkUserName() {
        // Valid username
        boolean vUserNameResult = login.checkUserName("kyl_1");
        assertTrue(vUserNameResult);

        // Invalid username
        boolean iUsernameResult = login.checkUserName("kyle!!!!!!!");
        assertFalse(iUsernameResult);
    }

    void checkPassword() {
        // Valid Password
        boolean vPasswordResult = login.checkPasswordComplexity("Ch&&sec@ke99!");
        assertTrue(vPasswordResult);

        // Invalid Password
        boolean iPasswordResult = login.checkPasswordComplexity("password");
        assertFalse(iPasswordResult);
    }

    @Test
    void loginUser() {
        // Sucessful Login
        login.registerUser(firstName, lastName, "ch_5", fakePassword);
        boolean vloginResult = login.loginUser("ch_5", fakePassword);
        assertTrue(vloginResult);

        // Uncessful Login
        boolean iloginResult = login.loginUser("ch*5", fakePassword);
        assertFalse(iloginResult);
    }

}