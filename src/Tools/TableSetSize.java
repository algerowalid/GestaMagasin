/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Eurequat-Algerie
 */
public class TableSetSize {
    
  
        public void SetClientTable(JTable table){
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(130);
      
     
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
  
              public void SetEmployeTable(JTable table){
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
      
     
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
  
             public void SetListVenteTable(JTable table){
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
      
     
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
    
             
               
    public void SetStockTable(JTable table){
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
      
     
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
    
                 
               
    public void SetCaisseTable(JTable table){
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(250);
        table.getColumnModel().getColumn(2).setPreferredWidth(250);
        table.getColumnModel().getColumn(3).setPreferredWidth(250);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);
        table.getColumnModel().getColumn(6).setPreferredWidth(150);
        table.getColumnModel().getColumn(7).setPreferredWidth(200);
        table.getColumnModel().getColumn(8).setPreferredWidth(200);
       
     
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
    
                 
    public void SetVenteTable(JTable table){
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(40);
        table.getColumnModel().getColumn(2).setPreferredWidth(130);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);
       
     
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
    
        public void SetProduitTable(JTable table){
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
    
        
        public void SetLESVENTESTable(JTable table){
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
       
       
     
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
        
                public void SetRappelTable(JTable table){
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        
     
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

     public void SetProductionTable(JTable table){
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(140);
        table.getColumnModel().getColumn(2).setPreferredWidth(40);
        table.getColumnModel().getColumn(3).setPreferredWidth(40);
        table.getColumnModel().getColumn(4).setPreferredWidth(40);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);
        
     
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
     
         

          
     public void SetClientListTable(JTable table){
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(800);
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

     public void SetFactureTable(JTable table){
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
     
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

          public void SetExonorationTable(JTable table){
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(4).setPreferredWidth(60);
        table.getColumnModel().getColumn(5).setPreferredWidth(60);
        table.getColumnModel().getColumn(6).setPreferredWidth(120);
        
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
          
          
          public void SetBilanTable(JTable table){
              
              table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

                    
     public void SetRappel2Table(JTable table){
              
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(207);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(400);
      //  table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
          
         public void SetReferenceTable(JTable table){
              
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
      //  table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
         
                   
          public void SetPaletteTable(JTable table){
              
              table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

          public void SetActionTable(JTable table){
              
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(471);
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }


          
          public void SetBilanProduitTable(JTable table){
              
        table.getColumnModel().getColumn(0).setPreferredWidth(190);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setPreferredWidth(100);
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

                    
          public void SetBilanClientTable(JTable table){
              
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(150);
        table.getColumnModel().getColumn(7).setPreferredWidth(100);
        table.getColumnModel().getColumn(8).setPreferredWidth(100);
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

}


