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

/**
 * @version 1.10 25 Aug 2017
 * @author Hamza Yasin
 */
public class DailyTask {
    private int id;
    private String attndnc;
    private String work;
    private String assignDate;
    private String assignStatus;

    /* Constructor */
    
    public DailyTask(int id, String attndnc, String work, String assignDate, String assignStatus) {
        setId(id);
        setAttndnc(attndnc);
        setWork(work);
        setAssignDate(assignDate);
        setAssignStatus(assignStatus);
    }

    public boolean setId(int id) {
        if (id > 0)
         this.id = id;
       else {
         this.id = id *-1;
        throw new IllegalArgumentException("Employee ID must be in positive Integers.");
       }
       return true;
    }


    public void setAttndnc(String attndnc) {
       if (!attndnc.equals("Choose"))
        this.attndnc = attndnc;
       else
           this.attndnc =  "Wrong Selection";
    }

    public void setWork(String work) {
        this.work = work;
    }
    
    public void setAssignDate(String assignDatel) {
        this.assignDate = assignDatel;
    }

    public void setAssignStatus(String assignStatus) {
        this.assignStatus = assignStatus;
    }

    public int getId() {
        return id;
    }

    public String getAttndnc() {
        return attndnc;
    }

    public String getWork() {
        return work;
    }
    
    public String getAssignDate() {
        return assignDate;
    }

    public String getAssignStatus() {
        return assignStatus;
    }
    
    
}
