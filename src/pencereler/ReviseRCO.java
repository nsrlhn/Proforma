package pencereler;

import veri.RCO;

public class ReviseRCO extends RCOwindow{
    RCO parent;
    public ReviseRCO(RCO parent, RCO rco) {
        super(rco);
        this.parent = parent;
    }
    @Override
    protected void special(){
        parent.revisions.add(rco);
        rco.name = String.format(parent.name+"-Rev%d",parent.revisions.indexOf(rco)+1);
        //rco.path = "PDF Files/"+rco.project.name+"/"+("RCO #"+rco.name+".pdf").replaceAll("\\s+", "");
    }
    @Override
    protected void addRow(){
        rco.pending = rco.getAraToplam();
        Object[] rowData = {rco.name,rco.date,rco.describtion,rco.getAraToplam(),rco.rejected,rco.pending,rco.approved,rco.status};
        int index = 0;
        for (RCO r : parent.project.rcolist){
            for (RCO rev : r.revisions){
                index++;
            }
            if(r == parent)break;
            index++;
        }
        rco.project.model_RCO.insertRow(index, rowData);
    }
}
