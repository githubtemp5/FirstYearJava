public class MailItem {

private EmailAddress sender;
private EmailAddress receiver;
private String subject;
private String message;
private boolean priority;

    public MailItem(EmailAddress _sender, EmailAddress _receiver, String _subject, String _message, boolean _priority) {
        sender = _sender;
        receiver = _receiver;
        subject = _subject;
        message = _message;
        priority = _priority;
    }
    
    public EmailAddress getSender(){
        return sender;
    }

    public EmailAddress getReceiver(){
        return receiver;
    }
    
    public String getSubject(){
        return subject;
    }
    
    public String getMessage(){
        return message;
    }
    
    public void print(){
        System.out.println("Sender: " + sender.getEmailAddress());
        System.out.println("Receiver: " + receiver.getEmailAddress());
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message );
        if(priority){
            System.out.println("State: Urgent");
        }
        else{
            System.out.println("State: Not-Urgent");
        }
    }
    
}
//import java.util.*;
// ArrayList<String> name;

//name = new ArrayList<String>();
//ArrayList <EmailAddress> emails;
//emails = new ArrayList<EmailAddres>();

//name.add("ALVIN");

