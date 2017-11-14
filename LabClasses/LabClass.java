import java.util.*;

public class LabClass {
private String instructor;
private String room;
private String timeAndDate;
private int classCapacity;
private ArrayList <Student> classList;
    public LabClass(int _classCapacity) {
        classCapacity = _classCapacity;
        classList = new ArrayList<Student>(); 
        instructor = "unknown";
        room = "unknown";
        timeAndDate = "unknown";
    }
    
    public String getInstructor() {
        return instructor;
    }
    
    public void changeInstructor(String _instructor) {
       instructor = _instructor;
    }
    
    public String room() {
        return room;
    }
    
    public void changeRoom(String _room) {
        room = _room;
    }
    
    public String timeAndDate() {
        return timeAndDate;
    }
    
    public void changeTimeAndDate(String _timeAndDate) {
        timeAndDate = _timeAndDate;
    }
    
    public int getEnrolledStudents() {
        return classList.size();
    }
    
    public void addStudent(Student _student) {
        if(getEnrolledStudents() <= classCapacity) {
            classList.add(_student);
        }
        else{
            System.out.println("Cannot add student. Class maximum capacity reached.");
        }
    }
    
    public void printClassList() {
        System.out.println("Lab Class: " + timeAndDate);
        System.out.println("Instructor: " + instructor);
        System.out.println("Room: " + room);
        System.out.println("Class List:");
        
        for (Student _student: classList) {
            System.out.println(_student.getName() + ", student ID:  " + _student.getStudentID() +  ", credits: " + _student.getCredits());
        }
        
        System.out.println("Numbers of Students: " + getEnrolledStudents());
    }
}
