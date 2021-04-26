import java.util.*;
import java.net.*;
import java.io.*;
    
public class GetHTTPSocket{


    //CLIENT PROGRAMMING
    
    public static void main(String args[]){

        //do the connection;        
        Socket sock = null;
        String hostname = args[0];
        try{
            sock = new Socket(hostname,80);
        }catch(UnknownHostException e){
            System.out.println("Unknown host");
        }catch(IOException e){
            System.out.println("Cannot connect");
        }

        try{
            PrintWriter pw = new PrintWriter(sock.getOutputStream());
            pw.printf("GET / HTTP/1.1\nHost: %s\nConnection: close\n\n)",hostname);
            pw.flush();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            while(true){
                String line = br.readLine();
                if(line == null) break;
                System.out.println(line);
            }

            pw.close();            
            br.close();
            sock.close();
        }catch(IOException e){
            System.out.println("Connection closed before we could write");
            e.printStackTrace();
        }

    }

}
    
