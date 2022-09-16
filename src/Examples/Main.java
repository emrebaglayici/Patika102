package Examples;

public class Main {
    public static void main(String[] args) {
        String strPalindrome="emre";
        Integer intPalindrome=32123;
//        System.out.println(palindromeStr(strPalindrome));
        System.out.println(palindromeInt(intPalindrome));
    }

    private static boolean palindromeStr(String strPalindrome) {
        String str="";
        for (int i = strPalindrome.length()-1; i >= 0; i--) {
            str+=strPalindrome.charAt(i);
        }
        return str.equals(strPalindrome);
    }

    public static boolean palindromeInt(Integer intPalindrome){
        String str= String.valueOf(intPalindrome);
        String newStr="";
        for (int i = str.length()-1; i >=0 ; i--) {
            newStr+=str.charAt(i);
        }
        return newStr.equals(str);
    }
}
