/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progassignmentpart1;

import java.util.Random;

/**
 *
 * @author Student
 */
public class Message {
    public String MessageID;
    public String RecipientCell;
    public String MessageHash;
    public String SentMessage;
    public String MessageLength;
    public String PrintMessage;
    
    public Message(String MessageID, String RecipientCell, String SentMessage, String MessageLength ) {
        this.MessageID = MessageID;
        this.RecipientCell = RecipientCell;
        this.SentMessage = SentMessage;
        this.MessageLength = MessageLength; // used while building the hash
    }
    
    public String generateMessageID (){
        Random rand = new Random();
        for (int i = 0; i < 10; i++ ){
    }
        return MessageID;
    }
    
    
    public boolean CheckMessageID (String MessageID){ 
         if ( MessageID.length()<=10){ 
          return true; 
        }else{ 
          return false; 
      }   
    } 
     
    public boolean CheckRecipientCell (String RecipientCell){ 
      return RecipientCell.startsWith("+27")&& RecipientCell.length()<=10; 
      } 
     
     public String checkMessageLength(String MessageLength) { 
 
    if (SentMessage.length() < 250) { 
        return "Message ready to send."; 
    }else{
       return "Please enter a message of less than 250 characters."; 
} 
     }
    
    public String createMessageHash(String MessageHash){ 
        if (MessageID == null && MessageID.contains("-")){ 
          return "-"; 
       }   
         return null; 
    } 
     
    public String SentMessage ( int choice){ 
          if (choice == 1){
        return "Message successfully sent."; 
          }else if (choice == 2){
                return "Press 0 to delete the message."; 
          }else if (choice == 3){
                 return "Message successfully stored."; 
          }else{ 
                return "Invalid option selected."; 
        } 
         
    } 
     
  
public String getMessageID() { return MessageID; } 
public String getRecipientCell() { return RecipientCell; } 
public String getMessageText() { return MessageText; } 
public String getMessageHash() { return MessageHash; } 
 

public String printMessages(){
    if (SentMessage.equals("")){
        return "No messages have been sent,";
    }else{
        return "Message sent";
    }
}

public static int getTotalMessages(int totalMessages){
        
    return totalMessages;
}

public static int returnTotalMessages(int returntotalMessages){
    return totalMessages;
}

        
        
        
        }

