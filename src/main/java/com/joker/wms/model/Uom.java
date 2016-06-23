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
@Table(name="uom",catalog="wms")
@Indexed
@XmlRootElement
public class Uom extends BaseObject implements Serializable {
    private Long uomId;
    private Long uomTypeId;
    private String abbreviation;
    private String description;
    private String pinyinName;
    private Long sequenceId;
    private Date createdTime;
    private Date lastUpdatedTime;
    private Long createdByUser;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="uom_id", unique=true, nullable=false)    
    public Long getUomId() {
        return this.uomId;
    }
    
    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }
    
    @Column(name="uom_type_id")
    @Field
    public Long getUomTypeId() {
        return this.uomTypeId;
    }
    
    public void setUomTypeId(Long uomTypeId) {
        this.uomTypeId = uomTypeId;
    }
    
    @Column(name="abbreviation", length=20)
    @Field
    public String getAbbreviation() {
        return this.abbreviation;
    }
    
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    @Column(name="description", length=100)
    @Field
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="pinyin_name", length=50)
    @Field
    public String getPinyinName() {
        return this.pinyinName;
    }
    
    public void setPinyinName(String pinyinName) {
        this.pinyinName = pinyinName;
    }
    
    @Column(name="sequence_id")
    @Field
    public Long getSequenceId() {
        return this.sequenceId;
    }
    
    public void setSequenceId(Long sequenceId) {
        this.sequenceId = sequenceId;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_time", length=19)
    @Field
    public Date getCreatedTime() {
        return this.createdTime;
    }
    
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_updated_time", length=19)
    @Field
    public Date getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }
    
    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }
    
    @Column(name="created_by_user")
    @Field
    public Long getCreatedByUser() {
        return this.createdByUser;
    }
    
    public void setCreatedByUser(Long createdByUser) {
        this.createdByUser = createdByUser;
    }
    
    @Column(name="last_updated_by_user")
    @Field
    public Long getLastUpdatedByUser() {
        return this.lastUpdatedByUser;
    }
    
    public void setLastUpdatedByUser(Long lastUpdatedByUser) {
        this.lastUpdatedByUser = lastUpdatedByUser;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Uom pojo = (Uom) o;

        if (uomTypeId != null ? !uomTypeId.equals(pojo.uomTypeId) : pojo.uomTypeId != null) return false;
        if (abbreviation != null ? !abbreviation.equals(pojo.abbreviation) : pojo.abbreviation != null) return false;
        if (description != null ? !description.equals(pojo.description) : pojo.description != null) return false;
        if (pinyinName != null ? !pinyinName.equals(pojo.pinyinName) : pojo.pinyinName != null) return false;
        if (sequenceId != null ? !sequenceId.equals(pojo.sequenceId) : pojo.sequenceId != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (uomTypeId != null ? uomTypeId.hashCode() : 0);
        result = 31 * result + (abbreviation != null ? abbreviation.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (pinyinName != null ? pinyinName.hashCode() : 0);
        result = 31 * result + (sequenceId != null ? sequenceId.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("uomId").append("='").append(getUomId()).append("', ");
        sb.append("uomTypeId").append("='").append(getUomTypeId()).append("', ");
        sb.append("abbreviation").append("='").append(getAbbreviation()).append("', ");
        sb.append("description").append("='").append(getDescription()).append("', ");
        sb.append("pinyinName").append("='").append(getPinyinName()).append("', ");
        sb.append("sequenceId").append("='").append(getSequenceId()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
