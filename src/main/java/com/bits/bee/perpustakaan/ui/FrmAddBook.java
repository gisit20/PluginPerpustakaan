/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.ui;

import com.bits.bee.perpustakaan.bl.AddBookTrans;
import com.bits.bee.perpustakaan.ui.component.PikBook;
import com.bits.bee.perpustakaan.ui.component.sPikBook;
import com.bits.bee.perpustakaan.ui.dlg.DlgAddBook;
import com.bits.bee.ui.UIMgr;
import com.bits.bee.ui.myswing.InternalFrameTrans;
import com.bits.lib.BUtil;
import com.bits.lib.dbswing.BCellEditor;
import com.bits.lib.dbswing.BdbState;
import com.bits.lib.security.BAuthMgr;
import com.borland.dx.dataset.DataSet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.openide.util.Exceptions;

/**
 *
 * @author Sigit Sukarman
 */
public class FrmAddBook extends InternalFrameTrans implements PropertyChangeListener {
    
    private static FrmAddBook singleton =null;
    private AddBookTrans trans = new AddBookTrans();
    private String OBJID = "PGP-TR-09";
    BdbState state = new BdbState();
    
    /**
     * Creates new form FrmAddBook
     */
    public FrmAddBook() {
        initComponents();
        initForm();
        initTable();
    }
    
    public synchronized FrmAddBook getInstance(){
        if(singleton==null){
            singleton=new FrmAddBook();
        }
        return singleton;
    }

    private void initForm() {
        jBToolbar1.setState(state);
        jBToolbar1.setObjid(OBJID);
        jBToolbar1.setAuthMgr(BAuthMgr.getDefault());

        state.addPropertyChangeListener("state", this);
        state.setState(BdbState.stNONE);
    }
    
    private void setEnabledPanel(boolean b) {
        BUtil.setEnabledPanel(jPanel1, b);
    }

