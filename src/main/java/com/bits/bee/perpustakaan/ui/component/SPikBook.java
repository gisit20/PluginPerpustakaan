/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.ui.component;

import com.bits.bee.perpustakaan.ui.dlg.DlgBook;
import com.bits.lib.dbswing.JBSPicker;
import java.awt.Dimension;
import javax.swing.JComponent;

/**
 *
 * @author Sigit Sukarman
 */
public class SPikBook extends JBSPicker{
    
//    public JComponent lastFocus;
    
    public SPikBook(){
        setDialog(DlgBook.getInstance());
        setPreferredSize(new Dimension(180, 90));   
        
        setToolTipText("Pilih Book");
    }
    
//    public JComponent getlastFocus(){
//        return lastFocus;
//    }
//    
//    public void setLastFocus(JComponent lastFocus){
//        this.lastFocus=lastFocus;
//    }
//
//    @Override
//    protected void Close_Dialog() {
//        
//        if (getlastFocus() != null){
//            getlastFocus().requestFocus();
//        }
//        super.Close_Dialog(); 
//    }
    
    
}
