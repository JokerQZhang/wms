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
@Table(name="test_paper",catalog="wms")
@Indexed
@XmlRootElement
public class TestPaper extends BaseObject implements Serializable {
    private Long paperId;
    private String purposeType;
    private String paperName;
    private String paperType;
    private Long score;
    private Date generateTime;
    private String memo;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="paper_id", unique=true, nullable=false)    
    public Long getPaperId() {
        return this.paperId;
    }
    
    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }
    
    @Column(name="purpose_type", length=20)
    @Field
    public String getPurposeType() {
        return this.purposeType;
    }
    
    public void setPurposeType(String purposeType) {
        this.purposeType = purposeType;
    }
    
    @Column(name="paper_name", length=50)
    @Field
    public String getPaperName() {
        return this.paperName;
    }
    
    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }
    
    @Column(name="paper_type", length=50)
    @Field
    public String getPaperType() {
        return this.paperType;
    }
    
    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }
    
    @Column(name="score")
    @Field
    public Long getScore() {
        return this.score;
    }
    
    public void setScore(Long score) {
        this.score = score;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="generate_time", length=19)
    @Field
    public Date getGenerateTime() {
        return this.generateTime;
    }
    
    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }
    
    @Column(name="memo", length=200)
    @Field
    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestPaper pojo = (TestPaper) o;

        if (purposeType != null ? !purposeType.equals(pojo.purposeType) : pojo.purposeType != null) return false;
        if (paperName != null ? !paperName.equals(pojo.paperName) : pojo.paperName != null) return false;
        if (paperType != null ? !paperType.equals(pojo.paperType) : pojo.paperType != null) return false;
        if (score != null ? !score.equals(pojo.score) : pojo.score != null) return false;
        if (generateTime != null ? !generateTime.equals(pojo.generateTime) : pojo.generateTime != null) return false;
        if (memo != null ? !memo.equals(pojo.memo) : pojo.memo != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (purposeType != null ? purposeType.hashCode() : 0);
        result = 31 * result + (paperName != null ? paperName.hashCode() : 0);
        result = 31 * result + (paperType != null ? paperType.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (generateTime != null ? generateTime.hashCode() : 0);
        result = 31 * result + (memo != null ? memo.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("paperId").append("='").append(getPaperId()).append("', ");
        sb.append("purposeType").append("='").append(getPurposeType()).append("', ");
        sb.append("paperName").append("='").append(getPaperName()).append("', ");
        sb.append("paperType").append("='").append(getPaperType()).append("', ");
        sb.append("score").append("='").append(getScore()).append("', ");
        sb.append("generateTime").append("='").append(getGenerateTime()).append("', ");
        sb.append("memo").append("='").append(getMemo()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
