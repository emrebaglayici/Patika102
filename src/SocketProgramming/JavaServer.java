package SocketProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServer {
    public static void main(String[] args) {
        Socket serverSocket;
        DataOutputStream dataOutputStream;
        String message;
        try{
      /*      serverSocket=new ServerSocket(8080);
            clientSocket=serverSocket.accept();
            dataInputStream=new DataInputStream(clientSocket.getInputStream());
            message=dataInputStream.readUTF();
            System.out.println("Received message : "+message);
            serverSocket.close(); */
            serverSocket=new Socket("localhost",8080);
            dataOutputStream=new DataOutputStream(serverSocket.getOutputStream());
            dataOutputStream.writeUTF("Selam");
            serverSocket.close();
        }catch (IOException e){
            System.err.println(e);
        }
    }
}
