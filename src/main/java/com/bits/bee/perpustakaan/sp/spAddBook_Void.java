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
public class spAddBook_Void extends BProcSimple{
    public spAddBook_Void() {
        super(BDM.getDefault(), "spAddBook_Void", "tambahid");

        //binding ke BProcsimple
        initParams();
    }
}
