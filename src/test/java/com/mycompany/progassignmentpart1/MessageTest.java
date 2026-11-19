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

    /**
     * =========PART 3===========
     */
    
    /**
     * Test of generateMessageID method, of class Message.
     */
    @Test
    public void testGenerateMessageID() {
        System.out.println("generateMessageID");
        Message instance = new Message("+27718693002", "Test message", 0);
        String expResult = "";
        String result = instance.generateMessageID();
        assertEquals(10, result.length());
       
    }

    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        String MessageID = "";
        Message instance = new Message("+27718693002", "Test message", 0);
        String validId = "1234567890";
        boolean result = instance.checkMessageID(MessageID);
        assertTrue(instance.checkMessageID(validId));
        
        String invalidId = "12345678901"; 
        assertFalse(instance.checkMessageID(invalidId));
    }

    /**
     * Test of checkRecipientCell method, of class Message.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        Message instance = null;
        String expResult = "";
        String result = instance.checkRecipientCell();
        assertEquals(expResult, result);
       }

    /**
     * Test of checkMessageLength method, of class Message.
     */
    @Test
    public void testCheckMessageLength() {
        System.out.println("checkMessageLength");
        Message instance = null;
        String expResult = "";
        String result = instance.checkMessageLength();
        assertEquals(expResult, result);
       }

    /**
     * Test of getMessageId method, of class Message.
     */
    @Test
    public void testGetMessageId_0args() {
        System.out.println("getMessageId");
        Message instance = null;
        String expResult = "";
        String result = instance.getMessageId();
        assertEquals(expResult, result);
       }

    /**
     * Test of getMessageHash method, of class Message.
     */
    @Test
    public void testGetMessageHash_0args() {
        System.out.println("getMessageHash");
        Message instance = null;
        String expResult = "";
        String result = instance.getMessageHash();
        assertEquals(expResult, result);
      }

    /**
     * Test of recordMessage method, of class Message.
     */
    @Test
    public void testRecordMessage() {
        System.out.println("recordMessage");
        Message msg = null;
        String status = "";
        Message.recordMessage(msg, status);
      }

    /**
     * Test of loadStoredFromJson method, of class Message.
     */
    @Test
    public void testLoadStoredFromJson() {
        System.out.println("loadStoredFromJson");
        String fileName = "";
        Message instance = null;
        String expResult = "";
        String result = instance.loadStoredFromJson(fileName);
        assertEquals(expResult, result);
       }

    /**
     * Test of displaySenderAndRecipient method, of class Message.
     */
    @Test
    public void testDisplaySenderAndRecipient() {
        System.out.println("displaySenderAndRecipient");
        Message instance = null;
        String expResult = "";
        String result = instance.displaySenderAndRecipient();
        assertEquals(expResult, result);
       }

    /**
     * Test of displayLongestMessage method, of class Message.
     */
    @Test
    public void testDisplayLongestMessage() {
        System.out.println("displayLongestMessage");
        Message instance = null;
        String expResult = "";
        String result = instance.displayLongestMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of searchRecAndMes method, of class Message.
     */
    @Test
    public void testSearchRecAndMes() {
        System.out.println("searchRecAndMes");
        String id = "";
        Message instance = null;
        String expResult = "";
        String result = instance.searchRecAndMes(id);
        assertEquals(expResult, result);
       }

    /**
     * Test of searchRec method, of class Message.
     */
    @Test
    public void testSearchRec() {
        System.out.println("searchRec");
        String recipient = "";
        Message instance = null;
        String expResult = "";
        String result = instance.searchRec(recipient);
        assertEquals(expResult, result);
        }

    /**
     * Test of deleteMessage method, of class Message.
     */
    @Test
    public void testDeleteMessage() {
        System.out.println("deleteMessage");
        String hash = "";
        Message instance = null;
        String expResult = "";
        String result = instance.deleteMessage(hash);
        assertEquals(expResult, result);
        }

    /**
     * Test of displayReport method, of class Message.
     */
    @Test
    public void testDisplayReport() {
        System.out.println("displayReport");
        Message instance = null;
        String expResult = "";
        String result = instance.displayReport();
        assertEquals(expResult, result);
       }

    /**
     * Test of getMessageCount method, of class Message.
     */
    @Test
    public void testGetMessageCount() {
        System.out.println("getMessageCount");
        Message instance = null;
        int expResult = 0;
        int result = instance.getMessageCount();
        assertEquals(expResult, result);
       }

    /**
     * Test of getSentCount method, of class Message.
     */
    @Test
    public void testGetSentCount() {
        System.out.println("getSentCount");
        Message instance = null;
        int expResult = 0;
        int result = instance.getSentCount();
        assertEquals(expResult, result);
        }

    /**
     * Test of getDisregardedCount method, of class Message.
     */
    @Test
    public void testGetDisregardedCount() {
        System.out.println("getDisregardedCount");
        Message instance = null;
        int expResult = 0;
        int result = instance.getDisregardedCount();
        assertEquals(expResult, result);
       }

    /**
     * Test of getStoredCount method, of class Message.
     */
    @Test
    public void testGetStoredCount() {
        System.out.println("getStoredCount");
        Message instance = null;
        int expResult = 0;
        int result = instance.getStoredCount();
        assertEquals(expResult, result);
       }

    /**
     * Test of getSentMessage method, of class Message.
     */
    @Test
    public void testGetSentMessage() {
        System.out.println("getSentMessage");
        int index = 0;
        Message instance = null;
        String expResult = "";
        String result = instance.getSentMessage(index);
        assertEquals(expResult, result);
      }

    /**
     * Test of getDisregardedMessage method, of class Message.
     */
    @Test
    public void testGetDisregardedMessage() {
        System.out.println("getDisregardedMessage");
        int index = 0;
        Message instance = null;
        String expResult = "";
        String result = instance.getDisregardedMessage(index);
        assertEquals(expResult, result);
      }

    /**
     * Test of getStoredMessage method, of class Message.
     */
    @Test
    public void testGetStoredMessage() {
        System.out.println("getStoredMessage");
        int index = 0;
        Message instance = null;
        String expResult = "";
        String result = instance.getStoredMessage(index);
        assertEquals(expResult, result);
       }

    /**
     * Test of getMessageHash method, of class Message.
     */
    @Test
    public void testGetMessageHash_int() {
        System.out.println("getMessageHash");
        int index = 0;
        Message instance = null;
        String expResult = "";
        String result = instance.getMessageHash(index);
        assertEquals(expResult, result);
       }

    /**
     * Test of getMessageId method, of class Message.
     */
    @Test
    public void testGetMessageId_int() {
        System.out.println("getMessageId");
        int index = 0;
        Message instance = null;
        String expResult = "";
        String result = instance.getMessageId(index);
        assertEquals(expResult, result);
       }
    
}
