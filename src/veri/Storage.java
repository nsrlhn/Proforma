package veri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Storage implements Serializable{
    //public ArrayList<Project> projectlist;
    //public ArrayList<Client> clientlist;
    public User user;
    
    public Storage(){
        user = new User();
        //projectlist = new ArrayList();
    }
    public static void write(Storage storage) throws FileNotFoundException, IOException{
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("StaticData"));
        
        o.writeObject(storage);
        o.close();
    }    
    public static Storage read() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fi = new FileInputStream(new File("StaticData"));
        ObjectInputStream oi = new ObjectInputStream(fi);
            
        Storage storage = (Storage) oi.readObject();

        oi.close();
        fi.close();
        return storage;
    }/*
    public static Object[][] getProjectsForTable(Storage storage){
        Object[][] o = new Object[storage.projectlist.size()][4];
        int i = 0;
        for (Project p : storage.projectlist){
            o[i][0] = p.name;
            i++;
        }
        return o;
    }*/
}
