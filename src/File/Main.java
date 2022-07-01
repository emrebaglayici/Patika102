package File;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file=new File("src/sql");
        /*file.delete();*/
        /*file.mkdir();*/
//        try {
//            if(file.createNewFile())
//                System.out.println(file.getName()+" file created!");
//            else
//                System.out.println(file.getName()+" file already created!");
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
        String[] list=file.list();
        for (String str:list){
            System.out.println(str);
        }
    }
}
