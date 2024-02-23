
import java.net.*;
//import java.io.*;

public class UDPdemoServe {
    public static void main(String[] args) {
        DatagramSocket ds=null;
        DatagramPacket dp=null,reply;
        try{
            ds=new DatagramSocket(1234);
            byte[] buffer = new byte[1000];
            dp=new DatagramPacket(buffer,buffer.length);
            ds.receive(dp); //recieve from client
            System.out.println("From client: "+(new String(dp.getData())));
            System.out.println("Client PORT: "+dp.getPort());
            reply = new DatagramPacket("From server OK ".getBytes(),"From Client OK ".length(),dp.getAddress(),dp.getPort());
            ds.send(reply);
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


