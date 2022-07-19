package HackerRankBigInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader
                =new BufferedReader(new InputStreamReader(
                        System.in
        ));
        BigInteger add,multp;
        String string1= bufferedReader.readLine();
        String string2= bufferedReader.readLine();

        BigInteger bigInteger1=
                new BigInteger(string1);
        BigInteger bigInteger2=
                new BigInteger(string2);

        add=bigInteger1.add(bigInteger2);
        multp=bigInteger1.multiply(bigInteger2);

        System.out.println(add);
        System.out.println(multp);
    }
}
