package first;

public class Daire {
    public int r;
    public final double PI=3.14;

    public Daire(int r) {
        this.r = r;
    }
    public void calculateArea(){
        double total=PI*this.r*this.r;
        System.out.println(total);
    }

    public static void main(String[] args) {
        Daire a=new Daire(10);
        a.calculateArea();
    }

}
