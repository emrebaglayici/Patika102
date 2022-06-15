package Inheritance;

public class SecurityPersonnel extends Officer{
    private String certificate;

    public SecurityPersonnel(String firstName, String lastName, String mPhone, String email, String department, String shift, String certificate) {
        super(firstName, lastName, mPhone, email, department, shift);
        this.certificate = certificate;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public void guardDuty(){
        System.out.println(this.getFirstName()+" "+this.getLastName()+" is on duty.");
    }
}
