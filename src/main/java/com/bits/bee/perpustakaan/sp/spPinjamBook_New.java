/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.bee.perpustakaan.sp;

import com.bits.lib.dx.BDM;
import com.bits.lib.dx.BProcSimple;

/**
 *
 * @author Sigit Sukarman
 */
public class spPinjamBook_New extends BProcSimple {
    public spPinjamBook_New() {
        super(BDM.getDefault(), "spPinjamBook_New", "pinjamid");

        //binding ke BProcsimple
        initParams();
    }
}
