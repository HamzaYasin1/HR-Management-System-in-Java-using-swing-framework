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

/*
 * @version 1.10 25 Aug 2017
 * @author Hamza Yasin
 */

public class UploadWork {
   
    
    private String gameDescription;
    private int idGame = 1;
    private String uploadDate;
    private String developerName;
    private String designerName;
    private String gameLink;
    
    /* Constructor */
    public UploadWork(int id, String gameDescription, String uploadDate, String developerName, String designerName, String gameLink) {
      
        setIdGame(id);
        setGameDescription(gameDescription);
        setUploadDate(uploadDate);
        setDeveloperName(developerName);
        setDesignerName(designerName);
        setGameLink(gameLink);
        
    }


      public boolean setIdGame(int id) {
       if (id > 0)
         this.idGame = id;
       else {
         this.idGame = id *-1;
        throw new IllegalArgumentException("Game ID must be in positive Integers.");
       }
       return true;
    }
    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    public void setGameLink(String gameLink) {
        this.gameLink = gameLink;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public String getDesignerName() {
        return designerName;
    }

    public String getGameLink() {
        return gameLink;
    }
    public int getIdGame()
    {
        return idGame;
    }
   
 
    
    
}
