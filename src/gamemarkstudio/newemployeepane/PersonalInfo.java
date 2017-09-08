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
package gamemarkstudio.newemployeepane;

import java.io.ByteArrayOutputStream;

/*
 * @version 1.10 25 Aug 2017
 * @author Hamza Yasin
 */
public class PersonalInfo {
    
    private int id = 0;
    private String name;
    private String address;
    private String cnic;
    private String phone;
    private String eName;
    private String ePhone;
    private byte[] pic;
    private String dob;
    private String email;
    private ByteArrayOutputStream img;
    private String post;
    private double salary;
    private String timing;
  

    public PersonalInfo(int id, String name, String phone ,String cnic, String eName , String ePhone , String address, String dob , String email ,byte[] pic,
                String post, double sal, String timing) {
        setId(id);
        setName(name);
        setAddress(address);
        setCnic(cnic);
        setPhone(phone);
        seteName(eName);
        setePhone(ePhone);
        setPic(pic);
        setDob(dob);
        setEmail(email);
        setPost(post);
        setSalary(sal);
        setTiming(timing);
        
        
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

    public void setPost(String post) {
        this.post = post;
    }

    public boolean setSalary(double salary) {
        if(salary > 0)
        this.salary = salary;
        else
         throw new IllegalArgumentException("Salary must be in positive Integers.");
        return true;    
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCnic(String cnic) {
       
        this.cnic = cnic;

    }

    public void setPhone(String phone) {
         this.phone = phone;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public void setePhone(String ePhone) {
         this.ePhone = ePhone;
        
    }

    public void setPic(byte[] pic) {
        this.pic = pic;  
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
      
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCnic() {
        return cnic;
    }

    public String getPhone() {
        return phone;
    }

    public String geteName() {
        return eName;
    }

    public String getePhone() {
        return ePhone;
    }

    public byte [] getPic()
    {
        if(img != null)
             return img.toByteArray();
        else 
            return pic;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPost() {
        return post;
    }

    public double getSalary() {
        return salary;
    }

    public String getTiming() {
        return timing;
    }
    
    
  
    
    
    
}
