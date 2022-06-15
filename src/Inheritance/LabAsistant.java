package Inheritance;

public class LabAsistant extends Asistant{
    public LabAsistant(String firstName, String lastName, String mPhone, String email, String section, String title, String officeHours) {
        super(firstName, lastName, mPhone, email, section, title, officeHours);


    }
    public void labTeach(){
        System.out.println(this.getFirstName()+" "+this.getLastName()+" is teaching at lab.");
    }

}
