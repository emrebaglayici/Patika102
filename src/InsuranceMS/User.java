package InsuranceMS;

import InsuranceMS.Adresses.IAdress;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String job;
    private Integer age;
    private ArrayList<IAdress> adressList;
    private Date lastLoginDate;

    public User(String firstName, String lastName, String email,
                String password, String job, Integer age,
                ArrayList<IAdress> adressList, Date lastLoginDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
        this.adressList = new ArrayList<>();
        this.lastLoginDate = lastLoginDate;
    }

    public User(ArrayList<IAdress> adressList) {
        this.adressList = adressList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ArrayList<IAdress> getAdressList() {
        return adressList;
    }

    public void setAdressList(ArrayList<IAdress> adressList) {
        this.adressList = adressList;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
