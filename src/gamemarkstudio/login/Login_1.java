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
/**
 * @version 1.10 25 Aug 2017
 * @author Hamza Yasin
 */
public class Login_1 {
     
     private int sr = 1;
     private String login;
     private String password;
     private String question;
     private String answer;
     private String name;
     private String status;
     private String dateTime;
    /* Constructor */
    public Login_1( int sr, String login, String password, String question, String answer, String name, String status, String time)
    {
        setSr(sr);
        setLogin(login);
        setPassword(password);
        setQuestion(question);
        setAnswer(answer);
        setName(name);
        setStatus(status);
        setDateTime(time);
        
    }

    public Login_1(String question, String ans) {
        setQuestion(question);
        setAnswer(ans);
    }
    
    public void setDateTime(String time)
    {
        this.dateTime = time;
    }
    
    public void setSr(int sr)
    {
        this.sr = sr;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   public void setQuestion( String question)
   {
        this.question = question;
   }
    public boolean setLogin(String log)
    {
        login = log;
        return true;
    }
    
    public boolean setPassword(String pass)
    {
        password = pass;
        return true;
    }
    
    public String getLogin()
    {
        return login;
    }
    
    public String getPassword()
    {
        return password;
    }

    public String getAnswer() {
        return answer;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getQuestion() {
        return question;
    }
    
    public int getSr()
    {
        return sr ;
    }
    public String getDateTime()
    {
        return dateTime;
    }
    
    
    
}
