package InsuranceMS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user
                =new User("emre",
                "baglayici","emrebaglayici","123","developer",
                26, "16-10-1996");
        Account account=new Individual(user);
        AccountManager accountManager=new AccountManager();
        accountManager.getAccountList().add(account);
        Scanner scanner=new Scanner(System.in);
        String email,password;
        System.out.println("Enter your email");
        email=scanner.next();
        System.out.println("Enter your password");
        password=scanner.next();
        accountManager.login(email,password);
    }
}
