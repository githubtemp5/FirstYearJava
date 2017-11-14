
public class Student {
    private String name;
    private String id;
    
    private int credits;
    private String favourite;
    public Student(String studentName, String studentID, String fav) {
        name = studentName;
        id = studentID;
        credits = 0;
        favourite = fav;
        
        
    }
    
    public String getName(){
        return name;
    }
    
    public void changeName(String newName){
        name = newName;
    }
    
    public String getStudentID(){
        return id;
    }
    
    public int getCredits(){
        return credits;
    }
    
    public void addCredits(int addPoints){
        credits += addPoints;
    }
    public String getLoginName(){
        return "UP" + id;
    }
    
    public void print(){
        System.out.println(name + "\nstudent ID: " + id + "\nCredits: "+ credits);
    }
    
    public String getFavourite(){
        return favourite;
    }
    
    public void changeFavourite(String newFav){
        favourite = newFav;
    }
    
    public boolean isPass(){
        if(credits >= 120){
            return true;
        }
        else {
            return false;
        }
    }
}
