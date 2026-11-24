package useregistrationsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        QuickChat m = new QuickChat();
        m.populateTestData();
        assertTrue(m.sentMessages.contains("Did you get the cake?"));
        assertTrue(m.sentMessages.contains("It is dinner time!"));
        assertEquals(2, m.sentMessages.size());
    }

    @Test
    public void testDisplayLongestMessage() {
        QuickChat m = new QuickChat();
        m.populateTestData();
        String longest = m.displayLongestMessage();
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest);
    }

    @Test
    public void testSearchForMessageID() {
        QuickChat m = new QuickChat();
        m.populateTestData();
        String result = m.searchByMessageID("0838884567");
        assertEquals("It is dinner time!", result);
    }

    @Test
    public void testSearchMessagesByRecipient() {
        QuickChat m = new QuickChat();
        m.populateTestData();
        String result = m.searchByRecipient("+27838884567");
        assertTrue(result.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(result.contains("Ok, I am leaving without you."));
    }

    @Test
    public void testDeleteByHash() {
        QuickChat m = new QuickChat();
        m.populateTestData();
        // Find hash of the "You are late" message
        String hashToDelete = "";
        for(Message msg : m.allMessages){
            if(msg.getMessage().contains("You are late")){
                hashToDelete = msg.getMessageHash();
                break;
            }
        }
        String result = m.deleteByHash(hashToDelete);
        assertEquals("Message: \"Where are you? You are late! I have asked you to be on time.\" successfully deleted.", result);
    }

    @Test
    public void testDisplayReport() {
        QuickChat m = new QuickChat();
        m.populateTestData();
        String report = m.displayReport();
        // Report must contain Hash, Recipient, Message as per brief
        assertTrue(report.contains("Hash"));
        assertTrue(report.contains("Recipient"));
        assertTrue(report.contains("Message"));
    }
}