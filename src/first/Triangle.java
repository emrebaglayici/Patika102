package first;

public class Triangle {
    public int r;
    public final double PI=3.14;

    public Triangle(int r) {
        this.r = r;
    }
    public void calculateArea(){
        double total=PI*this.r*this.r;
        System.out.println(total);
    }

    public static void main(String[] args) {
        Triangle a=new Triangle(10);
        a.calculateArea();
    }

}
