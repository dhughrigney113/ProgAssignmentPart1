/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progassignmentpart1;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Student
 */
// part 2 
public class Message {
    public String MessageID;
    public String RecipientCell;
    public String MessageHash;
    public int MessageNumber;
    public String MessageText;
    
   
    
    public Message(String RecipientCell, String MessageText, int MessageNumber ) {
        this.RecipientCell = RecipientCell;
        this.MessageNumber = MessageNumber;
        this.MessageText = MessageText;
        this.MessageID = generateMessageID();
        this.MessageHash = createMessageHash();
        
    }
     // Creates a random 10 digit ID
    public String generateMessageID (){
        Random rand = new Random();
         String id = "";
    for (int i = 0; i < 10; i++) {
        id = id + rand.nextInt(10);   // adds one random digit each time
    }
    return id;
    }
    
    // Checks that the ID is not longer than 10 characters
    // Returns true if it is OK and false if it is too long
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
    int length = MessageText.length();
       if (length <= 250) 
     { 
        return "Message ready to send."; 
    }
       return "Please enter a message of less than 250 characters." + (length - 250); 
 
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
// return the total number of messages sent.
public static int returnTotalMessages(int totalMessagesSent){
    return totalMessagesSent;
}

       //Stores the message to a JSON file (messages.json) so it can be sent later.
        
public void storeMessage(){
    String json = "{" 
            + "\"MessageID\":\"" +MessageID +"\","
            + "\"MessageHash\":\"" + MessageHash + "\","
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


// PART3 ARRAYS

 public static final int MAX_MESSAGES = 100;

    // Parallel arrays: the same index belongs to the same message
    private static String[] messageId = new String[MAX_MESSAGES];
    private static String[] messageHashes = new String[MAX_MESSAGES];
    private static String[] recipients = new String[MAX_MESSAGES];
    private static String[] messageTexts = new String[MAX_MESSAGES];
    private static String[] statuses = new String[MAX_MESSAGES];
    private static int messageCount = 0;

    // Sent, disregarded and stored messages: texts only
    private static String[] sentMessages = new String[MAX_MESSAGES];
    private static int sentCount = 0;
    private static String[] disregardedMessages = new String[MAX_MESSAGES];
    private static int disregardedCount = 0;
    private static String[] storedMessages = new String[MAX_MESSAGES];
    private static int storedCount = 0;

    private static int totalMessagesSent = 0;
    private static String senderName = "Me";
    private static String jsonFilePath = "messages.json";
    
    // Puts a parcel into the right array, using the counter as the next free index
        public static void recordMessage(Message msg) {
    if (messageCount < MAX_MESSAGES) {
        messageId[messageCount] = msg.getMessageId();
        messageHashes[messageCount] = msg.getMessageHash();
        recipients[messageCount] = msg.RecipientCell;
        messageTexts[messageCount] = msg.MessageText;
        statuses[messageCount] = "Stored"; 
        messageCount++;
        System.out.println("Message successfully recorded in arrays.");
    } else {
        System.out.println("Message storage is full.");
    }
}
     // Adds one message to the parallel arrays and to the sent/disregarded/stored array.  
    private void addEntry(String id, String hash, String recipient, String text, String status) {
        messageId[messageCount] = id;
        messageHashes[messageCount] = hash;
        recipients[messageCount] = recipient;
        messageTexts[messageCount] = text;
        statuses[messageCount] = status;
        messageCount++;

        if (status.equals("Sent")) {
            sentMessages[sentCount] = text;
            sentCount++;
        } else if (status.equals("Stored")) {
            storedMessages[storedCount] = text;
            storedCount++;
        } else {
            disregardedMessages[disregardedCount] = text;
            disregardedCount++;
        }
    }  
   
// Reads the stored messages from the JSON file INTO the stored array
    public String loadStoredFromJson(String fileName) {
        int loaded = 0;
    try {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (!line.equals("") && storedCount < MAX_MESSAGES) {
                // Extract the "message" value from the JSON line
                String marker = "\"message\":\"";
                int start = line.indexOf(marker);
                if (start != -1) {
                    start += marker.length();
                    int end = line.lastIndexOf("\"");
                    String msgText = line.substring(start, end).replace("\\\"", "\"");

                    storedMessages[storedCount] = msgText;
                    storedCount++;
                    loaded++;
                }
            }
        }
        return loaded + " stored message(s) loaded from " + fileName;
    } catch (IOException e) {
        return "No stored messages on file yet.";
    }
}

     // a) Sender and recipient of every stored message
    public String displaySenderAndRecipient() {
        String result = "";
        for (int i = 0; i < messageCount; i++) {
            if (statuses[i].equals("Stored")) {
                result = result + "Sender: " + senderName + " | Recipient: " + recipients[i] + "\n";
            }
        }
        return result.isEmpty() ? "No stored messages." : result.trim();
    }

    // b) The longest stored message
    public String displayLongestMessage() {
        if (storedCount == 0) {
            return "No stored messages.";
        }
        String longest = storedMessages[0];
        for (int i = 1; i < storedCount; i++) {
            if (storedMessages[i].length() > longest.length()) {
                longest = storedMessages[i];
            }
        }
        return longest;
    }

    
}