package Inheritance;

public abstract class Officer extends Employee{
    private String department;
    private String shift;
    public Officer(String firstName, String lastName, String mPhone, String email,String department,String shift) {
        super(firstName, lastName, mPhone, email);
        this.department=department;
        this.shift=shift;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    public abstract void work();
}
