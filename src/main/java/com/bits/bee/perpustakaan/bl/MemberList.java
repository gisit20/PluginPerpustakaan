/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.bl;

import com.bits.bee.ui.UIMgr;
import com.bits.lib.dx.BDM;
import com.bits.lib.dx.BQuerySimple;
import org.openide.util.Exceptions;

/**
 *
 * @author Sigit Sukarman
 */
public class MemberList extends BQuerySimple {

    private static MemberList singleton = null;
    
    public MemberList() {
        super(BDM.getDefault(), "member", "memberid", "memberid, membername, dob, addr");
        dataset.open();
    }
    
    public static synchronized MemberList getInstance(){
        if (singleton==null){
            singleton = new MemberList();
            try {
                singleton.Load();
            } catch (Exception ex) {
                UIMgr.showErrorDialog(ex.toString());
            }
        }
        return singleton;
    }
    
    public String getMemberName(String id){
        return find("memberid", id, "membername");
    }

}
