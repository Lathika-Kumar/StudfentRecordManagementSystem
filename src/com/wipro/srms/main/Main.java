package com.wipro.srms.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.wipro.srms.entity.AcademicRecord;
import com.wipro.srms.entity.AttendanceRecord;
import com.wipro.srms.entity.Student;
import com.wipro.srms.service.StudentRecordService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<AcademicRecord> academicRecords = new ArrayList<>();
        ArrayList<AttendanceRecord> attendanceRecords = new ArrayList<>();

        StudentRecordService service =
                new StudentRecordService(
                        students,
                        academicRecords,
                        attendanceRecords);

        int choice;

        do {
            System.out.println("STUDENT RECORD MANAGEMENT SYSTEM");
            System.out.println("1. Add Student");
            System.out.println("2. Add Academic Record");
            System.out.println("3. Update Academic Marks");
            System.out.println("4. Add / Update Attendance");
            System.out.println("5. Calculate Attendance Percentage");
            System.out.println("6. Calculate Semester Average");
            System.out.println("7. Generate Student Summary");
            System.out.println("8. Exit");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            try {

                switch (choice) {

                case 1:

                    System.out.print("Enter Student ID : ");
                    String studentId = sc.next();

                    sc.nextLine();

                    System.out.print("Enter Student Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Program : ");
                    String program = sc.nextLine();

                    System.out.print("Enter Current Semester : ");
                    int semester = sc.nextInt();

                    students.add(new Student(
                            studentId,
                            name,
                            program,
                            semester));

                    System.out.println("Student Added Successfully.");

                    break;

                case 2:

                    System.out.print("Record ID : ");
                    String recordId = sc.next();

                    System.out.print("Student ID : ");
                    String sid = sc.next();

                    System.out.print("Semester : ");
                    int sem = sc.nextInt();

                    System.out.print("Subject Code : ");
                    String subjectCode = sc.next();

                    sc.nextLine();

                    System.out.print("Subject Name : ");
                    String subjectName = sc.nextLine();

                    System.out.print("Internal Marks : ");
                    double internal = sc.nextDouble();

                    System.out.print("External Marks : ");
                    double external = sc.nextDouble();

                    AcademicRecord record =
                            new AcademicRecord(
                                    recordId,
                                    sid,
                                    sem,
                                    subjectCode,
                                    subjectName,
                                    internal,
                                    external,
                                    internal + external);

                    service.addAcademicRecord(record);

                    break;

                case 3:

                    System.out.print("Enter Record ID : ");
                    String rid = sc.next();

                    System.out.print("New Internal Marks : ");
                    double newInternal = sc.nextDouble();

                    System.out.print("New External Marks : ");
                    double newExternal = sc.nextDouble();

                    service.updateAcademicMarks(
                            rid,
                            newInternal,
                            newExternal);

                    break;

                case 4:

                    System.out.print("Attendance ID : ");
                    String attendanceId = sc.next();

                    System.out.print("Student ID : ");
                    String sid1 = sc.next();

                    System.out.print("Semester : ");
                    int sem1 = sc.nextInt();

                    System.out.print("Subject Code : ");
                    String code = sc.next();

                    System.out.print("Total Classes : ");
                    int totalClasses = sc.nextInt();

                    System.out.print("Attended Classes : ");
                    int attended = sc.nextInt();

                    AttendanceRecord attendance =
                            new AttendanceRecord(
                                    attendanceId,
                                    sid1,
                                    sem1,
                                    code,
                                    totalClasses,
                                    attended);

                    service.addOrUpdateAttendance(attendance);

                    break;

                case 5:

                    System.out.print("Student ID : ");
                    String id1 = sc.next();

                    System.out.print("Semester : ");
                    int semester1 = sc.nextInt();

                    double percentage =
                            service.calculateAttendancePercentage(
                                    id1,
                                    semester1);

                    System.out.printf(
                            "Attendance Percentage : %.2f%%\n",
                            percentage);

                    break;

                case 6:

                    System.out.print("Student ID : ");
                    String id2 = sc.next();

                    System.out.print("Semester : ");
                    int semester2 = sc.nextInt();

                    double average =
                            service.calculateSemesterAverage(
                                    id2,
                                    semester2);

                    System.out.printf(
                            "Semester Average : %.2f\n",
                            average);

                    break;

                case 7:

                    System.out.print("Student ID : ");
                    String id3 = sc.next();

                    System.out.print("Semester : ");
                    int semester3 = sc.nextInt();

                    service.generateStudentSummary(
                            id3,
                            semester3);

                    break;

                case 8:

                    System.out.println("Thank You!");

                    break;

                default:

                    System.out.println("Invalid Choice.");

                }

            } catch (Exception e) {

                System.out.println(e);

            }

        } while (choice != 8);

        sc.close();

    }

}