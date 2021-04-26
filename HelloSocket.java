import java.util.*;
import java.net.*;
import java.io.*;
    
public class HelloSocket{


    public static void main(String args[]){

        //do the connection;
        Socket sock = null;
        try{
            sock = new Socket("localhost",2021);
        }catch(UnknownHostException e){
            System.out.println("Unknown host");
        }catch(IOException e){
            System.out.println("Cannot connect");
        }

        try{
            PrintWriter pw = new PrintWriter(sock.getOutputStream());
            pw.println("Hello World");
            pw.close();
            sock.close();
        }catch(IOException e){
            System.out.println("Connection closed before we could write");
        }

    }

}
    
