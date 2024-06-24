package data;

import java.util.ArrayList;
import java.util.UUID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Admin extends User {
    private static String adminUsername = "admin";
    private static String adminPassword = "password";
    private static ObservableList<Student> studentList = FXCollections.observableArrayList();
    private static ArrayList<Student> tempStudent = new ArrayList<Student>();
    private static Student studentLog;

    public String generateId() {
        return UUID.randomUUID().toString().substring(9, 23);
    }

    public static void addTempStudent(Student student) {
        tempStudent.add(student);
    }
    
    public static void addStudentList(ArrayList<Student> student) {
    	studentList.addAll(student);
    }
    
    public static void addStudentList(Student student) {
    	studentList.add(student);
    }

    public static ObservableList<Student> getStudentList() {
        return studentList;
    }
    
    public static Student getStudentLog() {
    	return studentLog;
    }
    
    public static void setStudentLog(Student student) {
    	studentLog = student;
    }
    public static boolean isAdmin(String username, String password) {
        return username.equals(adminUsername) && password.equals(adminPassword);
    }
}
