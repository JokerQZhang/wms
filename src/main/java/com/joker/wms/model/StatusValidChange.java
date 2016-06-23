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
@Table(name="status_valid_change",catalog="wms")
@Indexed
@XmlRootElement
public class StatusValidChange extends BaseObject implements Serializable {
    private Long svcId;
    private Long statusIdFrom;
    private Long statusIdTo;
    private String conditionExpression;
    private String transitionName;
    private Date createdTime;
    private Date lastUpdatedTime;
    private Long createdByUser;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="svc_id", unique=true, nullable=false)    
    public Long getSvcId() {
        return this.svcId;
    }
    
    public void setSvcId(Long svcId) {
        this.svcId = svcId;
    }
    
    @Column(name="status_id_from")
    @Field
    public Long getStatusIdFrom() {
        return this.statusIdFrom;
    }
    
    public void setStatusIdFrom(Long statusIdFrom) {
        this.statusIdFrom = statusIdFrom;
    }
    
    @Column(name="status_id_to")
    @Field
    public Long getStatusIdTo() {
        return this.statusIdTo;
    }
    
    public void setStatusIdTo(Long statusIdTo) {
        this.statusIdTo = statusIdTo;
    }
    
    @Column(name="condition_expression", length=30)
    @Field
    public String getConditionExpression() {
        return this.conditionExpression;
    }
    
    public void setConditionExpression(String conditionExpression) {
        this.conditionExpression = conditionExpression;
    }
    
    @Column(name="transition_name", length=30)
    @Field
    public String getTransitionName() {
        return this.transitionName;
    }
    
    public void setTransitionName(String transitionName) {
        this.transitionName = transitionName;
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

        StatusValidChange pojo = (StatusValidChange) o;

        if (statusIdFrom != null ? !statusIdFrom.equals(pojo.statusIdFrom) : pojo.statusIdFrom != null) return false;
        if (statusIdTo != null ? !statusIdTo.equals(pojo.statusIdTo) : pojo.statusIdTo != null) return false;
        if (conditionExpression != null ? !conditionExpression.equals(pojo.conditionExpression) : pojo.conditionExpression != null) return false;
        if (transitionName != null ? !transitionName.equals(pojo.transitionName) : pojo.transitionName != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (statusIdFrom != null ? statusIdFrom.hashCode() : 0);
        result = 31 * result + (statusIdTo != null ? statusIdTo.hashCode() : 0);
        result = 31 * result + (conditionExpression != null ? conditionExpression.hashCode() : 0);
        result = 31 * result + (transitionName != null ? transitionName.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("svcId").append("='").append(getSvcId()).append("', ");
        sb.append("statusIdFrom").append("='").append(getStatusIdFrom()).append("', ");
        sb.append("statusIdTo").append("='").append(getStatusIdTo()).append("', ");
        sb.append("conditionExpression").append("='").append(getConditionExpression()).append("', ");
        sb.append("transitionName").append("='").append(getTransitionName()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
