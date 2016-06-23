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
@Table(name="test_question",catalog="wms")
@Indexed
@XmlRootElement
public class TestQuestion extends BaseObject implements Serializable {
    private Long questionId;
    private Long questionType;
    private Long questionLevel;
    private String questionTitle;
    private String rightAnswer;
    private String analysis;
    private Date createTime;
    private Long createUse;
    private Date modifyTime;
    private Long modifyUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="question_id", unique=true, nullable=false)    
    public Long getQuestionId() {
        return this.questionId;
    }
    
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
    
    @Column(name="question_type")
    @Field
    public Long getQuestionType() {
        return this.questionType;
    }
    
    public void setQuestionType(Long questionType) {
        this.questionType = questionType;
    }
    
    @Column(name="question_level")
    @Field
    public Long getQuestionLevel() {
        return this.questionLevel;
    }
    
    public void setQuestionLevel(Long questionLevel) {
        this.questionLevel = questionLevel;
    }
    
    @Column(name="question_title", length=65535)
    @Field
    public String getQuestionTitle() {
        return this.questionTitle;
    }
    
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }
    
    @Column(name="right_answer", length=30)
    @Field
    public String getRightAnswer() {
        return this.rightAnswer;
    }
    
    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
    
    @Column(name="analysis", length=65535)
    @Field
    public String getAnalysis() {
        return this.analysis;
    }
    
    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time", length=19)
    @Field
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    @Column(name="create_use")
    @Field
    public Long getCreateUse() {
        return this.createUse;
    }
    
    public void setCreateUse(Long createUse) {
        this.createUse = createUse;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modify_time", length=19)
    @Field
    public Date getModifyTime() {
        return this.modifyTime;
    }
    
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    
    @Column(name="modify_user")
    @Field
    public Long getModifyUser() {
        return this.modifyUser;
    }
    
    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestQuestion pojo = (TestQuestion) o;

        if (questionType != null ? !questionType.equals(pojo.questionType) : pojo.questionType != null) return false;
        if (questionLevel != null ? !questionLevel.equals(pojo.questionLevel) : pojo.questionLevel != null) return false;
        if (questionTitle != null ? !questionTitle.equals(pojo.questionTitle) : pojo.questionTitle != null) return false;
        if (rightAnswer != null ? !rightAnswer.equals(pojo.rightAnswer) : pojo.rightAnswer != null) return false;
        if (analysis != null ? !analysis.equals(pojo.analysis) : pojo.analysis != null) return false;
        if (createTime != null ? !createTime.equals(pojo.createTime) : pojo.createTime != null) return false;
        if (createUse != null ? !createUse.equals(pojo.createUse) : pojo.createUse != null) return false;
        if (modifyTime != null ? !modifyTime.equals(pojo.modifyTime) : pojo.modifyTime != null) return false;
        if (modifyUser != null ? !modifyUser.equals(pojo.modifyUser) : pojo.modifyUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (questionType != null ? questionType.hashCode() : 0);
        result = 31 * result + (questionLevel != null ? questionLevel.hashCode() : 0);
        result = 31 * result + (questionTitle != null ? questionTitle.hashCode() : 0);
        result = 31 * result + (rightAnswer != null ? rightAnswer.hashCode() : 0);
        result = 31 * result + (analysis != null ? analysis.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUse != null ? createUse.hashCode() : 0);
        result = 31 * result + (modifyTime != null ? modifyTime.hashCode() : 0);
        result = 31 * result + (modifyUser != null ? modifyUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("questionId").append("='").append(getQuestionId()).append("', ");
        sb.append("questionType").append("='").append(getQuestionType()).append("', ");
        sb.append("questionLevel").append("='").append(getQuestionLevel()).append("', ");
        sb.append("questionTitle").append("='").append(getQuestionTitle()).append("', ");
        sb.append("rightAnswer").append("='").append(getRightAnswer()).append("', ");
        sb.append("analysis").append("='").append(getAnalysis()).append("', ");
        sb.append("createTime").append("='").append(getCreateTime()).append("', ");
        sb.append("createUse").append("='").append(getCreateUse()).append("', ");
        sb.append("modifyTime").append("='").append(getModifyTime()).append("', ");
        sb.append("modifyUser").append("='").append(getModifyUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
