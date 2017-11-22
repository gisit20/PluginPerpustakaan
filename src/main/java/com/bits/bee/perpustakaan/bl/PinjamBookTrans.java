/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.bl;

import com.bits.bee.bl.BLUtil;
import com.bits.bee.perpustakaan.sp.spPinjamBook_New;
import com.bits.bee.perpustakaan.sp.spPinjamBook_Void;
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

/**
 *
 * @author Sigit Sukarman
 */
public class PinjamBookTrans extends BTrans {
    private PinjamBook pinjamBook = new PinjamBook(); // sebagai master
    private PinjamBookD pinjamBookD = new PinjamBookD(); // sebagai detailnya
    private PinjamBookAdapter adapter = new PinjamBookAdapter();
    private spPinjamBook_New spPinjamBookNew = new spPinjamBook_New();
    private spPinjamBook_Void spPinjamBookVoid = new spPinjamBook_Void();
    
    public PinjamBookTrans() {
        super(BDM.getDefault(), "PINJAM", "pinjamid", "pinjam");
    
        setMaster(pinjamBook);
        addDetail(pinjamBookD);
        setspNew(spPinjamBookNew);
        setspVoid(spPinjamBookVoid);

        getDataSetDetail().addDataChangeListener(adapter);
//        bookd.addPropertyChangeListener("qty", adapter);
//        bookd.addPropertyChangeListener("listprice", adapter);
//        bookd.addPropertyChangeListener("subtotal", adapter);
    }

    @Override
    public void New() {
        super.New(); 
        getDataSetMaster().setString("pinjamid", "AUTO");
        getDataSetMaster().setDate("pinjamdate", BHelp.getCurrentDate_SQL());        
    }

    @Override
    public void Save() throws Exception {
        BLUtil.renumberDetail(this, "pinjamdno");
        super.Save(); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class PinjamBookAdapter implements DataChangeListener, ColumnChangeListener{

        @Override
        public void postRow(DataChangeEvent dce) throws Exception {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void dataChanged(DataChangeEvent evt) {
            if (evt.getID() == DataChangeEvent.ROW_ADDED && getDataSetDetail().isNull("tambahid")){
                getDetail().setString("pinjamid", getMaster().getString("pinjamid"));
                getDetail().setShort("pinjamdno", (short) (getDataSetDetail().getRow()+1));
            }            
        }

        @Override
        public void changed(DataSet ds, Column column, Variant vrnt) {
//            if(column.getColumnName().equalsIgnoreCase("qty")){
//                int jumBrs = getDataSetDetail().getRowCount();
//                for (int i = 0; i < jumBrs; i++) {
//                    getDataSetDetail().goToRow(i);
////                    BigDecimal jumlah = getDataSetMaster().getBigDecimal("")
//                    
//                }
//            }
        }

        @Override
        public void validate(DataSet ds, Column column, Variant vrnt) throws Exception, DataSetException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    
    
}
