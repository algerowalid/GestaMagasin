/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licencejava;

import Tools.DataBase;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;



/**
 *
 * @author Algerowalid
 */
public class Operation {
    
    public Boolean verifier(String codeactivation){
        boolean a= false;
        Configs config = new Configs();
      
    return a;} 
    
    public String controldatefin(String date, int nombrejour){
    int lastdate=0;
    String sdt = null;
    int dt = Integer.parseInt(date);
                        if(nombrejour>1){
                            if(nombrejour<=30){
                            lastdate=dt+nombrejour;
                            }else{

                            int a = (nombrejour/30)*100;
                            int b = nombrejour%30;

                            lastdate=dt+a+b;
                            }

                            
    sdt= String.valueOf(lastdate);  
                               
    
    if(lastdate>0){ 
        
        int jour=Integer.parseInt(sdt.toString().trim().substring(6, 8));
        
                   if(jour>30){
                    StringBuilder myName = new StringBuilder(sdt);
                    myName.setCharAt(6, '3');
                    myName.setCharAt(7, '0');
                    
                    sdt=myName.toString();
                    int mois=Integer.parseInt(sdt.toString().trim().substring(4, 6))+1; 
                    String h = String.valueOf(mois);
                    sdt=myName.toString().trim().substring(0, 4)+h+myName.toString().trim().substring(6, 8);
                    
                    }

        int mois=Integer.parseInt(sdt.toString().trim().substring(4, 6));            
                     if(mois>12){
                        
                         int d = mois/12;
                         int r = mois%12;
                    
                                if(d>0){
                                int year = Integer.parseInt(sdt.toString().trim().substring(0, 4))+d;
                                        String m="";
                                        if(r<10){
                                        m="0"+String.valueOf(r);
                                        }else{
                                        m=String.valueOf(r);}
                                
                                sdt=year+m+sdt.toString().trim().substring(6, 8);

                                }
                     }
    
    }
                            
                            }
                        
                       if (nombrejour==777){
                        int a = 900000;
                        lastdate =Integer.parseInt(sdt);
                        lastdate= lastdate+a;
                        sdt=String.valueOf(lastdate);
                        }


    
    
    return sdt; }
    public String jour(){
       
     Calendar cal =new GregorianCalendar();
     int month= cal.get(Calendar.MONTH)+1;
     int day= cal.get(Calendar.DAY_OF_MONTH);
     int year = cal.get(Calendar.YEAR);
     
     String mnt =String.valueOf(month);
     String dy=String.valueOf(day);
     
     if (month<10){ mnt="0"+mnt; }
     if (day<10){ dy="0"+dy; }
     
     
      String date= year+""+mnt+""+dy;
   
     String heur=String.format("%tT", new java.util.Date());
    
    return date;}
    public String code(String s,String dt,String appli){ // coder  la date et le numéros de serie HDD pour le donner au developpeur 
        String d = this.jour();
        
        if(dt!=null){
        d=dt;}
        String b = this.executeVolCommand();
        
        if(s!=null){
        b=s;}
        
        String[] k = b.split("-");        
        d= this.encodedate(d);
        String f=appli+d.trim().substring(0, 4)+k[1]+d.trim().substring(4, 8)+k[0];
        
        return f;}
    public String decode(String h ){
    String d,hdd;
    String apl = h.trim().substring(0,2);
    h=h.substring(2);
    d=h.trim().substring(8,10)+h.trim().substring(2,4)+h.trim().substring(11,12)+h.trim().substring(10,11)+h.trim().substring(0,2);
    hdd = h.trim().substring(12,16)+"-"+h.trim().substring(4,8);  
       return d+"/"+hdd+"/"+apl;}
    public String decodedate(String end){
    String h = null; 
    h=end.trim().substring(4,6)+end.trim().substring(2,4)+end.trim().substring(7,8)+end.trim().substring(6,7)+end.trim().substring(0,2);
    return h; }
    public String encodedate(String end){// ddYYyymM 
    String h = null; 
    h=end.trim().substring(6,8)+end.trim().substring(2,4)+end.trim().substring(0,2)+end.trim().substring(5,6)+end.trim().substring(4,5);
    return h; }
    public String executeVolCommand(){
    String NEWLINE = System.getProperty("line.separator");
    StringBuffer buffer = new StringBuffer();
    try{

      Process pb = new ProcessBuilder("cmd","/c", "vol").start();  
      InputStream in = pb.getInputStream();  
      BufferedReader br = new BufferedReader(new InputStreamReader(in));  
      String line;  
      while ((line = br.readLine()) != null) {  
        buffer.append(line + NEWLINE);  
      }
    }
    catch(Exception e){e.printStackTrace();}
    
    String k = buffer.toString();
    String u;
    
   u= k.substring(k.lastIndexOf(" ") + 1);
   u= u.replaceAll("\\s+","");
    
   return u;      }
    public static int randInt(int min, int max) {
    // NOTE: Usually this should be a field rather than a method
    // variable so that it is not re-seeded every call.
    Random rand = new Random();
    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
}
    public boolean supercheck() throws SQLException, ClassNotFoundException{
    boolean n=false;
    
        String req ="Select count(id) as cnt from brak ";
        DataBase a = new DataBase();
        Configs b = new Configs();
        
        boolean a1 = false;
  
            a1 = a.checkdb(req);
        
        boolean b1= b.CheckExistConf();
    
    
        if(b1==true && a1==true){
        n = true;
        }else{n=false;}
        
    
    return n;}
    
    
    
}
