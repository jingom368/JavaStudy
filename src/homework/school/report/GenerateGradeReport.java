package homework.school.report;

import java.util.ArrayList;

import homework.grade.BasisEvaluation;
import homework.grade.GradeEvaluation;
import homework.grade.MajorEvaluation;
import homework.grade.PassFailEvaluation;
import homework.school.School;
import homework.school.Score;
import homework.school.Student;
import homework.school.Subject;
import homework.utils.Define;

public class GenerateGradeReport {
    School school = School.getInstance();
    public static final String TITLE = " 수강생 학점 \t\t\n";
    public static final String HEADER = " 이름 | 학번 | 필수과목 | 점수 \n";
    public static final String LINE = "----------------------------------------\n";

    private StringBuffer buffer = new StringBuffer();

    public String getReport() {
        ArrayList<Subject> subjectList = school.getSubjectList();
        
        for(Subject subject : subjectList) {
            makeHeader(subject);
            makeBody(subject);
            makeFooter();
        }
        return buffer.toString();
    }

    public void makeHeader(Subject subject) {
        buffer.append(GenerateGradeReport.LINE);
        buffer.append("\t" + subject.getSubjectName());
        buffer.append(GenerateGradeReport.TITLE);
        buffer.append(GenerateGradeReport.HEADER);
        buffer.append(GenerateGradeReport.LINE);
    }

    public void makeBody(Subject subject) {
        ArrayList<Student> studentList = subject.getStudentList();

        for(int i=0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            buffer.append(student.getstudentName());
            buffer.append(" | ");
            buffer.append(student.getStudentId());
            buffer.append(" | ");
            buffer.append(student.getMajorSubject().getSubjectName() + "\t");
            buffer.append(" | ");

            getScoreGrade(student, subject.getSubjectId());

            buffer.append("\n");
            buffer.append(LINE);
        }
    }

    public void getScoreGrade(Student student, int subjectId) {
        ArrayList<Score> scoreList = student.getScoreList();
        int majorId = student.getMajorSubject().getSubjectId();

        GradeEvaluation[] gradeEvaluation = {new BasisEvaluation(),
                                new MajorEvaluation(), new PassFailEvaluation()};
        
        for(int i=0; i<scoreList.size(); i++) {
            Score score = scoreList.get(i);
            if(score.getSubject().getSubjectId() == subjectId) { // 학점 산출할 과목
                String grade;
                if(score.getSubject().getGradeType() == Define.PF_TYPE) { // pass, fail 방식
                        grade = gradeEvaluation[Define.PF_TYPE].getGrade(score.getPoint());
                }
            
                else {
                    if(score.getSubject().getSubjectId() == majorId) // 필수 과목인 경우
                        grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());
                    else // 일반 과목인 경우
                        grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint());
                }
                buffer.append(score.getPoint());
                buffer.append(":");
                buffer.append(grade);
                buffer.append(" | ");
            }
        }
    }

    public void makeFooter() {
        buffer.append("\n");
    }
}
