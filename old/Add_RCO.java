package pencereler;

import background.main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import veri.*;

public class Add_RCO extends RCOwindow implements ActionListener{
    RCO rco;
    Project project;
    DefaultTableModel model_M,model_L,model_O;
    String[] titleMaterial = {"Name","Quantity","Unit","Tax","Unit Price"};
    String[] titleLabour = {"Name","Man","Day","Unit Price"};
    String[] titleOther = {"Name","Quantity","Tax","Unit Price"};
    
    
    Add_RCO(Project project){
        this.project = project;
        main.rco = new RCO();
        this.rco = main.rco;
        rco.name = String.format("RCO #%d", project.rcolist.size()+1);
        rco.project = project;
        setTitle("Add New RCO");
        
        date();
        tf_username.setText(rco.user.name);
        tf_usertitle.setText(rco.user.title);
        
        b_Madd.addActionListener(this);
        b_Mdelete.addActionListener(this);
        b_Ladd.addActionListener(this);
        b_Ldelete.addActionListener(this);
        b_Oadd.addActionListener(this);
        b_Odelete.addActionListener(this);
        b_Save.addActionListener(this);
        
        model_M = new DefaultTableModel();
        table_M.setModel(model_M);
        model_M.setDataVector(null, titleMaterial);
        addMaterial();
        model_L = new DefaultTableModel();
        table_L.setModel(model_L);
        model_L.setDataVector(null, titleLabour);
        addLabour();
        model_O = new DefaultTableModel();
        table_O.setModel(model_O);
        model_O.setDataVector(null, titleOther);
        addOther();
    }
    
    private void date(){
        Date simdikiZaman = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        tf_date.setText(df.format(simdikiZaman));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b_Madd){
            addMaterial();
        }
        if(e.getSource()== b_Mdelete){
            removeMaterial();
        }
        if(e.getSource()== b_Ladd){
            addLabour();
        }

        if(e.getSource()== b_Ldelete){
            removeLabour();      
        }
        if(e.getSource()== b_Oadd){
            addOther();
        }

        if(e.getSource()== b_Odelete){
            removeOther();      
        }
        if(e.getSource()== b_Save){
            rco.date = tf_date.getText();
            rco.note = ta_note.getText();
            rco.describtion = tf_describtion.getText();
            rco.model_M = model_M;
            rco.model_L = model_L;
            rco.model_O = model_O;
            rco.karpayi = Float.parseFloat(tf_karpayi.getText());
            for( int i = 0 ; i < model_M.getRowCount() ; i++){
                if(model_M.getValueAt(i, 0) == "")rco.materials.remove(i);
                else{
                    rco.materials.get(i).name = (String) model_M.getValueAt(i, 0);
                    try{rco.materials.get(i).quantity = Integer.parseInt((String)model_M.getValueAt(i, 1));} catch(NumberFormatException ex){}
                    if (model_M.getValueAt(i, 2) != null)rco.materials.get(i).unit = (String) model_M.getValueAt(i, 2);
                    try{rco.materials.get(i).tax = Float.parseFloat((String)model_M.getValueAt(i, 3)+"f");} catch(NumberFormatException ex){}
                    try{rco.materials.get(i).unitprice = Float.parseFloat((String)model_M.getValueAt(i, 3)+"f");} catch(NumberFormatException ex){}
                    try{rco.materials.get(i).calculateSubtotal();}catch(Exception ex){};
                } 
            }
            
            for( int i = 0 ; i < model_L.getRowCount() ; i++){
                if(model_L.getValueAt(i, 0) == "")rco.labours.remove(i);
                else{
                    rco.labours.get(i).name = (String) model_L.getValueAt(i, 0);
                    try{rco.labours.get(i).man = Integer.parseInt((String)model_L.getValueAt(i, 1));} catch(NumberFormatException ex){}
                    try{rco.labours.get(i).day = Integer.parseInt((String)model_L.getValueAt(i, 2));} catch(NumberFormatException ex){}
                    try{rco.labours.get(i).unitprice = Float.parseFloat((String)model_L.getValueAt(i, 3)+"f");} catch(NumberFormatException ex){}
                    try{rco.labours.get(i).calculateSubtotal();}catch(Exception ex){};
                } 
            }
            for( int i = 0 ; i < model_O.getRowCount() ; i++){
                if(model_O.getValueAt(i, 0) == "")rco.others.remove(i);
                else{
                    rco.others.get(i).name = (String) model_O.getValueAt(i, 0);
                    try{rco.others.get(i).quantity = Integer.parseInt((String)model_O.getValueAt(i, 1));} catch(NumberFormatException ex){}
                    try{rco.others.get(i).tax = Float.parseFloat((String)model_O.getValueAt(i, 2)+"f");} catch(NumberFormatException ex){}
                    try{rco.others.get(i).unitprice = Float.parseFloat((String)model_O.getValueAt(i, 3)+"f");} catch(NumberFormatException ex){}
                    try{rco.others.get(i).calculateSubtotal();}catch(Exception ex){};
                } 
            }
            rco.user.name = tf_username.getText();
            rco.user.title = tf_usertitle.getText();
            main.storage.user = rco.user;
            project.rcolist.add(rco);
            try{main.anapencere.refreshlist();}catch(Exception ex){};
            try{main.editproject.refreshlist();}catch(Exception ex){};
            
            this.dispose();
        }
    }

}
