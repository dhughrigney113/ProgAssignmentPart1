/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progassignmentpart1;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class ProgAssignmentPart1 {
static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
      
        Scanner input = new Scanner(System.in);
         UserLogin obj = new UserLogin();
         
         System.out.println("=========REGISTRATION============");
         System.out.println("Hi there ,Please Enter Your Name");
         String Name = input.nextLine();
         
         System.out.println("Please Enter Your Surname");
         String Surname = input.nextLine();
         
        
        System.out.println("Please Enter Your Username");
        String Username = input.next();
        obj.CheckUsername(Username);
        
        System.out.println("Please Enter Your Password");
        String password = input.next();
        obj.CheckPassword(password);
        
         System.out.println("Please Enter Your Cell Phone Number");
        String CellphoneNumber = input.next();
        obj.CheckCellphoneNumber(CellphoneNumber);
        
        String results = obj.RegisterUser(Username, password, CellphoneNumber);
        System.out.println(results);
       
        
    
    // part2
        System.out.println("=========LOGIN============");
        System.out.print(" Hi Please Enter Your Username ");
        Username = input.next();
        
        
        System.out.print(" Please Enter Your Password ");
        password = input.next();
        
        
        if (!Username.equals("kyl") || !password.equals("kyl_1")){
             System.out.println("Login failed, Goodbye");
             return;
        }
        System.out.println("---------------------------------------------");
     System.out.println("Welcome to QuickChat");
     
        boolean running = true;
     
     while (running){
         System.out.println("Option 1) Send Messages");
         System.out.println("Option 2) Coming Soon");
         System.out.println("Option 3) Quit");
        System.out.print("Choose an option (1-3): ");

    int choice = Integer.parseInt(input.next());
      if (choice == 1) {
         System.out.println("How many messages do you want to send?");
        int numMessages = Integer.parseInt(input.next());
           SendMessages(numMessages);

    } else if (choice == 2) {
          System.out.println("Still in development, Coming Soon");
    } else if (choice == 3) {
          running = false;
    } else {
       System.out.println("Please choose option 1, 2 or 3");

    }
}}
             // Uses a for loop to capture exactly the number of messages the user set.
         private static void SendMessages(int numMessages){
             int totalSent = 0;
              for(int i = 0; i< numMessages; i++ ){
                  System.out.println("\n--- Message " + (i + 1) + " of " + numMessages + " ---");
 
            System.out.print("Enter recipient cell number (e.g. +27718693002): ");
            String RecipientCell = input.nextLine().trim();
 
            System.out.print("Enter your message (max 250 characters): ");
            String MessageText = input.nextLine().trim();
            System.out.println("---------------------------------------------");
            // loop counter i is the message number used in the hash
            Message msg = new Message(RecipientCell, MessageText, i);
 
            String cellResult = msg.checkRecipientCell();
            System.out.println(cellResult);
            String lengthResult = msg.checkMessageLength();
            System.out.println(lengthResult);
            
            System.out.println("---------------------------------------------");
            if (!cellResult.equals("Cell phone number successfully captured.")
                    || !lengthResult.equals("Message ready to send.")) {
                continue; // skip invalid message, move to the next one
            }
                System.out.println("1) Send Message");
                System.out.println("2) Disregard Message");
                System.out.println("3) Store Message to send later");
                   int choice = Integer.parseInt(input.nextLine());
                System.out.println(msg.SentMessage(choice));
                
                if (choice == 1) {
             Message.recordMessage(msg, "Sent");
             totalSent++;
             System.out.println(msg.printMessages());

            } else if (choice == 2){ 
             Message.recordMessage(msg, "Disregard");  // message disregarded
        } else if (choice == 3) {
            Message.recordMessage(msg, "Stored");
            msg.storeMessage();       // should store the messages
        }
    }
    System.out.println("\nTotal messages sent: " + Message.returnTotalMessages(totalSent));
}
         
         // ===== PART 3 the fourth main menu ======
    private static void storedMessagesMenu(Scanner scanner) {
        boolean inMenu = true;

        while (inMenu) {
            System.out.println("\n--STORED MESSAGES--");
            System.out.println("a) Display the sender and recipient of all stored messages.");
            System.out.println("b) Display the longest stored message.");
            System.out.println("c) Search for a message ID and display the corresponding recipient and message.");
            System.out.println("d) Search for all the messages for a particular recipient.");
            System.out.println("e) Delete a message using the message hash.");
            System.out.println("f) Display a report that list the full details of all the stored messages.");
            System.out.println("g) Back to the main menu.");
            System.out.print("Choose an option: ");
            String choice = input.nextLine().trim().toLowerCase();
           
              
             Message messageManager = new Message("", "", 0); 
             System.out.println(
             messageManager.loadStoredFromJson("messages.json")
);
              if (choice.equals("a")) {
                System.out.println(messageManager.displaySenderAndRecipient());
            } else if (choice.equals("b")) {
                System.out.println("Longest Message: " + messageManager.displayLongestMessage());
            } else if (choice.equals("c")) {
                System.out.print("Enter the message ID: ");
                System.out.println(messageManager.searchRecAndMes(input.nextLine().trim()));
            } else if (choice.equals("d")) {
                System.out.print("Enter the recipient number: ");
                System.out.println(messageManager.searchRec(input.nextLine().trim()));
            } else if (choice.equals("e")) {
                System.out.print("Enter the message hash: ");
                System.out.println(messageManager.deleteMessage(input.nextLine().trim().toUpperCase()));
            } else if (choice.equals("f")) {
                System.out.println(messageManager.displayReport());
            } else if (choice.equals("g")) {
                inMenu = false;
            } else {
                System.out.println("Invalid option..");
    


        }
    }
    }
}
