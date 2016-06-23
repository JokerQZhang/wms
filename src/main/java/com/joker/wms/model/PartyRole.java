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
@Table(name="party_role",catalog="wms")
@Indexed
@XmlRootElement
public class PartyRole extends BaseObject implements Serializable {
    private Long prId;
    private Long partyId;
    private Long roleTypeId;
    private String roleAttached1;
    private String roleAttached2;
    private String roleAttached3;
    private Date createdTime;
    private Date lastUpdatedTime;
    private Long createdByUser;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="pr_id", unique=true, nullable=false)    
    public Long getPrId() {
        return this.prId;
    }
    
    public void setPrId(Long prId) {
        this.prId = prId;
    }
    
    @Column(name="party_id")
    @Field
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    
    @Column(name="role_type_id")
    @Field
    public Long getRoleTypeId() {
        return this.roleTypeId;
    }
    
    public void setRoleTypeId(Long roleTypeId) {
        this.roleTypeId = roleTypeId;
    }
    
    @Column(name="role_attached1", length=50)
    @Field
    public String getRoleAttached1() {
        return this.roleAttached1;
    }
    
    public void setRoleAttached1(String roleAttached1) {
        this.roleAttached1 = roleAttached1;
    }
    
    @Column(name="role_attached2", length=50)
    @Field
    public String getRoleAttached2() {
        return this.roleAttached2;
    }
    
    public void setRoleAttached2(String roleAttached2) {
        this.roleAttached2 = roleAttached2;
    }
    
    @Column(name="role_attached3", length=50)
    @Field
    public String getRoleAttached3() {
        return this.roleAttached3;
    }
    
    public void setRoleAttached3(String roleAttached3) {
        this.roleAttached3 = roleAttached3;
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

        PartyRole pojo = (PartyRole) o;

        if (partyId != null ? !partyId.equals(pojo.partyId) : pojo.partyId != null) return false;
        if (roleTypeId != null ? !roleTypeId.equals(pojo.roleTypeId) : pojo.roleTypeId != null) return false;
        if (roleAttached1 != null ? !roleAttached1.equals(pojo.roleAttached1) : pojo.roleAttached1 != null) return false;
        if (roleAttached2 != null ? !roleAttached2.equals(pojo.roleAttached2) : pojo.roleAttached2 != null) return false;
        if (roleAttached3 != null ? !roleAttached3.equals(pojo.roleAttached3) : pojo.roleAttached3 != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (roleTypeId != null ? roleTypeId.hashCode() : 0);
        result = 31 * result + (roleAttached1 != null ? roleAttached1.hashCode() : 0);
        result = 31 * result + (roleAttached2 != null ? roleAttached2.hashCode() : 0);
        result = 31 * result + (roleAttached3 != null ? roleAttached3.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("prId").append("='").append(getPrId()).append("', ");
        sb.append("partyId").append("='").append(getPartyId()).append("', ");
        sb.append("roleTypeId").append("='").append(getRoleTypeId()).append("', ");
        sb.append("roleAttached1").append("='").append(getRoleAttached1()).append("', ");
        sb.append("roleAttached2").append("='").append(getRoleAttached2()).append("', ");
        sb.append("roleAttached3").append("='").append(getRoleAttached3()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
