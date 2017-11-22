/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.ui;

import com.bits.bee.perpustakaan.bl.Book;
import com.bits.bee.perpustakaan.ui.dlg.DlgBook;
import com.bits.bee.perpustakaan.ui.dlg.DlgPegawai;
import com.bits.bee.ui.UIMgr;
import com.bits.bee.ui.myswing.InternalFrameTrans;
import com.bits.lib.BUtil;
import com.bits.lib.dbswing.BdbState;
import com.bits.lib.security.BAuthMgr;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.openide.util.Exceptions;

/**
 *
 * @author Sigit Sukarman
 */
public class FrmBook extends InternalFrameTrans implements PropertyChangeListener {
    
    String OBJID = "PGP-TR-08";
    Book bk = new Book();
    BdbState state = new BdbState();
    
    /**
     * Creates new form FrmBook
     */
    public FrmBook() {
        initComponents();
        initMaster();
    }
    
    private void initMaster() {
        jBToolbar1.setState(state);
        jBToolbar1.setObjid(OBJID);
        jBToolbar1.setAuthMgr(BAuthMgr.getDefault());

        state.addPropertyChangeListener("state", this);
        state.setState(BdbState.stNONE);
    }
    
    private void initPanel(boolean enable) {
        BUtil.setEnabledPanel(jPanel1, enable);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBToolbar1 = new com.bits.lib.dbswing.JBToolbar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bTextIDField1 = new com.bits.bee.ui.myswing.BTextIDField();
        jBdbTextField1 = new com.bits.lib.dbswing.JBdbTextField();
        jBdbTextField2 = new com.bits.lib.dbswing.JBdbTextField();
        jBdbTextField3 = new com.bits.lib.dbswing.JBdbTextField();
        jFormLabel1 = new com.bits.bee.ui.myswing.JFormLabel();

        setTitle(org.openide.util.NbBundle.getMessage(FrmBook.class, "FrmBook.title")); // NOI18N

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
            }
        });

        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 11)); // NOI18N
        jLabel1.setText(org.openide.util.NbBundle.getMessage(FrmBook.class, "FrmBook.jLabel1.text")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 11)); // NOI18N
        jLabel2.setText(org.openide.util.NbBundle.getMessage(FrmBook.class, "FrmBook.jLabel2.text")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 11)); // NOI18N
        jLabel3.setText(org.openide.util.NbBundle.getMessage(FrmBook.class, "FrmBook.jLabel3.text")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 11)); // NOI18N
        jLabel4.setText(org.openide.util.NbBundle.getMessage(FrmBook.class, "FrmBook.jLabel4.text")); // NOI18N

        bTextIDField1.setText(org.openide.util.NbBundle.getMessage(FrmBook.class, "FrmBook.bTextIDField1.text")); // NOI18N
        bTextIDField1.setColumnName(org.openide.util.NbBundle.getMessage(FrmBook.class, "FrmBook.bTextIDField1.columnName")); // NOI18N
        bTextIDField1.setDataSet(bk.getDataSet());

        jBdbTextField1.setText(org.openide.util.NbBundle.getMessage(FrmBook.class, "FrmBook.jBdbTextField1.text")); // NOI18N
        jBdbTextField1.setColumnName(org.openide.util.NbBundle.getMessage(FrmBook.class, "FrmBook.jBdbTextField1.columnName")); // NOI18N
        jBdbTextField1.setDataSet(bk.getDataSet());

        jBdbTextField2.setText(org.openide.util.NbBundle.getMessage(FrmBook.class, "FrmBook.jBdbTextField2.text")); // NOI18N
        jBdbTextField2.setColumnName(org.openide.util.NbBundle.getMessage(FrmBook.class, "FrmBook.jBdbTextField2.columnName")); // NOI18N
        jBdbTextField2.setDataSet(bk.getDataSet());

        jBdbTextField3.setText(org.openide.util.NbBundle.getMessage(FrmBook.class, "FrmBook.jBdbTextField3.text")); // NOI18N
        jBdbTextField3.setColumnName(org.openide.util.NbBundle.getMessage(FrmBook.class, "FrmBook.jBdbTextField3.columnName")); // NOI18N
        jBdbTextField3.setDataSet(bk.getDataSet());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bTextIDField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBdbTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBdbTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jBdbTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBdbTextField1, jBdbTextField2, jBdbTextField3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(bTextIDField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jBdbTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jBdbTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jBdbTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 54, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bTextIDField1, jLabel1, jLabel2, jLabel3, jLabel4});

        jFormLabel1.setText(org.openide.util.NbBundle.getMessage(FrmBook.class, "FrmBook.jFormLabel1.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBToolbar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jFormLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBToolbar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jFormLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
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
        doEdit(bTextIDField1.getText());
    }//GEN-LAST:event_jBToolbar1ToolbarEditPerformed

    private void jBToolbar1ToolbarNewPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {//GEN-FIRST:event_jBToolbar1ToolbarNewPerformed
        doNew();
    }//GEN-LAST:event_jBToolbar1ToolbarNewPerformed

    private void jBToolbar1ToolbarOpenPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {//GEN-FIRST:event_jBToolbar1ToolbarOpenPerformed
        doOpen();
    }//GEN-LAST:event_jBToolbar1ToolbarOpenPerformed

    private void jBToolbar1ToolbarSavePerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {//GEN-FIRST:event_jBToolbar1ToolbarSavePerformed
        doSave();
    }//GEN-LAST:event_jBToolbar1ToolbarSavePerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bits.bee.ui.myswing.BTextIDField bTextIDField1;
    private com.bits.lib.dbswing.JBToolbar jBToolbar1;
    private com.bits.lib.dbswing.JBdbTextField jBdbTextField1;
    private com.bits.lib.dbswing.JBdbTextField jBdbTextField2;
    private com.bits.lib.dbswing.JBdbTextField jBdbTextField3;
    private com.bits.bee.ui.myswing.JFormLabel jFormLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doNew() {
        bk.getDataSet().emptyAllRows();
        bk.New();
        bk.setString("bookid", "AUTO");
        bk.setTransCode("BK");
        state.setState(BdbState.stNEW);
    }

    @Override
    public void doOpen() {
//        DlgPegawai dlg = DlgPegawai.getInstance();
//        dlg.setVisible(true);
//        if (dlg.getSelectedID() != null) {
//            try {
//                bk.LoadID(dlg.getSelectedID());
//                state.setState(BdbState.stEDIT);            
//            } catch (Exception ex) {
//                Exceptions.printStackTrace(ex);
//            }
//        }
        
        
        DlgBook dlg = DlgBook.getInstance();
        dlg.setVisible(true);
        if (dlg.getSelectedID() != null) {
            try {
                bk.LoadID(dlg.getSelectedID());
                state.setState(BdbState.stEDIT);            
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    @Override
    public void doEdit() {
        state.setState(BdbState.stEDIT);
    }

    @Override
    public void doEdit(String id) {               
        if(id != null){
            try {
                bk.LoadID(id);
                state.setState(BdbState.stEDIT);
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }            
        }
    }

    @Override
    public void doSave() {
        try {
            bk.saveChanges();
            UIMgr.showMessageDialog("Data berhasil Disimpan");
            state.setState(BdbState.stNONE);
        } catch (Exception ex) {
            UIMgr.showErrorDialog("Error", ex);
        }
    }

    @Override
    public void doCancel() {
        state.setState(BdbState.stNONE);
    }

    @Override
    public void doDelete() {
        try {
            bk.getDataSet().deleteRow();
            bk.saveChanges();
            UIMgr.showMessageDialog("Data Berhasil dihapus");
            state.setState(BdbState.stNONE);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    @Override
    public void doVoid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doPrint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doRefresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTransState(int state) {
        this.state.setState(state);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
       if (evt.getPropertyName().equalsIgnoreCase("state")) {
            if (state.getState() == BdbState.stNEW || state.getState() == BdbState.stEDIT) {
                initPanel(true);
                jBToolbar1.setEnableEdit(false);
            } else {
                jBToolbar1.setEnableEdit(true);
                initPanel(false);
            }
        }
    }
}
