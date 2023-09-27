package grade;

import java.util.ArrayList;

import school.School;
import school.Score;
import school.Student;
import school.Subject;
import utils.Define;

public class GenerateGradeReport {
    School school = School.getInstance();
    public static final String TITLE = " 수강생 학점 \t\t\n";
    public static final String HEADER = " 이름 | 학번 | 필수과목 | 점수 \n";
    public static final String LINE = "----------------------------------------\n";

    private StringBuffer buffer = new StringBuffer();

    public String getReport() {
        ArrayList<Subject> subjectList = shcool.getSubjectList();
        
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
                                new MajorEvaluation()};
        
        for(int i=0; i<ScoreList.size(); i++) {
            Score score = scoreList.get(i);
            if(score.getSubject().getSubjectId() == subjectId) { // 학점 산출할 과목
                String grade;
            }
                if(score.getStudent().getStudentId() == majorId) // 필수 과목인 경우
                    grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());
                else // 일반 과목인 경우
        }
    }
}
