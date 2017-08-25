/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;


import net.proteanit.sql.DbUtils;



/**
 *
 * @author Eurequat-Algerie
 */
public class DataBase {
    
    public static java.sql.Connection connexion;
    public static java.sql.Connection connexion2;
    private static java.sql.Statement statement;
    public static  String lien;
    

    
   
    
 public static void setter(String a){
    DataBase.lien=a;
   }
 public static  java.sql.Statement connect(){
String unicode= "?useUnicode=yes&characterEncoding=UTF-8";
  try {
           Class.forName("org.sqlite.JDBC");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
          // connexion = DriverManager.getConnection("jdbc:sqlite:"+lien+"\\src\\database\\logbase");
           connexion = DriverManager.getConnection("jdbc:sqlite:"+lien+"src//database//data.sqlite");
           connexion2 = DriverManager.getConnection("jdbc:sqlite:"+lien+"src//database//data.sqlite");
       } catch (SQLException ex) {
           Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
           statement =  connexion.createStatement();
       } catch (SQLException ex) {
           Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
       }
 
        //String URL = "jdbc:mysql://localhost/erma?user=root";
        
     

        
        
        // Postgresal 
       /*
           try {
         Class.forName("org.postgresql.Driver");
       //  c = DriverManager.getConnection("jdbc:postgresql://192.168.1.160:5432/TestBase","postgres", "cavock725");
         connexion = DriverManager.getConnection("jdbc:postgresql://"+adresse+":5432/erma","postgres", "cavock725");
         connexion = DriverManager.getConnection("jdbc:postgresql://"+adresse+":5432/erma","postgres", "cavock725");
        
          statement = connexion.createStatement();
         

      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
        
        
        */
        
        
        
        /*
                String URL = "jdbc:mysql://"+PointVente.adress+"/pointvente";
       
        
        try {
            Class.forName("com.mysql.jdbc.Driver");

     
             connexion = DriverManager.getConnection(URL+unicode,"root","");
             connexion2 = DriverManager.getConnection(URL+unicode,"root","");
             statement= connexion.createStatement();


        } catch (ClassNotFoundException claseNoEncontrada) {
            JOptionPane.showMessageDialog(null, claseNoEncontrada.getMessage(),
                    "No se encontró el controlador", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException excepcionSql) {
            JOptionPane.showMessageDialog(null, excepcionSql.getMessage(),
                    "Error en base de datos", JOptionPane.ERROR_MESSAGE);

        }
*/
        return statement;
    }
 public static  boolean query( String requete) {
         boolean insert=false;
                try {
                        statement.executeUpdate(requete);
                        insert=true;     
                           
                }

                catch (SQLException ex) {
                    insert=false;
                    System.out.println("Anomalie query: "+requete+"\n"+ex.toString());
                  // JOptionPane.showMessageDialog(null, "Erreur SQL" + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                                       }
             
        return insert;
       }       
 public static boolean close() {
        boolean clos=false;
        try {
            //statement = connect.createStatement();
            //statement.executeQuery("SHUTDOWN");
            connexion.close();
            clos=true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                                          "Erreur de fermeture de la base de donnÃ©es",
                                          "ERREUR",
                                          JOptionPane.ERROR_MESSAGE);
            clos=false;
        }
return clos;
    }

 // AUTRE METHODES 
       
