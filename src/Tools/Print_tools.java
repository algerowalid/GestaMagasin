/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author Eurequat-Algerie
 */
public class Print_tools {
    
    public void PrintReceip(String printName, 
            String en, String adr, String tel, String mail, String m1 , String m2,
            String dt, String hr,double total, int nb, int barcode,
            ArrayList<Vector> List)
    {
        PrinterService printerService = new PrinterService();
    
        
          byte[] data;
            ArrayList<Byte> list = new ArrayList<Byte>();
            Byte[] tempList;
            
            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x1d, 0x61, 0x01}));

            
          /*  data = "[If loaded.. Logo1 goes here]\r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x1c, 0x70, 0x01, 0x00, '\r', '\n'}));  //Stored Logo Printing
*/
            data = (en+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            data = (adr+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            if(tel.length()>0){
            data = ("Tel: "+tel+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            }
            
            if(mail.length()>0){
            data = ("Email: "+mail+"\r\n\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            }
            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x1d, 0x61, 0x00})); // Alignment

            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x44, 0x02, 0x10, 0x22, 0x00})); //Set horizontal tab

            data = (dt).getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            list.addAll(Arrays.asList(new Byte[]{' ', 0x09, ' '}));   //Moving Horizontal Tab

            data = ("                "+hr+"\r\n----------------------------------------\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x45})); // bold

            data = "Les articles : \r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x46})); // bolf off

        
            // notice that we use a unicode representation because that is how Java expresses these bytes at double byte unicode
            // This will TAB to the next horizontal position
            data = "Produit             Qnt    P.U    Total\r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            for(int i=0; i<List.size();i++){
           
                String pr = List.get(i).get(1).toString();
                int qnt = Integer.parseInt(List.get(i).get(3).toString());
                double price = Double.parseDouble(List.get(i).get(2).toString());
                double ttl = qnt*price;
                
                if(pr.length()>20){
                pr = (String) pr.subSequence(0, 20);
                }else if(pr.length()<20){
                    int h = 20 -pr.length();
                    for (int k =0; k<h ; k++){
                    pr = pr+" ";
                    }
                }
                
                pr = pr.replaceAll("é","e");
                
                String lepr=String.format( "%.2f", price ); 
                String lettl=String.format( "%.2f", ttl ); 
                String qnn = String.valueOf(qnt);
                
                if(qnn.length()<4){
                    int h = 4 -qnn.length();
                    for (int k =0; k<h ; k++){
                    qnn = qnn+" ";
                    }
                }
                
                 if(lepr.length()<7){
                    int h = 7 -lepr.length();
                    for (int k =0; k<h ; k++){
                    lepr = lepr+" ";
                    }
                }
                
                  
                 if(lettl.length()<7){
                    int h = 7 -lettl.length();
                    for (int k =0; k<h ; k++){
                    lettl = lettl+" ";
                    }
                }
                
                 
             data = (pr+" "+qnn+""+lepr+"  "+lettl+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

                
                
            }
           
    
            data = "-----------------------------------------\r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            
            data = "Nombre Articles ".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            // Character expansion
           // list.addAll(Arrays.asList(new Byte[]{0x06, 0x09, 0x1b, 0x69, 0x01, 0x01}));

            String nbr= String.valueOf(nb);
            data = ("      "+nbr+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x69, 0x00, 0x00}));  //Cancel Character Expansion

            data = "Total".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            // Character expansion
            //list.addAll(Arrays.asList(new Byte[]{0x06, 0x09, 0x1b, 0x69, 0x01, 0x01}));

            String tt = String.valueOf(total);
            data = ("               "+tt+" Da\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x69, 0x00, 0x00}));  //Cancel Character Expansion

            data = "-----------------------------------------\r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));


        
         list.addAll(Arrays.asList(new Byte[]{0x1b, 0x1d, 0x61, 0x01}));

            data = ("\u001b\u0034"+m1+"\u001b\u0035\r\n").getBytes();  //Specify/Cencel White/Black Invert
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            data = (m2+"\r\n\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
/*
            //1d barcode example 
            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x1d, 0x61, 0x01}));
            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x62, 0x06, 0x02, 0x02}));

            data = ("000"+barcode+"\u001e\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
*/
            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x64, 0x02}));      //Cut
            list.addAll(Arrays.asList(new Byte[]{0x07})); // Kick cash drawer

            data = new byte[list.size()];

            for (int index = 0; index < data.length; index++) {
                data[index] = (Byte) list.get(index);
            }
            
            
             //print some stuff
		printerService.printBytes(printName, data);
            
    }
 
    
    public void OpenDrawer(String printName){
    
         PrinterService printerService = new PrinterService();
   
         EscPosPrinter exc = new EscPosPrinter();
         
         
         
         
         byte[] data;
         Byte[] tempList;
           ArrayList<Byte> list = new ArrayList<Byte>();
         
           
            tempList = new Byte[exc.open().length];
            CopyArray(exc.open(), tempList);
            list.addAll(Arrays.asList(tempList));
            data = new byte[list.size()];
            
              for (int index = 0; index < data.length; index++) {
                data[index] = (Byte) list.get(index);
            }
          
            
            printerService.printBytes(printName, data);
        
    }
    
    
    public void PrintBilan(String printName, 
            String dt1,String dt2, String hr,double total, int idc, int narticle, 
            ArrayList<Vector> List,String ouv, double ec)
    {
        PrinterService printerService = new PrinterService();
    
        
          byte[] data;
            ArrayList<Byte> list = new ArrayList<Byte>();
            Byte[] tempList;
            
            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x1d, 0x61, 0x01}));
            
            data = ("Caisse N : "+idc+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            data = ("Date Ouverture: "+dt1+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            data = ("Date Cloture: "+dt2+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            data = ("Heure Cloture: "+hr+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
               data = ("Ouverte par: "+ouv+"\r\n\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
          
            
            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x1d, 0x61, 0x00})); // Alignment

            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x44, 0x02, 0x10, 0x22, 0x00})); //Set horizontal tab

          
            list.addAll(Arrays.asList(new Byte[]{' ', 0x09, ' '}));   //Moving Horizontal Tab

          
            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x45})); // bold

            data = "Les articles : \r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x46})); // bold off

        
            // notice that we use a unicode representation because that is how Java expresses these bytes at double byte unicode
            // This will TAB to the next horizontal position
            data = "Produit             Qnt    P.U    Total\r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            for(int i=0; i<List.size();i++){
           
                String pr = List.get(i).get(0).toString();
                int qnt = Integer.parseInt(List.get(i).get(1).toString());
                double price = Double.parseDouble(List.get(i).get(2).toString());
                double ttl = qnt*price;
                
                if(pr.length()>20){
                pr = (String) pr.subSequence(0, 20);
                }else if(pr.length()<20){
                    int h = 20 -pr.length();
                    for (int k =0; k<h ; k++){
                    pr = pr+" ";
                    }
                }
                
                pr = pr.replaceAll("é","e");
                
                String lepr=String.format( "%.2f", price ); 
                String lettl=String.format( "%.2f", ttl ); 
                String qnn = String.valueOf(qnt);
                
                if(qnn.length()<4){
                    int h = 4 -qnn.length();
                    for (int k =0; k<h ; k++){
                    qnn = qnn+" ";
                    }
                }
                
                 if(lepr.length()<7){
                    int h = 7 -lepr.length();
                    for (int k =0; k<h ; k++){
                    lepr = lepr+" ";
                    }
                }
                
                  
                 if(lettl.length()<7){
                    int h = 7 -lettl.length();
                    for (int k =0; k<h ; k++){
                    lettl = lettl+" ";
                    }
                }
                
                 
             data = (pr+" "+qnn+""+lepr+"  "+lettl+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

                
                
            }
    
            data = "-----------------------------------------\r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            
            data = "Nombre Articles ".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            // Character expansion
            //list.addAll(Arrays.asList(new Byte[]{0x06, 0x09, 0x1b, 0x69, 0x01, 0x01}));

            String nbr= String.valueOf(narticle);
            data = ("             "+nbr+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            //list.addAll(Arrays.asList(new Byte[]{0x1b, 0x69, 0x00, 0x00}));  //Cancel Character Expansion
            
               data = "Total ".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            // Character expansion
            //list.addAll(Arrays.asList(new Byte[]{0x06, 0x09, 0x1b, 0x69, 0x01, 0x01}));

            String tt=String.format( "%.2f", total ); 
            data = ("                       "+tt+" Da \r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            //list.addAll(Arrays.asList(new Byte[]{0x1b, 0x69, 0x00, 0x00}));  //Cancel Character Expansion
            
            
                 data = "Ecart   ".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

      
            String e=String.format( "%.2f",ec ); 
            data = ("                     "+e+" Da \r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            data = "-----------------------------------------\r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));


        
            
            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x64, 0x02}));      //Cut
            
            data = new byte[list.size()];

            for (int index = 0; index < data.length; index++) {
                data[index] = (Byte) list.get(index);
            }
            
            
             //print some stuff
		printerService.printBytes(printName, data);
            
    }
 
    
    
        private static void CopyArray(byte[] array1, Byte[] array2) {
        for (int index = 0; index < array2.length; index++) {
            array2[index] = array1[index];
        }
    }
        
        
           public void PrintReceipEsc(String printName, 
            String en, String adr, String tel, String mail, String m1 , String m2,
            String dt, String hr,double total, int nb, int barcode,
            ArrayList<Vector> List)
    {
        PrinterService printerService = new PrinterService();
    
        EscPosPrinter esc = new EscPosPrinter();
        
            byte[] data;
            ArrayList<Byte> list = new ArrayList<Byte>();
            Byte[] tempList;
            
        
                
            tempList = new Byte[esc.setFontSize(1,1).length];
            CopyArray(esc.setFontSize(1,1), tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            data = esc.setTextPosition(1);
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            
            data = (en+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            
            
            data = (adr+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            
            tempList = new Byte[esc.setFontSize(0,0).length];
            CopyArray(esc.setFontSize(0,0), tempList);
            list.addAll(Arrays.asList(tempList));
            
            if(tel.length()>0){
            data = ("Tel: "+tel+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            }
            
            if(mail.length()>0){
            data = ("Email: "+mail+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            }
            
  //          list.addAll(Arrays.asList(new Byte[]{0x1b, 0x1d, 0x61, 0x00})); // Alignment

//            list.addAll(Arrays.asList(new Byte[]{0x1b, 0x44, 0x02, 0x10, 0x22, 0x00})); //Set horizontal tab

            data = ("Date:"+dt).getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            list.addAll(Arrays.asList(new Byte[]{' ', 0x09, ' '}));   //Moving Horizontal Tab

            data = ("            "+hr+"\r\n-----------------------------------------------\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
             
            data = esc.setTextPosition(0);
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

       

            data = "Les articles : \r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            // notice that we use a unicode representation because that is how Java expresses these bytes at double byte unicode
            // This will TAB to the next horizontal position
            data = "Produit             Qnt       P.U       Total\r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            for(int i=0; i<List.size();i++){
           
                String pr = List.get(i).get(1).toString().replaceAll("é","e");
                pr = pr.replaceAll("è","e");
                pr = pr.replaceAll("à","a");
                pr = pr.replaceAll("'"," ");
                int qnt = Integer.parseInt(List.get(i).get(3).toString());
                double price = Double.parseDouble(List.get(i).get(2).toString());
                double ttl = qnt*price;
                
                if(pr.length()>20){
                pr = (String) pr.subSequence(0, 20);
                }else if(pr.length()<20){
                    int h = 20 -pr.length();
                    for (int k =0; k<h ; k++){
                    pr = pr+" ";
                    }
                }
                
                String lepr=String.format( "%.2f", price ); 
                String lettl=String.format( "%.2f", ttl ); 
                String qnn = String.valueOf(" "+qnt);
                
                if(qnn.length()<3){
                    int h = 3 -qnn.length();
                    for (int k =0; k<h ; k++){
                    qnn = qnn+" ";
                    }
                }
                
                 if(lepr.length()<7){
                    int h = 7 -lepr.length();
                    for (int k =0; k<h ; k++){
                    lepr = lepr+" ";
                    }
                }
                
                  
                 if(lettl.length()<7){
                    int h = 7 -lettl.length();
                    for (int k =0; k<h ; k++){
                    lettl = lettl+" ";
                    }
                }
                
                 
            data = (pr+qnn+"     "+lepr+"    "+lettl+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            }
           
    
            data = "------------------------------------------------\r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            
            data = "Nombre Articles ".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

      
            String nbr= String.valueOf(nb);
            data = ("   "+nbr+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            data = "                  Total".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            list.addAll(Arrays.asList(new Byte[]{' ', 0x09, ' '}));   //Moving Horizontal Tab
     
            String tt = String.valueOf(total);
            data = (" "+tt+" Da\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

        
            data = "------------------------------------------------\r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
      
              
            data = esc.setTextPosition(1);
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            data = esc.printText(m1+"\r\n");
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            data = esc.printText(m2+"\r\n");
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            data = esc.printText("\r\n");
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            
            data = esc.printText("\r\n");
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            data = esc.printText("\r\n");
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            data = esc.printText("\r\n");
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            tempList = new Byte[esc.cut().length];
            CopyArray(esc.cut(), tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            tempList = new Byte[esc.open().length];
            CopyArray(esc.open(), tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            data = new byte[list.size()];

            for (int index = 0; index < data.length; index++) {
                data[index] = (Byte) list.get(index);
            }
            
            
             //print some stuff
		printerService.printBytes(printName, data);
            
    }
    
           
                public void PrintBilanEsc(String printName, 
            String dt1,String dt2, String hr,double total, int idc, int narticle, 
            ArrayList<Vector> List,String ouv, double ec)
    {
        PrinterService printerService = new PrinterService();
    
          EscPosPrinter esc = new EscPosPrinter();
     
        
          byte[] data;
            ArrayList<Byte> list = new ArrayList<Byte>();
            Byte[] tempList;
            
        
            tempList = new Byte[esc.setTextPosition(1).length];
            CopyArray(esc.setTextPosition(1), tempList);
            list.addAll(Arrays.asList(tempList));
            
            data = ("Caisse N : "+idc+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            data = ("Date Ouverture: "+dt1+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            data = ("Date Cloture: "+dt2+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            data = ("Heure Cloture: "+hr+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            data = ("Ouverte par: "+ouv+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            tempList = new Byte[esc.setTextPosition(0).length];
            CopyArray(esc.setTextPosition(0), tempList);
            list.addAll(Arrays.asList(tempList));

            
            data = "Les articles : \r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

        
             data = "Produit             Qnt       P.U         Total\r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            for(int i=0; i<List.size();i++){
           
                String pr = List.get(i).get(0).toString().replaceAll("é","e");
                pr = pr.replaceAll("è","e");
                pr = pr.replaceAll("à","a");
                pr = pr.replaceAll("'"," ");
                int qnt = Integer.parseInt(List.get(i).get(1).toString());
                double price = Double.parseDouble(List.get(i).get(2).toString());
                double ttl = qnt*price;
                
                if(pr.length()>20){
                pr = (String) pr.subSequence(0, 20);
                }else if(pr.length()<20){
                    int h = 20 -pr.length();
                    for (int k =0; k<h ; k++){
                    pr = pr+" ";
                    }
                }
                
                String lepr=String.format( "%.2f", price ); 
                String lettl=String.format( "%.2f", ttl ); 
                
               
              String qnn =" "+String.valueOf(qnt);
                
                if(qnn.length()<4){
                    int h = 4 -qnn.length();
                    for (int k =0; k<h ; k++){
                    qnn = qnn+" ";
                    }
                }
                
                 if(lepr.length()<7){
                    int h = 7 -lepr.length();
                    for (int k =0; k<h ; k++){
                    lepr = lepr+" ";
                    }
                }
                
                  
                 if(lettl.length()<7){
                    int h = 7 -lettl.length();
                    for (int k =0; k<h ; k++){
                    lettl = lettl+" ";
                    }
                }
                
             //data = (pr+qnn+"     "+lepr+"  "+lettl+"\r\n").getBytes();
             tempList = new Byte[esc.printText(pr+qnn+"     "+lepr+"  "+lettl+"\r\n").length];
            CopyArray(esc.printText(pr+qnn+"     "+lepr+"  "+lettl+"\r\n"), tempList);
            list.addAll(Arrays.asList(tempList));

                
                
            }
           
    
            tempList = new Byte[esc.printText("-------------------------------------------\r\n").length];
            CopyArray(esc.printText("-------------------------------------------\r\n"), tempList);
            list.addAll(Arrays.asList(tempList));
            
              
             tempList = new Byte[esc.setTextPosition(2).length];
            CopyArray(esc.setTextPosition(2), tempList);
            list.addAll(Arrays.asList(tempList));
            
            data = "Nombre Articles ".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            String nbr= String.valueOf(narticle);
            data = ("   "+nbr+"\r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
      
               data = "Total   ".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

      
            String tt=String.format( "%.2f", total ); 
            data = ("   "+tt+" Da \r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

               data = "Ecart   ".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

      
            String e=String.format( "%.2f",ec ); 
            data = ("   "+e+" Da \r\n").getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
      
            data = "------------------------------------------------\r\n".getBytes();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));


        
            
            data = esc.printText("\r\n");
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            
            data = esc.printText("\r\n");
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            data = esc.printText("\r\n");
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            data = esc.printText("\r\n");
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));

            data = esc.lineFeed();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            data = esc.lineFeed();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            data = esc.lineFeed();
            tempList = new Byte[data.length];
            CopyArray(data, tempList);
            list.addAll(Arrays.asList(tempList));
            
            
            
            tempList = new Byte[esc.cut().length];
            CopyArray(esc.cut(), tempList);
            list.addAll(Arrays.asList(tempList));
            
            data = new byte[list.size()];

            for (int index = 0; index < data.length; index++) {
                data[index] = (Byte) list.get(index);
            }
            
            
             //print some stuff
		printerService.printBytes(printName, data);
            
    }
}
