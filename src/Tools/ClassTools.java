/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;


import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Eurequat-Algerie
 */
public class ClassTools {
    
    public static DataBase database = new DataBase();
    
    // Close Jframe 
    public  void close(JFrame jframe) {
      WindowEvent winClosingEvent = new WindowEvent(jframe,WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

    }
    
    // Request netx JtextField
    public  void nextTextField(JTextField a, java.awt.event.KeyEvent evt ){
    
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             a.requestFocus();
         }
        
    }

    // Populating JTREE  2 table 
    // ex : req = "SELECT idfamille,designation from famille"
    //  sreq = "SELECT designation from sous_famille where idfamille=
    public final void pop_tree(JTree tree,String title, String req,String sreq) {
        try {
 
            
            Statement stm = database.connect();
            
            ArrayList list = new ArrayList();
            list.add(title);
            String sql = req;
            
            ResultSet rs = stm.executeQuery(sql);
 
            while (rs.next()) {
                Object value[] = {rs.getString(1), rs.getString(2)};
                list.add(value);
            }
            
            Object hierarchy[] = list.toArray();
            DefaultMutableTreeNode root = processHierarchy(hierarchy,req,sreq);
            DefaultTreeModel treeModel = new DefaultTreeModel(root);
            tree.setModel(treeModel);
        } catch (Exception e) {
        }
 
    }
    @SuppressWarnings("CallToThreadDumpStack")
    public DefaultMutableTreeNode processHierarchy(Object[] hierarchy,String req1, String req) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(hierarchy[0]);
        try {
            int ctrow = 0;
            int i = 0;
            try {
 
                Statement stm = database.connect();
                
                String sql = req1;
                ResultSet rs = stm.executeQuery(sql);
 
                while (rs.next()) {
                    ctrow = rs.getRow();
                }
                String L1Nam[] = new String[ctrow];
                String L1Id[] = new String[ctrow];
                ResultSet rs1 = stm.executeQuery(sql);
                while (rs1.next()) {
                    L1Nam[i] = rs1.getString(2);
                    L1Id[i] = rs1.getString(1);
                    i++;
                }
                DefaultMutableTreeNode child, grandchild;
                for (int childIndex = 0; childIndex < L1Nam.length; childIndex++) {
                    child = new DefaultMutableTreeNode(L1Nam[childIndex]);
                    node.add(child);//add each created child to root
                    String sql2 = req + L1Id[childIndex];
                    ResultSet rs3 = stm.executeQuery(sql2);
                    while (rs3.next()) {
                        grandchild = new DefaultMutableTreeNode(rs3.getString(1));
                        child.add(grandchild);//add each grandchild to each child
                    }
                }
 
            } catch (Exception ex) {
                ex.printStackTrace();
            }
 
        } catch (Exception e) {
        }
 
        return (node);
    }
    
    
    
    // Fill combobox 
    
     public static void FillCombo(JComboBox combo,String req){
        
       database.connect();
        ResultSet rs2 = database.GetResult(req);
        try {
            while(rs2.next()){
                int id;
                String nom= rs2.getString(1);
                combo.addItem(nom);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.close();
        
    }
       public static void FillCombo1(JComboBox combo,String req){
        
       database.connect();
        ResultSet rs2 = database.GetResult(req);
        try {
            while(rs2.next()){
                int id;
                String nom= rs2.getInt(1)+"."+rs2.getString(2);
                combo.addItem(nom);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.close();
        
    }
    
    //Check 
    
    public int checkDate(String date, int i){
        String[] sp = date.split("-");
        if(sp.length==3){
            if(sp[0].length()==4 && sp[1].length()==2 && sp[2].length()==2  ){
                  i++;
            }
        }
    return i;}
    
    
}
