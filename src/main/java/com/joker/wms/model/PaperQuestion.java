package com.joker.wms.model;

import com.joker.wms.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="paper_question",catalog="wms")
@Indexed
@XmlRootElement
public class PaperQuestion extends BaseObject implements Serializable {
    private Long paperQuestionId;
    private Long questionId;
    private Long paperId;
    private String answer;
    private Date answerTime;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="paper_question_id", unique=true, nullable=false)    
    public Long getPaperQuestionId() {
        return this.paperQuestionId;
    }
    
    public void setPaperQuestionId(Long paperQuestionId) {
        this.paperQuestionId = paperQuestionId;
    }
    
    @Column(name="question_id")
    @Field
    public Long getQuestionId() {
        return this.questionId;
    }
    
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
    
    @Column(name="paper_id")
    @Field
    public Long getPaperId() {
        return this.paperId;
    }
    
    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }
    
    @Column(name="answer", length=30)
    @Field
    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="answer_time", length=19)
    @Field
    public Date getAnswerTime() {
        return this.answerTime;
    }
    
    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaperQuestion pojo = (PaperQuestion) o;

        if (questionId != null ? !questionId.equals(pojo.questionId) : pojo.questionId != null) return false;
        if (paperId != null ? !paperId.equals(pojo.paperId) : pojo.paperId != null) return false;
        if (answer != null ? !answer.equals(pojo.answer) : pojo.answer != null) return false;
        if (answerTime != null ? !answerTime.equals(pojo.answerTime) : pojo.answerTime != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (questionId != null ? questionId.hashCode() : 0);
        result = 31 * result + (paperId != null ? paperId.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (answerTime != null ? answerTime.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("paperQuestionId").append("='").append(getPaperQuestionId()).append("', ");
        sb.append("questionId").append("='").append(getQuestionId()).append("', ");
        sb.append("paperId").append("='").append(getPaperId()).append("', ");
        sb.append("answer").append("='").append(getAnswer()).append("', ");
        sb.append("answerTime").append("='").append(getAnswerTime()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
