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
        Link = tools.getUrl(url,"Sarl_El_ITRAA");
        
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
       
        
        
        
        Login login = new Login();
        //PRINCIPAL login = new PRINCIPAL();
        String[] kl = null;
        login.main(kl);
        
        
    }
    
}
