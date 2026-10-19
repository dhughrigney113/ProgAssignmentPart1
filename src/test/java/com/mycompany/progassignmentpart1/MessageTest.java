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
public class MessageTest {
    
    public MessageTest() {
    }
    
   
    /**
     * Test of generateMessageID method, of class Message.
     */
    @Test
    public void testGenerateMessageIDVaild() {
        System.out.println("generateMessageIDVaild");
        Message instance = new Message("+27718693002","Hi Mike, can you join us for dinner tonight? ",0);
        String result = instance.generateMessageID();
        assertEquals(10, result.length());
       
    }

    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageIDInvaild() {
        System.out.println("checkMessageIDInvaild");
        String MessageID = "277186930025"; // too long
        Message instance = new Message("+27718693002","Hi Mike, can you join us for dinner tonight? ",0);
        boolean result = instance.checkMessageID(MessageID);
        assertEquals(false, instance.checkMessageID(MessageID));
        
    }

    /**
     * Test of checkRecipientCell method, of class Message.
     */
    @Test
    public void testCheckRecipientCellVaild() {
        System.out.println("checkRecipientCellVaild");
        Message instance = new Message ("+27718693002","Hi Mike, can you join us for dinner tonight? ",0);
        String expResult = "Cell phone number successfully captured.";
        String result = instance.checkRecipientCell();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testCheckRecipientCellInvaild() {
        System.out.println("checkRecipientCellInvaild");
        Message instance = new Message ("08575975889","Hi Keegan, did you receive the payment? ",0);
        String expResult = "Cell phone number is incorrectly formatted or does not contain "
            + "an international code. Please correct the number and try again.";
        String result = instance.checkRecipientCell();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkMessageLength method, of class Message.
     */
    @Test
    public void testCheckMessageLengthVaild() {
        System.out.println("checkMessageLengthVaild");
        Message instance = new Message ("+27718693002","Hi Mike, can you join us for dinner tonight? ",0);
        String expResult = "Message ready to send.";
        String result = instance.checkMessageLength();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testCheckMessageLengthInvalid() {
        System.out.println("checkMessageLengthInvalid");
        String longText = "a".repeat(260);   // 260 characters, 10 over the limit
        Message instance = new Message("+27718693002", longText, 0);        
        String expResult = "Please enter a message of less than 250 characters.10";
        String result = instance.checkMessageLength();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of createMessageHash method, of class Message.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        Message instance = new Message ("+27718693002","Hi Mike, can you join us for dinner tonight? ",0);
        String result = instance.createMessageHash();
        assertTrue(result.endsWith(":0:HITONIGHT"));
        assertEquals(instance.MessageID.substring(0, 2), result.substring(0, 2));
       
    }

    /**
     * Test of SentMessage method, of class Message.
     */
    @Test
    public void testSentMessage() {
        System.out.println("SentMessage");
        Message instance = new Message ("+27718693002","Hi Mike, can you join us for dinner tonight? ",0);
        assertEquals("Message successfully sent.", instance.SentMessage(1));
        assertEquals("Press 0 to delete the message.", instance.SentMessage(2));
        assertEquals("Message successfully stored.", instance.SentMessage(3));
        
    }

    /**
     * Test of printMessages method, of class Message.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        String text = "Hi Mike, can you join us for dinner tonight?";
        Message instance = new Message ("+27718693002",text ,0);
        String expResult = "Message ID: " + instance.MessageID + "\n"
            + "Message Hash: " + instance.MessageHash + "\n"
            + "Recipient: +27718693002\n"
            + "Message: " + text;
    assertEquals(expResult, instance.printMessages());
        
    }

    /**
     * Test of returnTotalMessages method, of class Message.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        int totalMessagesSent = 0;
        int expResult = 0;
        int result = Message.returnTotalMessages(totalMessagesSent);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of storeMessage method, of class Message.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        Message instance = new Message ("+27718693002","Hi Mike, can you join us for dinner tonight? ",0);
        instance.storeMessage();
        
    }

    /**
     * Test of getMessageId method, of class Message.
     */
    @Test
    public void testGetMessageId() {
        System.out.println("getMessageId");
        Message instance = new Message ("+27718693002","Hi Mike, can you join us for dinner tonight? ",0);
        String result = instance.getMessageId();
        assertEquals(instance.MessageID, result);
        assertEquals(10, result.length());
        
    }

    /**
     * Test of getMessageHash method, of class Message.
     */
    @Test
    public void testGetMessageHash() {
        System.out.println("getMessageHash");
        Message instance = new Message ("+27718693002","Hi Mike, can you join us for dinner tonight? ",0);
        String result = instance.getMessageHash();
        assertEquals(instance.MessageHash, result);
        assertTrue(result.endsWith(":0:HITONIGHT"));
       
    }
    
}
