/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.action;

import com.bits.bee.perpustakaan.ui.FrmMember;
import com.bits.bee.perpustakaan.ui.FrmMember2;
import com.bits.bee.ui.ScreenManager;
import com.bits.core.ui.action.MenuAction;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Sigit Sukarman
 */
public class FrmMemberAction2 extends MenuAction{
    @Override
    public String getObjId() {
        return "PGP-TR-07";
    }

    @Override
    public ImageIcon getIcon() {
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ScreenManager.getMainFrame().addInternalFrame(new FrmMember2());
    }   
}
