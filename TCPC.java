import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPC {

    public static void main(String args[])
    {
        Socket cs;
        DataInputStream Sin;
        DataOutputStream Sout;
        Scanner s;
        try
        {
            String msg;
            cs=new Socket("localhost",5000);
            Sin=new DataInputStream(cs.getInputStream());
            Sout=new DataOutputStream(cs.getOutputStream());
            s = new Scanner(System.in);
            System.out.println("Client is running");
            String str=Sin.readUTF();
            while(!str.equalsIgnoreCase("bye"))
            {
                System.out.println("Server Says : "+str);
                System.out.println("Client said : ");
                msg=s.nextLine();
                Sout.writeUTF(msg);
                str=Sin.readUTF();
            }
        }catch(Exception e)
            {
                System.out.println("Error in program");
            }

        
    } 
    
}