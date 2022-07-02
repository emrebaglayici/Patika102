package PrintWriter;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String data="Test";

        try {
            PrintWriter printWriter=new PrintWriter("output.txt");
            printWriter.print(data);
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
