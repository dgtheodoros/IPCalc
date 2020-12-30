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



//import java.io.File;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;

/**
 *
 * @author Theo
 */


public class InfoIPCalc extends JFrame {
    
    
    public  InfoIPCalc(MainJFrame frame) throws IOException{
            initComponents();
            
    }
    private void initComponents() throws IOException {
        
       setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
       
       JTextArea jTextArea1 = new javax.swing.JTextArea();
       jTextArea1.setColumns(50);
       jTextArea1.setRows(10);
       jTextArea1.setEditable(false);
       setIconImage(ImageIO.read(new File("src\\main\\resources\\ip-adress-64.png")));
       setTitle("IP Calculator");
       setResizable(false);
       try {
            // Read some text from the resource file to display in
            // the JTextArea.
            jTextArea1.read(new InputStreamReader(
                    getClass().getResourceAsStream("/info.txt")),
                null);
        } catch (IOException e) {
        }
       
      /* File f = new File("/resources/info.txt");
        try {
           try (BufferedReader br = new BufferedReader(new FileReader(f))) {
               jTextArea1.read(br, "File");
               br.close();
               jTextArea1.requestFocus();
           }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InfoIPCalc.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       
       
       
       
       JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);
       jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(layout.createSequentialGroup()        
            .addGap(10, 10, 10)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(10, Short.MAX_VALUE))
                
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(layout.createSequentialGroup()        
            .addGap(10, 10, 10)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(jScrollPane1);
        
        pack();
    }
   
    public static void  main(MainJFrame frame) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    InfoIPCalc info = new InfoIPCalc(frame);

                    info.setSize(150, 150);
                    //info.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
    }
    
}

