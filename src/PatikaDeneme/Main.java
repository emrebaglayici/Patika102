package PatikaDeneme;

public class Main {
    public static void subs(int n){
        System.out.print(n+" ");
        if (n<=0)
            return ;
        subs(n-5);
        System.out.print(n+" ");
    }
    public static void main(String[] args) {
        subs(35);
    }
}
