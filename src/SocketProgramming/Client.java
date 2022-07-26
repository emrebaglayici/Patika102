package SocketProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Socket socket=null;
        PrintWriter out=null;
        BufferedReader in=null;
        String value;
        try{
            socket=new Socket("localhost",7775);
            out=new PrintWriter(socket.getOutputStream(),true);
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Enter a number for sending server");
            BufferedReader data=new BufferedReader(new InputStreamReader(System.in));
            while ((value=data.readLine())!=null){
                out.println(value);
                System.out.println("Received result from server= "+in.readLine());
                System.out.println("Enter a number for sending server");
            }
            out.close();
            in.close();
            data.close();
            socket.close();
        }catch (Exception e){
            System.out.println("port Error");
        }
    }
}
