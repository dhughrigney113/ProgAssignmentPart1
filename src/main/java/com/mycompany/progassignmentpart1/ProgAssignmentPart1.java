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
        
    }
    // imitate the login which is used above
      public static void main() {
        
        
        System.out.println("=========LOGIN============");
        System.out.print(" Please Enter Your Username");
        String Username = input.nextLine();
        
        
        System.out.print("Hi Please Enter Your Password");
        String password = input.nextLine();
        
        
         System.out.print("Hi Please Enter Your Cell Phone Number");
        String CellphoneNumber = input.next();
        
        if (!Username.equals("kyl")&&!password.equals("kyl_1"))
             System.out.println("Login failed, Goodbye");

     System.out.println("Welcome to QuickChat");
        boolean running = true;
     
     while (running){
         System.out.println("Option 1) Send Messages");
         System.out.println("Option 2) Still in development,Coming Soon");
         System.out.println("Option 3) Quit");
         
         int option = Integer.parseInt(input.nextLine);
         if (option == 1){
             
         }else if (option == 2) {
        System.out.println("Still in development,Coming Soon");

         }else if (option == 3){
             running =false;
         }else{
             System.out.println("Please choose option 1, 2 or 3");
         }
         System.out.println("Message is sent:" +
                 Message.returnTotalMessages());
         System.out.println("Thank you for using the app, Goodbye");
     }
          
     
     
}
}