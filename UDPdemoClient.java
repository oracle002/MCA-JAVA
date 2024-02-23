import java.net.*;
//import java.io.*;

public class UDPdemoClient {
    public static void main(String[] args) {
        DatagramSocket ds=null;
        DatagramPacket dp=null,reply=null;
        InetAddress shost=null;
        try{
            ds=new DatagramSocket();
            byte[] m = "bye".getBytes(); 
            shost = InetAddress.getByName("localhost");  //sender host
            dp=new DatagramPacket(m,3,shost,1234);
            ds.send(dp);
            byte[] buffer=new byte[1000];
            reply=new DatagramPacket(buffer, buffer.length);
            ds.receive(reply);
            System.out.println("Reply: "+(new String(reply.getData())).trim());
        } catch(Exception e){
            System.out.println(e);
        }
        finally{
            if(ds!=null){
                ds.close();
            }
        }
    }
}
    
    

