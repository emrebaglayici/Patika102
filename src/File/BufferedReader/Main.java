package File.BufferedReader;

import java.io.*;

public class Main {
    public static void main(String[] args) {
//        try {
//            FileReader fileReader=new FileReader("patika.txt");
//            BufferedReader bufferedReader=new BufferedReader(fileReader);
//
//            String line;
//            while((line= bufferedReader.readLine())!=null){
//                System.out.println(line);
//            }
//            bufferedReader.close();
//            fileReader.close();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        String data="LEARNINGJAVA";
        try {
            FileWriter fileWriter=new FileWriter("output.txt");
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write(data);

            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
