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
import com.borland.dx.dataset.Column;
import com.borland.dx.dataset.DataSetException;
import com.borland.dx.dataset.Variant;
import java.util.HashMap;
import java.util.TooManyListenersException;

/**
 *
 * @author Sigit Sukarman
 */
public class ViewStockBook extends BTable{
    public ViewStockBook(){
        super(BDM.getDefault(), "bookstock", "bookid");
        
        Column[] cols = {
		new Column("bookid",			 "memberid",			 Variant.STRING),
		new Column("qty",			 "dob",			 Variant.BIGDECIMAL)
	};
        
        createDataSet(cols);
        dataset.open();
    }
}
