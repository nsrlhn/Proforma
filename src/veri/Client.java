package veri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import pencereler.EditClientWindow;
import pencereler.AddClientWindow;

public class Client implements Serializable{
    public String name,phone,adress,note,path;
    
    public Client(){
        this.path = "Clients/";
        this.name = "";
        this.phone = "";
        this.adress = "";
        this.note = "";
    }
    
    public static Client open(String path){
        try{
            FileInputStream fi = new FileInputStream(new File(path));
            ObjectInputStream oi = new ObjectInputStream(fi);
            Client c = (Client) oi.readObject();
            //c.path = path.substring(0, path.lastIndexOf('/')+1);
            oi.close();
            fi.close();
            return c;
        }catch(IOException | ClassNotFoundException e){System.out.println("pencereler.StartWindow.main() error opening clt");}
        return null;
    }    
    public static void save(Client c){
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(c.path+c.name+".clt"));
            o.writeObject(c);
            o.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddClientWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddClientWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
