package veri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pencereler.ProjectWindow;

public class Project implements Serializable{

    public ArrayList<RCO> rcolist;
    public String name,path,pdfpath,clientName,date,currency,attention;
    public float originalContractAmount = 0;
    public DefaultTableModel model_RCO;
    String[] titleTable;
    
    public Project(String name, String clientName, String currency){
        this.clientName = clientName;
        this.name = name;
        this.currency = currency;
        String[] title = {"RCO","Date","Description","Amount ("+currency+")","Rejected ("+currency+")","Pending ("+currency+")","Apprvd Amount ("+currency+")","Status"};
        this.titleTable = title;
        date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        rcolist = new ArrayList<RCO>();
        path = "Projects/";
        name = "";
        rcolist = new ArrayList();
        model_RCO = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 4 || column == 7)return true;
                else return false;
            }
        };
        model_RCO.setDataVector(null, title);/*
        int i = 0;
        for (RCO rco : rcolist){
            rco.rejected = Float.parseFloat(model_RCO.getValueAt(i, 4).toString());
            rco.approved = Float.parseFloat(model_RCO.getValueAt(i, 6).toString());
            try{rco.status = model_RCO.getValueAt(i, 7).toString();}catch(Exception e){}
            i++;
            for (RCO rev : rco.revisions){
                rev.rejected = Float.parseFloat(model_RCO.getValueAt(i, 4).toString());
                rev.approved = Float.parseFloat(model_RCO.getValueAt(i, 6).toString());
                try{rev.status = model_RCO.getValueAt(i, 7).toString();}catch(Exception e){}
                i++;
            }
        }*/
    }
    public static Project open(String path){
        try{
            FileInputStream fi = new FileInputStream(new File(path));
            ObjectInputStream oi = new ObjectInputStream(fi);
            Project p = (Project) oi.readObject();
            //p.path = path.substring(0, path.lastIndexOf('/')+1);
            oi.close();
            fi.close();
            int i = path.lastIndexOf('\\')+1;
            System.out.println(i);
            String newName = path.substring(i, path.length()-4);
            p.name = newName;
            return p;
        }catch(IOException | ClassNotFoundException e){System.out.println("error opening pjt");}
        return null;
    }
    public static void save(Project project){
        //project.rcolist.get(0).model_M = new DefaultTableModel();
        project.model_RCO = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 4 || column == 7)return true;
                else return false;
            }
        };
        project.model_RCO.setDataVector(null, project.titleTable);
        for (RCO rco : project.rcolist){
            Object[] rowData = {rco.name,rco.date,rco.describtion,rco.getAraToplam(),rco.rejected,rco.pending,rco.approved,rco.status};
            rco.project.model_RCO.addRow(rowData);
            for (RCO rev : rco.revisions){
            Object[] rowData2 = {rev.name,rev.date,rev.describtion,rev.getAraToplam(),rev.rejected,rev.pending,rev.approved,rev.status};
            rev.project.model_RCO.addRow(rowData2);
                    
            }
        }
    try {
        ObjectOutputStream o;
        o = new ObjectOutputStream(new FileOutputStream(project.path+project.name+".pjt"));
        o.writeObject(project);
        o.close();
        //JOptionPane.showConfirmDialog(null,"Project is saved", "Information", JOptionPane.DEFAULT_OPTION);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(ProjectWindow.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showConfirmDialog(null,"Project cannot saved : File Not Found", "Error", JOptionPane.DEFAULT_OPTION);
    } catch (IOException ex) {
        Logger.getLogger(ProjectWindow.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showConfirmDialog(null,"Project cannot saved : IOException", "Error", JOptionPane.DEFAULT_OPTION);
    }
    }
    
    public RCO getRCO(int index){
        int i = 0;
        int j = 0;
        for (RCO rco : rcolist){
            if (i==index)return rcolist.get(j);
            i++;
            int k = 0;
            for (RCO rev : rco.revisions){
                if (i==index){return rcolist.get(j).revisions.get(k);}
                k++;
                i++;
            } j++;
        }
        return null;
    }
    public RCO getMainRCO(int index){
        int i = 0;
        int j = 0;
        for (RCO rco : rcolist){
            if (i==index)return rcolist.get(j);
            i++;
            for (RCO rev : rco.revisions){
                if (i==index)return rcolist.get(j);
                i++;
            } j++;
        }
        return null;
    }
    
    public RCO[] getAllRCO(){
        int i=0;
        for (RCO rco : rcolist){
            i++;
            for (RCO rev : rco.revisions){
            i++;
            }
        }
        RCO[] r = new RCO[i];
        i = 0;
        for (RCO rco : rcolist){
            r[i] = rco;
            i++;
            for (RCO rev : rco.revisions){
                r[i] = rev;
                i++;
            }
        }
        return r;
    }

    public String[] getList(){
        int i=0;
        for (RCO rco : rcolist){
            i++;
            for (RCO rev : rco.revisions){
            i++;
            }
        }
        String[] s = new String[i];
        i=0;
        int j=0;
        for (RCO rco : rcolist){
            s[i]=rco.name + "       :  " + rco.date + "    " + "Describtion" + "    " + "Amount" + "    " + "Rejected" + "    " + "    " + "Approved Amount" + "    " + "Status" + "    " + "Client";
            i++;
            j++;
            int k=0;
            for (RCO rev : rco.revisions){
            s[i]=rev.name + "  :  " + rev.date + "    " + "Describtion" + "    " + "Amount" + "    " + "Rejected" + "    " + "    " + "Approved Amount" + "    " + "Status" + "    " + "Client";
            i++; 
            k++;
            }
        }
        return s;
    }

}
