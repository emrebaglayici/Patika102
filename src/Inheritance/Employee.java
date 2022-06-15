package Inheritance;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private String mPhone;
    private String email;

    public Employee(String firstName, String lastName, String mPhone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mPhone = mPhone;
        this.email = email;
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

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void in(){
        System.out.println(this.firstName+" "+this.lastName+" is in.");
    }

    public void in(String entranceHour){
        System.out.println(this.firstName+" "+this.lastName+" is in at "+entranceHour+" .");
    }

    public void out(){
        System.out.println(this.firstName+" "+this.lastName+" is out.");
    }
    public void diningHall(){
        System.out.println(this.firstName+" "+this.lastName+" at dining hall.");
    }

    public static void loginUsers(Employee[] employees){
        for(Employee employee:employees){
            employee.in();
        }
    }
}
