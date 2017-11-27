/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.ui;

import com.bits.bee.perpustakaan.bl.ViewStockBookTrans;
import com.bits.bee.perpustakaan.ui.dlg.DlgViewStockBook;
import com.bits.bee.ui.UIMgr;
import com.bits.bee.ui.myswing.InternalFrameTrans;
import com.bits.lib.BUtil;
import com.bits.lib.dbswing.BdbState;
import com.bits.lib.dx.BDM;
import com.bits.lib.dx.JBSQL;
import com.bits.lib.security.BAuthMgr;
import com.borland.dx.dataset.DataSet;
import com.borland.dx.dataset.DataSetView;
import com.borland.dx.sql.dataset.QueryDataSet;
import com.borland.dx.sql.dataset.QueryDescriptor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.openide.util.Exceptions;

/**
 *
 * @author Sigit Sukarman
 */
public class FrmViewStockBook extends InternalFrameTrans {

    private ViewStockBookTrans trans = new ViewStockBookTrans();
    private String OBJID = "PGP-TR-12";
    BdbState state = new BdbState();
    
     private QueryDataSet qds = new QueryDataSet();
    private DataSetView dsv = new DataSetView();
    
    /**
     * Creates new form FrmViewStockBook2
     */
    public FrmViewStockBook() {
        initComponents();
        initForm();
        initTable();
        refresh();
    }
    
    private void initForm() {
        jBToolbar1.setState(state);
        jBToolbar1.setObjid(OBJID);
        jBToolbar1.setAuthMgr(BAuthMgr.getDefault());

//        state.addPropertyChangeListener("state", this);
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
//
        ds.getColumn("bookid").setCaption("No Buku");
        ds.getColumn("bookid").setWidth(12);
        ds.getColumn("bookid").setVisible(1);
        ds.getColumn("title").setCaption("Judul Buku");
        ds.getColumn("title").setWidth(15);
        ds.getColumn("title").setVisible(1);
        ds.getColumn("qty").setCaption("Jumlah");
        ds.getColumn("qty").setWidth(4);
        ds.getColumn("qty").setVisible(1);
        
//        //hilangkan colom yg tidak perlu
//        ds.getColumn("prjid").setVisible(0);
//        ds.getColumn("deptid").setVisible(0);
//        ds.getColumn("pid").setVisible(0);
//        ds.getColumn("subtotal").setVisible(0);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jBdbTable1 = new com.bits.lib.dbswing.JBdbTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle(org.openide.util.NbBundle.getMessage(FrmViewStockBook.class, "FrmViewStockBook.title")); // NOI18N

        jBToolbar1.setEnableCancel(false);
        jBToolbar1.setEnableDelete(false);
        jBToolbar1.setEnableNew(false);
        jBToolbar1.setEnablePrint(false);
        jBToolbar1.setEnableSave(false);
        jBToolbar1.setEnableVoid(false);
        jBToolbar1.addJBToolbarListener(new com.bits.lib.dbswing.JBToolbarListener() {
            public void toolbarNewPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
            }
            public void toolbarOpenPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
                jBToolbar1ToolbarOpenPerformed(evt);
            }
            public void toolbarEditPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
            }
            public void toolbarSavePerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
            }
            public void toolbarCancelPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
            }
            public void toolbarDeletePerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
            }
            public void toolbarVoidPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
            }
            public void toolbarPrintPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
            }
            public void toolbarRefreshPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
                jBToolbar1ToolbarRefreshPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jBdbTable1.setDataSet(trans.getDataSetDetail());
        jBdbTable1.setEditable(false);
        jScrollPane1.setViewportView(jBdbTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBToolbar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBToolbar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBToolbar1ToolbarRefreshPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {//GEN-FIRST:event_jBToolbar1ToolbarRefreshPerformed
        refresh();
    }//GEN-LAST:event_jBToolbar1ToolbarRefreshPerformed

    private void jBToolbar1ToolbarOpenPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {//GEN-FIRST:event_jBToolbar1ToolbarOpenPerformed
        doOpen();
    }//GEN-LAST:event_jBToolbar1ToolbarOpenPerformed
    
    private void refresh() {
        StringBuffer sql = new StringBuffer();
        StringBuffer filter = new StringBuffer();
        sql.append("Select m.bookid, d.title, m.qty FROM bookstock m "
                        + "LEFT JOIN book d On d.bookid=m.bookid"
        //                + "LEFT JOIN branch br On br.branchid=sadj.branchid "
        );
        
        JBSQL.setWHERE(sql, filter);
        JBSQL.setORDERBY(sql, "d.title, m.bookid");

        if (qds.isOpen()) {
            qds.close();
        }
        qds.setQuery(new QueryDescriptor(BDM.getDefault().getDatabase(), sql.toString()));
        qds.open();

        initTable();
        if (dsv.isOpen()) {
            dsv.close();
        }
        dsv.setStorageDataSet(qds.getStorageDataSet());
        dsv.open();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bits.lib.dbswing.JBToolbar jBToolbar1;
    private com.bits.lib.dbswing.JBdbTable jBdbTable1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doNew() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doOpen() {
        DlgViewStockBook dlg = DlgViewStockBook.getInstance();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doEdit(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doSave() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doCancel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    }

    @Override
    public void setTransState(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
