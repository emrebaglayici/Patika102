package File.Buffered.Out;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        String data = "Java 102";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte[] byteArray = data
                    .getBytes();
            bufferedOutputStream.write(byteArray);
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
