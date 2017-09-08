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
package gamemarkstudio.dailywork;

import gamemarkstudiio.DataConnection.ConnectionClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class is written to handle the methods of class DailyTask.
 * @version 1.10 25 Aug 2017
 * @author Hamza Yasin
 */

public class DailyTaskHandling {
   
    private static ArrayList<DailyTask> dailylist = new ArrayList();
    /* Loading the data from database*/
    public static boolean Load() 
    {
         if(!dailylist.isEmpty())
            return false;
        ResultSet resultSet = ConnectionClass.selectQuery("select * from dailywork;");
        try{
            while(resultSet.next()){
            dailylist.add(new DailyTask(Integer.parseInt(resultSet.getObject(1).toString()), 
                    resultSet.getObject(2).toString(), 
                    resultSet.getObject(3).toString(), 
                    resultSet.getString(4), 
                    resultSet.getString(5)));
            }
            System.out.println("loaded with size of " + dailylist.size());
        }catch(SQLException e){
            e.getMessage();
        }
        return true;
        
      } 
    /* Saving data in database*/
    public static void Save(DailyTask dt) {       
         try {
        // unique(dt); (sr, attndnc, work, assignTime, assignStatus)"
         ConnectionClass.query("insert into dailywork " +
                 "values ("+ dt.getId()+", '"
                 + dt.getAttndnc()+"', '"
                 +dt.getWork()+"', '"
                 +dt.getAssignDate()+"', '"
                 +dt.getAssignStatus()+"');");
         dailylist.add(dt);
         }catch(IllegalArgumentException e){
             e.getMessage();
            throw new IllegalArgumentException("Employee Against this id don't exist");
        }
     }
      /* Deleting single data from database*/
    public static void DeleteRecord(DailyTask dt)
   {
       try {
       Load();    
       ConnectionClass.query("DELETE FROM dailwork WHERE sr = "+ dt.getId() + ";");
       }catch(Exception e)
       {
        throw new IllegalArgumentException(e.getMessage());
       } 
   }
    /* Deleting the whole data from database*/
    public static void DeleteAllData(DailyTask dt)
   {
       try {
       Load();
       for (int i = 0; i< dailylist.size(); i++){
       ConnectionClass.query("DELETE FROM personalinfo WHERE sr = "+ dailylist.get(i).getId() + ";");
       }
       }catch(Exception e)
       {
         throw new IllegalArgumentException(e.getMessage());
       }
       
   }
    /* Cleaing the ArrayList*/
    public static void arrayDispose()
    {
        dailylist.clear();
    }
   /* Getting the data in ArrayList*/
    public static ArrayList<DailyTask> getArray()
   {
       return dailylist;
   }
    /* Updating data in database*/  
    public static void UpdateRecord(DailyTask dt)
   {
       try {
       Load();
       ConnectionClass.query("UPDATE dailywork SET attndnc = '" + dt.getAttndnc()  
               + "',work = '"
               + dt.getWork() 
               + "'WHERE sr = " 
               + dt.getId() +" ;");
       }catch(Exception e)
       {
          throw new IllegalArgumentException(e.getMessage());
       }
         
   }   
}