    private void initTable() {
        DataSet ds = trans.getDataSetDetail();

        for (int i = 0; i < ds.getColumnCount(); i++) {
            ds.getColumn(i).setVisible(0);
        }

        UIMgr.setDataSetDetailTrans(ds);
        ds.getColumn("tambahid").setVisible(0);
        
        ds.getColumn("tambahdno").setCaption("No");
        ds.getColumn("tambahdno").setWidth(4);
        ds.getColumn("tambahdno").setVisible(1);
        ds.getColumn("bookid").setCaption("Kode Buku");
        ds.getColumn("bookid").setItemEditor(new BCellEditor(new sPikBook()));
        ds.getColumn("bookid").setWidth(15);
        ds.getColumn("bookid").setVisible(1);
        ds.getColumn("title").setCaption("Judul Buku");
        ds.getColumn("title").setWidth(20);
        ds.getColumn("title").setVisible(1);
        ds.getColumn("qty").setCaption("Jumlah");
        ds.getColumn("qty").setVisible(1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBStatusbar1 = new com.bits.lib.dbswing.JBStatusbar();
        jBToolbar1 = new com.bits.lib.dbswing.JBToolbar();
        jFormLabel1 = new com.bits.bee.ui.myswing.JFormLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTambahID = new com.bits.bee.ui.myswing.BTextIDField();
        jLabel2 = new javax.swing.JLabel();
        jBDatePicker1 = new com.bits.lib.dbswing.JBDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        jBdbTable1 = new com.bits.lib.dbswing.JBdbTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jBToolbar1.setEnablePrint(false);
        jBToolbar1.setEnableRefresh(false);
        jBToolbar1.setEnableVoid(false);
        jBToolbar1.addJBToolbarListener(new com.bits.lib.dbswing.JBToolbarListener() {
            public void toolbarNewPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
                jBToolbar1ToolbarNewPerformed(evt);
            }
            public void toolbarOpenPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
                jBToolbar1ToolbarOpenPerformed(evt);
            }
            public void toolbarEditPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
                jBToolbar1ToolbarEditPerformed(evt);
            }
            public void toolbarSavePerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
                jBToolbar1ToolbarSavePerformed(evt);
            }
            public void toolbarCancelPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
                jBToolbar1ToolbarCancelPerformed(evt);
            }
            public void toolbarDeletePerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
                jBToolbar1ToolbarDeletePerformed(evt);
            }
            public void toolbarVoidPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
            }
            public void toolbarPrintPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
            }
            public void toolbarRefreshPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
                jBToolbar1ToolbarRefreshPerformed(evt);
            }
        });

        jFormLabel1.setText(org.openide.util.NbBundle.getMessage(FrmAddBook.class, "FrmAddBook.jFormLabel1.text")); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(FrmAddBook.class, "FrmAddBook.jLabel1.text")); // NOI18N

        txtTambahID.setText(org.openide.util.NbBundle.getMessage(FrmAddBook.class, "FrmAddBook.txtTambahID.text")); // NOI18N
        txtTambahID.setColumnName(org.openide.util.NbBundle.getMessage(FrmAddBook.class, "FrmAddBook.txtTambahID.columnName")); // NOI18N
        txtTambahID.setDataSet(trans.getDataSetMaster());

        jLabel2.setText(org.openide.util.NbBundle.getMessage(FrmAddBook.class, "FrmAddBook.jLabel2.text")); // NOI18N

        jBDatePicker1.setColumnName(org.openide.util.NbBundle.getMessage(FrmAddBook.class, "FrmAddBook.jBDatePicker1.columnName")); // NOI18N
        jBDatePicker1.setDataSet(trans.getDataSetMaster());

        jBdbTable1.setDataSet(trans.getDataSetDetail());
        jScrollPane1.setViewportView(jBdbTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTambahID, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtTambahID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jBDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBToolbar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFormLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jBStatusbar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jBToolbar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBStatusbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBToolbar1ToolbarCancelPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {//GEN-FIRST:event_jBToolbar1ToolbarCancelPerformed
        doCancel();
    }//GEN-LAST:event_jBToolbar1ToolbarCancelPerformed

    private void jBToolbar1ToolbarDeletePerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {//GEN-FIRST:event_jBToolbar1ToolbarDeletePerformed
        doDelete();
    }//GEN-LAST:event_jBToolbar1ToolbarDeletePerformed

    private void jBToolbar1ToolbarEditPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {//GEN-FIRST:event_jBToolbar1ToolbarEditPerformed
        doEdit();
    }//GEN-LAST:event_jBToolbar1ToolbarEditPerformed

    private void jBToolbar1ToolbarNewPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {//GEN-FIRST:event_jBToolbar1ToolbarNewPerformed
        doNew();
    }//GEN-LAST:event_jBToolbar1ToolbarNewPerformed

    private void jBToolbar1ToolbarOpenPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {//GEN-FIRST:event_jBToolbar1ToolbarOpenPerformed
        doOpen();
    }//GEN-LAST:event_jBToolbar1ToolbarOpenPerformed

    private void jBToolbar1ToolbarRefreshPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {//GEN-FIRST:event_jBToolbar1ToolbarRefreshPerformed
        doRefresh();
    }//GEN-LAST:event_jBToolbar1ToolbarRefreshPerformed

    private void jBToolbar1ToolbarSavePerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {//GEN-FIRST:event_jBToolbar1ToolbarSavePerformed
        doSave();
    }//GEN-LAST:event_jBToolbar1ToolbarSavePerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bits.lib.dbswing.JBDatePicker jBDatePicker1;
    private com.bits.lib.dbswing.JBStatusbar jBStatusbar1;
    private com.bits.lib.dbswing.JBToolbar jBToolbar1;
    private com.bits.lib.dbswing.JBdbTable jBdbTable1;
    private com.bits.bee.ui.myswing.JFormLabel jFormLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.bits.bee.ui.myswing.BTextIDField txtTambahID;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doNew() {
        trans.emptyAllRows();
        trans.New();
        state.setState(BdbState.stNEW);
    }

    @Override
    public void doOpen() {
        DlgAddBook dlg = DlgAddBook.getInstance();
        dlg.setVisible(true);
        String id = dlg.getSelectedID();
        if (id != null) {
            try {
                trans.LoadID(id);
                state.setState(BdbState.stEDIT);
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }

        }

    }

    @Override
    public void doEdit() {
        try {
            trans.LoadID(txtTambahID.getText());
            state.setState(BdbState.stEDIT);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }

    }

    @Override
    public void doEdit(String string) {
        state.setState(BdbState.stEDIT);
    }

    @Override
    public void doSave() {
        try {
            trans.Save();
            UIMgr.showMessageDialog("Data Berhasil disimpan");
            state.setState(BdbState.stNONE);
        } catch (Exception ex) {
            UIMgr.showErrorDialog("Gagal simpan data", ex);
            Exceptions.printStackTrace(ex);
        }
    }

    @Override
    public void doCancel() {
        trans.Cancel();
        state.setState(BdbState.stNONE);
    }

    @Override
    public void doDelete() {
        state.setState(BdbState.stNONE);
    }

    @Override
    public void doVoid() {
        
    }

    @Override
    public void doPrint() {
        
    }

    @Override
    public void doRefresh() {
        
    }

    @Override
    public void setTransState(int i) {
        
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equalsIgnoreCase("state")){
            if (state.getState()==BdbState.stNEW 
                    || state.getState()==BdbState.stEDIT){
                setEnabledPanel(true);
            } else {
                setEnabledPanel(false);
            }
            jBToolbar1.setEnableDelete(false);
        }
    }
}