/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgtheodoros.ipcalc;

import javax.swing.JTextField;

/**
 *
 * @author Theo
 * This interface passes values of class MainJFrame to CIDRJFrame that are private
 */
public interface PassFields {
    
    public String ValField1();
    public String ValField2();
    public String ValField3();
    public String ValField4();
    public  int ValSlider();
    
}
