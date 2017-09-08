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
package gamemarkstudio.login;

import gamemarkstudiio.DataConnection.ConnectionClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * This class is written to handle the methods of class Login_1.
 * @version 1.10 25 Aug 2017
 * @author Hamza Yasin
 */
public class LoginHandling {
    
   private static ArrayList<Login_1> loginList = new ArrayList();
    /* Loading the data from database*/   
   public static boolean load()
   {
       if (!loginList.isEmpty())
            return false;
        
        ResultSet resultSet = ConnectionClass.selectQuery("SELECT * FROM login;");
        
        if(resultSet == null)
            return false;
        
         try{
            while(resultSet.next()){
                
              loginList.add(new Login_1(Integer.parseInt(resultSet.getObject(1).toString()),resultSet.getObject(2).toString(),
                      resultSet.getObject(3).toString(),resultSet.getObject(4).toString(), resultSet.getObject(5).toString(), 
                      resultSet.getObject(6).toString(), resultSet.getObject(7).toString(), resultSet.getObject(8).toString()));
            }
            System.out.println("loaded with size of " + loginList.size());
        }catch(SQLException e){
        }
       return true;
   }
   /* Generating the unique Login ID*/
   public static int LoginID()
   {
         if (!loginList.isEmpty())
             return loginList.get(loginList.size()-1).getSr()+1;
         else
             return 1;
     
    }
   /* Getting Access to the login */  
   public static boolean access(String user, String pass)
   {
       load();
        for(int i=0; i<loginList.size(); i++)
        {
           if(loginList.get(i).getLogin().equals(user) && loginList.get(i).getPassword().equals(pass))
                return true;
        }
        return false;
   }
   /* Getting Security question*/
   public static String getQuestion(String username)
   {
       load();
       for(int i = 0; i < loginList.size(); i++)
       {
           if (loginList.get(i).getLogin().equals(username))
               return loginList.get(i).getQuestion();
       }
       return "";
   }
   /* Reseting the password */
   public static boolean resetMyPassword(String userName, String answer, String newPassword)
   {
       for(int i=0; i< loginList.size(); i++)
           if(loginList.get(i).getLogin().equals(userName))
           {
               if(loginList.get(i).getAnswer().toUpperCase().equals(answer.toUpperCase()))
               {
                   UpdateRecord(userName, loginList.get(i).getPassword(),  newPassword);
                   return true;
               }
           }
       return false;
   }
    /* Saving the  record in database*/
   public static void save(Login_1 login)
   {
       try {
           
        uniqueCheck(login);
       ConnectionClass.query("Insert into gms.login (srno, id, pass, question, answer, name, status, date_time)\n" + "values ( "+login.getSr()+ 
               ", '"+ login.getLogin()+"', '"
               + login.getPassword()+"','" + login.getQuestion()+ "', '" +login.getAnswer()+"', '" + login.getName()+"' , '"
               + login.getStatus()+ "','Not Available' );");
       loginList.add(login);
       
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
            
   } 
    /* Searching the result */
    public static Login_1 searchByID(int sr)
    {
        try
        {
            load();
            
            for(int i=0; i<loginList.size(); i++)
            {
                if(loginList.get(i).getSr() == sr)
                    return loginList.get(i);
            }
        }catch(Exception e){
        }
        return null;        
    }
   
    /* Deleting the record*/   
    public static void DeleteRecord(int srno)
    {
       try {
       load();
             
       ConnectionClass.query("DELETE FROM login WHERE id = "+srno+ ";");
       for(int i=0; i<loginList.size(); i++)
           if(srno == loginList.get(i).getSr())
           {
                loginList.remove(i);
                break;
           }
      
       }catch(Exception e)
       {
            throw new IllegalArgumentException(e.getMessage());
       }
    }
    /*Deleting record by ID*/        
    public static void DeleteRecordById(String username)
    {
       try {
       load();
             
       ConnectionClass.query("DELETE FROM login WHERE id = '"+ username+ "';");
       }catch(Exception e)
       {
            throw new IllegalArgumentException(e.getMessage());
       }
    }
     
    public static ArrayList<Login_1> search(String search)
    {
         load();
         ArrayList<Login_1> send = new ArrayList<>();
         for (int i =0; i < loginList.size();i++){
          if (loginList.get(i).getLogin().toUpperCase().contains(search.toUpperCase()))
                send.add(loginList.get(i));
         }
         arrayDispose();
         return send;
    }
     
    public static void arrayDispose()
    {
        loginList.clear();
    }
     
    /*Unique Check of ID*/ 
    private static void uniqueCheck(Login_1 login)
    {
        for(int i=0; i<loginList.size(); i++)
        {
            if(login.getLogin().equals(loginList.get(i).getLogin())){
                throw new IllegalArgumentException("Record against Login '"+login.getLogin() +"' already exist ");     
            }
        }
    }
     
     
       
    public static void UpdateRecord(String userName, String oldPassword, String newPassword)
    {
       try {
       
       load();
       boolean chk = false;
       
       for(int i=0; i<loginList.size(); i++)
           if(loginList.get(i).getLogin().equals(userName) && loginList.get(i).getPassword().equals(oldPassword))
           {
               chk = true;
               loginList.get(i).setPassword(newPassword);
               break;
           }
       
       if(!chk){
           throw new IllegalArgumentException("Please Enter Correct Information.");
       }
       ConnectionClass.query("UPDATE login SET pass = '"+ newPassword+ "' WHERE id = '" + userName+"' ;");
           
       }catch(IllegalArgumentException e)
       {
          throw new IllegalArgumentException(e.getMessage());
       }
         
    }
   
    public static ArrayList<Login_1> getArray()
    {
       return loginList;
    }
}

