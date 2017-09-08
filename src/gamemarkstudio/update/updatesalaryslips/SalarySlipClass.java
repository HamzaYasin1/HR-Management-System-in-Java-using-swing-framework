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
package gamemarkstudio.update.updatesalaryslips;
/*
 * @version 1.10 25 Aug 2017
 * @author Hamza Yasin
 */

public class SalarySlipClass {
    
    private int id;
    private String name;
    private String post;
    private String monthName;
    private int totalWorkingDays;
    private double advance;
    private double deduction;
    private String date;
    private double netSalary;

    /* Constructor */
    public SalarySlipClass(int id, String name, String post, String monthName, int totalWorkingDays, double advance, double deduction, double netSalary ,String date) {
        setId(id);
        setName(name);
        setPost(post);
        setMonthName(monthName);
        setTotalWorkingDays(totalWorkingDays);
        setAdvance(advance);
        setDeduction(deduction);
        setNetSalary(netSalary);
        setDate(date);
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
      
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean setNetSalary(double netSalary) {
        if (netSalary > 0)
        this.netSalary = netSalary;
        else{
            this.netSalary = netSalary*-1;
            throw new IllegalArgumentException("Net Salary must be in positive integers.");
        }
        return true;
    }
        public void setPost(String post) {
        if (!post.equals("Choose"))
        this.post = post;
        else
            this.post = "Wrong Selection.";
    }

    public void setMonthName(String monthName) {
        if (!monthName.equals("Choose"))
        this.monthName = monthName;
        else
            this.monthName = "Wrong Selection.";
    }

    public boolean setTotalWorkingDays(int totalWorkingDays) {
        if (totalWorkingDays > 0)
        this.totalWorkingDays = totalWorkingDays;
        else {
            this.totalWorkingDays = totalWorkingDays*-1;
            throw new IllegalArgumentException("Working Days must be in positive integers.");
          }
         return true;
    }

    public boolean setAdvance(double advance) {
        if (advance > 0)
        this.advance = advance;
        else{
            this.advance = advance *-1;
            throw new IllegalArgumentException("Advance must be in positive integers.");
       }
        return true;
    }

    public boolean setDeduction(double deduction) {
        if (deduction > 0)
        this.deduction = deduction;
        else {
            this.deduction = deduction *-1;
            throw new IllegalArgumentException("Deduction must be in positive integers.");
        }
        return true;
    }

    public void setDate(String date) {
        if (!date.equals("Choose"))
            this.date = date;
        else 
            this.date = "Wrong Selection";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

    public String getMonthName() {
        return monthName;
    }

    public int getTotalWorkingDays() {
        return totalWorkingDays;
    }

    public double getGross() {
        return getNetSalary() - (getAdvance() + getDeduction());
    }

    public double getAdvance() {
        return advance;
    }

    public double getDeduction() {
        return deduction;
    }

    public String getDate() {
        return date;
    }

    public double getNetSalary() {
        return netSalary;
    }

    
    
    
    
    
    
}
