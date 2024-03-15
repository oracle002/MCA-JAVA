import java.io.*;
import java.net.*;




public class UDPServer {
    public static void main (String[] args) throws IOException{

        DatagramSocket  serverSocket = new DatagramSocket(Integer.parseInt("5001"));
        System.out.println("Server Started. Listening for Clients on port 5001" + "...");
        byte[] receiveData=new byte[1024]; //create a data array to store the received message
        DatagramPacket receivePacket;
        while(true)
        {
            receivePacket =new DatagramPacket(receiveData,receiveData.length);// create a packet to store the incoming message properties
            serverSocket.receive(receivePacket);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String msg= new String(receivePacket.getData());
            System.out.println("[Client || IP: " + IPAddress + " ,Port: " + port +"]  " + msg);
        }
    }

    
}
