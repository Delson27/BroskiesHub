package BroskiesHubTask2;
import java.util.ArrayList;
import java.util.Scanner;

class Student{
    private String name;
    private int id;
    private String grade;

    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Student [ID: " + id + ", Name: " + name + ", Grade: " + grade + "]";
    }
}
public class bht2 {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.println("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter student name: ");
        String name = sc.nextLine();
        System.out.println("Enter student grade: ");
        String grade = sc.nextLine();
        
        students.add(new Student(id,name,grade));
        System.out.println("Student added successfully!");
    }

    public static void removeStudent() {
        System.out.println("Enter student ID to remove: ");
        int id=sc.nextInt();
        sc.nextLine();
        boolean removed=false;
        for(Student s:students){
            if(s.getId()==id){
                students.remove(s);
                removed=true;
                System.out.println("Student removed successfully!");
                break;
            }
        }
        if(!removed){
            System.out.println("Student not found with ID: "+id+"\n");
        }
    }

    public static void displayStudents() {
        if(students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("List of Students:");
            for(Student s:students) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        while(true){
          
            System.out.println("***Student Management Menu***");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();

            switch(choice){
                case 1 :{
                    addStudent();
                    break;
                } 
                case 2:{
                    removeStudent();
                    break;
                }
                case 3:{
                    displayStudents();
                    break;
                }
                case 4:{
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default : System.out.println("Invalid choice. Please try again.");
            }


        }

    }    
    
}
