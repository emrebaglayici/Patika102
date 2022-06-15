package Inheritance;

public class ComputerPersonnel extends Officer{
    private String job;
    public ComputerPersonnel(String firstName, String lastName, String mPhone, String email, String department, String shift,String job) {
        super(firstName, lastName, mPhone, email, department, shift);
        this.job=job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    public void setupNetwork(){
        System.out.println(this.getFirstName()+" "+this.getLastName()+" is set up the network.");
    }
}
