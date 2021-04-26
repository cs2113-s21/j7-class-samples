import java.util.*;
import java.net.*;
import java.io.*;
    
public class EchoServer{

    public static void main(String args[]){

        try{

            //server listening on port 2021
            ServerSocket serveSock = new ServerSocket(2021);

            //wait and block incoming connection
            Socket sock = serveSock.accept();

            //once that connection occurs, it will open a new socket
            //to talk to that client using sock

            //we open a reader and writer
            PrintWriter pw = new PrintWriter(sock.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            //for everything that is read, we write it back to the client
            while(true){
                String line = br.readLine();
                if(line == null) break;
                pw.println(line); //echo!
                pw.flush(); //ensure that the writer happens now!
            }

            //once there is no more, we close the IO and the socket
            pw.close();
            br.close();
            sock.close();
            serveSock.close();
            
        }catch(Exception e){}

    }


}
