package pencereler;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import veri.Pdf_LOG;
import veri.Project;
import veri.RCO;

public class ProjectWindow extends javax.swing.JFrame implements Serializable {
    Project project;
    public ProjectWindow(Project project) {
        this.project = project;
        initComponents();
        this.setVisible(true);
        this.jPanel2.remove(b_Save);
        
        TableColumn testColumn = ProjectWindow.tableRCO.getColumnModel().getColumn(7);
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("APPROVED");
        comboBox.addItem("REJECTED");
        comboBox.addItem("PENDING");
        testColumn.setCellEditor(new DefaultCellEditor(comboBox));/*
        tableRCO.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(new JTextField()));
        tableRCO.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JTextField()));
        tableRCO.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JTextField()));*/
    }

    @SuppressWarnings("unchecked") 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRCO = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        b_CreateRCO = new javax.swing.JButton();
        b_ReviseRCO = new javax.swing.JButton();
        b_Save = new javax.swing.JButton();
        tf_oca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Client : "+this.project.clientName+"  |  Project : "+this.project.name);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        tableRCO.setModel(project.model_RCO);
        tableRCO.getTableHeader().setReorderingAllowed(false);
        tableRCO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRCOMouseClicked(evt);
            }
        });
        tableRCO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableRCOKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableRCO);

        jPanel1.add(jScrollPane1);

        b_CreateRCO.setText("Create RCO");
        b_CreateRCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_CreateRCOActionPerformed(evt);
            }
        });

        b_ReviseRCO.setText("Revise RCO");
        b_ReviseRCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ReviseRCOActionPerformed(evt);
            }
        });

        b_Save.setText("Save Project");
        b_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_SaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_CreateRCO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_ReviseRCO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_Save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(b_CreateRCO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_ReviseRCO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(b_Save)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);

        jLabel1.setText("original contract amount :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_oca, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_oca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_CreateRCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_CreateRCOActionPerformed
        RCO rco = new RCO(project);
        new RCOwindow(rco);
        this.dispose();
    }//GEN-LAST:event_b_CreateRCOActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        tableRCO.setModel(project.model_RCO);
        tf_oca.setText(Float.toString(project.originalContractAmount));
    }//GEN-LAST:event_formWindowActivated

    private void b_ReviseRCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ReviseRCOActionPerformed
        RCO rco = project.getMainRCO(this.tableRCO.getSelectedRow()).copy();
        new ReviseRCO(project.getMainRCO(this.tableRCO.getSelectedRow()),rco);
        this.dispose();
    }//GEN-LAST:event_b_ReviseRCOActionPerformed

    private void b_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_SaveActionPerformed
        this.dispose();
        Project.save(project);
        new StartWindow();
    }//GEN-LAST:event_b_SaveActionPerformed

    private void tableRCOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRCOMouseClicked
        if (evt.getClickCount() == 2){
            new EditRCO(project.getRCO(tableRCO.getSelectedRow()),tableRCO.getSelectedRow());
            this.dispose();
        }
    }//GEN-LAST:event_tableRCOMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        /*CellEditor cellEditor;
        for (int i = 0 ; i < tableRCO.getColumnCount() ; i++){
            cellEditor = tableRCO.getColumnModel().getColumn(i).getCellEditor();
            if (cellEditor != null) {
                if (cellEditor.getCellEditorValue() != null) {
                    cellEditor.stopCellEditing();
                } else {
                    cellEditor.cancelCellEditing();
                }
            }
        }*/
        try{
            this.formWindowClosed(evt);
            
            Project.save(project);
            new StartWindow();
            try {
                new Pdf_LOG(project);
            } catch (IOException ex) {
                Logger.getLogger(ProjectWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(ProjectWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
        catch(NumberFormatException e){JOptionPane.showConfirmDialog(this,"Rejected should be number", "Error", JOptionPane.DEFAULT_OPTION);}
    }//GEN-LAST:event_formWindowClosing

    private void tableRCOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableRCOKeyPressed
        /*if (evt.getKeyChar() == 127){
            int reply = JOptionPane.showConfirmDialog(null, "Delete this RCO ?", "", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
              project.rcolist.remove(tableRCO.getSelectedRow());
              project.model_RCO.removeRow(tableRCO.getSelectedRow());
            }
        } */
    }//GEN-LAST:event_tableRCOKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        int i = 0;
        for (RCO rco : project.rcolist){
            try{rco.status = project.model_RCO.getValueAt(i, 7).toString();}catch(Exception e){}
            rco.rejected = Float.parseFloat(project.model_RCO.getValueAt(i, 4).toString());
            rco.approved = 0;
            rco.pending = 0;
            if (rco.status.equals("PENDING")) {rco.pending = rco.getAraToplam();}
            else if (rco.status.equals("APPROVED")) {rco.approved = rco.getAraToplam() - rco.rejected;}
            else if (rco.status.equals("REJECTED")) {rco.rejected = rco.getAraToplam();}
            i++;
            for (RCO rev : rco.revisions){
                try{rev.status = project.model_RCO.getValueAt(i, 7).toString();}catch(Exception e){}
                rev.rejected = Float.parseFloat(project.model_RCO.getValueAt(i, 4).toString());
                rev.approved = 0;
                rev.pending = 0;
                if (rev.status.equals("PENDING")) rev.pending = rev.getAraToplam();
                else if (rev.status.equals("APPROVED")) rev.approved = rev.getAraToplam() - rev.rejected;
                else if (rev.status.equals("REJECTED")) rev.rejected = rev.getAraToplam();
                i++;
            }
        }
        project.originalContractAmount = Float.parseFloat(tf_oca.getText());
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_CreateRCO;
    private javax.swing.JButton b_ReviseRCO;
    private javax.swing.JButton b_Save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tableRCO;
    private javax.swing.JTextField tf_oca;
    // End of variables declaration//GEN-END:variables

}
