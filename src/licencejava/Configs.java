package licencejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Configs {
    
    public static Properties prop = new Properties();
    
    public void SaveProp(String titre, String valeur) throws IOException{
        prop.setProperty(titre,valeur);
        prop.store(new FileOutputStream("config.tr"),null);
    }
    public String  GetProp(String titre) throws IOException{
        String valeur="";
       
        if(new File ("config.tr").exists()){
        prop.load(new FileInputStream("config.tr"));
        valeur=prop.getProperty(titre);
       }else{
        valeur="Erreur";
        }
        
        return   valeur;}
    public boolean CheckExistConf(){
    boolean k=false;
    if(new File("config.tr").exists()){
    k=true;}
    return k;}
    
     public void SaveProp2(String titre, String valeur) throws IOException{
        prop.setProperty(titre,valeur);
        prop.store(new FileOutputStream("config2.tr"),null);
    }
     public String  GetProp2(String titre) throws IOException{
        String valeur="";
       
        if(new File ("config2.tr").exists()){
        prop.load(new FileInputStream("config2.tr"));
        valeur=prop.getProperty(titre);
       }else{
        valeur="Erreur";
        }
        
        return   valeur;}
    public boolean CheckExistConf2(){
    boolean k=false;
    if(new File("config2.tr").exists()){
    k=true;}
    return k;}
}
