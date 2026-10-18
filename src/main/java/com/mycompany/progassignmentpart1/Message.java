/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progassignmentpart1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Student
 */
public class Message {
    public String MessageID;
    public String RecipientCell;
    public String MessageHash;
    public String MessageNumber;
    public String MessageText;
    
   
    
    public Message(String recipientCell, String messageText, int messageNumber ) {
        this.MessageID = generateMessageID();
        this.RecipientCell = RecipientCell;
        this.MessageNumber = MessageNumber;
        this.MessageHash = createMessageHash();
        this.MessageText = MessageText;
    }
    
    public String generateMessageID (){
        Random rand = new Random();
        for (int i = 0; i < 10; i++ ){
    }
        return MessageID;
    }
    
    
    public boolean checkMessageID (String MessageID){ 
         if ( MessageID.length()<=10){ 
          return true; 
        }else{ 
          return false; 
      }   
    } 
     
    public String checkRecipientCell() {
    if (RecipientCell.startsWith("+27") && RecipientCell.length() <= 13) {
        return "Cell phone number successfully captured.";
    }
    return "Cell phone number is incorrectly formatted or does not contain "
            + "an international code. Please correct the number and try again.";
}
     
     public String checkMessageLength() { 
 
    if (MessageText.length() <= 250) { 
        return "Message ready to send."; 
    }
       return "Please enter a message of less than 250 characters."; 
 
     }
    
      
     
     
    public String createMessageHash(){ 
      String Message = MessageID.substring(0, 2);
        String[] words = MessageText.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", "").toUpperCase();
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "").toUpperCase();
        this.MessageHash = Message + ":" + MessageNumber + ":" + firstWord + lastWord;
        return this.MessageHash;
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
  
public String printMessages(){
    return "Message ID: " + MessageID + "\n"
                + "Message Hash: " + MessageHash + "\n"
                + "Recipient: " + RecipientCell + "\n"
                + "Message: " + MessageText;
}

public static int getTotalMessages(int totalMessages){
        
    return totalMessages;
}
// return the total number of messages sent.
public static int returnTotalMessages(int totalMessagesSent){
    return totalMessagesSent;
}

       //Stores the message to a JSON file (messages.json) so it can be sent
     // later. Appends to the file if it already exists.  

public void storeMessage(){
    String json = "{" 
            + "\"MessageID\":\"" +MessageID +"\","
            + "\"RecipientCell\":\"" +RecipientCell +"\","
            + "\"message\":\"" + MessageText.replace("\"", "\\\"") + "\""
                    + "}";

          try (FileWriter writer = new FileWriter("messages.json", true)) {
            writer.write(json + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error storing message: " + e.getMessage());
        }
    }
 public String getMessageId() { return MessageID; }
    public String getMessageHash() { return MessageHash; }
}


