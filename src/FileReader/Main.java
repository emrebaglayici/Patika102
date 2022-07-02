package FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        try {
//            FileReader input=new FileReader("patika.txt");
//            input.skip(2);
//            int i= input.read();
//            while (i!=-1){
//                System.out.print((char)i);
//                i= input.read();
//            }
//            input.close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        String data="Java 102";
        try {
            FileWriter fileWriter=new FileWriter("output.txt");
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
