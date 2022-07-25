package HackerRankSHA256;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String regex="^[a-zA-Z0-9]+$";
        Pattern pattern=Pattern.compile(regex);
        System.out.println("Type a string");
        String in=scanner.nextLine();
        Matcher matcher= pattern.matcher(in);
        if (matcher.matches()&& in.length()>=6 && in.length()<=20){
            System.out.println(getSha256(in));
        }


    }
    public static String getSha256(String str){
        try {
            MessageDigest md=MessageDigest.getInstance("SHA-256");
            byte[] messageDigest= md.digest(str.getBytes());
            BigInteger bigInteger=new BigInteger(1,messageDigest);
            String hexString=bigInteger.toString(16);
            while (hexString.length()<64){
                hexString="0"+hexString;
            }
            return hexString;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
}
