package TuringBaseballGame;

import java.util.Scanner;
import java.util.Stack;

class Solution{
    public static int callPoints(String[] ops){
        int result=0;
        Stack<Integer> records=new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "+" -> {
                    int prev1 = records.pop();
                    int prev2 = records.pop();
                    records.push(prev2);
                    records.push(prev1);
                    records.push(prev1 + prev2);
                }
                case "D" -> records.push(records.peek() * 2);
                case "C" -> records.pop();
                default -> records.push(Integer.parseInt(op));
            }
        }

        for (Integer record : records) {
            result += record;
        }
        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ops=sc.nextLine().split(" ");
        System.out.println(Solution.callPoints(ops));
    }
}
