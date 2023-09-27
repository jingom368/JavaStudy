package school;

import java.util.ArrayList;

public class Student {
    private int studentId;
    private String studentName;
    private Subject majorStudent;

    private ArrayList<Score> scoreList = new ArrayList<Score>();

    public Student(int studentId, String studentName, Subject majorStudent) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.majorStudent = majorStudent;
    }

    public void addSubjectScore(Score score) {
        scoreList.add(score);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }  

    public String getstudentName() {
        return studentName;
    }

    public void setstudentName() {
        this.studentName = studentName;
    }
    
    public Subject getMajorSubject() {
        return majorSubject;
    }

    public void setMajorSubject() {
        this.majorSubject = majorSubject;
    }

    public ArrayList<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(ArrayList<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
