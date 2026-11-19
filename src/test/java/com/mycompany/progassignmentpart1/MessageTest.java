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
    
    
    // Test data constants from assignment specification
    private static final String REC_1 = "+27834557896";
    private static final String MSG_1 = "Did you get the cake?";

    private static final String REC_2 = "+27838884567";
    private static final String MSG_2 = "Where are you? You are late! I have asked you to be on time.";

    private static final String REC_3 = "+27834484567";
    private static final String MSG_3 = "Yohoooo, I am at your gate.";

    private static final String REC_4 = "0838884567";
    private static final String MSG_4 = "It is dinner time !";

    private static final String REC_5 = "+27838884567";
    private static final String MSG_5 = "Ok, I am leaving without you.";
    
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
        Message validInstance = new Message(REC_1, MSG_1, 0);
        String result = validInstance.checkRecipientCell();
        assertEquals("Cell phone number successfully captured.", validInstance.checkRecipientCell());
       Message invalidInstance = new Message(REC_4, MSG_4, 3);
       assertTrue(invalidInstance.checkRecipientCell().contains("incorrectly formatted"));
    }

    /**
     * Test of checkMessageLength method, of class Message.
     */
    @Test
    public void testCheckMessageLength() {
        System.out.println("checkMessageLength");
        Message instance = new Message(REC_1, MSG_1, 0);
        String result = instance.checkMessageLength();
        assertEquals("Message ready to send.", instance.checkMessageLength());
       }

    /**
     * Test of getMessageId method, of class Message.
     */
    @Test
    public void testGetMessageId_0args() {
        System.out.println("getMessageId");
        Message instance = new Message(REC_1, MSG_1, 0);;
        String result = instance.getMessageId();
        assertEquals(10, instance.getMessageId().length());
       }

    /**
     * Test of getMessageHash method, of class Message.
     */
    @Test
    public void testGetMessageHash_0args() {
        System.out.println("getMessageHash");
        Message instance = new Message(REC_1, MSG_1, 0);
        String hash = instance.getMessageHash();
        assertNotNull(hash);
        assertTrue(hash.endsWith(":0:DIDCAKE"));
      }

    /**
     * Test of recordMessage method, of class Message.
     */
    @Test
    public void testRecordMessage() {
        System.out.println("recordMessage");
        Message msg1 = new Message(REC_1, MSG_1, 0);
        Message.recordMessage(msg1, "Sent");

        Message msg2 = new Message(REC_2, MSG_2, 1);
        Message.recordMessage(msg2, "Stored");

        Message msg3 = new Message(REC_3, MSG_3, 2);
        Message.recordMessage(msg3, "Disregard");

        Message msg4 = new Message(REC_4, MSG_4, 3);
        Message.recordMessage(msg4, "Sent");

        Message msg5 = new Message(REC_5, MSG_5, 4);
        Message.recordMessage(msg5, "Stored");

        assertTrue(msg1.getMessageCount() >= 5);
        assertEquals(MSG_1, msg1.getSentMessage(0));
      }

    /**
     * Test of loadStoredFromJson method, of class Message.
     */
    @Test
    public void testLoadStoredFromJson() {
        System.out.println("loadStoredFromJson");
        String fileName = "messages.json";
        String result = Message.loadStoredFromJson(fileName);
       assertNotNull(result);
       }

    /**
     * Test of displaySenderAndRecipient method, of class Message.
     */
    @Test
    public void testDisplaySenderAndRecipient() {
       System.out.println("displaySenderAndRecipient");
        Message msg2 = new Message(REC_2, MSG_2, 1);
        Message.recordMessage(msg2, "Stored");

        String result = Message.displaySenderAndRecipient();
        assertNotNull(result);
        assertTrue(result.contains(REC_2));
       }

    /**
     * Test of displayLongestMessage method, of class Message.
     */
    @Test
    public void testDisplayLongestMessage() {
        System.out.println("displayLongestMessage");
        Message msg1 = new Message(REC_1, MSG_1, 0);
        Message.recordMessage(msg1, "Sent");

        Message msg2 = new Message(REC_2, MSG_2, 1);
        Message.recordMessage(msg2, "Stored");

        Message msg3 = new Message(REC_3, MSG_3, 2);
        Message.recordMessage(msg3, "Disregard");

        Message msg4 = new Message(REC_4, MSG_4, 3);
        Message.recordMessage(msg4, "Sent");

        String result = Message.displayLongestMessage();
        assertEquals(MSG_2, result);
    }

    /**
     * Test of searchRecAndMes method, of class Message.
     */
    @Test
    public void testSearchRecAndMes() {
        System.out.println("searchRecAndMes");
        Message msg4 = new Message(REC_4, MSG_4, 3);
        Message.recordMessage(msg4, "Sent");

        String id = msg4.getMessageId();
        String expResult = "Recipient: " + REC_4 + " | Message: " + MSG_4;
        String result = Message.searchRecAndMes(id);
        assertEquals(expResult, result);
       }

    /**
     * Test of searchRec method, of class Message.
     */
    @Test
    public void testSearchRec() {
        System.out.println("searchRec");
       Message msg2 = new Message(REC_2, MSG_2, 1);
        Message.recordMessage(msg2, "Stored");

        Message msg5 = new Message(REC_5, MSG_5, 4);
        Message.recordMessage(msg5, "Stored");

        String result = Message.searchRec(REC_2);
        assertTrue(result.contains(MSG_2));
        assertTrue(result.contains(MSG_5));}

    /**
     * Test of deleteMessage method, of class Message.
     */
    @Test
    public void testDeleteMessage() {
        System.out.println("deleteMessage");
        Message msg2 = new Message(REC_2, MSG_2, 1);
        Message.recordMessage(msg2, "Stored");

        String hash = msg2.getMessageHash();
        String expResult = "Message \"" + MSG_2 + "\" successfully deleted.";
        String result = Message.deleteMessage(hash);
        assertEquals(expResult, result);
        }

    /**
     * Test of displayReport method, of class Message.
     */
    @Test
    public void testDisplayReport() {
       System.out.println("displayReport");
        Message msg1 = new Message(REC_1, MSG_1, 0);
        Message.recordMessage(msg1, "Sent");

        String result = Message.displayReport();
        assertNotNull(result);
        assertTrue(result.contains("MESSAGE REPORT"));
        assertTrue(result.contains(MSG_1));
       }

    /**
     * Test of getMessageCount method, of class Message.
     */
    @Test
    public void testGetMessageCount() {
        System.out.println("getMessageCount");
        Message instance = new Message(REC_1, MSG_1, 0);
        Message.recordMessage(instance, "Sent");
        assertTrue(instance.getMessageCount() > 0);
       }

    /**
     * Test of getSentCount method, of class Message.
     */
    @Test
    public void testGetSentCount() {
        System.out.println("getSentCount");
        Message instance = new Message(REC_1, MSG_1, 0);
        Message.recordMessage(instance, "Sent");
        int result = instance.getSentCount();
        assertTrue(instance.getSentCount() > 0);
        }

    /**
     * Test of getDisregardedCount method, of class Message.
     */
    @Test
    public void testGetDisregardedCount() {
        System.out.println("getDisregardedCount");
        Message instance = new Message(REC_3, MSG_3, 2);
        Message.recordMessage(instance, "Disregard");
        int result = instance.getDisregardedCount();
        assertTrue(instance.getDisregardedCount() > 0);       }

    /**
     * Test of getStoredCount method, of class Message.
     */
    @Test
    public void testGetStoredCount() {
        System.out.println("getStoredCount");
        Message instance = new Message(REC_2, MSG_2, 1);
        Message.recordMessage(instance, "Stored");
        assertTrue(instance.getStoredCount() > 0);
       }

    /**
     * Test of getSentMessage method, of class Message.
     */
    @Test
    public void testGetSentMessage() {
        System.out.println("getSentMessage");
        Message instance = new Message(REC_1, MSG_1, 0);
        Message.recordMessage(instance, "Sent");
        assertNotNull(instance.getSentMessage(0));      }

    /**
     * Test of getDisregardedMessage method, of class Message.
     */
    @Test
    public void testGetDisregardedMessage() {
        System.out.println("getDisregardedMessage");
        Message instance = new Message(REC_3, MSG_3, 2);
        Message.recordMessage(instance, "Disregard");
        assertNotNull(instance.getDisregardedMessage(0));
      }

    /**
     * Test of getStoredMessage method, of class Message.
     */
    @Test
    public void testGetStoredMessage() {
        System.out.println("getStoredMessage");
        Message instance = new Message(REC_2, MSG_2, 1);
        Message.recordMessage(instance, "Stored");
        assertNotNull(instance.getStoredMessage(0));
       }

    /**
     * Test of getMessageHash method, of class Message.
     */
    @Test
    public void testGetMessageHash_int() {
        System.out.println("getMessageHash");
        Message instance = new Message(REC_1, MSG_1, 0);
        Message.recordMessage(instance, "Sent");
        assertNotNull(instance.getMessageHash(0));
       }

    /**
     * Test of getMessageId method, of class Message.
     */
    @Test
    public void testGetMessageId_int() {
        System.out.println("getMessageId");
       Message instance = new Message(REC_1, MSG_1, 0);
        Message.recordMessage(instance, "Sent");
        assertNotNull(instance.getMessageId(0));
       }
    
}
