/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progassignmentpart1;

/**
 *
 * @author Student
 */
public class UserLogin {
    
    public String Username;
    public String Password;
    public String CellphoneNumber;
    
    public boolean CheckUsername (String Username){
      if (Username.contains("_") && Username.length()==5){
          return true;
        }else{
          return false;
      }  
    }
    
    public boolean CheckPassword (String Password){
      if (Password.contains("A-Z" + "0-9" + "^a-zA-z0-9") && Password.length()==8){
          return true;
        }else{
          return false;
      }  
    }
    
    public boolean CheckCellphoneNumber (String CellphoneNumber){
      return CellphoneNumber.startsWith("+27")&& CellphoneNumber.length()<=10;
    }
    
    public String RegisterUser(String Username, String Password, String CellphoneNumber){
        if (!CheckUsername(Username)){
            return "Username is not correctly formatted; Please ensure that your username contains an underscore and is not more than five characters in length";
        }else if (!CheckPassword(Password)){
            return "Password is not correctly formatted; Please ensure that Password contains at least eight characters, a capital letter, a number and a special charachter.";
        }else if (!CheckCellphoneNumber(CellphoneNumber)){
            return "Cell Phone Number is not correctly formatted; or does not contain international code";
        }else{
            return "Login Successfull, Welcome<user first name>, <user last name> it is great to see you again";
        
        }
    }
    
    public boolean UserLogin(String Username, String Password, String CellphoneNumber){
       //if (Username.equals(Username))
       //if (Password.equals(Password))
       return this.Username.equals(Username) && this.Password.equals(Password);
    }
    
    
    public String returnUserLoginStaus (boolean loginSuccessful, boolean loginUnsuccessful){
       if (loginSuccessful){
             return "Welcome " + name + " , " + surname+ it is great to see you again.";                                                         
            }else if (loginUnsuccessful){
            return "Username or password incorrect, Please try again";
            }else {
            return "Login unsuccessful"; 
            }
    
    
    }
}
