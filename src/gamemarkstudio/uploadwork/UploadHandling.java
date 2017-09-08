/*
 * %W% %E% Hamza Yasin
 *
 * Copyright (c) 2017-2018 Miranz Technology. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Miranz
 * technology. You shall not disclose such Confidential Information and 
 * shall use it only in accordance with the terms of the license agreement 
 * you entered into with Miranz.
 *
 */
package gamemarkstudio.uploadwork;

import gamemarkstudiio.DataConnection.ConnectionClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*
 * @version 1.10 25 Aug 2017
 * @author Hamza Yasin
 */


public class UploadHandling {
 
    private static ArrayList<UploadWork>upload = new ArrayList();
    
    public static boolean load()
   {
       if (!upload.isEmpty())
            return false;
        
        ResultSet resultSet = ConnectionClass.selectQuery("SELECT * FROM gms.uploadwork;");
        
        if(resultSet == null)
            return false;
        
         try{
            while(resultSet.next()){
                
              upload.add(new UploadWork(Integer.parseInt(resultSet.getObject(1).toString()),resultSet.getObject(2).toString(),
                      resultSet.getObject(3).toString(),resultSet.getObject(4).toString(), resultSet.getObject(5).toString(), 
                      resultSet.getObject(6).toString()));
            }
            System.out.println("loaded with size of " + upload.size());
        }catch(SQLException e){
        }
       return true;
   }
     
     
       public static void save(UploadWork up)
   {
       try {
           
        uniqueCheck(up);
       ConnectionClass.query("Insert into uploadwork ( id, description, upload_date, developer_name, designer_name, game_link)\n" + "values ( "+up.getIdGame()+ 
               ",'"+ up.getGameDescription()+"', '"
               + up.getUploadDate()+"','" + up.getDeveloperName()+ "', '" +up.getDesignerName()+"', '" + up.getGameLink() + "' );");
       upload.add(up);
       
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
            
   } 
       
        private static void uniqueCheck(UploadWork up)
    {
        for(int i=0; i<upload.size(); i++)
        {
            if(up.getIdGame() == upload.get(i).getIdGame())
                throw new IllegalArgumentException("Record against this id '"+ up.getIdGame() +"' already exist ");            
        }
    }
        
        public static void DeleteRecord( UploadWork up)
   {
       try {
       load();
             
       ConnectionClass.query("DELETE FROM uploadwork WHERE id = "+ up.getIdGame()+ ";");
      
       }catch(Exception e)
       {
            throw new IllegalArgumentException(e.getMessage());
       }
   }
   
   public static ArrayList<UploadWork> search(String search) 
    {
        load();
        ArrayList<UploadWork> send = new ArrayList();
        
        for (int i = 0; i < upload.size(); i++)
        {
            if (String.valueOf(upload.get(i).getIdGame()).toUpperCase().contains(search.toUpperCase()))
                send.add(upload.get(i));
            else if (upload.get(i).getDesignerName().toUpperCase().contains(search.toUpperCase()))
                send.add(upload.get(i));
            else if (upload.get(i).getDeveloperName().toUpperCase().contains(search.toUpperCase()))
                send.add(upload.get(i));
            else if (upload.get(i).getGameDescription().toUpperCase().contains(search.toUpperCase()))
                send.add(upload.get(i));
            else if (String.valueOf(upload.get(i).getUploadDate()).toUpperCase().contains(search.toUpperCase()))
                send.add(upload.get(i)); 
           
        }
        arrayDispose();
        return send;
        
    }
     public static void arrayDispose()
    {
        upload.clear();
    }
    
     
     public static void UpdateRecord(UploadWork up)
   {
       try {
       
       load();
     
       ConnectionClass.query("UPDATE uploadwork SET description = '" + up.getGameDescription()+ "', upload_date = '"+ up.getUploadDate()+
               "', developer_date = '"+ up.getDeveloperName() + "', designer_name = '" + up.getDesignerName() + "', game_link = '" + up.getGameLink()
               + " ' WHERE id = " + up.getIdGame() +" ;");
       
       }catch(Exception e)
       {
          throw new IllegalArgumentException(e.getMessage());
       }
         
   }
        public static ArrayList<UploadWork> getArray()
   {
       return upload;
   }
    
    
}
