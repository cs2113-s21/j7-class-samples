import java.util.*;
import java.net.*;
import java.io.*;
    
public class HelloServerSocket{

    public static void main(String args[]){

        

        ServerSocket serveSock = null;

        try{
            serveSock = new ServerSocket(2021);

            //accept an incoming connection
            Socket sock = serveSock.accept(); //blocking

            PrintWriter pw = new PrintWriter(sock.getOutputStream());
            pw.println("Hello World");
            pw.close();
            sock.close();
        }catch(Exception e){}
            
            
    }
    
}
