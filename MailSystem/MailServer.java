import java.util.*;

public class MailServer{
private ArrayList <MailItem> items;

    public MailServer() {
        items = new ArrayList<MailItem>();
    }
    
    public int howManyMailItems(EmailAddress who){
    
        int count = 0;
        for(MailItem item : items){    
            if(item.getReceiver().equals(who)){
            count++;
            }
        }
        return count;
    }
    
    public MailItem getNextMailItem(EmailAddress who){
        Iterator <MailItem> it = items.iterator();

        while(it.hasNext()){
            MailItem item = it.next();
            if(item.getReceiver().equals(who)){
                it.remove();
                return item;
            }
        }
        return null;
    }
    
    public void post(MailItem item){
        items.add(item);
    }
}
