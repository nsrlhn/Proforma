package pencereler;

import background.main;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.CellEditor;
import javax.swing.JFileChooser;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import veri.Labour;
import veri.Material;
import veri.Other;
import veri.Pdf_RCO;
import veri.RCO;

public class RCOwindow extends javax.swing.JFrame{
    protected RCO rco;
    protected ArrayList<File> mergePDF;
    
    public RCOwindow(RCO rco) {
        this.mergePDF = new ArrayList();
        this.rco = rco;
        initComponents();
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        tf_describtion = new javax.swing.JTextField();
        tf_date = new javax.swing.JTextField();
        sp_L = new javax.swing.JScrollPane();
        table_L = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tf_karpayi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        sp_M = new javax.swing.JScrollPane();
        table_M = new javax.swing.JTable();
        sp_O1 = new javax.swing.JScrollPane();
        table_O = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_usertitle = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        b_savePDF = new javax.swing.JButton();
        b_merge = new javax.swing.JButton();
        l_merge = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_attn = new javax.swing.JTextField();
        tf_titleM = new javax.swing.JTextField();
        tf_titleL = new javax.swing.JTextField();
        tf_titleO = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jScrollPane3 = new javax.swing.JScrollPane();
        ta_note = new javax.swing.JTextArea();
        sp_O2 = new javax.swing.JScrollPane();
        table_O2 = new javax.swing.JTable();
        tf_titleO2 = new javax.swing.JTextField();
        sp_O3 = new javax.swing.JScrollPane();
        table_O3 = new javax.swing.JTable();
        tf_titleO3 = new javax.swing.JTextField();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocation(new java.awt.Point(150, 50));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Description :");

        tf_describtion.setName(""); // NOI18N

        tf_date.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_date.setDragEnabled(true);
        tf_date.setMaximumSize(new java.awt.Dimension(15, 24));
        tf_date.setName(""); // NOI18N

        sp_L.setName(""); // NOI18N

        table_L.setRowHeight(18);
        table_L.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table_LKeyPressed(evt);
            }
        });
        sp_L.setViewportView(table_L);
        if (table_L.getColumnModel().getColumnCount() > 0) {
            table_L.getColumnModel().getColumn(0).setHeaderValue("Name");
            table_L.getColumnModel().getColumn(1).setHeaderValue("Man");
            table_L.getColumnModel().getColumn(2).setHeaderValue("Day");
            table_L.getColumnModel().getColumn(3).setHeaderValue("Unit Price");
        }

        jLabel14.setText("OH&P :");

        tf_karpayi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_karpayi.setText("15");
        tf_karpayi.setMinimumSize(new java.awt.Dimension(15, 30));

        jLabel4.setText("%");

        table_M.setToolTipText("");
        table_M.setRequestFocusEnabled(false);
        table_M.setRowHeight(18);
        table_M.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table_MKeyPressed(evt);
            }
        });
        sp_M.setViewportView(table_M);
        if (table_M.getColumnModel().getColumnCount() > 0) {
            table_M.getColumnModel().getColumn(0).setHeaderValue("Name");
            table_M.getColumnModel().getColumn(1).setHeaderValue("Quantity");
            table_M.getColumnModel().getColumn(2).setHeaderValue("Unit");
            table_M.getColumnModel().getColumn(3).setHeaderValue("Tax");
            table_M.getColumnModel().getColumn(4).setHeaderValue("Unit Price");
        }

        sp_O1.setVerifyInputWhenFocusTarget(false);

        table_O.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_O.setRowHeight(18);
        table_O.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table_OKeyPressed(evt);
            }
        });
        sp_O1.setViewportView(table_O);

        jLabel6.setText("User Name : ");

        jLabel7.setText("User Title :");

        jLabel8.setText(" Note :");

        b_savePDF.setText("Save & Preview");
        b_savePDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_savePDFActionPerformed(evt);
            }
        });

        b_merge.setText("Merge PDF");
        b_merge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_mergeActionPerformed(evt);
            }
        });

        jLabel9.setText("Attention : ");

        tf_titleM.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tf_titleM.setText("Material :");
        tf_titleM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_titleMActionPerformed(evt);
            }
        });

        tf_titleL.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tf_titleL.setText("Labor :");

        tf_titleO.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tf_titleO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_titleOActionPerformed(evt);
            }
        });

        ta_note.setColumns(20);
        ta_note.setRows(5);
        jScrollPane3.setViewportView(ta_note);

        sp_O2.setVerifyInputWhenFocusTarget(false);

        table_O2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_O2.setRowHeight(18);
        table_O2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table_O2KeyPressed(evt);
            }
        });
        sp_O2.setViewportView(table_O2);

        tf_titleO2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        sp_O3.setVerifyInputWhenFocusTarget(false);

        table_O3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_O3.setRowHeight(18);
        table_O3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table_O3KeyPressed(evt);
            }
        });
        sp_O3.setViewportView(table_O3);

        tf_titleO3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_titleM, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(tf_titleL)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_titleO, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_titleO2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_titleO3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sp_O3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sp_L)
                            .addComponent(sp_M)
                            .addComponent(sp_O1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_karpayi, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(83, 83, 83))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tf_usertitle, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(b_merge)
                                        .addGap(36, 36, 36)
                                        .addComponent(b_savePDF))
                                    .addComponent(l_merge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tf_attn, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_date, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tf_describtion, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3)
                            .addComponent(sp_O2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tf_attn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(tf_date, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_describtion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_M, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 37, Short.MAX_VALUE)
                        .addComponent(tf_titleM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_L, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 37, Short.MAX_VALUE)
                        .addComponent(tf_titleL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_O1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(tf_titleO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_O2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(tf_titleO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sp_O3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tf_titleO3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel14)
                                .addComponent(tf_karpayi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_usertitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_merge)
                            .addComponent(b_savePDF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_merge)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_savePDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_savePDFActionPerformed
        save();
        special();
        addRow();
        this.setVisible(false);
        try {
            new Pdf_RCO(this.rco);
        } catch (IOException ex) {
            Logger.getLogger(RCOwindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(RCOwindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!mergePDF.isEmpty())merge();
        Desktop desktop = Desktop.getDesktop();
        File file;
        if(mergePDF.isEmpty())file = new File(rco.project.pdfpath+"/RCO#"+rco.name+".pdf");
        else file = new File(rco.project.pdfpath+"/RCO#"+rco.name+"(merged).pdf");
        if(file.exists()) try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(RCOwindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        new ProjectWindow(rco.project);
        this.dispose();
    }//GEN-LAST:event_b_savePDFActionPerformed

    private void table_MKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_MKeyPressed
        if(evt.getKeyChar()=='\n')addMaterial();
        if(evt.getKeyChar()==127)removeMaterial();
    }//GEN-LAST:event_table_MKeyPressed
    protected void addMaterial(){
        Object[] o = {null,null,null,null,null};
        rco.model_M.addRow(o);
        rco.materials.add(new Material());
    }
    protected void removeMaterial(){
        int i = table_M.getSelectedRow();
        rco.model_M.removeRow(i);
        rco.materials.remove(i);
    }
    protected void addLabour(){
        Object[] o = {null,null,null,null,null};
        rco.model_L.addRow(o);
        rco.labours.add(new Labour());
    }
    protected void removeLabour(){
        int i = table_L.getSelectedRow();
        rco.model_L.removeRow(i);
        rco.labours.remove(i);
    }
    protected void addOther(){
        Object[] o = {null,null,null,null};
        rco.model_O.addRow(o);
        rco.others.add(new Other());
    }
    protected void removeOther(){
        int i = table_O.getSelectedRow();
        rco.model_O.removeRow(i);
        rco.others.remove(i);
    } 
    protected void addOther2(){
        Object[] o = {null,null,null,null};
        rco.model_O2.addRow(o);
        rco.others2.add(new Other());
    }
    protected void removeOther2(){
        int i = table_O2.getSelectedRow();
        rco.model_O2.removeRow(i);
        rco.others2.remove(i);
    } 
    protected void addOther3(){
        Object[] o = {null,null,null,null};
        rco.model_O3.addRow(o);
        rco.others3.add(new Other());
    }
    protected void removeOther3(){
        int i = table_O3.getSelectedRow();
        rco.model_O3.removeRow(i);
        rco.others3.remove(i);
    } 
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tf_date.setText(rco.date);
        tf_karpayi.setText(Float.toString(rco.karpayi));
        tf_describtion.setText(rco.describtion);
        tf_username.setText(rco.user.name);
        tf_usertitle.setText(rco.user.title);
        ta_note.setText(rco.note);
        tf_attn.setText(rco.project.attention);
        tf_titleM.setText(rco.title_M);
        tf_titleL.setText(rco.title_L);
        tf_titleO.setText(rco.title_O);
        tf_titleO2.setText(rco.title_O2);
        tf_titleO3.setText(rco.title_O3);
        setTable();
    }//GEN-LAST:event_formWindowOpened
    
    protected void setTable() {
        table_M.setModel(rco.model_M);
        table_L.setModel(rco.model_L);
        table_O.setModel(rco.model_O);
        table_O2.setModel(rco.model_O2);
        table_O3.setModel(rco.model_O3);
        if(rco.model_M.getRowCount() == 0)addMaterial();
        if(rco.model_L.getRowCount() == 0)addLabour();
        if(rco.model_O.getRowCount() == 0)addOther();
        if(rco.model_O2.getRowCount() == 0)addOther2();
        if(rco.model_O3.getRowCount() == 0)addOther3();
        
    }  
    private void table_LKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_LKeyPressed
        if(evt.getKeyChar()=='\n')addLabour();
        if(evt.getKeyChar()==127)removeLabour();
    }//GEN-LAST:event_table_LKeyPressed

    private void table_OKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_OKeyPressed
        if(evt.getKeyChar()=='\n')addOther();
        if(evt.getKeyChar()==127)removeOther();
    }//GEN-LAST:event_table_OKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        save();
        special();
        addRow();
        this.setVisible(false);
        new ProjectWindow(rco.project);
        try {
            new Pdf_RCO(this.rco);
        } catch (IOException ex) {
            Logger.getLogger(RCOwindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(RCOwindow.class.getName()).log(Level.SEVERE, null,ex);
        }
        if (!mergePDF.isEmpty())merge();
        this.dispose();
    }//GEN-LAST:event_formWindowClosing
    private void merge(){
        PDFMergerUtility PDFmerger = new PDFMergerUtility();
        PDFmerger.setDestinationFileName(rco.project.pdfpath+"/RCO#"+rco.name+"(merged).pdf");
        try{PDFmerger.addSource(new File(rco.project.pdfpath+"/RCO#"+rco.name+".pdf"));}catch(FileNotFoundException e){}
        for (File f : mergePDF)try {
            PDFmerger.addSource(f);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RCOwindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            PDFmerger.mergeDocuments(null);
        } catch (IOException ex) {
            Logger.getLogger(RCOwindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void b_mergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_mergeActionPerformed
        JFileChooser jfc = new JFileChooser();
	int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            mergePDF.add(jfc.getSelectedFile());
            l_merge.setText(mergePDF.size()+" pdf merged");
        }
    }//GEN-LAST:event_b_mergeActionPerformed

    private void tf_titleMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_titleMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_titleMActionPerformed

    private void table_O2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_O2KeyPressed
        if(evt.getKeyChar()=='\n')addOther2();
        if(evt.getKeyChar()==127)removeOther2();
    }//GEN-LAST:event_table_O2KeyPressed

    private void table_O3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_O3KeyPressed
        if(evt.getKeyChar()=='\n')addOther3();
        if(evt.getKeyChar()==127)removeOther3();
    }//GEN-LAST:event_table_O3KeyPressed

    private void tf_titleOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_titleOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_titleOActionPerformed
    
    protected void addRow(){
        rco.pending = rco.getAraToplam();
        Object[] rowData = {rco.name,rco.date,rco.describtion,rco.getAraToplam(),rco.rejected,rco.pending,rco.approved,rco.status};
        rco.project.model_RCO.addRow(rowData);
    }
    protected void save(){
        CellEditor cellEditor = table_M.getCellEditor();
        if (cellEditor != null) {
                cellEditor.cancelCellEditing();
        }
        cellEditor = table_L.getCellEditor();
        if (cellEditor != null) {
                cellEditor.cancelCellEditing();
        }
        cellEditor = table_O.getCellEditor();
        if (cellEditor != null) {
                cellEditor.cancelCellEditing();
        }
        cellEditor = table_O2.getCellEditor();
        if (cellEditor != null) {
                cellEditor.cancelCellEditing();
        }
        cellEditor = table_O3.getCellEditor();
        if (cellEditor != null) {
                cellEditor.cancelCellEditing();
        }
        rco.project.attention = tf_attn.getText();
        rco.date = tf_date.getText();
        rco.describtion = tf_describtion.getText();
        rco.karpayi = Float.parseFloat(tf_karpayi.getText());
        rco.title_M = tf_titleM.getText();
        rco.title_L = tf_titleL.getText();
        rco.title_O = tf_titleO.getText();
        rco.title_O2 = tf_titleO2.getText();
        rco.title_O3 = tf_titleO3.getText();
        for( int i = 0 ; i < rco.model_M.getRowCount() ; i++){
            if(rco.model_M.getValueAt(i, 0) == null || rco.model_M.getValueAt(i, 0).toString().isEmpty()){rco.materials.remove(i);rco.model_M.removeRow(i);i--;}
            else{
                rco.materials.get(i).name = (String) rco.model_M.getValueAt(i, 0);
                try{rco.materials.get(i).quantity = Integer.parseInt((String)rco.model_M.getValueAt(i, 1));} catch(NumberFormatException ex){}
                if (rco.model_M.getValueAt(i, 2) != null)rco.materials.get(i).unit = (String) rco.model_M.getValueAt(i, 2);
                try{rco.materials.get(i).tax = Float.parseFloat((String)rco.model_M.getValueAt(i, 3)+"f");} catch(NumberFormatException ex){}
                try{rco.materials.get(i).unitprice = Float.parseFloat((String)rco.model_M.getValueAt(i, 4)+"f");} catch(NumberFormatException ex){}
                try{rco.materials.get(i).calculateSubtotal();}catch(Exception ex){};
            } 
        } 
        for( int i = 0 ; i < rco.model_L.getRowCount() ; i++){
            if(rco.model_L.getValueAt(i, 0) == null || rco.model_L.getValueAt(i, 0).toString().isEmpty()){rco.labours.remove(i);rco.model_L.removeRow(i);i--;}
            else{
                rco.labours.get(i).name = (String) rco.model_L.getValueAt(i, 0);
                try{rco.labours.get(i).man = Integer.parseInt((String)rco.model_L.getValueAt(i, 1));} catch(NumberFormatException ex){}
                try{rco.labours.get(i).day = Integer.parseInt((String)rco.model_L.getValueAt(i, 2));} catch(NumberFormatException ex){}
                try{rco.labours.get(i).unitprice = Float.parseFloat((String)rco.model_L.getValueAt(i, 3)+"f");} catch(NumberFormatException ex){}
                try{rco.labours.get(i).calculateSubtotal();}catch(Exception ex){};
            } 
        }
        for( int i = 0 ; i < rco.model_O.getRowCount() ; i++){
            if(rco.model_O.getValueAt(i, 0) == null || rco.model_O.getValueAt(i, 0).toString().isEmpty()){rco.others.remove(i);rco.model_O.removeRow(i);i--;}
            else{
                rco.others.get(i).name = (String) rco.model_O.getValueAt(i, 0);
                try{rco.others.get(i).quantity = Integer.parseInt((String)rco.model_O.getValueAt(i, 1));} catch(NumberFormatException ex){}
                try{rco.others.get(i).tax = Float.parseFloat((String)rco.model_O.getValueAt(i, 2)+"f");} catch(NumberFormatException ex){}
                try{rco.others.get(i).unitprice = Float.parseFloat((String)rco.model_O.getValueAt(i, 3)+"f");} catch(NumberFormatException ex){}
                try{rco.others.get(i).calculateSubtotal();}catch(Exception ex){};
                } 
        }
        for( int i = 0 ; i < rco.model_O2.getRowCount() ; i++){
            if(rco.model_O2.getValueAt(i, 0) == null || rco.model_O2.getValueAt(i, 0).toString().isEmpty()){rco.others2.remove(i);rco.model_O2.removeRow(i);i--;}
            else{
                rco.others2.get(i).name = (String) rco.model_O2.getValueAt(i, 0);
                try{rco.others2.get(i).quantity = Integer.parseInt((String)rco.model_O2.getValueAt(i, 1));} catch(NumberFormatException ex){}
                try{rco.others2.get(i).tax = Float.parseFloat((String)rco.model_O2.getValueAt(i, 2)+"f");} catch(NumberFormatException ex){}
                try{rco.others2.get(i).unitprice = Float.parseFloat((String)rco.model_O2.getValueAt(i, 3)+"f");} catch(NumberFormatException ex){}
                try{rco.others2.get(i).calculateSubtotal();}catch(Exception ex){};
                } 
        }
        for( int i = 0 ; i < rco.model_O3.getRowCount() ; i++){
            if(rco.model_O3.getValueAt(i, 0) == null || rco.model_O3.getValueAt(i, 0).toString().isEmpty()){rco.others3.remove(i);rco.model_O3.removeRow(i);i--;}
            else{
                rco.others3.get(i).name = (String) rco.model_O3.getValueAt(i, 0);
                try{rco.others3.get(i).quantity = Integer.parseInt((String)rco.model_O3.getValueAt(i, 1));} catch(NumberFormatException ex){}
                try{rco.others3.get(i).tax = Float.parseFloat((String)rco.model_O3.getValueAt(i, 2)+"f");} catch(NumberFormatException ex){}
                try{rco.others3.get(i).unitprice = Float.parseFloat((String)rco.model_O3.getValueAt(i, 3)+"f");} catch(NumberFormatException ex){}
                try{rco.others3.get(i).calculateSubtotal();}catch(Exception ex){};
                } 
        }
        rco.note = ta_note.getText();
        rco.user.name = tf_username.getText();
        rco.user.title = tf_usertitle.getText();
        try{main.storage.user = rco.user;}catch(Exception ex){System.out.println("error : pencereler.RCOwindow.save()");};
    }
    protected void special(){
        rco.project.rcolist.add(rco);
        //rco.path = "PDF Files/"+rco.project.name+"/"+("RCO #"+rco.name+".pdf").replaceAll("\\s+", "");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton b_merge;
    protected javax.swing.JButton b_savePDF;
    protected javax.swing.Box.Filler filler1;
    protected javax.swing.Box.Filler filler2;
    protected javax.swing.JInternalFrame jInternalFrame1;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel13;
    protected javax.swing.JLabel jLabel14;
    protected javax.swing.JLabel jLabel4;
    protected javax.swing.JLabel jLabel6;
    protected javax.swing.JLabel jLabel7;
    protected javax.swing.JLabel jLabel8;
    protected javax.swing.JLabel jLabel9;
    protected javax.swing.JScrollPane jScrollPane3;
    protected javax.swing.JLabel l_merge;
    protected javax.swing.JScrollPane sp_L;
    protected javax.swing.JScrollPane sp_M;
    protected javax.swing.JScrollPane sp_O1;
    protected javax.swing.JScrollPane sp_O2;
    protected javax.swing.JScrollPane sp_O3;
    protected javax.swing.JTextArea ta_note;
    protected javax.swing.JTable table_L;
    protected javax.swing.JTable table_M;
    public javax.swing.JTable table_O;
    public javax.swing.JTable table_O2;
    public javax.swing.JTable table_O3;
    protected javax.swing.JTextField tf_attn;
    protected javax.swing.JTextField tf_date;
    protected javax.swing.JTextField tf_describtion;
    protected javax.swing.JTextField tf_karpayi;
    protected javax.swing.JTextField tf_titleL;
    protected javax.swing.JTextField tf_titleM;
    protected javax.swing.JTextField tf_titleO;
    protected javax.swing.JTextField tf_titleO2;
    protected javax.swing.JTextField tf_titleO3;
    public javax.swing.JTextField tf_username;
    public javax.swing.JTextField tf_usertitle;
    // End of variables declaration//GEN-END:variables
}
