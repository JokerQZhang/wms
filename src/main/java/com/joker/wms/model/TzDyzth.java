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
@Table(name="tz_dyzth",catalog="wms")
@Indexed
@XmlRootElement
public class TzDyzth extends BaseObject implements Serializable {
    private Long dyzthId;
    private String tzDate;
    private Long groupPartyId;
    private Date createdTime;
    private Long createdByUser;
    private Date lastUpdatedTime;
    private Long lastUpdatedByUser;
    private String hyDate;
    private String address;
    private String content;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="dyzth_id", unique=true, nullable=false)    
    public Long getDyzthId() {
        return this.dyzthId;
    }
    
    public void setDyzthId(Long dyzthId) {
        this.dyzthId = dyzthId;
    }
    
    @Column(name="tz_date", length=20)
    @Field
    public String getTzDate() {
        return this.tzDate;
    }
    
    public void setTzDate(String tzDate) {
        this.tzDate = tzDate;
    }
    
    @Column(name="group_party_id")
    @Field
    public Long getGroupPartyId() {
        return this.groupPartyId;
    }
    
    public void setGroupPartyId(Long groupPartyId) {
        this.groupPartyId = groupPartyId;
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
    
    @Column(name="created_by_user")
    @Field
    public Long getCreatedByUser() {
        return this.createdByUser;
    }
    
    public void setCreatedByUser(Long createdByUser) {
        this.createdByUser = createdByUser;
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
    
    @Column(name="last_updated_by_user")
    @Field
    public Long getLastUpdatedByUser() {
        return this.lastUpdatedByUser;
    }
    
    public void setLastUpdatedByUser(Long lastUpdatedByUser) {
        this.lastUpdatedByUser = lastUpdatedByUser;
    }
    
    @Column(name="hy_date", length=20)
    @Field
    public String getHyDate() {
        return this.hyDate;
    }
    
    public void setHyDate(String hyDate) {
        this.hyDate = hyDate;
    }
    
    @Column(name="address")
    @Field
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="content", length=2000)
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

        TzDyzth pojo = (TzDyzth) o;

        if (tzDate != null ? !tzDate.equals(pojo.tzDate) : pojo.tzDate != null) return false;
        if (groupPartyId != null ? !groupPartyId.equals(pojo.groupPartyId) : pojo.groupPartyId != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;
        if (hyDate != null ? !hyDate.equals(pojo.hyDate) : pojo.hyDate != null) return false;
        if (address != null ? !address.equals(pojo.address) : pojo.address != null) return false;
        if (content != null ? !content.equals(pojo.content) : pojo.content != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (tzDate != null ? tzDate.hashCode() : 0);
        result = 31 * result + (groupPartyId != null ? groupPartyId.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);
        result = 31 * result + (hyDate != null ? hyDate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("dyzthId").append("='").append(getDyzthId()).append("', ");
        sb.append("tzDate").append("='").append(getTzDate()).append("', ");
        sb.append("groupPartyId").append("='").append(getGroupPartyId()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("', ");
        sb.append("hyDate").append("='").append(getHyDate()).append("', ");
        sb.append("address").append("='").append(getAddress()).append("', ");
        sb.append("content").append("='").append(getContent()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
