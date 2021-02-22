/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *This file is part of IPCalc.
 *
 *    IPCalc is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    IPCalc is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with IPCalc.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.dgtheodoros.ipcalc;

import static java.lang.Math.pow;

//import java.lang.reflect.Array;
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
   private int[] hosts = new int [2];
   private int[] subnetbit = new int [2];
   private long subnetbit_cidr;
   private  Integer subbits  = 8 ;
   ArrayList<Integer> sub;
   
  // public HostMatch(){
  //      this.sub = new ArrayList<>(4);
   //}
   
   public HostMatch (String s1,String s2,String s3,String s4,int k){
        this.sub = new ArrayList<>();
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
        this.subnetbit_cidr = 0;
        subNet(k);
        calchosts(k);
        calsubnetbits (k,subbits);
        //calsubnet (this.v);
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
    
    
    
    private void calsubnetbits (int h,int d){
            
                this.subnetbit[0] = h-d;
                this.subnetbit[1] = (int)(pow(2,(this.subnetbit[0]))); /* Number of subnets*/
                this.subnetbit_cidr = (long)(pow(2,32-h)); /* Number of subnets for CIDR*/
                

    }
    
    
    private void calsubnet ( String v[]){
      
            this.sub.clear();            
            if (this.f1 == ""){
                this.f1="0";
            }
            if (this.f2 == ""){
                this.f2="0";
            }
            if (this.f3 == ""){
                this.f3="0";
            }
            if (this.f4 == ""){
                this.f4="0";
            }
            //int z1 = Integer.parseInt(this.f1);
           // int z2 = Integer.parseInt(this.v[0],2);
            int z1= Integer.parseInt(Integer.toBinaryString((Integer.parseInt(this.f1))&(Integer.parseInt(this.v[0],2))),2);
            int z2= Integer.parseInt(Integer.toBinaryString((Integer.parseInt(this.f2))&(Integer.parseInt(this.v[1],2))),2);
            int z3= Integer.parseInt(Integer.toBinaryString((Integer.parseInt(this.f3))&(Integer.parseInt(this.v[2],2))),2);
            int z4= Integer.parseInt(Integer.toBinaryString((Integer.parseInt(this.f4))&(Integer.parseInt(this.v[3],2))),2);
            this.sub.add(0,z1);
            this.sub.add(1,z2);
            this.sub.add(2,z3);
            this.sub.add(3,z4);
            this.sub.add(4,z1+(255-Integer.parseInt(this.v[0],2)));
            this.sub.add(5,z2+(255-Integer.parseInt(this.v[1],2)));
            this.sub.add(6,z3+(255-Integer.parseInt(this.v[2],2)));
            this.sub.add(7,z4+(255-Integer.parseInt(this.v[3],2)));
    
    }
    
    
    public String[] getsubN (){
        return this.v;
    }
    
    public int[] getcalchosts(){
        return this.hosts;
    }
    
    public int[] getcalsubnetbits(){
        return this.subnetbit;
    }
    
    public long getsubnetbit_cidr(){
        return subnetbit_cidr;
    }
    public void setcalchosts(int h){
        calchosts(h);
    }
    
    public ArrayList<Integer> getcalsubnet(String s1,String s2,String s3,String s4){
        this.f1 = s1;
        this.f2 = s2;
        this.f3 = s3;
        this.f4 = s4;
        calsubnet (this.v);
        return this.sub;
    }
    
    public void setcalsubnetbits(int h,int d){
        subbits = d;
        calsubnetbits(h,d);
        
        
    }
    
    public void setsubN (int k){
        subNet(k);
    }
    
}
