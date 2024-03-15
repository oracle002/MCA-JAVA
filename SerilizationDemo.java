import java.io.*;
import java.util.*;

class person implements Serializable{
     String  name;
     transient int age;

    public person(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
}

public class SerilizationDemo {
    public static void main(String[] args) {
        try{
            person p1=new person("Peter Parker", 21);
            ObjectOutputStream out =new ObjectOutputStream(new FileOutputStream("person.ser"));
            out.writeObject(p1);
            out.close();

            ObjectInputStream in=new ObjectInputStream(new FileInputStream("person.ser"));
            person p2=(person)in.readObject();


            in.close();
    

            System.out.println(p2.name);
            System.out.println(p2.age);


     
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
