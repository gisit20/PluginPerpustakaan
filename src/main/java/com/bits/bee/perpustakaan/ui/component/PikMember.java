/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.ui.component;

import com.bits.bee.perpustakaan.bl.MemberList;
import com.bits.bee.perpustakaan.ui.dlg.DlgMember;
import com.bits.lib.dbswing.JBDialog;
import com.bits.lib.dbswing.JBPicker;

/**
 *
 * @author Sigit Sukarman
 */
public class PikMember extends JBPicker{
    
    private DlgMember dlg;
    
    @Override
    public JBDialog getDefaultDialog() {
        if (dlg == null){
            dlg=DlgMember.getInstance();
        }
        return dlg;
    }

    @Override
    protected String getDescription(String id) {
        return MemberList.getInstance().getMemberName(id);
    }
    
}
