/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.bl;

import com.bits.lib.dx.BDM;
import com.bits.lib.dx.BTable;
import com.bits.lib.dx.Column;
import com.borland.dx.dataset.Variant;
import static com.lowagie.text.pdf.PdfName.DM;

/**
 *
 * @author Sigit Sukarman
 */
public class Book extends BTable {

    public Book() {    
        super(BDM.getDefault(), "book", "bookid");
	/********** book **********/
	Column[] cols = {
		new Column("bookid",			 "bookid",			 Variant.STRING),
		new Column("title",			 "title",			 Variant.STRING),
		new Column("penulis",			 "penulis",			 Variant.STRING),
		new Column("penerbit",			 "penerbit",			 Variant.STRING)
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
