/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progassignmentpart1;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Student
 */
//================== part 2====================================================================== 
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
          List<String> objects = new ArrayList<>();

        try {
        if (Files.exists(Paths.get(jsonFilePath))) {
            for (String line : Files.readAllLines(Paths.get(jsonFilePath))) {
                line = line.trim();
                if (line.startsWith("{")) {
                    if (line.endsWith(",")) {
                        line = line.substring(0, line.length() - 1);
                    }
                    objects.add(line);
                }
            }
        }
        objects.add(json);

         List<String> out = new ArrayList<>();
        out.add("[");
        for (int i = 0; i < objects.size(); i++) {
            out.add(objects.get(i) + (i < objects.size() - 1 ? "," : ""));
        }
        out.add("]");
        Files.write(Paths.get(jsonFilePath), out);
    } catch (IOException e) {
        System.out.println("Error storing message: " + e.getMessage());
    }
}
 public String getMessageId() { return MessageID; }
    public String getMessageHash() { return MessageHash; }


// =====================PART3 ARRAYS================================================================
 
   
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
    
// Called from main after SentMessage(choice): "Sent", "Stored" or "Disregard"
       public static void recordMessage(Message msg, String status) {
      if (messageCount >= MAX_MESSAGES) {
        System.out.println("Message storage is full.");
        return;
    }

    if (status.equals("Sent") && sentCount >= MAX_MESSAGES
            || status.equals("Stored") && storedCount >= MAX_MESSAGES
            || status.equals("Disregard") && disregardedCount >= MAX_MESSAGES) {
        System.out.println("Message status array is full.");
        return;
    }
    addEntry(msg.MessageID, msg.MessageHash, msg.RecipientCell, msg.MessageText, status);

    
}
     // Adds one message to the arrays and to the sent/disregarded/stored array.  
    private static void addEntry(String id, String hash, String recipient, String text, String status) {
        messageId[messageCount] = id;
        messageHashes[messageCount] = hash;
        recipients[messageCount] = recipient;
        messageTexts[messageCount] = text;
        statuses[messageCount] = status;
        messageCount++;

        if (status.equals("Sent")) {
            sentMessages[sentCount++] = text;
        } else if (status.equals("Stored")) {
            storedMessages[storedCount++] = text;
       } else if (status.equals("Disregard")){
            disregardedMessages[disregardedCount++] = text;
          
        }
    }  
   
// Reads the stored messages from the JSON file INTO the stored array
    public static String loadStoredFromJson(String fileName) {
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
    public static String displaySenderAndRecipient() {
        String result = "";
        for (int i = 0; i < messageCount; i++) {
            if (statuses[i].equals("Stored")) {
                result = result + "Sender: " + senderName + " | Recipient: " + recipients[i] + "\n";
            }
        }
        return result.isEmpty() ? "No stored messages." : result.trim();
    }

    // b) The longest stored message
    public static String displayLongestMessage() {
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

     private static int findIndex(String[] array, String target) {
    for (int i = 0; i < messageCount; i++) {
        if (array[i] != null && array[i].equals(target)) {
            return i; 
        }
    }
    return -1; 
}    
    
    // c) Search for a message ID: recipient and message
    public static String searchRecAndMes(String id) {
        int index = findIndex(messageId, id);
        if (index == -1) {
            return "Message ID " + id + " not found.";
        }
        return "Recipient: " + recipients[index] + " | Message: " + messageTexts[index];
    }

    // d) Every sent or stored message going to one recipient
    public static String searchRec(String recipient) {
        String result = "";
        for (int i = 0; i < messageCount; i++) {
            if (recipients[i].equals(recipient) && !statuses[i].equals("Disregard")) {
                result = result + messageTexts[i] + "\n";
            }
        }
        if (result.isEmpty()) {
            return "No messages found for recipient " + recipient + ".";
        }
        return result.trim();
    }
   
    // e) Delete a message using its message hash
public static String deleteMessage(String hash) {
    
    // Step 1: Find the index of the message hash
    int deleteIndex = -1;

    for (int i = 0; i < messageCount; i++) {
        if (messageHashes[i] != null && messageHashes[i].equals(hash)) {
            deleteIndex = i;
            break;
        }
    }

    if (deleteIndex == -1) {
        return "Message hash " + hash + " not found.";
    }

    String deleted = messageTexts[deleteIndex];

    // Step 2: Shift everything after it one place left
    // in EVERY parallel array
    for (int i = deleteIndex; i < messageCount - 1; i++) {
        messageId[i] = messageId[i + 1];
        messageHashes[i] = messageHashes[i + 1];
        recipients[i] = recipients[i + 1];
        messageTexts[i] = messageTexts[i + 1];
        statuses[i] = statuses[i + 1];
      }

    // Step 3: Clear the last slot and lower the counter
    messageId[messageCount - 1] = null;
    messageHashes[messageCount - 1] = null;
    recipients[messageCount - 1] = null;
    messageTexts[messageCount - 1] = null;
    statuses[messageCount - 1] = null;

    messageCount--;

    return "Message \"" + deleted + "\" successfully deleted.";
}
// f) Full report of every dispatched parcel
  public static String displayReport(){
       if (messageCount == 0) {
        return "No messages recorded yet.";
    }
       String result = "MESSAGE REPORT\n";
        for (int i = 0; i < messageCount; i++) {
          if (!statuses[i].equals("Disregard")) {
           result = result + "-\n"
                   + "Message ID: " + messageId[i] + "\n"
                   + "Message Hash: " + messageHashes[i] + "\n"
                   + "Recipient: " + recipients[i] + "\n"
                   + "Message: " + messageTexts[i] + "\n"
                   + "Status: " + statuses[i] + "\n";
        }
    }
                result = result + "-\nTotal stored messages: " + messageCount;
                  return result;
}
   // ---- Getters ----
  public int getMessageCount() {return messageCount;
  }
  public int getSentCount() { return sentCount;
  }
    public int getDisregardedCount() { return disregardedCount; 
  }
    public int getStoredCount() { return storedCount;
  }
    public String getSentMessage(int index) { return sentMessages[index];
  }
    public String getDisregardedMessage(int index) { return disregardedMessages[index]; 
  }
    public String getStoredMessage(int index) { return storedMessages[index]; 
  }
    public String getMessageHash(int index) { return messageHashes[index]; 
  }
   public String getMessageId(int index) { return messageId[index]; 
   }
  }
 
