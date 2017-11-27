/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.bl;

import com.bits.lib.dx.BDM;
import com.bits.lib.dx.BTable;
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
public class ViewStockBookTrans extends BTrans{
    private ViewStockBook view = new ViewStockBook(); // sebagai master
    private ViewStockBookD viewD = new ViewStockBookD(); // sebagai detailnya
//    private PinjamBookAdapter adapter = new PinjamBookTrans.PinjamBookAdapter();
    
    public ViewStockBookTrans(){
        super(BDM.getDefault(), "VIEW", "bookid", "view");
        
        setMaster(view);
        addDetail(viewD);                
    }
    
    private class ViewBookAdapter implements DataChangeListener, ColumnChangeListener{

        @Override
        public void postRow(DataChangeEvent dce) throws Exception {
        }

        @Override
        public void dataChanged(DataChangeEvent evt) {
            if (evt.getID() == DataChangeEvent.ROW_ADDED && getDataSetDetail().isNull("bookid")){
                getDetail().setString("bookid", getMaster().getString("pinjamid"));
//                getDetail().setShort("pinjamdno", (short) (getDataSetDetail().getRow()+1));
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
        }
        
    }
    
}
