/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgtheodoros.ipcalc;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Theo
 */
public class RegexMatches {
    
   private static final String REGEX = "[0-9]{1,2}+";
   //private static final String INPUT = "";
   private static Pattern pattern;
   private static Matcher matcher;

   public boolean compare( String INPUT ) {
      pattern = Pattern.compile(REGEX);
      matcher = pattern.matcher(INPUT);
      

      //System.out.println("Current REGEX is: "+REGEX);
      //System.out.println("Current INPUT is: "+INPUT);

      //System.out.println("lookingAt(): "+matcher.lookingAt());
      //System.out.println("matches(): "+matcher.matches());
      
          return matcher.matches();
      
   }
   
}
