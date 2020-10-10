/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgtheodoros.ipcalc;

import static java.lang.Math.pow;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Theo
 */
public class HostMatch {
    
   private static String f1;
   private static String f2;
   private static String f3;
   private static String f4;
   String[] v = new String[4];
   int[] hosts = new int [2];
   
   public HostMatch (int k){
        
        this.v[0] = "";
        this.v[1] = "";
        this.v[2] = "";
        this.v[3] = "";
        this.hosts[0] = 0;
        this.hosts[1] = 0;
        subNet(k);
        calchosts(k);
   }
    
    private void subNet (int n) {
        int m = 0;
        int d = 8;
        
       
        String[] p;
        
        p = new String[32];
        
        for (int i=0;i<n;i++){
            p[i] = Integer.toString(1);
        }
        for (int i=n;i<32;i++){
            p[i] = Integer.toString(0);
        }
        for (int i=1;i<=4;i++){
            for (int j=m;j<d;j++){
                this.v[i-1] = this.v[i-1].concat(p[j]);
                
            }
            m=d;
            d=d+8;
        
        }
        
    }
    

    private void calchosts (int h){
        
        this.hosts[0] = 32-h; /* Host bits*/
        this.hosts[1] = (int) pow(2,(this.hosts[0])); /* Number of hosts*/
    }
    
    
    
    
    public String[] getsubN (){
        return this.v;
    }
    
    public int[] getcalchosts(){
        return this.hosts;
    }
    
}
