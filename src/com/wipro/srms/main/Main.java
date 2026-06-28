package com.wipro.srms.main;


import java.util.ArrayList;
import java.time.LocalDate;
import com.wipro.srms.entity.Student;
import com.wipro.srms.entity.AcademicRecord;
import com.wipro.srms.entity.AttendanceRecord;
import com.wipro.srms.service.StudentRecordService;


public class Main {
public static void main(String[] args) {


// Initialize students
ArrayList<Student> students = new ArrayList<>();
students.add(new Student("S001", "Rahul Sharma", "B.Sc Computer Science", 3));
 
students.add(new Student("S002", "Anita Verma", "B.Com General", 2));


// Initialize academic records
ArrayList<AcademicRecord> academicRecords = new ArrayList<>();
academicRecords.add(new AcademicRecord("AR101", "S001", 3, "CS301", "Data Structures", 18.0, 62.0, 80.0));
academicRecords.add(new AcademicRecord("AR102", "S001", 3, "CS302", "Operating Systems", 20.0, 60.0, 80.0));


// Initialize attendance records
ArrayList<AttendanceRecord> attendanceRecords = new ArrayList<>();
attendanceRecords.add(new AttendanceRecord("AT201", "S001", 3, "CS301", 40, 35));
attendanceRecords.add(new AttendanceRecord("AT202", "S001", 3, "CS302", 38, 34));


// Create service
StudentRecordService service = new StudentRecordService(students, academicRecords, attendanceRecords);


try {
// Validate student
service.validateStudent("S001");


// Add a new academic record for an existing subject
AcademicRecord newRecord = new AcademicRecord("AR103", "S001", 3, "CS303", "Computer Networks", 19.0, 61.0, 80.0);
service.addAcademicRecord(newRecord);


// Update marks for a specific record
service.updateAcademicMarks("AR101", 20.0, 63.0);


// Update attendance
AttendanceRecord updatedAttendance = new AttendanceRecord("AT201", "S001", 3, "CS301", 42, 37);
 
service.addOrUpdateAttendance(updatedAttendance);


// Generate full summary
String summary = service.generateStudentSummary("S001", 3); System.out.println(summary);

} catch (Exception ex) {
System.out.println(ex.toString());
}
}
}
