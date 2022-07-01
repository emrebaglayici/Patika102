package File.Buffered.In;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream=new FileInputStream("patika.txt");
            BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
            int i= bufferedInputStream.read();
            while (i!=-1){
                System.out.print((char)i);
                i= bufferedInputStream.read();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
