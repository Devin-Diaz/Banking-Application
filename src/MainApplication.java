//PATH TO PROJECT: /IdeaProjects/BankingApplication
//For version control reasons
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CreatingUserAccount user = new CreatingUserAccount(
                "Devin", "Diaz", "04=17=04", "diazdev@gmail.com",
                "ddiaz3", "kimurabjj", "camry", "bb"
        );




//        System.out.print("Change password (Y/N): ");
//        String ans = sc.nextLine();
//        if(ans.equalsIgnoreCase("y")) {
//            changingUserPassword(user); //<- an object that was made in this method static main()
//        }
    }

    //new static void method to change users password
    private static void changingUserPassword(CreatingUserAccount user) {
        UserChangingDetails newUserPassword = new UserChangingDetails();
        newUserPassword.userPasswordChangerFinal(user);
    }

    private static void settingUserPassword(CreatingUserAccount user) {
        Scanner sc = new Scanner(System.in);
        String password;
        System.out.println("PLEASE CREATE PASSWORD \n" +
                "PASSWORD MUST CONTAIN: \n" +
                "8 OR MORE CHARACTERS \n" +
                "SPECIAL CHARACTER e.g !, @, #, $, %,...\n" +
                "UPPERCASE CHARACTER \n" +
                "AND CANNOT HAVE YOUR FIRST OR LAST NAME.");
    }
}