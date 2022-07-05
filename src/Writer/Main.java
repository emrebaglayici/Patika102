package Writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        String data = "İÖĞÜ";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("patika.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            System.out.println(outputStreamWriter.getEncoding());
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            fileOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}
