package first;

public class Course {
    String name,code,prefix;
    int note;
    static int counter=0;

    static {
        int random=(int)(Math.random()*10);
        counter=random;
        System.out.println(counter);
    }
    public Course(String name,String code,String prefix){
        this.name=name;
        this.code=code;
        this.prefix=prefix;
        this.note=0;
    }



    public static void courseList(){
        String[] courses={"Mat","Fizik","Kimya"};
        for(String i:courses){
            System.out.println(i);
        }
    }

}
