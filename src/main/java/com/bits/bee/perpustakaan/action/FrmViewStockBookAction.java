/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.action;

import com.bits.bee.perpustakaan.ui.FrmViewStockBook;
import com.bits.bee.perpustakaan.ui.FrmViewStockBook11;
import com.bits.bee.ui.ScreenManager;
import com.bits.core.ui.action.MenuAction;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Sigit Sukarman
 */
public class FrmViewStockBookAction extends MenuAction {

    @Override
    public String getObjId() {
        return "PGP-TR-12";
    }

    @Override
    public ImageIcon getIcon() {
        return  null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ScreenManager.getMainFrame().addInternalFrame(new FrmViewStockBook());
    }
    
}
