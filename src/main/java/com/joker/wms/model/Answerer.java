package com.joker.wms.model;

import com.joker.wms.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="answerer",catalog="wms")
@Indexed
@XmlRootElement
public class Answerer extends BaseObject implements Serializable {
    private Long answererId;
    private String answerPerson;
    private String answerPhone;
    private String answerIdentifyId;
    private Long answerPid;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="answerer_id", unique=true, nullable=false)    
    public Long getAnswererId() {
        return this.answererId;
    }
    
    public void setAnswererId(Long answererId) {
        this.answererId = answererId;
    }
    
    @Column(name="answer_person", length=50)
    @Field
    public String getAnswerPerson() {
        return this.answerPerson;
    }
    
    public void setAnswerPerson(String answerPerson) {
        this.answerPerson = answerPerson;
    }
    
    @Column(name="answer_phone", length=20)
    @Field
    public String getAnswerPhone() {
        return this.answerPhone;
    }
    
    public void setAnswerPhone(String answerPhone) {
        this.answerPhone = answerPhone;
    }
    
    @Column(name="answer_identify_id", length=20)
    @Field
    public String getAnswerIdentifyId() {
        return this.answerIdentifyId;
    }
    
    public void setAnswerIdentifyId(String answerIdentifyId) {
        this.answerIdentifyId = answerIdentifyId;
    }
    
    @Column(name="answer_pid")
    @Field
    public Long getAnswerPid() {
        return this.answerPid;
    }
    
    public void setAnswerPid(Long answerPid) {
        this.answerPid = answerPid;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answerer pojo = (Answerer) o;

        if (answerPerson != null ? !answerPerson.equals(pojo.answerPerson) : pojo.answerPerson != null) return false;
        if (answerPhone != null ? !answerPhone.equals(pojo.answerPhone) : pojo.answerPhone != null) return false;
        if (answerIdentifyId != null ? !answerIdentifyId.equals(pojo.answerIdentifyId) : pojo.answerIdentifyId != null) return false;
        if (answerPid != null ? !answerPid.equals(pojo.answerPid) : pojo.answerPid != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (answerPerson != null ? answerPerson.hashCode() : 0);
        result = 31 * result + (answerPhone != null ? answerPhone.hashCode() : 0);
        result = 31 * result + (answerIdentifyId != null ? answerIdentifyId.hashCode() : 0);
        result = 31 * result + (answerPid != null ? answerPid.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("answererId").append("='").append(getAnswererId()).append("', ");
        sb.append("answerPerson").append("='").append(getAnswerPerson()).append("', ");
        sb.append("answerPhone").append("='").append(getAnswerPhone()).append("', ");
        sb.append("answerIdentifyId").append("='").append(getAnswerIdentifyId()).append("', ");
        sb.append("answerPid").append("='").append(getAnswerPid()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
