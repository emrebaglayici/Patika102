package File.PrintStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main{
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("print.txt");
            PrintStream printStream=new PrintStream(fileOutputStream,true);
            printStream.print(123+"321");

            printStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
