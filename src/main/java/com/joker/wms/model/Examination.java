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
@Table(name="examination",catalog="wms")
@Indexed
@XmlRootElement
public class Examination extends BaseObject implements Serializable {
    private Long examinationId;
    private Long paperId;
    private Long answererId;
    private Date startTime;
    private Date endTime;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="examination_id", unique=true, nullable=false)    
    public Long getExaminationId() {
        return this.examinationId;
    }
    
    public void setExaminationId(Long examinationId) {
        this.examinationId = examinationId;
    }
    
    @Column(name="paper_id")
    @Field
    public Long getPaperId() {
        return this.paperId;
    }
    
    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }
    
    @Column(name="answerer_id")
    @Field
    public Long getAnswererId() {
        return this.answererId;
    }
    
    public void setAnswererId(Long answererId) {
        this.answererId = answererId;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_time", length=19)
    @Field
    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_time", length=19)
    @Field
    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Examination pojo = (Examination) o;

        if (paperId != null ? !paperId.equals(pojo.paperId) : pojo.paperId != null) return false;
        if (answererId != null ? !answererId.equals(pojo.answererId) : pojo.answererId != null) return false;
        if (startTime != null ? !startTime.equals(pojo.startTime) : pojo.startTime != null) return false;
        if (endTime != null ? !endTime.equals(pojo.endTime) : pojo.endTime != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (paperId != null ? paperId.hashCode() : 0);
        result = 31 * result + (answererId != null ? answererId.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("examinationId").append("='").append(getExaminationId()).append("', ");
        sb.append("paperId").append("='").append(getPaperId()).append("', ");
        sb.append("answererId").append("='").append(getAnswererId()).append("', ");
        sb.append("startTime").append("='").append(getStartTime()).append("', ");
        sb.append("endTime").append("='").append(getEndTime()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
