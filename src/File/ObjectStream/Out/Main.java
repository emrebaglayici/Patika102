package File.ObjectStream.Out;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Car c1=new Car("Yamaha","XMax400");
//        try {
//            FileOutputStream outputStream=new FileOutputStream("car.txt");
//            ObjectOutputStream output=new ObjectOutputStream(outputStream);
//            output.writeObject(c1);
//            output.close();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try {
            FileInputStream fileInputStream=new FileInputStream("car.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            Car newCar= (Car) objectInputStream.readObject();
            System.out.println(newCar.getBrand());
            System.out.println(newCar.getModel());
            fileInputStream.close();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
