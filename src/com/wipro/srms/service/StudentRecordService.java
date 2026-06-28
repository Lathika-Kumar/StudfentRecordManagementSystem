package com.wipro.srms.service;

import java.util.ArrayList;

import com.wipro.srms.entity.AcademicRecord;
import com.wipro.srms.entity.AttendanceRecord;
import com.wipro.srms.entity.Student;
import com.wipro.srms.util.DuplicateRecordException;
import com.wipro.srms.util.InvalidStudentException;
import com.wipro.srms.util.RecordNotFoundException;

public class StudentRecordService {

    private ArrayList<Student> students;
    private ArrayList<AcademicRecord> academicRecords;
    private ArrayList<AttendanceRecord> attendanceRecords;

    // Constructor
    public StudentRecordService(ArrayList<Student> students,
                                ArrayList<AcademicRecord> academicRecords,
                                ArrayList<AttendanceRecord> attendanceRecords) {

        this.students = students;
        this.academicRecords = academicRecords;
        this.attendanceRecords = attendanceRecords;
    }

    // Validate Student
    public boolean validateStudent(String studentId)
            throws InvalidStudentException {

        if (studentId == null || studentId.trim().isEmpty()) {
            throw new InvalidStudentException();
        }

        for (Student student : students) {

            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return true;
            }

        }

        throw new InvalidStudentException();
    }

    // Add Academic Record
    public void addAcademicRecord(AcademicRecord record)
            throws DuplicateRecordException,
                   InvalidStudentException {

        // Check student exists
        validateStudent(record.getStudentId());

        // Check duplicate record
        for (AcademicRecord ar : academicRecords) {

            if (ar.getStudentId().equalsIgnoreCase(record.getStudentId())
                    && ar.getSemester() == record.getSemester()
                    && ar.getSubjectCode().equalsIgnoreCase(record.getSubjectCode())) {

                throw new DuplicateRecordException();
            }
        }

        academicRecords.add(record);

        System.out.println("Academic Record Added Successfully.");
    }

    // Update Academic Marks
    public void updateAcademicMarks(String recordId,
                                    double newInternalMarks,
                                    double newExternalMarks)
            throws RecordNotFoundException {

        for (AcademicRecord ar : academicRecords) {

            if (ar.getRecordId().equalsIgnoreCase(recordId)) {

                ar.setInternalMarks(newInternalMarks);

                ar.setExternalMarks(newExternalMarks);

                ar.setTotalMarks(newInternalMarks + newExternalMarks);

                System.out.println("Academic Marks Updated.");

                return;
            }

        }

        throw new RecordNotFoundException();
    }
 // Add or Update Attendance
    public void addOrUpdateAttendance(AttendanceRecord newRecord)
            throws InvalidStudentException {

        validateStudent(newRecord.getStudentId());

        for (AttendanceRecord ar : attendanceRecords) {

            if (ar.getStudentId().equalsIgnoreCase(newRecord.getStudentId())
                    && ar.getSemester() == newRecord.getSemester()
                    && ar.getSubjectCode().equalsIgnoreCase(newRecord.getSubjectCode())) {

                ar.setTotalClasses(newRecord.getTotalClasses());
                ar.setAttendedClasses(newRecord.getAttendedClasses());

                System.out.println("Attendance Updated Successfully.");

                return;
            }
        }

        attendanceRecords.add(newRecord);

        System.out.println("Attendance Added Successfully.");
    }
 // Calculate Attendance Percentage
    public double calculateAttendancePercentage(String studentId,
                                                int semester)
            throws RecordNotFoundException,
                   InvalidStudentException {

        validateStudent(studentId);

        int totalClasses = 0;
        int attendedClasses = 0;

        for (AttendanceRecord ar : attendanceRecords) {

            if (ar.getStudentId().equalsIgnoreCase(studentId)
                    && ar.getSemester() == semester) {

                totalClasses += ar.getTotalClasses();
                attendedClasses += ar.getAttendedClasses();
            }
        }

        if (totalClasses == 0) {
            throw new RecordNotFoundException();
        }

        return ((double) attendedClasses / totalClasses) * 100;
    }
 // Calculate Semester Average
    public double calculateSemesterAverage(String studentId,
                                           int semester)
            throws RecordNotFoundException,
                   InvalidStudentException {

        validateStudent(studentId);

        double total = 0;
        int count = 0;

        for (AcademicRecord ar : academicRecords) {

            if (ar.getStudentId().equalsIgnoreCase(studentId)
                    && ar.getSemester() == semester) {

                total += ar.getTotalMarks();
                count++;
            }
        }

        if (count == 0) {
            throw new RecordNotFoundException();
        }

        return total / count;
    }
 // Generate Student Summary
    public String generateStudentSummary(String studentId,
                                       int semester)
            throws InvalidStudentException,
                   RecordNotFoundException {

        validateStudent(studentId);

        Student student = null;

        for (Student s : students) {

            if (s.getStudentId().equalsIgnoreCase(studentId)) {

                student = s;
                break;
            }
        }

        if (student == null) {
            throw new InvalidStudentException();
        }

        double average = calculateSemesterAverage(studentId, semester);

        double attendance = calculateAttendancePercentage(studentId, semester);
        System.out.println("Student ID           : " + student.getStudentId());
        System.out.println("Student Name         : " + student.getName());
        System.out.println("Program              : " + student.getProgram());
        System.out.println("Semester             : " + semester);
        System.out.printf("Semester Average     : %.2f%n", average);
        System.out.printf("Attendance           : %.2f%%%n", attendance);
		return studentId;
    }
}