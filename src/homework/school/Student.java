package homework.school;

import java.util.ArrayList;

public class Student {
    private int studentId;        // 학번
    private String studentName;   // 이름
    private Subject majorSubject; // 필수 과목

    private ArrayList<Score> scoreList = new ArrayList<Score>();

    public Student(int studentId, String studentName, Subject majorStudent) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.majorSubject = majorStudent;
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

    public void setstudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public Subject getMajorSubject() {
        return majorSubject;
    }

    public void setMajorSubject(Subject majorSubject) {
        this.majorSubject = majorSubject;
    }

    public ArrayList<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(ArrayList<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
