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
@Table(name="party_relationship",catalog="wms")
@Indexed
@XmlRootElement
public class PartyRelationship extends BaseObject implements Serializable {
    private Long partyRelationshipId;
    private Long partyRelationshipTypeId;
    private Long partyIdFrom;
    private Long partyIdTo;
    private Long roleTypeIdFrom;
    private Long roleTypeIdTo;
    private Date fromDate;
    private Date thruDate;
    private Long statusId;
    private Date createdTime;
    private Date lastUpdatedTime;
    private Long createdByUser;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="party_relationship_id", unique=true, nullable=false)    
    public Long getPartyRelationshipId() {
        return this.partyRelationshipId;
    }
    
    public void setPartyRelationshipId(Long partyRelationshipId) {
        this.partyRelationshipId = partyRelationshipId;
    }
    
    @Column(name="party_relationship_type_id")
    @Field
    public Long getPartyRelationshipTypeId() {
        return this.partyRelationshipTypeId;
    }
    
    public void setPartyRelationshipTypeId(Long partyRelationshipTypeId) {
        this.partyRelationshipTypeId = partyRelationshipTypeId;
    }
    
    @Column(name="party_id_from")
    @Field
    public Long getPartyIdFrom() {
        return this.partyIdFrom;
    }
    
    public void setPartyIdFrom(Long partyIdFrom) {
        this.partyIdFrom = partyIdFrom;
    }
    
    @Column(name="party_id_to")
    @Field
    public Long getPartyIdTo() {
        return this.partyIdTo;
    }
    
    public void setPartyIdTo(Long partyIdTo) {
        this.partyIdTo = partyIdTo;
    }
    
    @Column(name="role_type_id_from")
    @Field
    public Long getRoleTypeIdFrom() {
        return this.roleTypeIdFrom;
    }
    
    public void setRoleTypeIdFrom(Long roleTypeIdFrom) {
        this.roleTypeIdFrom = roleTypeIdFrom;
    }
    
    @Column(name="role_type_id_to")
    @Field
    public Long getRoleTypeIdTo() {
        return this.roleTypeIdTo;
    }
    
    public void setRoleTypeIdTo(Long roleTypeIdTo) {
        this.roleTypeIdTo = roleTypeIdTo;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="from_date", length=10)
    @Field
    public Date getFromDate() {
        return this.fromDate;
    }
    
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="thru_date", length=10)
    @Field
    public Date getThruDate() {
        return this.thruDate;
    }
    
    public void setThruDate(Date thruDate) {
        this.thruDate = thruDate;
    }
    
    @Column(name="status_id")
    @Field
    public Long getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(Long statusId) {
        this.statusId = statusId;
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

        PartyRelationship pojo = (PartyRelationship) o;

        if (partyRelationshipTypeId != null ? !partyRelationshipTypeId.equals(pojo.partyRelationshipTypeId) : pojo.partyRelationshipTypeId != null) return false;
        if (partyIdFrom != null ? !partyIdFrom.equals(pojo.partyIdFrom) : pojo.partyIdFrom != null) return false;
        if (partyIdTo != null ? !partyIdTo.equals(pojo.partyIdTo) : pojo.partyIdTo != null) return false;
        if (roleTypeIdFrom != null ? !roleTypeIdFrom.equals(pojo.roleTypeIdFrom) : pojo.roleTypeIdFrom != null) return false;
        if (roleTypeIdTo != null ? !roleTypeIdTo.equals(pojo.roleTypeIdTo) : pojo.roleTypeIdTo != null) return false;
        if (fromDate != null ? !fromDate.equals(pojo.fromDate) : pojo.fromDate != null) return false;
        if (thruDate != null ? !thruDate.equals(pojo.thruDate) : pojo.thruDate != null) return false;
        if (statusId != null ? !statusId.equals(pojo.statusId) : pojo.statusId != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (partyRelationshipTypeId != null ? partyRelationshipTypeId.hashCode() : 0);
        result = 31 * result + (partyIdFrom != null ? partyIdFrom.hashCode() : 0);
        result = 31 * result + (partyIdTo != null ? partyIdTo.hashCode() : 0);
        result = 31 * result + (roleTypeIdFrom != null ? roleTypeIdFrom.hashCode() : 0);
        result = 31 * result + (roleTypeIdTo != null ? roleTypeIdTo.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (thruDate != null ? thruDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("partyRelationshipId").append("='").append(getPartyRelationshipId()).append("', ");
        sb.append("partyRelationshipTypeId").append("='").append(getPartyRelationshipTypeId()).append("', ");
        sb.append("partyIdFrom").append("='").append(getPartyIdFrom()).append("', ");
        sb.append("partyIdTo").append("='").append(getPartyIdTo()).append("', ");
        sb.append("roleTypeIdFrom").append("='").append(getRoleTypeIdFrom()).append("', ");
        sb.append("roleTypeIdTo").append("='").append(getRoleTypeIdTo()).append("', ");
        sb.append("fromDate").append("='").append(getFromDate()).append("', ");
        sb.append("thruDate").append("='").append(getThruDate()).append("', ");
        sb.append("statusId").append("='").append(getStatusId()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
