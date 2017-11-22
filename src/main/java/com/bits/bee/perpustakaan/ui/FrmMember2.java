/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.ui;

import com.bits.bee.perpustakaan.bl.Member;
import com.bits.bee.ui.FrmMasterAbstract;
import com.bits.bee.ui.UIMgr;
import com.bits.bee.ui.myswing.DateCellEditor;
import com.bits.lib.dbswing.JBDatePicker;
import com.bits.lib.dx.provider.BTableProvider;
import com.borland.dx.text.DateFormatter;

/**
 *
 * @author Sigit Sukarman
 */
public class FrmMember2 extends FrmMasterAbstract {

    public FrmMember2() {
        super(BTableProvider.createTable(Member.class), "Member", "PGP-TR-07");
        initTable();
    }

    private void initTable() {
        table.getDataSet().getColumn("memberid").setWidth(6);
        table.getDataSet().getColumn("membername").setWidth(10);
        JBDatePicker jbdp = new JBDatePicker();
        table.getDataSet().getColumn("dob").setItemEditor(new DateCellEditor(jbdp));
        table.getDataSet().getColumn("dob").setFormatter(new DateFormatter());
        table.getDataSet().getColumn("addr").setWidth(10);

        table.getDataSet().getColumn("memberid").setCaption("Kode");
        table.getDataSet().getColumn("membername").setCaption("Nama");
        table.getDataSet().getColumn("dob").setCaption("Tanggal Lahir");
        table.getDataSet().getColumn("addr").setCaption("Alamat");
    }

    private boolean validateData() {
        if (getTable().getDataSet().isNull("memberid")) {
            UIMgr.showErrorDialog("Kode tidak boleh kosong");
            return false;
        } else if (getTable().getDataSet().isNull("membername")) {
            UIMgr.showErrorDialog("Nama tidak boleh kosong");
            return false;
        } else if (getTable().getDataSet().isNull("dob")) {
            UIMgr.showErrorDialog("Tanggal Lahir tidak boleh kosong");
            return false;
        } else if (getTable().getDataSet().isNull("addr")) {
            UIMgr.showErrorDialog("Alamat tidak boleh kosong");
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public void  doSave(){
        if (validateData()){
            super.doSave();
        }
    }
}
