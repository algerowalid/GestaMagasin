/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumMap;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import sarl_el_itraa.Main;


/**
 *
 * @author Eurequat-Algerie
 */
public class tools {
    
    public static final int STATUS_COL = 7;
    
    public static  void tablealigne(JTable table) {
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    int column=table.getColumnCount();

    for(int i=0;i<column;i++){
    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }
    
    }
    public static class HeaderRenderer implements TableCellRenderer {

    DefaultTableCellRenderer renderer;

    public HeaderRenderer(JTable table) {
        renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int col) {
        return renderer.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, col);
    }
} 
    
     public static void EnteteTable(JTable table, ArrayList<String> list){
    
         TableColumn column = null;

         
         for (int i = 0; i <list.size(); i++) {
            column = table.getColumnModel().getColumn(i);
            table.getColumnModel().getColumn(i).setHeaderValue(list.get(i));
          }
   
           JTableHeader header = table.getTableHeader();
           header.setDefaultRenderer(new tools.HeaderRenderer(table));
        
           tools.setCellsAlignment(table, SwingConstants.CENTER);
      
    }
     
     
       public static void setCellsAlignment(JTable table, int alignment)
    {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }
    
    
    public static void heure(final JLabel dd){

     ActionListener updateClockAction = new ActionListener() {
     public void actionPerformed(ActionEvent e) {
     Calendar cal =new GregorianCalendar();
     int month= cal.get(Calendar.MONTH);
     int day= cal.get(Calendar.DAY_OF_MONTH);
     int year = cal.get(Calendar.YEAR);
     
     
     String dy,mt;
     if(day<10){dy="0"+day;}else{dy=String.valueOf(day);};
     if((month+1)<10){mt="0"+(month+1);}else{mt=String.valueOf((month+1));};
      String date= dy+"-"+mt+"-"+year;
   
     String heur=String.format("%tT", new java.util.Date());
     dd.setText(date+" "+"Heure: "+heur); 
    }
};            
                javax.swing.Timer t = new javax.swing.Timer(1000, updateClockAction);
                t.start();
    
    
    }
    public static String jour(){
       
     Calendar cal =new GregorianCalendar();
     int month= cal.get(Calendar.MONTH)+1;
     int day= cal.get(Calendar.DAY_OF_MONTH);
     int year = cal.get(Calendar.YEAR);
     
     String mnt =String.valueOf(month);
     String dy=String.valueOf(day);
     
     if (month<10){ mnt="0"+mnt; }
     if (day<10){ dy="0"+dy; }
     
     
      String date= year+"-"+mnt+"-"+dy;
   
     String heur=String.format("%tT", new java.util.Date());
    
    return date;}
    
    
      public static String getheure(){
       
     String heur=String.format("%tT", new java.util.Date());
    
    return heur;}
   
    public static void disablePanel(JPanel p){
       int a =p.getComponentCount();
       for (int i=0; i<a;i++){
       p.getComponent(i).setEnabled(false);      
       }
       p.setVisible(false);
    }
   
    public static void enablePanel(JPanel p){
       int a =p.getComponentCount();
       for (int i=0; i<a;i++){
       p.getComponent(i).setEnabled(true);      
       }
       p.setVisible(true);
    }
    
    public static void disableOnly(JPanel p){
       int a =p.getComponentCount();
       for (int i=0; i<a;i++){
       p.getComponent(i).setEnabled(false);      
       }
       }
     
    public static void enableOnly(JPanel p){
       int a =p.getComponentCount();
       for (int i=0; i<a;i++){
       p.getComponent(i).setEnabled(true);      
       }
      
    }
    
    public static void searchImage(JLabel image, String p,String lien){

    lien = lien+"//src//produit//";
    File folder = new File(lien);
    

    p=p.toUpperCase();
       
    File[] listOfFiles = folder.listFiles();
    Arrays.sort(listOfFiles);
    ArrayList<String> names = new ArrayList<String>();
    String file = null;
    
           ArrayList<Integer> compteur = new ArrayList<Integer>();
   
       
       String[] part = p.split(" ");
       int size = part.length;
       

          for (int i = 0; i < listOfFiles.length; i++) {
                  file = listOfFiles[i].getName();
                  if(file.contains(part[0])){
                  names.add(file);
                  compteur.add(0);
                  }
            }
          
          
          
      if(size!=0){
          
 
       for(int k=1; k<size;k++){
           
          for (int i = 0; i < names.size(); i++) {
                  file = names.get(i);
                  if(file.contains(part[k])){
                      int a = compteur.get(i);
                      a++;
                      compteur.set(i,a);
                  }
       }              
            }
       
        
       
          for(int i=1; i<compteur.size();i++){
            int a,b;
            a=compteur.get(i-1);
            b=compteur.get(i);
            String m,l;
              if(b<a && b!=50){
               compteur.set(i, a);
               compteur.set(i-1,b);
               
               m=names.get(i);
               l=names.get(i-1);
               names.set(i, l);
               names.set(i-1, m);

              i=1;    
              }else if(a==b){
              int f,t ; 
              f= names.get(i).length();
              t = names.get(i-1).length();
                //     System.out.println(names.toString());
              
              if(f>t){
               m=names.get(i);
               l=names.get(i-1);
               names.set(i, l);
               names.set(i-1, m);
               compteur.set(i, 50);
      
              
              }
              
              }// fin else a==b
              
          }
         
          
          }
         
          if(names.size()>0){
 
                BufferedImage imag = null;
                    try 
                    {
                        imag = ImageIO.read(new File(lien+names.get(names.size()-1)));

                 
                    } catch (Exception e) 
                    {
                        e.printStackTrace();
                    }

                ImageIcon imageIcon = new ImageIcon(fitimage(imag, image.getWidth(), image.getHeight()));
               image.setIcon(imageIcon);
    
    
          }else{
                  BufferedImage imag = null;
        try {
            imag = ImageIO.read(new File(lien+"noimage.png"));
        } catch (IOException ex) {
            Logger.getLogger(tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ImageIcon imageIcon = new ImageIcon(fitimage(imag, image.getWidth(), image.getHeight()));
          image.setIcon(imageIcon);
          }
    
    
    }
    
   public static Image fitimage(Image img , int w , int h){
    BufferedImage resizedimage = new BufferedImage(w,h,BufferedImage.TRANSLUCENT );
  
    Graphics2D g2 = resizedimage.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(img, 0, 0,w,h,null);
    g2.dispose();
    return resizedimage;
}

    
    public static void totalInt(JTextField ttl,int ajout, int operation){
    
          // flag operation 0: add       1:soustract
    int tt = Integer.parseInt(ttl.getText());
    if(operation==0){
        tt =tt+ajout;
    }else{
        tt =tt-ajout;
        if(tt<0){tt=0;}
    }
      
    ttl.setText(String.valueOf(tt));
    }
    
    public static void totalDouble(JLabel ttl, ArrayList<Vector> element, int pos){
    
  
        double tt=0.0;
        for(int i=0; i<element.size();i++){
        tt = tt+Double.parseDouble(element.get(i).get(pos).toString());
        }
      
    ttl.setText(String.valueOf(tt));
    }
        
    public static String nextDate(String date, int days){
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(date));
            c.add(Calendar.DATE, days);  // number of days to add
            date = sdf.format(c.getTime());  // dt is now the new dat
            
            
        } catch (ParseException ex) {
            Logger.getLogger(tools.class.getName()).log(Level.SEVERE, null, ex);
        }
return date;}

    public static Date Newdate(String dt, int jour)  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, jour);  // number of days to add
        dt = sdf.format(c.getTime());
        Date resd = null;
        try {
            resd= sdf.parse(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return resd;}

    public Date setCurrentDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        String dd="",mm="";
        if(day<10){
            dd="0"+day;
        }else{
            dd=""+day;
        }

        if((month+1)<10){
            mm="0"+(month+1);
        }else{
            mm=""+(month+1);
        }

         date = year + "-" + mm + "-" + dd;
        Date resd = null;
        try {
            resd= sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

      return resd;
    }

    public static long getDateDiffString(String dateOne, String dateTwo)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1= null;
        Date dt2= null;
        try {
            dt1 = sdf.parse(dateOne);
            dt2 = sdf.parse(dateTwo);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        long timeOne = dt1.getTime();
        long timeTwo = dt2.getTime();
        long oneDay = 1000 * 60 * 60 * 24;
        //long delta = (timeTwo - timeOne) / oneDay;
        long delta = (timeTwo- timeOne) / oneDay;
        
        return delta;
    }

        public String GetTodayDate() {
            String date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        String dd="",mm="";
        if(day<10){
            dd="0"+day;
        }else{
            dd=""+day;
        }

        if((month+1)<10){
            mm="0"+(month+1);
        }else{
            mm=""+(month+1);
        }

         date = year + "-" + mm + "-" + dd;
        

      return date;
    }
    
    public  Image requestImage(String lien) {
        Image image = null;

        try {
            image = ImageIO.read(new File(lien));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    
    public static boolean connectionAdr(String k){
    
    boolean a=false;
        try {
            InetAddress inet;
            
            //inet = InetAddress.getByAddress(ae);
            inet = InetAddress.getByName(k);
            a=inet.isReachable(3000);
                    
        } catch (UnknownHostException ex) {
            Logger.getLogger(tools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return a;}
    
    
    public void toExcel(JTable table, File file){
    try{
        TableModel model = table.getModel();
        FileWriter excel = new FileWriter(file);

        for(int i = 0; i < model.getColumnCount(); i++){
            excel.write(model.getColumnName(i) + "\t");
        }

        excel.write("\n");

        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount(); j++) {
                excel.write(model.getValueAt(i,j).toString()+"\t");
            }
            excel.write("\n");
        }

        excel.close();

    }catch(IOException e){ System.out.println(e); }
}


    public static  String getUrl(URL url , String Package_Name){

  	String jarPath = null;
  	String result = "";
        

        try {
			jarPath = URLDecoder.decode(url.getFile(), "UTF-8"); //Should fix it to be read correctly by the system
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
    String parentPath = new File(jarPath).getParentFile().getPath(); //Path of the jar
      
    parentPath = parentPath + File.separator;
    parentPath  =  parentPath .replaceAll("\\\\","/");         

        String[] parts = parentPath.split("/");
    
         
         
   for(int i=0;i<parts.length;i++){
   result = result +parts[i]+"//";
   if(parts[i].startsWith(Package_Name)){
      i=parts.length;
   }
   
}



return result;}


    public static JTable getNewRenderedTable(JTable table) {
       
        final String today = jour();
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                String status = (String)table.getModel().getValueAt(row, STATUS_COL);
                if (today.equals(status)) {
                    setBackground(Color.YELLOW);
                    setForeground(Color.BLACK);
                } else {
                    setBackground(table.getBackground());
                    setForeground(table.getForeground());
                }       
                return this;
            }   
        });
        return table;
    }

    
    public static String GetJtext(JTextField a){
        String re = "";
        if(a.getText().trim().length()>0){
        re = a.getText().replaceAll("'", "''");
        }else{
        re="";}
    
    return re;}
    
    public static void QRcode(String myCodeText){
   
   		String filePath = Main.Link+"src//badge//qrcode.png";
		int size = 250;
		String fileType = "png";
		File myFile = new File(filePath);
		try {
			
			Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			
			// Now with zxing version 3.2.1 you could change border size (white border size to just 1)
			hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
 
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix byteMatrix = qrCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE, size,
					size, hintMap);
			int CrunchifyWidth = byteMatrix.getWidth();
			BufferedImage image = new BufferedImage(CrunchifyWidth, CrunchifyWidth,
					BufferedImage.TYPE_INT_RGB);
			image.createGraphics();
 
			Graphics2D graphics = (Graphics2D) image.getGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
			graphics.setColor(Color.BLACK);
 
			for (int i = 0; i < CrunchifyWidth; i++) {
				for (int j = 0; j < CrunchifyWidth; j++) {
					if (byteMatrix.get(i, j)) {
						graphics.fillRect(i, j, 1, 1);
					}
				}
			}
			ImageIO.write(image, fileType, myFile);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriterException ex) {
            Logger.getLogger(tools.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   }
    public static boolean checkMail(String mail){
   boolean a=false;
    Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
    Matcher m = p.matcher(mail);
    a = m.matches();
   
   return a;} 
    
   
   
   public static void ShutdownPc() throws IOException{
    Runtime runtime = Runtime.getRuntime();
    Process proc = runtime.exec("shutdown -s -f -t 0");
    System.exit(0);
}
   
   public static void RestartPc() throws IOException{
    Runtime runtime = Runtime.getRuntime();
    Process proc = runtime.exec("shutdown -r -f -t 0");
    System.exit(0);
}
   
}