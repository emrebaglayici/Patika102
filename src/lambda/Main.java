package lambda;

public class Main {
    public static void main(String[] args) {
//        Math sum=new Math() {
//            @Override
//            public int transaction(int a, int b) {
//                return a+b;
//            }
//        };

        Math sum=(a,b)->a+b;
        Math subtraction=(a,b)->a-b;
        Math division=(a,b)->{
            if(b==0)
                b=1;
            return a/b;
        };
        Math multiply=(a,b)->a*b;


        System.out.println(sum.transaction(10,2));

    }
}
