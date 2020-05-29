package pencereler;

import veri.RCO;

public class EditRCO extends RCOwindow{
    int index;
    public EditRCO(RCO rco, int index) {
        super(rco);
        this.index = index;
    }
    @Override
    protected void addRow(){
        Object[] rowData = {rco.name,rco.date,rco.describtion,rco.getAraToplam(),rco.rejected,rco.pending,rco.approved,rco.status};
        int c = 0;
        for (int i = 0  ; i < rco.project.model_RCO.getRowCount() ; i++){
            if (rco.name == rco.project.model_RCO.getValueAt(i, 0)){
                for (Object o : rowData){
                rco.project.model_RCO.setValueAt(o, index, c);
                c++;
                }
            }
        }
    }
    @Override
    protected void special(){}
}
