/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 *
 * @author Eurequat-Algerie
 */
public class DataBase_Method {
    public static DataBase database = new DataBase();
    
    
    public static boolean Test_Base(){
    
        boolean result =false;
        
        database.connect();
        String req = "select count(id) as count from employe";
        int a = database.RecuperationInt(req,"count");
        database.close();
        
        if(a>0){
        result=true;}
        
        
    return result;}
    
    public static int loginResult(String login, String password){
        int idEmploye=0;
        
        database.connect();
        String req ="select id from employe where login='"+login+"' and password='"+password+"'";
        idEmploye = database.RecuperationInt(req,"id");
        database.close();
        
    return idEmploye;}
    
    
       public static int ParametreloginResult(String login, String password){
        int idEmploye=0;
        
        database.connect();
        String req ="select count(id) as id  from parametre where nom='login=' and valeur='"+login+"'";
        String req2 ="select count(id) as id  from parametre where nom='password' and valeur='"+password+"'";
        int a = database.RecuperationInt(req,"id");
        int b = database.RecuperationInt(req2,"id");
        database.close();
        
        idEmploye=a+b;
    return idEmploye;}
    
    
    
}
