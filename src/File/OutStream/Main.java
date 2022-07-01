package File.OutStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String str="\nOutputStream learning\n";
        try {
            File file=new File("patika.txt");
            FileOutputStream fileOutputStream=new FileOutputStream(file,true);
            byte[] strByte=str.getBytes();
            fileOutputStream.write(strByte);
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }
}
