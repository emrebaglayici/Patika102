package File.InputStream;

import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream inputStream=new FileInputStream("src/File/InputStream/patika.txt");
            System.out.println("Available : "+inputStream.available());
            inputStream.skip(10);
            int i=inputStream.read();
            while(i!=-1){
                System.out.print((char)i);
                i=inputStream.read();
            }
            inputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
