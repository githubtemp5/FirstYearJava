public class EmailAddress {
private String name;
private String address;
private String emailAddress;

    public EmailAddress(String inputName, String inputAddress) {
        name = inputName;
        address = inputAddress;
        emailAddress = name +"@"+ address;
    }
    
    public String getName(){
        return name;
    }
    
    public String getEmailAddress(){
        return emailAddress;
    }
}