 public static void refresh(String requete, JTable table ){
    
     ResultSet rs = null;

          try {
    
    rs = statement.executeQuery(requete);
    table.setModel(DbUtils.resultSetToTableModel(rs));
       
       
          } catch (SQLException e) {
      System.out.println("Anomalie refresh table\n"+e.toString()+"\n"+requete);
    }
        try {
          rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
 

 public static void AddStock(int id, double qnt, String date){

     String req = "UPDATE stock set qnt=qnt+"+qnt+",date='"+date+"' WHERE id_produit="+id+"";
     query(req);
   
 }
 public static void SoustStock(int id, double qnt, String date){
    String req = "UPDATE stock set qnt=qnt-"+qnt+",date='"+date+"' WHERE id_produit="+id+"";
     query(req);
 }
 
 // remplissage des jtextField
 
public ArrayList<String> getitems(String req,String colonne) throws SQLException{

ArrayList<String> a = new ArrayList<String>() ;
ResultSet rs;
rs=statement.executeQuery(req);
boolean k = rs.next();
while(k){
a.add(rs.getString(colonne));
k=rs.next();
}

return a; }

public ArrayList<Double> getitemsDouble(String req,String colonne) throws SQLException{

ArrayList<Double> a = new ArrayList<Double>() ;
ResultSet rs;
rs=statement.executeQuery(req);
boolean k = rs.next();
while(k){
a.add(rs.getDouble(colonne));
k=rs.next();
}

return a; }
public static int RecuperationInt(String req, String col){
   int idi = 0;
              try {
                 ResultSet rs2 = statement.executeQuery(req);

                 boolean k=rs2.next();
                        while (k){
                            idi=rs2.getInt(col);
                            k=rs2.next();
                        }
                            
                } catch (SQLException e) {
                 System.out.println("Anomalie requete: \n "+e+"\n"+req);
                 }
                 
    return idi;}
public static String RecuperationString(String req, String col){
   String  resultat = null;
              try {
                 statement = connexion.createStatement();
                 ResultSet rs2 = statement.executeQuery(req);

                 boolean k=rs2.next();
                        while (k){
                            resultat=rs2.getString(col);
                            k=rs2.next();
                        }
                        
                } catch (SQLException e) {
                 System.out.println("Anomalie lors de l'execution de la requête: "+req+"\n"+e.toString());
                 }
                 
    return resultat;}
public static double RecuperationDouble(String req, String col){
   double  resultat = 0.00;
              try {
                 statement = connexion.createStatement();
                 ResultSet rs2 = statement.executeQuery(req);

                 boolean k=rs2.next();
                        while (k){
                            resultat=rs2.getDouble(col);
                            k=rs2.next();
                        }
                        
                } catch (SQLException e) {
                 System.out.println("Anomalie:"+req+" \n"+e.toString());
                 }
                 
    return resultat;}
public static String RecuperationStringSeparer(String req, String col){
   String resultat = "";
              try {
                 statement = connexion.createStatement();
                 ResultSet rs2 = statement.executeQuery(req);

                 boolean k=rs2.next();
                        while (k){
                           String enregistrement = rs2.getString(col);
                           resultat = resultat+"-"+enregistrement;
                           k=rs2.next();
                          
                        }
                        
                } catch (SQLException e) {
                 System.out.println("Anomalie lors de l'execution de la requête");
                 }
                 
    return resultat;}

public static String RecuperationIntegerSeparer(String req, String col){
   String resultat = "";
              try {
                 statement =  connexion.createStatement();
                 ResultSet rs2 = statement.executeQuery(req);

                 boolean k=rs2.next();
                        while (k){
                           int enregistrement = rs2.getInt(col);
                           resultat = resultat+"-"+enregistrement;
                           k=rs2.next();
                          
                        }
                        
                } catch (SQLException e) {
                 System.out.println("Anomalie lors de l'execution de la requête");
                 }
                 
    return resultat;}
public static String RecuperationDoubleSeparer(String req, String col){
   String resultat = "";
              try {
                 statement = connexion.createStatement();
                 ResultSet rs2 = statement.executeQuery(req);

                 boolean k=rs2.next();
                        while (k){
                          double enregistrement = rs2.getDouble(col);
                           resultat = resultat+"-"+enregistrement;
                           k=rs2.next();
                          
                        }
                        
                } catch (SQLException e) {
                 System.out.println("Anomalie lors de l'execution de la requête");
                 }
                 
    return resultat;}
//
public static Double ValeurStock(){
    double resultat = 0.0;

    String reqS ="Select * from stock where qnt>0";
    String ids = DataBase.RecuperationIntegerSeparer(reqS, "id_produit");
    String qnts = DataBase.RecuperationIntegerSeparer(reqS, "qnt");

    
   String[] idp = ids.split("-");
   String[] qntp = qnts.split("-");
   
   
   for (int i=1;i<idp.length;i++){
   
   String reqprice= "select * from entree_stock where  id_estock=(select max(id_estock) from entree_stock where id_produit="+idp[i]+")";
    if(DataBase.RecuperationDouble(reqprice,"prix_achat")>0){
    double price = DataBase.RecuperationDouble(reqprice, "prix_achat");
   
   
  
           int qn = Integer.parseInt(qntp[i]);
            double ttl = (Double) price*qn;
           resultat = resultat +ttl;
        }
   }
   

return resultat;}
public static int CompteurInt(String req){
  int resultat=0;
              try {
                 statement =  connexion.createStatement();
                 ResultSet rs2 = statement.executeQuery(req);

                 boolean k=rs2.next();
                        while (k){
                            resultat++;
                            k=rs2.next();
                        }
                        
                } catch (SQLException e) {
                 System.out.println("Anomalie lors de l'execution de la requête");
                 }
    
return resultat;}
public static int SommeInt(String req, String col){
  int resultat=0;
              try {
                 statement =  connexion.createStatement();
                 ResultSet rs2 = statement.executeQuery(req);

                 boolean k=rs2.next();
                        while (k){
                            resultat=resultat+rs2.getInt(col);
                            k=rs2.next();
                        }
                        
                } catch (SQLException e) {
                 System.out.println("Anomalie lors de l'execution de la requête");
                 }
    
return resultat;}
public static Double SommeDouble(String req, String col){
  Double resultat=0.0;
              try {
                 statement = connexion.createStatement();
                 ResultSet rs2 = statement.executeQuery(req);

                 boolean k=rs2.next();
                        while (k){
                            resultat=resultat+rs2.getDouble(col);
                            k=rs2.next();
                        }
                        
                } catch (SQLException e) {
                 System.out.println("Anomalie lors de l'execution de la requête SommeDouble");
                 }
    
return resultat;}
//
public boolean checkdb(String req) throws SQLException, ClassNotFoundException{
            boolean k=false;
            connect();
            
            int cn = RecuperationInt(req,"cnt");
        
if (cn>0) {
   k=true;
}
           

this.close();
            
            return k;
}

public static ArrayList<String> RecuperationArrayList(String req, String col){
  ArrayList<String> resultat = new ArrayList<String>();
              try {
                 statement = connexion.createStatement();
                 ResultSet rs2 = statement.executeQuery(req);

                 boolean k=rs2.next();
                        while (k){
                           String enregistrement = rs2.getString(col);
                           resultat.add(enregistrement);
                           k=rs2.next();
                          
                        }
                        
                } catch (SQLException e) {
                 System.out.println("Anomalie reque: "+req);
                 }
     
    return resultat;}

public static ArrayList<Integer> RecuperationArrayListInt(String req, String col){
  ArrayList<Integer> resultat = new ArrayList<Integer>();
              try {
                 statement = connexion.createStatement();
                 ResultSet rs2 = statement.executeQuery(req);

                 boolean k=rs2.next();
                        while (k){
                           int enregistrement = rs2.getInt(col);
                           resultat.add(enregistrement);
                           k=rs2.next();
                          
                        }
                        
                } catch (SQLException e) {
                 System.out.println("Anomalie reque: "+req);
                 }
     
    return resultat;}

public static ArrayList<Vector> RecuperationArrayListVector4(String req){
  ArrayList<Vector> resultat = new ArrayList<Vector>();
              try {
                 statement = connexion.createStatement();
                 ResultSet rs2 = statement.executeQuery(req);

                 boolean k=rs2.next();
                        while (k){
                            String name = rs2.getString(1);
                           int qnt = rs2.getInt(2);
                           double pr = rs2.getDouble(3);
                           double tt = rs2.getDouble(4);
                           
                           Vector vect = new Vector();
                           vect.add(name);
                           vect.add(qnt);
                           vect.add(pr);
                           vect.add(tt);
                           
                           resultat.add(vect);
                           k=rs2.next();
                          
                        }
                        
                } catch (SQLException e) {
                 System.out.println("Anomalie reque: "+req);
                 }
     
    return resultat;}
public static ArrayList<Vector> RecuperationArrayListVector5(String req){
  ArrayList<Vector> resultat = new ArrayList<Vector>();
              try {
                 statement = connexion.createStatement();
                 ResultSet rs2 = statement.executeQuery(req);

                 boolean k=rs2.next();
                        while (k){
                            int id = rs2.getInt(1);
                            String name = rs2.getString(2);
                           double pr = rs2.getDouble(3);
                            int qnt = rs2.getInt(4);
                           double tt = rs2.getDouble(5);
                           
                           Vector vect = new Vector();
                           vect.add(id);
                           vect.add(name);
                           vect.add(pr);
                           vect.add(qnt);
                           vect.add(tt);
                           
                           resultat.add(vect);
                           k=rs2.next();
                          
                        }
                        
                } catch (SQLException e) {
                 System.out.println("Anomalie reque: "+req);
                 }
     
    return resultat;}

public static ResultSet GetResult(String req){
       ResultSet rs = null;
                
    try {
        statement = connexion.createStatement();
        rs = statement.executeQuery(req);
          
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
  return rs;}
}
