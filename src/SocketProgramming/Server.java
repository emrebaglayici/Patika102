package SocketProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        String clientReceive;
        ServerSocket serverSocket=null;
        Socket clientSocket=null;

        int number;
        try{
            serverSocket=new ServerSocket(7775);
            clientSocket=serverSocket.accept();
            PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while ((clientReceive=in.readLine())!=null){
                System.out.println("Received Number from Client"+clientReceive);
                number=Integer.valueOf(clientReceive);
                out.println(number*number);
            }
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        }catch (Exception e){
            System.out.println("Port Error");
        }
        System.out.println("Server Ready to go");
    }
}
