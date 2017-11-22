/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.bl;

import com.bits.bee.bl.BLUtil;
import com.bits.bee.perpustakaan.sp.spAddBook_New;
import com.bits.bee.perpustakaan.sp.spAddBook_Void;
import com.bits.lib.BHelp;
import com.bits.lib.dx.BDM;
import com.bits.lib.dx.BTrans;
import com.borland.dx.dataset.Column;
import com.borland.dx.dataset.ColumnChangeListener;
import com.borland.dx.dataset.DataChangeEvent;
import com.borland.dx.dataset.DataChangeListener;
import com.borland.dx.dataset.DataSet;
import com.borland.dx.dataset.DataSetException;
import com.borland.dx.dataset.Variant;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Sigit Sukarman
 */
public class AddBookTrans extends BTrans {

    private AddBook book = new AddBook();
    private AddBookD bookd = new AddBookD();
    private AddBookAdapter adapter = new AddBookAdapter();
    private spAddBook_New spAddNew = new spAddBook_New();
    private spAddBook_Void spAddVoid = new spAddBook_Void();

    public AddBookTrans() {
        super(BDM.getDefault(), "TAMBAH", "tambahid", "tambah");

        setMaster(book);
        addDetail(bookd);
        setspNew(spAddNew);
        setspVoid(spAddVoid);

        getDataSetDetail().addDataChangeListener(adapter);
        bookd.addPropertyChangeListener("qty", adapter);
//        bookd.addPropertyChangeListener("listprice", adapter);
//        bookd.addPropertyChangeListener("subtotal", adapter);
    }

    @Override
    public void New() {
        super.New();
        getDataSetMaster().setString("tambahid", "AUTO");
        getDataSetMaster().setDate("tambahdate", BHelp.getCurrentDate_SQL());
    }

    @Override
    public void Save() throws Exception {
        BLUtil.renumberDetail(this, "tambahdno");
        super.Save();
    }

    private class AddBookAdapter implements DataChangeListener, ColumnChangeListener, PropertyChangeListener {

        @Override
        public void postRow(DataChangeEvent dce) throws Exception {

        }

        @Override
        public void dataChanged(DataChangeEvent evt) {
            if (evt.getID() == DataChangeEvent.ROW_ADDED && getDataSetDetail().isNull("tambahid")) {
                getDetail().setString("tambahid", getMaster().getString("tambahid"));
                getDetail().setShort("tambahdno", (short) (getDataSetDetail().getRow() + 1));
//                getDetail().setString("whid", Reg.getInstance().getValueString("WHSTOCK"));

            }
        }

        @Override
        public void changed(DataSet ds, Column column, Variant vrnt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void validate(DataSet ds, Column column, Variant vrnt) throws Exception, DataSetException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

}
