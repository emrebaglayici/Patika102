package File.Reader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream=new FileInputStream("file.txt");


            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            System.out.println(inputStreamReader.getEncoding());
            int i= inputStreamReader.read();
            while (i!=-1){
                System.out.print((char) i);
                i=inputStreamReader.read();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
