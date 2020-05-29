package veri;

import background.main;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class RCO implements Serializable{
    
    public ArrayList<Material> materials;
    public ArrayList<Labour> labours;
    public ArrayList<Other> others,others2,others3;
    public String name,date,describtion,note,status,title_M,title_L,title_O,title_O2,title_O3;
    public DefaultTableModel model_M,model_L,model_O,model_O2,model_O3;
    public float karpayi;
    public ArrayList<RCO> revisions;
    public Project project;
    public User user;
    public float rejected,pending,approved;
    
    public RCO(Project project){
        title_M = "Material :";
        title_L = "Labor : ";
        title_O = "";
        title_O2 = "";
        title_O3 = "";
        
        this.project = project;
        name();
        note = "";
        status = "PENDING";
        try{user = main.storage.user;}catch(Exception e){System.out.println("errro : veri.RCO.<init>()");user = new User();}
        revisions = new ArrayList();
        materials = new ArrayList();
        labours = new ArrayList();
        others = new ArrayList();
        others2 = new ArrayList();
        others3 = new ArrayList();
        date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        
        String[] titleMaterial = {"Name","Quantity","Unit","Tax (%)","Unit Price ("+project.currency+")"};
        String[] titleLabour = {"Name","Man","Day","Unit Price ("+project.currency+")"};
        String[] titleOther = {"Name","Quantity","Tax (%)","Unit Price ("+project.currency+")"};
        
        model_M = new DefaultTableModel();
        model_M.setDataVector(null, titleMaterial);
        model_L = new DefaultTableModel();
        model_L.setDataVector(null, titleLabour);
        model_O = new DefaultTableModel();
        model_O.setDataVector(null, titleOther);
        model_O2 = new DefaultTableModel();
        model_O2.setDataVector(null, titleOther);
        model_O3 = new DefaultTableModel();
        model_O3.setDataVector(null, titleOther);
    }
    
    void name(){
        this.name = String.format("%d", project.rcolist.size()+1);
    }
    public RCO copy(){
        RCO newrco = new RCO(project);
        newrco.materials = Material.copyArrayList(this.materials);
        newrco.labours = Labour.copyArrayList(this.labours);
        newrco.others = Other.copyArrayList(this.others);
        newrco.others2 = Other.copyArrayList(this.others2);
        newrco.others3 = Other.copyArrayList(this.others3);
        newrco.name = String.valueOf(this.name);
        newrco.date = String.valueOf(this.date);
        newrco.model_M = modelCopy(model_M);
        newrco.model_L = modelCopy(model_L);
        newrco.model_O = modelCopy(model_O);
        newrco.model_O2 = modelCopy(model_O2);
        newrco.model_O3 = modelCopy(model_O3);
        newrco.karpayi = this.karpayi;
        newrco.describtion = String.valueOf(this.describtion);
        newrco.project = this.project;
        newrco.note = String.valueOf(this.note);
        newrco.user = this.user.copy();
        newrco.title_M = String.valueOf(this.title_M);
        newrco.title_L = String.valueOf(this.title_L);
        newrco.title_O = String.valueOf(this.title_O);
        newrco.title_O2 = String.valueOf(this.title_O2);
        newrco.title_O3 = String.valueOf(this.title_O3);
        return newrco;
}    
    private static DefaultTableModel modelCopy(DefaultTableModel model){
        DefaultTableModel m = new DefaultTableModel();
        String[] title = new String[model.getColumnCount()];
        Object[][] o = new Object[model.getRowCount()][model.getColumnCount()];
        for (int i = 0 ; i < title.length ; i++){
            title[i] = model.getColumnName(i);
            for (int j = 0 ; j < model.getRowCount() ; j++){
                o[j][i] = model.getValueAt(j, i);
            }
        }
        m.setDataVector(o, title);
        return m;
    }
    
    public float getAraToplam(){
        float f = 0;
        for (Material m : this.materials)f += m.subtotal*m.tax/100+m.subtotal;
        for (Labour l : this.labours)f += l.subtotal;
        for (Other o : this.others)f += o.subtotal*o.tax/100+o.subtotal;
        for (Other o : this.others2)f += o.subtotal*o.tax/100+o.subtotal;
        for (Other o : this.others3)f += o.subtotal*o.tax/100+o.subtotal;
        return f;
    }   
}
