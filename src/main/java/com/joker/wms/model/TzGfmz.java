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
@Table(name="tz_gfmz",catalog="wms")
@Indexed
@XmlRootElement
public class TzGfmz extends BaseObject implements Serializable {
    private Long gfmzId;
    private String tzDate;
    private Long groupPartyId;
    private Date createdTime;
    private Long createdByUser;
    private Date lastUpdatedTime;
    private Long lastUpdatedByUser;
    private String sylhgkTimes;
    private String sylhgkDtl;
    private String dyzhfwzTimes;
    private String dyzhfwzDtl;
    private String szgsNum;
    private String szgsTime;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="gfmz_id", unique=true, nullable=false)    
    public Long getGfmzId() {
        return this.gfmzId;
    }
    
    public void setGfmzId(Long gfmzId) {
        this.gfmzId = gfmzId;
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
    
    @Column(name="sylhgk_times", length=20)
    @Field
    public String getSylhgkTimes() {
        return this.sylhgkTimes;
    }
    
    public void setSylhgkTimes(String sylhgkTimes) {
        this.sylhgkTimes = sylhgkTimes;
    }
    
    @Column(name="sylhgk_dtl")
    @Field
    public String getSylhgkDtl() {
        return this.sylhgkDtl;
    }
    
    public void setSylhgkDtl(String sylhgkDtl) {
        this.sylhgkDtl = sylhgkDtl;
    }
    
    @Column(name="dyzhfwz_times", length=20)
    @Field
    public String getDyzhfwzTimes() {
        return this.dyzhfwzTimes;
    }
    
    public void setDyzhfwzTimes(String dyzhfwzTimes) {
        this.dyzhfwzTimes = dyzhfwzTimes;
    }
    
    @Column(name="dyzhfwz_dtl")
    @Field
    public String getDyzhfwzDtl() {
        return this.dyzhfwzDtl;
    }
    
    public void setDyzhfwzDtl(String dyzhfwzDtl) {
        this.dyzhfwzDtl = dyzhfwzDtl;
    }
    
    @Column(name="szgs_num", length=20)
    @Field
    public String getSzgsNum() {
        return this.szgsNum;
    }
    
    public void setSzgsNum(String szgsNum) {
        this.szgsNum = szgsNum;
    }
    
    @Column(name="szgs_time", length=20)
    @Field
    public String getSzgsTime() {
        return this.szgsTime;
    }
    
    public void setSzgsTime(String szgsTime) {
        this.szgsTime = szgsTime;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TzGfmz pojo = (TzGfmz) o;

        if (tzDate != null ? !tzDate.equals(pojo.tzDate) : pojo.tzDate != null) return false;
        if (groupPartyId != null ? !groupPartyId.equals(pojo.groupPartyId) : pojo.groupPartyId != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;
        if (sylhgkTimes != null ? !sylhgkTimes.equals(pojo.sylhgkTimes) : pojo.sylhgkTimes != null) return false;
        if (sylhgkDtl != null ? !sylhgkDtl.equals(pojo.sylhgkDtl) : pojo.sylhgkDtl != null) return false;
        if (dyzhfwzTimes != null ? !dyzhfwzTimes.equals(pojo.dyzhfwzTimes) : pojo.dyzhfwzTimes != null) return false;
        if (dyzhfwzDtl != null ? !dyzhfwzDtl.equals(pojo.dyzhfwzDtl) : pojo.dyzhfwzDtl != null) return false;
        if (szgsNum != null ? !szgsNum.equals(pojo.szgsNum) : pojo.szgsNum != null) return false;
        if (szgsTime != null ? !szgsTime.equals(pojo.szgsTime) : pojo.szgsTime != null) return false;

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
        result = 31 * result + (sylhgkTimes != null ? sylhgkTimes.hashCode() : 0);
        result = 31 * result + (sylhgkDtl != null ? sylhgkDtl.hashCode() : 0);
        result = 31 * result + (dyzhfwzTimes != null ? dyzhfwzTimes.hashCode() : 0);
        result = 31 * result + (dyzhfwzDtl != null ? dyzhfwzDtl.hashCode() : 0);
        result = 31 * result + (szgsNum != null ? szgsNum.hashCode() : 0);
        result = 31 * result + (szgsTime != null ? szgsTime.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("gfmzId").append("='").append(getGfmzId()).append("', ");
        sb.append("tzDate").append("='").append(getTzDate()).append("', ");
        sb.append("groupPartyId").append("='").append(getGroupPartyId()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("', ");
        sb.append("sylhgkTimes").append("='").append(getSylhgkTimes()).append("', ");
        sb.append("sylhgkDtl").append("='").append(getSylhgkDtl()).append("', ");
        sb.append("dyzhfwzTimes").append("='").append(getDyzhfwzTimes()).append("', ");
        sb.append("dyzhfwzDtl").append("='").append(getDyzhfwzDtl()).append("', ");
        sb.append("szgsNum").append("='").append(getSzgsNum()).append("', ");
        sb.append("szgsTime").append("='").append(getSzgsTime()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
