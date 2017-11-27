/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.bl;

import com.bits.bee.bl.InstanceObserver;
import com.bits.lib.dx.BDM;
import com.bits.lib.dx.BQuerySimple;
import java.math.BigDecimal;
import org.openide.util.Exceptions;

/**
 *
 * @author Sigit Sukarman
 */
public class QtyList extends BQuerySimple implements InstanceObserver {

    private static QtyList singleton = null;

    public QtyList() {
        super(BDM.getDefault(), "bookstock", "bookid", "bookid, qty");
    }

    public static synchronized QtyList getInstance(){
        if(singleton==null){
            singleton=new QtyList();
            try {
                singleton.Load();
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        return singleton;
    }

    public String getQty(String id){
        return find("bookid", id, "qty");
    }
    
    @Override
    public void doUpdate() {
        singleton=null;
    }

}
