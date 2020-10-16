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
    
   private  String f1; // IP field
   private  String f2; // IP field
   private  String f3; // IP field
   private  String f4; // IP field
   String[] v = new String[4]; // Netmask
   int[] hosts = new int [2];
   int[] subnetbit = new int [2];
   ArrayList<Integer> sub;
   
   public HostMatch(){
        this.sub = new ArrayList<>(4);
   }
   
   public HostMatch (String s1,String s2,String s3,String s4,int k){
        this.sub = new ArrayList<>(4);
        this.v[0] = "";
        this.v[1] = "";
        this.v[2] = "";
        this.v[3] = "";
        this.f1 = s1;
        this.f2 = s2;
        this.f3 = s3;
        this.f4 = s4;
        this.hosts[0] = 0;
        this.hosts[1] = 0;
        this.subnetbit[0] = 0;
        this.subnetbit[1] = 0;
        subNet(k);
        calchosts(k);
   }
    
   
   
    private void subNet (int n) {
        int m = 0;
        int d = 8;
        
       
        String[] p;
        
        p = new String[32];
        
        for (int i=0;i<n;i++){        //Sets the 1s in netmask
            p[i] = Integer.toString(1);
        }
        for (int i=n;i<32;i++){    //Sets the 0s in netmask
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
        switch (this.hosts[0]){
            case 1:
                this.hosts[1] = 2;
                break;
            case 0:
                this.hosts[1] = 1;
                break;
            default:    
            this.hosts[1] = (int)((pow(2,(this.hosts[0])))-2); /* Number of hosts*/           
        }
        
    }
    
    
    
    private void calsubnetbits (int h){
            
        this.subnetbit[0] = h;
        switch (this.hosts[0]){
            
        }   
    }
    
    
    private void calsubnet (){
      
            this.sub.clear();
            this.sub.add(0,Integer.parseInt(this.f1)&Integer.parseInt(this.v[0]));
    
    }
    
    
    public String[] getsubN (){
        return this.v;
    }
    
    public int[] getcalchosts(){
        return this.hosts;
    }
    
    public void setcalchosts(int h){
        calchosts(h);
    }
    
    public ArrayList<Integer> getcalsubnet(){
        return this.sub;
    }
    
}
