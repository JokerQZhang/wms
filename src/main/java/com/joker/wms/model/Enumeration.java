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
@Table(name="enumeration",catalog="wms")
@Indexed
@XmlRootElement
public class Enumeration extends BaseObject implements Serializable {
    private Long enumId;
    private Long enumTypeId;
    private String enumCode;
    private Long sequenceId;
    private String description;
    private String pinyinName;
    private String enumAttached1;
    private String enumAttached2;
    private String enumAttached3;
    private Date createdTime;
    private Date lastUpdatedTime;
    private Long createdByUser;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="enum_id", unique=true, nullable=false)    
    public Long getEnumId() {
        return this.enumId;
    }
    
    public void setEnumId(Long enumId) {
        this.enumId = enumId;
    }
    
    @Column(name="enum_type_id")
    @Field
    public Long getEnumTypeId() {
        return this.enumTypeId;
    }
    
    public void setEnumTypeId(Long enumTypeId) {
        this.enumTypeId = enumTypeId;
    }
    
    @Column(name="enum_code", length=20)
    @Field
    public String getEnumCode() {
        return this.enumCode;
    }
    
    public void setEnumCode(String enumCode) {
        this.enumCode = enumCode;
    }
    
    @Column(name="sequence_id")
    @Field
    public Long getSequenceId() {
        return this.sequenceId;
    }
    
    public void setSequenceId(Long sequenceId) {
        this.sequenceId = sequenceId;
    }
    
    @Column(name="description", length=30)
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
    
    @Column(name="enum_attached1", length=30)
    @Field
    public String getEnumAttached1() {
        return this.enumAttached1;
    }
    
    public void setEnumAttached1(String enumAttached1) {
        this.enumAttached1 = enumAttached1;
    }
    
    @Column(name="enum_attached2", length=30)
    @Field
    public String getEnumAttached2() {
        return this.enumAttached2;
    }
    
    public void setEnumAttached2(String enumAttached2) {
        this.enumAttached2 = enumAttached2;
    }
    
    @Column(name="enum_attached3", length=30)
    @Field
    public String getEnumAttached3() {
        return this.enumAttached3;
    }
    
    public void setEnumAttached3(String enumAttached3) {
        this.enumAttached3 = enumAttached3;
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

        Enumeration pojo = (Enumeration) o;

        if (enumTypeId != null ? !enumTypeId.equals(pojo.enumTypeId) : pojo.enumTypeId != null) return false;
        if (enumCode != null ? !enumCode.equals(pojo.enumCode) : pojo.enumCode != null) return false;
        if (sequenceId != null ? !sequenceId.equals(pojo.sequenceId) : pojo.sequenceId != null) return false;
        if (description != null ? !description.equals(pojo.description) : pojo.description != null) return false;
        if (pinyinName != null ? !pinyinName.equals(pojo.pinyinName) : pojo.pinyinName != null) return false;
        if (enumAttached1 != null ? !enumAttached1.equals(pojo.enumAttached1) : pojo.enumAttached1 != null) return false;
        if (enumAttached2 != null ? !enumAttached2.equals(pojo.enumAttached2) : pojo.enumAttached2 != null) return false;
        if (enumAttached3 != null ? !enumAttached3.equals(pojo.enumAttached3) : pojo.enumAttached3 != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (enumTypeId != null ? enumTypeId.hashCode() : 0);
        result = 31 * result + (enumCode != null ? enumCode.hashCode() : 0);
        result = 31 * result + (sequenceId != null ? sequenceId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (pinyinName != null ? pinyinName.hashCode() : 0);
        result = 31 * result + (enumAttached1 != null ? enumAttached1.hashCode() : 0);
        result = 31 * result + (enumAttached2 != null ? enumAttached2.hashCode() : 0);
        result = 31 * result + (enumAttached3 != null ? enumAttached3.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("enumId").append("='").append(getEnumId()).append("', ");
        sb.append("enumTypeId").append("='").append(getEnumTypeId()).append("', ");
        sb.append("enumCode").append("='").append(getEnumCode()).append("', ");
        sb.append("sequenceId").append("='").append(getSequenceId()).append("', ");
        sb.append("description").append("='").append(getDescription()).append("', ");
        sb.append("pinyinName").append("='").append(getPinyinName()).append("', ");
        sb.append("enumAttached1").append("='").append(getEnumAttached1()).append("', ");
        sb.append("enumAttached2").append("='").append(getEnumAttached2()).append("', ");
        sb.append("enumAttached3").append("='").append(getEnumAttached3()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
