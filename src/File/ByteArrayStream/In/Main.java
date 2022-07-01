package File.ByteArrayStream.In;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        byte[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(arr,2,5);
        System.out.println("Available : " + inputStream.available());
        int i = inputStream.read();
        while (i != -1){
            System.out.println(i);
            i=inputStream.read();
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
