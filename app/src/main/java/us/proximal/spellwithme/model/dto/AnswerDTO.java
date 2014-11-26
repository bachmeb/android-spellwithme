package us.proximal.spellwithme.model.dto;

import java.util.Date;

/**
 * Created by b on 11/26/14.
 */
public class AnswerDTO {

    private int questionId;
    private int studentId;
    private int mkoId;
    private Date date;
    private char grade;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getMkoId() {
        return mkoId;
    }

    public void setMkoId(int mkoId) {
        this.mkoId = mkoId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}
