package Inheritance;

public class Asistant extends Academician{
    private String officeHours;
    public Asistant(String firstName, String lastName, String mPhone, String email, String section, String title,String officeHours) {
        super(firstName, lastName, mPhone, email, section, title);
        this.officeHours=officeHours;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public void doQuiz(){
        System.out.println(this.getFirstName()+" "+this.getLastName()+" is doing quiz.");
    }

    @Override
    public void teach(String classHours) {

    }
}
