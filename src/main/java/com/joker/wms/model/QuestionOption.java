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
@Table(name="question_option",catalog="wms")
@Indexed
@XmlRootElement
public class QuestionOption extends BaseObject implements Serializable {
    private Long questionOptionId;
    private Long questionId;
    private String title;
    private String content;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="question_option_id", unique=true, nullable=false)    
    public Long getQuestionOptionId() {
        return this.questionOptionId;
    }
    
    public void setQuestionOptionId(Long questionOptionId) {
        this.questionOptionId = questionOptionId;
    }
    
    @Column(name="question_id")
    @Field
    public Long getQuestionId() {
        return this.questionId;
    }
    
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
    
    @Column(name="title", length=20)
    @Field
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Column(name="content", length=500)
    @Field
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionOption pojo = (QuestionOption) o;

        if (questionId != null ? !questionId.equals(pojo.questionId) : pojo.questionId != null) return false;
        if (title != null ? !title.equals(pojo.title) : pojo.title != null) return false;
        if (content != null ? !content.equals(pojo.content) : pojo.content != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (questionId != null ? questionId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("questionOptionId").append("='").append(getQuestionOptionId()).append("', ");
        sb.append("questionId").append("='").append(getQuestionId()).append("', ");
        sb.append("title").append("='").append(getTitle()).append("', ");
        sb.append("content").append("='").append(getContent()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
