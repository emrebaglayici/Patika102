package Generics;

public class Main {
    public static void main(String[] args) {
//        String str="abc";
//        Nullable<String> nullable=new Nullable<>(str);
//        nullable.run();
//        Integer a=12;
//        String b="emre";
//        Double c=3.3;
//        Test<Integer,String,Double> test=new Test<>(a,b,c);
//        test.showInfo();

        Integer x=123;
        String s="123";
        Nullable<Integer> n1=new Nullable<>(x);
        n1.run();
    }
}
