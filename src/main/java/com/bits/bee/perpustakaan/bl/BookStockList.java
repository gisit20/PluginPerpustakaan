/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.bl;

import com.bits.bee.bl.InstanceObserver;
import com.bits.bee.conf.InstanceMgr;
import com.bits.lib.dx.BDM;
import com.bits.lib.dx.BQuerySimple;
import org.openide.util.Exceptions;

/**
 *
 * @author Sigit Sukarman
 */
public class BookStockList extends BQuerySimple implements InstanceObserver {

    private static BookStockList singleton = null;
    
    public BookStockList(){
        super(BDM.getDefault(), "bookstock", "bookid", "bookid, qty");
    }
    
    public static synchronized BookStockList getInstance() {
        if (singleton == null) {
            singleton = new BookStockList();
            try {
                singleton.Load();
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
            InstanceMgr.getInstance().addObserver(singleton);
        }
        return singleton;
    }
    
    public String getTitleBook(String id){
        return find("bookid", id, "title");
    }
    
    @Override
    public void doUpdate() {
        singleton=null;
    }
    
}
