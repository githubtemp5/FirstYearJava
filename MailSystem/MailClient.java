
public class MailClient {
    private MailServer server;
    private EmailAddress user;

    public MailClient(MailServer mailServer, String _user, String _address) {
        server = mailServer;
        user = new EmailAddress(_user, _address);
    }
    
    public void printNextMailItem(){
        MailItem item = server.getNextMailItem(user);
        
        if(item == null){
            System.out.println("No new mail");
        }
        else{
            item.print();
        }
        
    }
    
    public EmailAddress getEmail(){
        return user;
    }
    
    public void sendMailItem(MailClient receiver, String subject, String message, boolean priority){
        
        MailItem item = new MailItem(user, receiver.getEmail(), subject, message, priority);   
        server.post(item);
    }


}
