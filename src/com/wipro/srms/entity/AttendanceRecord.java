package com.wipro.srms.entity;

public class AttendanceRecord {

    private String attendanceId;
    private String studentId;
    private int semester;
    private String subjectCode;
    private int totalClasses;
    private int attendedClasses;

    public AttendanceRecord(String attendanceId,
                            String studentId,
                            int semester,
                            String subjectCode,
                            int totalClasses,
                            int attendedClasses) {

        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.semester = semester;
        this.subjectCode = subjectCode;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getTotalClasses() {
        return totalClasses;
    }

    public void setTotalClasses(int totalClasses) {
        this.totalClasses = totalClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public void setAttendedClasses(int attendedClasses) {
        this.attendedClasses = attendedClasses;
    }
}