import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.*;

// this class is the basis of all required information needed to create an account in the banking application
// this also comes with the implemented method of our authenticator for security reasons
// a toString() method is provided at the end to display all information
public class CreatingUserAccount implements Authenticator{

    //Map field as it's more practical than making individual fields for required information
    private Map<String, String> userDetails;

    // all of our fields needed to create an account in the system.

    /* constructor to create account for the banking applications
       We instantiate our userDetails into a HashMap. Every account created,
       will be associated with a HashMap storing all their data.
       TODO EVENTUALLY: sort our HashMap or optimize it with SortedHashMap data structure
     */

    public CreatingUserAccount(String firstName, String lastName, String DOB,
                               String email, String username, String password,
                               String securityQuestionOne, String securityQuestionTwo) {

        Scanner sc = new Scanner(System.in);

        userDetails = new HashMap<>();
        userDetails.put("firstName", firstName);
        userDetails.put("lastName", lastName);
        userDetails.put("DOB", DOB);
        userDetails.put("email", email);
        userDetails.put("username", username);

        //WORK ON THIS FEATURE, FOR FIRST TIME PASSWORD CREATORS
        while(passwordConditions(password)) {
            System.out.print("Invalid password. Please enter a new password:");
            password = sc.nextLine();
        }
        userDetails.put("password", password);

        userDetails.put("securityQuestionOne", securityQuestionOne);
        userDetails.put("securityQuestionTwo", securityQuestionTwo);

    }

    // default constructor to be able to inherit this class to UserChangingDetails
    public CreatingUserAccount() {}

    /* used to authenticate our password whenever a user attempts an action relating
        to their person information. These actions can consist of changing password, username,
        email. Anything relating to their account
     */
    @Override
    public boolean passwordChecker(String password) {
        return !password.equals(userDetails.get("password"));
    }

    @Override
    public boolean passwordConditions(String userPassword) {

        // password cannot be null or shorter than 8 characters
        if(userPassword == null || userPassword.length() < 7) return true;
        /*
            . -> is a wildcard character, it can mean any single character on your keyboard
            * -> means of zero or more occurrences.
            These two combined means MATCHES ZERO OR MORE OF ANY CHARACTER
         */

        String regexUserFirstName = userDetails.get("firstName");
        String regexUserLastName = userDetails.get("lastName");

        //Must contain an uppercase character
        String regexUpperCase = ".*[A-Z].*";

        //Must contain a special character.
        String regexSpecialCharacter = ".*[^a-zA-Z0-9].*";

        //compiles the regex into patterns
        //the regex flag (?i) makes the following input case-sensitive
        Pattern patternFirstName = Pattern.compile("(?i)" + regexUserFirstName);
        Pattern patternLastName = Pattern.compile("(?i)" + regexUserLastName);
        Pattern patternForUpperCase = Pattern.compile(regexUpperCase);
        Pattern patternForSpecialCharacter = Pattern.compile(regexSpecialCharacter);

        //Returns a matcher object with our String that can now be checked for patterns
        Matcher matchFirstName = patternFirstName.matcher(userPassword);
        Matcher matchLastName = patternLastName.matcher(userPassword);
        Matcher matchUpperCase = patternForUpperCase.matcher(userPassword);
        Matcher matchSpecialCharacter = patternForSpecialCharacter.matcher(userPassword);

        //testing to see if the String matches or does not match the pattern we gave via regex
        return matchFirstName.find() || matchLastName.find() ||
                !matchUpperCase.matches() || !matchSpecialCharacter.matches();
    }

    // username required conditions
    @Override
    public boolean userNameConditions(String userName) {
        String regexUpperCase = ".*[A-Z].*";
        Pattern patternUpperCase = Pattern.compile(regexUpperCase);
        Matcher matchUpperCase = patternUpperCase.matcher(userName);

        return matchUpperCase.matches() && userName.length() > 3;
    }


    // accessor method to obtain any of our fields stored in the HashMap from our constructor
    public String getUserDetails(String getUserDetailKey) {
        return userDetails.get(getUserDetailKey);
    }

    // mutator method to adjust any values stored in our fields within the HashMap from the constructor
    public void setUserDetails(String setUserDetailsKey, String setUserDetailsValue) {
        userDetails.put(setUserDetailsKey, setUserDetailsValue);
    }

    // our toString() method to display all user details for user to verify
    @Override
    public String toString() {
        return "Welcome " + userDetails.get("firstName") + "! \n\n" +
                "The following is your banking login credentials: \n" +
                "USERNAME: " + userDetails.get("username") + "\n" +
                "PASSWORD: " + userDetails.get("password") + "\n";
    }
}
