import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CreatingUserAccount user = new CreatingUserAccount(
                "Devin", "Diaz", "04-17-04",
                "ddiaz@harvard.edu", "ddiaz71", "Kimurabjj",
                "brighton", "camry"
        );


        System.out.print("Change password (Y/N): ");
        String ans = sc.nextLine();
        if(ans.equalsIgnoreCase("y")) {
            userPasswordChanger(user);
        }
    }

    private static void userPasswordChanger(CreatingUserAccount user) {
        String currentUser = user.getUserDetails("username").toUpperCase();
        Scanner sc = new Scanner(System.in);
        String newPassword;
        String oldPassword;

        System.out.print("Please Enter Old Password: ");
        oldPassword = sc.nextLine();

        if(!user.passwordChecker(oldPassword)) {
            do {
                System.out.println("*NOT FOUND* PLEASE TRY AGAIN");
                System.out.print("Please Enter Old Password: ");
                oldPassword = sc.nextLine();
            }while(!user.passwordChecker(oldPassword));
        }
        System.out.print("Enter New Password: ");
        newPassword = sc.nextLine();

        if(!user.passwordChangerConditions(newPassword)) {
            do {
                System.out.println("*INVALID SEQUENCE* MUST HAVE SPECIAL CHAR, UPPERCASE," +
                        "NON FIRST AND LAST NAME, AND 8 OR MORE CHARACTERS!");
                System.out.print("Enter New Password: ");
                newPassword = sc.nextLine();
            }while(!user.passwordChangerConditions(newPassword));
        }

        user.setUserDetails("password", newPassword);
        System.out.println("UPDATE FOR : " + currentUser + "\n"+
                "YOUR NEW CREDENTIALS: \n" +
                "OLD PASSWORD: " + oldPassword + "\n" +
                "NEW PASSWORD: " + user.getUserDetails("password"));
    }
}