package Inheritance;

public class Instructor extends Academician{
    private int gateNumber;
    public Instructor(String firstName, String lastName, String mPhone, String email, String section, String title,int gateNumber) {
        super(firstName, lastName, mPhone, email, section, title);
        this.gateNumber=gateNumber;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public void congregation(){
        System.out.println(this.getFirstName()+" "+this.getLastName()+" is at congregation.");
    }
    public void doExam(){
        System.out.println(this.getFirstName()+" "+this.getLastName()+" is doing exam.");
    }

    @Override
    public void teach(String classHours) {
        System.out.println(this.getFirstName()+" "+this.getLastName()+ "instructor enter the class at "+classHours);
    }
}
