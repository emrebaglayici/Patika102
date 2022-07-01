package InsuranceMS;

import java.util.TreeSet;

public class AccountManager {
    private Account account;
    private TreeSet<Account> accountList;

    public AccountManager(TreeSet<Account> accountList) {
        this.accountList = new TreeSet<>();
    }

    public AccountManager() {
        this.accountList = new TreeSet<>();
    }

    public TreeSet<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(TreeSet<Account> accounts) {
        this.accountList = accounts;
    }

    public Account login(String email, String password) {
        for (Account a : accountList) {
            try {
                if (a.login(email, password)) {
                    a.showInfo();
                    return a;
                }
            } catch (InvalidAuthenticationException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
