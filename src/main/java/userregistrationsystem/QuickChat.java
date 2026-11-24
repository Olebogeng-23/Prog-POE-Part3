package useregistrationsystem;

import java.util.ArrayList;
import java.util.List;

public class QuickChat {
    public List<String> sentMessages = new ArrayList<>();
    public List<String> disregardedMessages = new ArrayList<>();
    public List<String> storedMessages = new ArrayList<>();
    public List<String> messageHashes = new ArrayList<>();
    public List<String> messageIDs = new ArrayList<>();
    public List<Message> allMessages = new ArrayList<>();

    public void populateTestData(){
        allMessages.clear(); sentMessages.clear(); storedMessages.clear(); disregardedMessages.clear(); messageHashes.clear(); messageIDs.clear();
        addMessage("1000000001", "+27834557896", "Did you get the cake?", "Sent");
        addMessage("2000000002", "+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        addMessage("3000000003", "+27834484567", "Yohooo, I am at your gate.", "Disregard");
        addMessage("0838884567", "0838884567", "It is dinner time!", "Sent");
        addMessage("5000000005", "+27838884567", "Ok, I am leaving without you.", "Stored");
    }
    public void addMessage(String id, String rec, String txt, String flag){
        String hash = Message.createHash(id, allMessages.size(), txt);
        Message m = new Message(id, rec, txt, flag, hash);
        allMessages.add(m); messageIDs.add(id); messageHashes.add(hash);
        if(flag.equalsIgnoreCase("Sent")) sentMessages.add(txt);
        else if(flag.equalsIgnoreCase("Stored")) storedMessages.add(txt);
        else disregardedMessages.add(txt);
    }
    public String displaySenderAndRecipientOfStored(){
        StringBuilder sb=new StringBuilder();
        for(Message m: allMessages) if(m.getFlag().equalsIgnoreCase("Stored")) sb.append("Recipient: ").append(m.getRecipient()).append(", Message: ").append(m.getMessage()).append("\n");
        return sb.toString().trim();
    }
    public String displayLongestMessage(){
        String longest=""; for(Message m: allMessages) if(m.getMessage().length()>longest.length()) longest=m.getMessage(); return longest;
    }
    public String searchByMessageID(String id){
        for(Message m: allMessages) if(m.getMessageID().equals(id)||m.getRecipient().equals(id)) return m.getMessage(); return "Not found";
    }
    public String searchByRecipient(String rec){
        StringBuilder sb=new StringBuilder(); for(Message m: allMessages) if(m.getRecipient().equals(rec)){ if(sb.length()>0) sb.append("\n"); sb.append(m.getMessage()); } return sb.toString();
    }
    public String deleteByHash(String hash){
        for(int i=0;i<allMessages.size();i++){ Message m=allMessages.get(i); if(m.getMessageHash().equals(hash)){ String del=m.getMessage(); allMessages.remove(i); messageHashes.remove(hash); storedMessages.remove(del); return "Message: \""+del+"\" successfully deleted."; } } return "Not found";
    }
    public String displayReport(){
        StringBuilder sb=new StringBuilder("=== Stored Messages Full Report ===\n");
        for(Message m: allMessages){ sb.append("Hash: ").append(m.getMessageHash()).append("\nID: ").append(m.getMessageID()).append("\nRecipient: ").append(m.getRecipient()).append("\nMessage: ").append(m.getMessage()).append("\n---\n"); } return sb.toString();
    }
}