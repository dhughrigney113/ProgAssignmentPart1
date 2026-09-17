/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progassignmentpart1;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class UserLoginTest {
    
    public UserLoginTest() {
    }
    

    @Test
    public void testCheckUsername() {
        System.out.println("CheckUsername");
        String Username = "kyl_1";
        UserLogin instance = new UserLogin();
        boolean expResult = true;
        boolean result = instance.CheckUsername(Username);
        assertEquals(expResult, result);
       
    }

   
    @Test
    public void testCheckPassword() {
        System.out.println("CheckPassword");
        String Password = "Ch&&sec@ke99!";
        UserLogin instance = new UserLogin();
        boolean expResult = true;
        boolean result = instance.CheckPassword(Password);
        assertEquals(expResult, result);
        
    }

  
    @Test
    public void testCheckCellphoneNumber() {
        System.out.println("CheckCellphoneNumber");
        String CellphoneNumber = "+27838968976";
        UserLogin instance = new UserLogin();
        boolean expResult = true;
        boolean result = instance.CheckCellphoneNumber(CellphoneNumber);
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testRegisterUser() {
        System.out.println("RegisterUser");
        String Username = "kyl_1";
        String Password = "Ch&&sec@ke99!";
        String CellphoneNumber = "+27838968976";
        UserLogin instance = new UserLogin();
        String expResult = "true";
        String result = instance.RegisterUser(Username, Password, CellphoneNumber);
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testUserLogin() {
        System.out.println("UserLogin");
        String Username = "kyl_1";
        String Password = "Ch&&sec@ke99!";
        String CellphoneNumber = "+27838968976";
        UserLogin instance = new UserLogin();
        boolean expResult = true;
        boolean result = instance.UserLogin(Username, Password, CellphoneNumber);
        assertEquals(expResult, result);
       
    }

    
    @Test
    public void testReturnUserLoginStaus() {
        System.out.println("returnUserLoginStaus");
        boolean loginSuccessful = true;
        boolean loginUnsuccessful = false;
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.returnUserLoginStaus(loginSuccessful, loginUnsuccessful);
        assertEquals(expResult, result);
        
    }
    
}
