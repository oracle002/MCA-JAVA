import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPS {

    public static void main(String args[])
    {
        ServerSocket ss;
        Socket as;
        DataInputStream Sin;
        DataOutputStream Sout;
        Scanner s;
        try
        {
            String msg;
            ss=new ServerSocket(5000);
            as=ss.accept();
            Sin=new DataInputStream(as.getInputStream());
            Sout=new DataOutputStream(as.getOutputStream());
            s = new Scanner(System.in);
            System.out.println("Server is running");

            Sout.writeUTF("Welcome Client");
            String str=Sin.readUTF();

            
            while(!str.equalsIgnoreCase("bye"))
            {
                System.out.println("Client said : "+str);
                System.out.println("Server said : ");
                msg = s.nextLine();
                Sout.writeUTF(msg);
                str=Sin.readUTF();
            }
        }catch(Exception e)
            {
                System.out.println("Error in program");
            }

        
    } 
    
}
