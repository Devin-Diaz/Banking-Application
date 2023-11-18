//PATH TO PROJECT: /IdeaProjects/BankingApplication
//For version control reasons
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
            changingUserPassword(user);
        }
    }

    //new static void method to change users password
    private static void changingUserPassword(CreatingUserAccount user) {
        UserChangingDetails newUserPassword = new UserChangingDetails();
        newUserPassword.userPasswordChangerFinal(user);
    }

}