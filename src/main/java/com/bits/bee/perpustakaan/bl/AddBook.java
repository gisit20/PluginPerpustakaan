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
public class AddBook extends BTable{
    
    public AddBook(){
        super(BDM.getDefault(), "addbook", "tambahid");
        
        Column[] cols = {
            new Column("tambahid", "tambahid", Variant.STRING),
            new Column("tambahdate", "tambahdate", Variant.DATE)
        };
        
        createDataSet(cols);
        dataset.open();
    }
    
}
