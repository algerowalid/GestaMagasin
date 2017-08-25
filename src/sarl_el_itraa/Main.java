/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarl_el_itraa;

import Tools.DataBase;
import Tools.tools;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import licencejava.Configs;
import licencejava.DemandeLicence;
import licencejava.Operation;
import views.Login;
import views.PRINCIPAL;

/**
 *
 * @author Eurequat-Algerie
 */
public class Main {

      public static String Link="";
    //public static String adress="127.0.0.1";
    public static String adress="192.168.1.100";
    public static DataBase d = new DataBase();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        URL url = Main.class.getProtectionDomain().getCodeSource().getLocation(); //Gets the path
        Link = tools.getUrl(url,"SARL_EL_ITRAA");
        
        d.setter(Link);
        
        Configs c = new Configs();
        String req45 = "select count(id) as cnt from parametre ";
        
        d.connect();
       
        int a = d.RecuperationInt(req45,"cnt");
        if(a==0){
        String req46 = "Insert into parametre (nom,valeur) "
                + " values ('login','admin')";
        
        String req47 = "Insert into parametre (nom,valeur) "
                + " values ('password','admin')";
        d.query(req46);
        d.query(req47);
        }
        
        d.close();
       
        
         //CHECK FOR LICENCE 
            
     
                 /*
            
            Operation j = new Operation();
            tools t= new tools();
          
            
            //today date  and serial
            String date = t.jour();
            String serial = j.executeVolCommand();
            int nombrejour=0;
            
            
            
            
            
            //Verifie l'existence d'une ligne base de donnée et le fichier de configuration
            boolean k;
      try {
          k = j.supercheck();
      
            if(k==true){ // si les lignes existe on procéde au déchiffrement
                
                String req = "SELECT * FROM brak";
                String codeData = null;
                String datef=null;
                String codeConfig = null;
                
                d.connect();
                codeData=d.RecuperationString(req, "info");
                datef=d.RecuperationString(req,"rem");
                codeConfig =c.GetProp("ddtf");
                
                d.close();
                
                
                
                if(!codeData.equals(null) && !codeData.equals("null") ){
                    String[] part = j.decode(codeData).split("/");
                    
                    
                    
                    //&& part[0]==codeConfig && serial==part[1]
                    // if(part[2].equals("LF") && part[0].equals(codeConfig) && serial.equals(part[1])){
                    if(part[2].equals("LF") && serial.equals(part[1])){
                        
                        String today = t.jour();
                        today = today.replaceAll("-", "");
                        int dateAu = Integer.parseInt(today);
                        int dtf = Integer.parseInt(part[0]);
                        
                        
                        if(dateAu<dtf){
                            String[] lgd = null;
                            Login.main(lgd);
                            
                        }else{
                            
                            String req2 = "insert into  brak (info,rem) values('null','null')";
                            String req3 = "Delete from brak";
                            
                            d.connect();
                            d.query(req3);
                            d.query(req2);
                            d.close();
                            
                            DemandeLicence dm = new DemandeLicence();
                            
                            String codage = j.code(null,null,"LF");
                            dm.Setterlien(Link);
                            dm.setCode(codage);
                            String[] rgtd=null;
                            
                            dm.main(rgtd);
                            
                        }
                        
                    }
                    
                    
                }else{ // Si l'existence est FALSE  on enregistre les infos
                    
                    
                    DemandeLicence dm = new DemandeLicence();
                    dm.Setterlien(Link);
                    String codage = j.code(null,null,"LF");
                    dm.setCode(codage);
                    String[] rgtd=null;
                    
                    dm.main(rgtd);
                    
                }
                
            }else{
                DemandeLicence dm = new DemandeLicence();
                String codage = j.code(null,null,"LF");
                dm.Setterlien(Link);
                dm.setCode(codage);
                String[] rgtd=null;
                
                dm.main(rgtd);
            }
            
          
    
            } catch (SQLException ex) {
          Logger.getLogger(PointVente.class.getName()).log(Level.SEVERE, null, ex);
      }catch (ClassNotFoundException ex) {
          Logger.getLogger(PointVente.class.getName()).log(Level.SEVERE, null, ex);
      }
            
            
        */
        
        //Login login = new Login();
        PRINCIPAL login = new PRINCIPAL();
        String[] kl = null;
        login.main(kl);
        
        
    }
    
}
