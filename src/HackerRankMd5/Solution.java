package HackerRankMd5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String regex="^[a-zA-Z0-9]+$";
        Pattern pattern=Pattern.compile(regex);
        Scanner scanner=new Scanner(System.in);
        System.out.println("Type a string");
        String input=scanner.nextLine();
        Matcher matcher=pattern.matcher(input);
        if (matcher.matches() && input.length()>=6 && input.length()<=20){
            System.out.println(getMd5(input));
        }
        else{
            System.out.println("wrong");
        }

    }
    public static String getMd5(String s){
        try {
            MessageDigest md=MessageDigest.getInstance("MD5");
            byte[] messageDigest= md.digest(s.getBytes());
            BigInteger no=new BigInteger(1,messageDigest);
            String hashText=no.toString(16);
            while(hashText.length()<32){
                hashText="0"+hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
