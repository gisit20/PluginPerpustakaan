/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.ui.component;

import com.bits.bee.perpustakaan.bl.BookList;
import com.bits.bee.perpustakaan.ui.FrmAddBook;
import com.bits.bee.perpustakaan.ui.dlg.DlgAddBook;
import com.bits.bee.ui.DlgItem;
import com.bits.lib.dbswing.JBDialog;
import com.bits.lib.dbswing.JBPicker;
import com.bits.lib.dbswing.JBSPicker;

/**
 *
 * @author Sigit Sukarman
 */
public class PikBook extends JBPicker {
    private DlgAddBook dlg;
    
    @Override
    public JBDialog getDefaultDialog() {
        if(dlg==null){
            dlg=new DlgAddBook().getInstance(); 
        }
        return dlg;
    }

    @Override
    protected String getDescription(String id) {
        return BookList.getInstance().getTitleBook(id);
    }
}
