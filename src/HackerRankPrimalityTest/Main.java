package HackerRankPrimalityTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        String n = bufferedReader.readLine();
//        BigInteger bigInteger=new BigInteger(n);
//
//        boolean a,b,c;
//        a=bigInteger.isProbablePrime(-1); //true always
//        b=bigInteger.isProbablePrime(0);  // true always
//        c=bigInteger.isProbablePrime(1);
//
//
//        if(a && b && c){
//            System.out.println("prime");
//        }else {
//            System.out.println("not prime");
//        }
//        bufferedReader.close();
//        System.out.println(isPrime(88));

//        primeTill(700);
//        System.out.println(isPrime(3)?"true":"false");
        System.out.println((11/2));


    }
    public static void primeTill(int n){
        int number;
        for (int i = 2; i <=n ; i++) {
            number=0;
            for (int j = 2; j <=i/2 ; j++) {
                if(i%j==0)
                    number++;
            }
            if(number==0)
                System.out.println(i);
        }
    }
    public static boolean isPrime(Integer number){
        if (number<=1){
            return false;
        }else{
            for (int i = 2; i <=number/2 ; i++) {
                if ((number%i)==0){
                    return  false;
                }
            }
            return true;
        }
    }
}
