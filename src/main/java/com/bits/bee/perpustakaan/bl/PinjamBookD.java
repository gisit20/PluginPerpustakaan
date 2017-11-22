/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.bl;

import com.bits.lib.dx.BDM;
import com.bits.lib.dx.BTable;
import com.bits.lib.dx.JBSQL;
import com.borland.dx.dataset.CalcFieldsListener;
import com.borland.dx.dataset.Column;
import com.borland.dx.dataset.ColumnChangeListener;
import com.borland.dx.dataset.DataChangeEvent;
import com.borland.dx.dataset.DataChangeListener;
import com.borland.dx.dataset.DataRow;
import com.borland.dx.dataset.DataSet;
import com.borland.dx.dataset.DataSetException;
import com.borland.dx.dataset.ReadRow;
import com.borland.dx.dataset.Variant;
import java.util.HashMap;
import java.util.TooManyListenersException;

/**
 *
 * @author Sigit Sukarman
 */
public class PinjamBookD extends BTable implements CalcFieldsListener, DataChangeListener, ColumnChangeListener {

    public PinjamBookD() {
        super(BDM.getDefault(), "pinjambookd", "pinjamdno");
        /**
         * ******** pinjambookd *********
         */
        Column[] cols = {
            new Column("pinjamid", "pinjamid", Variant.STRING),
            new Column("pinjamdno", "pinjamdno", Variant.SHORT),
            new Column("bookid", "bookid", Variant.STRING),
            new Column("title", "title", Variant.STRING),
            new Column("qty", "qty", Variant.BIGDECIMAL)
        };
        HashMap hm = JBSQL.ColumnsToHashMap(cols);
        JBSQL.setCalc((Column) hm.get("title"));
//	((Column)hm.get("duedate")).setFormatter(UIMgr.getDateYMD());
        createDataSet(cols);
        try {
            dataset.addCalcFieldsListener(this);
            dataset.addColumnChangeListener(this);
            dataset.addDataChangeListener(this);
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

    @Override
    public void postRow(DataChangeEvent dce) throws Exception {
        if (getDataSet().isNull("bookid")
                || getDataSet().getString("bookid").length() < 1) {
            getDataSet().emptyRow();
        }
    }

    @Override
    public void dataChanged(DataChangeEvent dce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changed(DataSet ds, Column column, Variant vrnt) {
        String columnName = column.getColumnName();
        if (columnName.equalsIgnoreCase("bookid") && ds.getString("bookid").length() > 0) { //mengeset quantyty sama unit saja
            itemid_changed();
        }
    }

    @Override
    public void validate(DataSet ds, Column column, Variant vrnt) throws Exception, DataSetException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void itemid_changed() {
        setInt("qty", 1);
        dataset.post();
    }

}
