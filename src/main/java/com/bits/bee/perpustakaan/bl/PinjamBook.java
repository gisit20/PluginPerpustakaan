/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.bl;

import com.bits.lib.dx.BDM;
import com.bits.lib.dx.BTable;
import com.borland.dx.dataset.Column;
import com.borland.dx.dataset.Variant;

/**
 *
 * @author Sigit Sukarman
 */
public class PinjamBook extends BTable{
public PinjamBook(){
    super(BDM.getDefault(), "pinjambook", "pinjamid");
    
	/********** pinjambook **********/
	Column[] cols = {
		new Column("pinjamid",			 "pinjamid",			 Variant.STRING),
		new Column("pinjamdate",			 "pinjamdate",			 Variant.DATE),
		new Column("memberid",			 "memberid",			 Variant.STRING)
	};
//	HashMap hm = JBSQL.ColumnsToHashMap(cols);
//	JBSQL.setCalc((Column)hm.get("qtydesc"));
//	((Column)hm.get("duedate")).setFormatter(UIMgr.getDateYMD());
	createDataSet(cols);
//	try {
//		dataset.addCalcFieldsListener(this);
//		dataset.addColumnChangeListener(this);
//	} catch (DataSetException ex) {
//		ex.printStackTrace();
//	} catch (TooManyListenersException ex) {
//		ex.printStackTrace();
//	}
	dataset.open();

}    

}
