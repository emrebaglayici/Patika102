package File.ByteArrayStream.Out;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String data="Java 102!";
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        byte[] bytes=data.getBytes();

        try {
            byteArrayOutputStream.write(bytes);
            String temp=byteArrayOutputStream.toString();
            System.out.println(temp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
