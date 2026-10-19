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
         
         /*System.out.println("=========REGISTRATION============");
         System.out.println("Hi there ,Please Enter Your Name");
         String Name = input.nextLine();
         
         System.out.println("Hi there ,Please Enter Your Surname");
         String Surname = input.nextLine();
         
        
        System.out.println("Hi Please Enter Your Username");
        String Username = input.next();
        obj.CheckUsername(Username);
        
        System.out.println("Hi Please Enter Your Password");
        String password = input.next();
        obj.CheckPassword(password);
        
         System.out.println("Hi Please Enter Your Cell Phone Number");
        String CellphoneNumber = input.next();
        obj.CheckCellphoneNumber(CellphoneNumber);
        
        String results = obj.RegisterUser(Username, password, CellphoneNumber);
        System.out.println(results);
       */
        
    
    // imitate the login which is used above
      
        
        
        System.out.println("=========LOGIN============");
        System.out.print(" Hi Please Enter Your Username ");
        String Username = input.nextLine();
        
        
        System.out.print(" Please Enter Your Password ");
        String password = input.nextLine();
        
        
        if (!Username.equals("kyl")&&!password.equals("kyl_1")){
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
         
         int option = Integer.parseInt(input.nextLine());
         if (option == 1){
             System.out.println("how many Messages do you want to send?");
              int numMessages = Integer.parseInt(input.nextLine());
              SendMessages(numMessages);
          
         }else if (option == 2) {
        System.out.println("Still in development,Coming Soon");
        System.out.println("---------------------------------------------"); 
         }else if (option == 3){
             running =false;
         }else{
             System.out.println("Please choose option 1, 2 or 3");
         }
              }
    }
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
            totalSent++;         //show send message
            System.out.println(msg.printMessages());
            } else if (choice == 2) {  // message disregarded
        } else if (choice == 3) {    
            msg.storeMessage();       // should store the messages
        }
    }
    System.out.println("\nTotal messages sent: " + Message.returnTotalMessages(totalSent));
}
              }
              
         
     
          
         

