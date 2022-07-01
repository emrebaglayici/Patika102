package InsuranceMS;

import InsuranceMS.Adresses.IAdress;
import InsuranceMS.Insurance.Insurance;
import com.sun.net.httpserver.Authenticator;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Account implements Comparable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getAuthenticationStatus() == account.getAuthenticationStatus() && getUser().equals(account.getUser()) && getInsurances().equals(account.getInsurances());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthenticationStatus(), getUser(), getInsurances());
    }

    private AuthenticationStatus authenticationStatus;
    private User user;


    private ArrayList<Insurance> insurances;

    public Account(User user) {
        this.user = user;
        this.insurances = new ArrayList<>();
    }

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public boolean login(String email, String password) throws InvalidAuthenticationException {
        if (email.equals(user.getEmail())&& password.equals(user.getPassword())) {
            setAuthenticationStatus(AuthenticationStatus.success);
            System.out.println("User logged in");
            return true;
        } else {
            throw new InvalidAuthenticationException("Email or password invalid");
        }
    }
    public abstract void addPolicy();

    public void userManuelAddressAdding(User user, IAdress adress) {
        user.getAdressList().add(adress);
    }

    public void userManuelAddressRemoving(User user, IAdress adress) {
        user.getAdressList().remove(adress);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public final void showInfo() {
        System.out.println(" Name : " +
                getUser().getFirstName() + " Last Name : " +
                getUser().getLastName() + " Email : " +
                getUser().getEmail() + " Password : " +
                getUser().getPassword() + " Job : " +
                getUser().getJob() + " Age : " +
                getUser().getAge() + " Adress : " +
                getUser().getAdressList() + " Last login date : " +
                getUser().getLastLoginDate()
        );
    }
}
