package CoensioAssigment;

import java.util.Arrays;

public class Solution {
    public static String returnDuplicates(String myInput) {
        StringBuilder str = new StringBuilder();
        char[] chars = myInput.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1 && chars[i] == chars[i + 1]) {
                str.append(chars[i]);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(returnDuplicates("improper"));
    }
}
