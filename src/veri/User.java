package veri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable{
    public String name,title;
    public User(){
        name = "";
        title = "";
    }
    public User copy(){
        User newuser = new User();
        newuser.name = String.valueOf(this.name);
        newuser.title = String.valueOf(this.title);
        return newuser;
    }
    public static void write(User storage) throws FileNotFoundException, IOException{
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("User"));
        
        o.writeObject(storage);
        o.close();
    }    
    public static User read() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fi = new FileInputStream(new File("User"));
        ObjectInputStream oi = new ObjectInputStream(fi);
            
        User storage = (User) oi.readObject();

        oi.close();
        fi.close();
        return storage;
    }
}
