/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.io.*;
import java.util.ResourceBundle;
import javax.swing.JPanel;
import sarl_el_itraa.Main;



/**
 *
 * @author Eurequat-Algerie
 */
public class Tools_File {
 
   public static  String FILE_DIR = "";
   private static final String FILE_TEXT_EXT = ".pdf";
	
   public static void setter(String a){
   Tools_File.FILE_DIR=Main.Link+"//src//Document";
 
   }
   public static void main(String args[]) {
	new Tools_File().deleteFile(FILE_DIR,FILE_TEXT_EXT);
   }
	
    
    
     public void deleteFile(String folder, String ext){
		
     GenericExtFilter filter = new GenericExtFilter(ext);
     File dir = new File(folder);
	
     //list out all the file name with .txt extension
     String[] list = dir.list(filter);
	     
//     if (list.length == 0) return;

     File fileDelete;
	    
     for (String file : list){
   	String temp = new StringBuffer(FILE_DIR)
                      .append(File.separator)
                      .append(file).toString();
    	fileDelete = new File(temp);
    	boolean isdeleted = fileDelete.delete();
    	System.out.println("file : " + temp + " is deleted : " + isdeleted);
     }
   }
  
   //inner class, generic extension filter 
   public class GenericExtFilter implements FilenameFilter {
	
       private String ext;
	
       public GenericExtFilter(String ext) {
         this.ext = ext;             
       }
	       
       public boolean accept(File dir, String name) {
         return (name.endsWith(ext));
       }
    }
   
 
   
    
}
