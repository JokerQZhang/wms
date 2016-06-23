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
@Table(name="status_item",catalog="wms")
@Indexed
@XmlRootElement
public class StatusItem extends BaseObject implements Serializable {
    private Long statusId;
    private Long statusTypeId;
    private String statusCode;
    private Long sequenceId;
    private String description;
    private Date createdTime;
    private Date lastUpdatedTime;
    private Long createdByUser;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="status_id", unique=true, nullable=false)    
    public Long getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
    
    @Column(name="status_type_id")
    @Field
    public Long getStatusTypeId() {
        return this.statusTypeId;
    }
    
    public void setStatusTypeId(Long statusTypeId) {
        this.statusTypeId = statusTypeId;
    }
    
    @Column(name="status_code", length=20)
    @Field
    public String getStatusCode() {
        return this.statusCode;
    }
    
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
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

        StatusItem pojo = (StatusItem) o;

        if (statusTypeId != null ? !statusTypeId.equals(pojo.statusTypeId) : pojo.statusTypeId != null) return false;
        if (statusCode != null ? !statusCode.equals(pojo.statusCode) : pojo.statusCode != null) return false;
        if (sequenceId != null ? !sequenceId.equals(pojo.sequenceId) : pojo.sequenceId != null) return false;
        if (description != null ? !description.equals(pojo.description) : pojo.description != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (statusTypeId != null ? statusTypeId.hashCode() : 0);
        result = 31 * result + (statusCode != null ? statusCode.hashCode() : 0);
        result = 31 * result + (sequenceId != null ? sequenceId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("statusId").append("='").append(getStatusId()).append("', ");
        sb.append("statusTypeId").append("='").append(getStatusTypeId()).append("', ");
        sb.append("statusCode").append("='").append(getStatusCode()).append("', ");
        sb.append("sequenceId").append("='").append(getSequenceId()).append("', ");
        sb.append("description").append("='").append(getDescription()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
