package useregistrationsystem;

public class Message {
    private String messageID, messageHash, recipient, message, flag;
    public Message(String id, String rec, String msg, String flag, String hash){
        this.messageID=id; this.recipient=rec; this.message=msg; this.flag=flag; this.messageHash=hash;
    }
    public String getMessageID(){ return messageID; }
    public String getMessageHash(){ return messageHash; }
    public String getRecipient(){ return recipient; }
    public String getMessage(){ return message; }
    public String getFlag(){ return flag; }
    public static String createHash(String id, int num, String txt){
        String[] w = txt.trim().split("\\s+"); String first = w[0]; String last = w[w.length-1];
        String idPart = id.length()>=2 ? id.substring(0,2).toUpperCase() : id.toUpperCase();
        return idPart + ":" + num + ":" + (first+last).toUpperCase();
    }
}