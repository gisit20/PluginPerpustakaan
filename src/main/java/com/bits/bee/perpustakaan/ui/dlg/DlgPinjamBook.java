/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.ui.dlg;

import com.bits.bee.ui.DlgFindKode;
import com.bits.bee.ui.ScreenManager;
import com.bits.bee.ui.UIMgr;
import com.bits.lib.dbswing.JBDialog;
import com.bits.lib.dx.BDM;
import com.bits.lib.dx.JBSQL;
import com.borland.dx.dataset.DataSetView;
import com.borland.dx.sql.dataset.QueryDataSet;
import com.borland.dx.sql.dataset.QueryDescriptor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Sigit Sukarman
 */
public class DlgPinjamBook extends JBDialog implements PropertyChangeListener {

    private static DlgPinjamBook dlg = null;
    private QueryDataSet qds = new QueryDataSet();
    private DataSetView dsv = new DataSetView();
    private String kode = null;

    /**
     * Creates new form DlgPinjamBook
     */
    public DlgPinjamBook() {
        super(ScreenManager.getParent(), "Dialog Pinjam Buku");
        initComponents();
        UIMgr.setPeriode(jBOSPeriode1, 0);
    }

    public static synchronized DlgPinjamBook getInstance() {
        if (dlg == null) {
            dlg = new DlgPinjamBook();
        }
        return dlg;
    }

    private void initTable() {
        qds.getColumn("pinjamid").setVisible(0);
        qds.getColumn("pinjamdno").setCaption("Nomor");
        qds.getColumn("pinjamdno").setWidth(3);
        qds.getColumn("pinjamdate").setCaption("Tanggal");
        qds.getColumn("pinjamdate").setWidth(8);
        qds.getColumn("memberid").setCaption("memberid");
        qds.getColumn("memberid").setWidth(8);
        qds.getColumn("qty").setCaption("qty");
        qds.getColumn("qty").setWidth(8);
    }

    private void refresh() {
        StringBuffer sql = new StringBuffer();
        StringBuffer filter = new StringBuffer();
        sql.append("Select m.pinjamid, d.pinjamdno, m.pinjamdate, m.memberid, d.bookid, d.qty FROM pinjambook m "
                + "LEFT JOIN pinjambookd d On d.pinjamid=pinjambook.pinjamid "
        //                + "LEFT JOIN branch br On br.branchid=sadj.branchid "
        );

        JBSQL.ANDFilterPeriode(filter, "m.pinjamdate", jBOSPeriode1);
        if (kode != null) {
            JBSQL.ANDFilter(filter, JBSQL.filterUpperLike("m.pinjamid", kode));
        }

        JBSQL.setWHERE(sql, filter);
        JBSQL.setORDERBY(sql, "m.pinjamid, pinjamdate");

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

    @Override
    protected void OK() {
        setSelectedID(dsv.getString("pinjamid"));
        super.OK();
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            refresh();
        }
        super.setVisible(visible);
    }

    @Override
    protected void f1Action() {
        DlgFindKode dlg = DlgFindKode.getInstance();
        dlg.setTitle("Cari Nomor Peminjaman");
        dlg.setTxtLabel("Cari Nomor");
        dlg.setVisible(true);
        String id = dlg.getSelectedID();
        if (id != null) {
            kode = id;
            refresh();
        }
        kode = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBToolbarDialog1 = new com.bits.lib.dbswing.JBToolbarDialog();
        jPanel1 = new javax.swing.JPanel();
        jBOSPeriode1 = new com.bits.bee.ui.myswing.JBOSPeriode();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jBdbTable1 = new com.bits.lib.dbswing.JBdbTable();
        btnOK1 = new com.bits.bee.ui.myswing.BtnOK();
        btnCancel1 = new com.bits.bee.ui.myswing.BtnCancel();
        jBStatusbarDialog1 = new com.bits.lib.dbswing.JBStatusbarDialog();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(DlgPinjamBook.class, "DlgPinjamBook.title")); // NOI18N

        jBToolbarDialog1.setEnableNew(false);
        jBToolbarDialog1.addJBToolbarListener(new com.bits.lib.dbswing.JBToolbarListener() {
            public void toolbarNewPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
            }
            public void toolbarOpenPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {
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
                jBToolbarDialog1ToolbarRefreshPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 11)); // NOI18N
        jLabel1.setText(org.openide.util.NbBundle.getMessage(DlgPinjamBook.class, "DlgPinjamBook.jLabel1.text")); // NOI18N

        jBdbTable1.setDataSet(dsv);
        jBdbTable1.setEditable(false);
        jBdbTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBdbTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jBdbTable1);

        btnOK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOK1ActionPerformed(evt);
            }
        });

        btnCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBOSPeriode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBOSPeriode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBOSPeriode1, jLabel1});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBToolbarDialog1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jBStatusbarDialog1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBToolbarDialog1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBStatusbarDialog1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOK1ActionPerformed
        OK();
    }//GEN-LAST:event_btnOK1ActionPerformed

    private void btnCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel1ActionPerformed
        Cancel();
    }//GEN-LAST:event_btnCancel1ActionPerformed

    private void jBToolbarDialog1ToolbarRefreshPerformed(com.bits.lib.dbswing.JBToolbarEvent evt) {//GEN-FIRST:event_jBToolbarDialog1ToolbarRefreshPerformed
        refresh();
    }//GEN-LAST:event_jBToolbarDialog1ToolbarRefreshPerformed

    private void jBdbTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBdbTable1MouseClicked
        if (evt.getClickCount()==2){
            OK();
        }
    }//GEN-LAST:event_jBdbTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bits.bee.ui.myswing.BtnCancel btnCancel1;
    private com.bits.bee.ui.myswing.BtnOK btnOK1;
    private com.bits.bee.ui.myswing.JBOSPeriode jBOSPeriode1;
    private com.bits.lib.dbswing.JBStatusbarDialog jBStatusbarDialog1;
    private com.bits.lib.dbswing.JBToolbarDialog jBToolbarDialog1;
    private com.bits.lib.dbswing.JBdbTable jBdbTable1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
