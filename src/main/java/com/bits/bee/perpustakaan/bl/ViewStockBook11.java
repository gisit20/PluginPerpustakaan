/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.bl;

import com.bits.bee.bl.BLUtil;
import com.bits.lib.dx.BDM;
import com.bits.lib.dx.BTable;
import com.bits.lib.dx.JBSQL;
import com.borland.dx.dataset.CalcFieldsListener;
import com.borland.dx.dataset.Column;
import com.borland.dx.dataset.DataRow;
import com.borland.dx.dataset.DataSetException;
import com.borland.dx.dataset.ReadRow;
import com.borland.dx.dataset.Variant;
import java.util.HashMap;
import java.util.TooManyListenersException;

/**
 *
 * @author Sigit Sukarman
 */
public class ViewStockBook11 extends BTable implements CalcFieldsListener {
    public ViewStockBook11(){
        super(BDM.getDefault(), "bookstock", "bookid");
        
        Column[] cols = {
		new Column("bookid",			 "memberid",			 Variant.STRING),
		new Column("title",			 "membername",			 Variant.STRING),
		new Column("qty",			 "dob",			 Variant.BIGDECIMAL)
	};
        HashMap hm = JBSQL.ColumnsToHashMap(cols);
        JBSQL.setCalc((Column) hm.get("title"));
//	((Column)hm.get("duedate")).setFormatter(UIMgr.getDateYMD());
        createDataSet(cols);
        BLUtil.setDataPreferredOrdinal(cols);
        try {
            dataset.addCalcFieldsListener(this);
//            dataset.addColumnChangeListener(this);
//            dataset.addDataChangeListener(this);
        } catch (DataSetException ex) {
            ex.printStackTrace();
        } catch (TooManyListenersException ex) {
            ex.printStackTrace();
        }
        dataset.open();
        
    }

    @Override
    public void calcFields(ReadRow rr, DataRow dr, boolean bln) {
        dr.setString("title", BookList.getInstance().getTitleBook(rr.getString("bookid")));
    }
}
