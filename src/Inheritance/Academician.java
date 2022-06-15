package Inheritance;

public abstract class Academician extends Employee{
    private String section;
    private String title;
    public Academician(String firstName, String lastName, String mPhone, String email, String section, String title) {
        super(firstName, lastName, mPhone, email);
        this.section=section;
        this.title=title;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public abstract void teach(String classHours);

    @Override
    public void in(){
        System.out.println(this.getFirstName()+" "+this.getLastName()+" entered A Gate .");
    }
}
