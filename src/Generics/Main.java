package Generics;

public class Main {
    public static void main(String[] args) {
//        String str="abc";
//        Nullable<String> nullable=new Nullable<>(str);
//        nullable.run();
        Integer a=12;
        String b="emre";
        Double c=3.3;
        Test<Integer,String,Double> test=new Test<>(a,b,c);
        test.showInfo();
    }
}
