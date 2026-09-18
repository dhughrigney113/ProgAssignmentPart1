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
         
         System.out.println("=========REGISTRATION============");
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
       
        
    }
}
