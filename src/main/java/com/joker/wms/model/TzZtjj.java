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
@Table(name="tz_ztjj",catalog="wms")
@Indexed
@XmlRootElement
public class TzZtjj extends BaseObject implements Serializable {
    private Long ztjjId;
    private String tzDate;
    private Long groupPartyId;
    private Date createdTime;
    private Long createdByUser;
    private Date lastUpdatedTime;
    private Long lastUpdatedByUser;
    private String zdcjfzghName;
    private String zdcjfzghStatus;
    private String xtzjxmType;
    private String xtzjxmPurpose;
    private String pyzfnsName;
    private String pyzfnsSkill;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="ztjj_id", unique=true, nullable=false)    
    public Long getZtjjId() {
        return this.ztjjId;
    }
    
    public void setZtjjId(Long ztjjId) {
        this.ztjjId = ztjjId;
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
    
    @Column(name="zdcjfzgh_name", length=50)
    @Field
    public String getZdcjfzghName() {
        return this.zdcjfzghName;
    }
    
    public void setZdcjfzghName(String zdcjfzghName) {
        this.zdcjfzghName = zdcjfzghName;
    }
    
    @Column(name="zdcjfzgh_status")
    @Field
    public String getZdcjfzghStatus() {
        return this.zdcjfzghStatus;
    }
    
    public void setZdcjfzghStatus(String zdcjfzghStatus) {
        this.zdcjfzghStatus = zdcjfzghStatus;
    }
    
    @Column(name="xtzjxm_type")
    @Field
    public String getXtzjxmType() {
        return this.xtzjxmType;
    }
    
    public void setXtzjxmType(String xtzjxmType) {
        this.xtzjxmType = xtzjxmType;
    }
    
    @Column(name="xtzjxm_purpose")
    @Field
    public String getXtzjxmPurpose() {
        return this.xtzjxmPurpose;
    }
    
    public void setXtzjxmPurpose(String xtzjxmPurpose) {
        this.xtzjxmPurpose = xtzjxmPurpose;
    }
    
    @Column(name="pyzfns_name")
    @Field
    public String getPyzfnsName() {
        return this.pyzfnsName;
    }
    
    public void setPyzfnsName(String pyzfnsName) {
        this.pyzfnsName = pyzfnsName;
    }
    
    @Column(name="pyzfns_skill")
    @Field
    public String getPyzfnsSkill() {
        return this.pyzfnsSkill;
    }
    
    public void setPyzfnsSkill(String pyzfnsSkill) {
        this.pyzfnsSkill = pyzfnsSkill;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TzZtjj pojo = (TzZtjj) o;

        if (tzDate != null ? !tzDate.equals(pojo.tzDate) : pojo.tzDate != null) return false;
        if (groupPartyId != null ? !groupPartyId.equals(pojo.groupPartyId) : pojo.groupPartyId != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;
        if (zdcjfzghName != null ? !zdcjfzghName.equals(pojo.zdcjfzghName) : pojo.zdcjfzghName != null) return false;
        if (zdcjfzghStatus != null ? !zdcjfzghStatus.equals(pojo.zdcjfzghStatus) : pojo.zdcjfzghStatus != null) return false;
        if (xtzjxmType != null ? !xtzjxmType.equals(pojo.xtzjxmType) : pojo.xtzjxmType != null) return false;
        if (xtzjxmPurpose != null ? !xtzjxmPurpose.equals(pojo.xtzjxmPurpose) : pojo.xtzjxmPurpose != null) return false;
        if (pyzfnsName != null ? !pyzfnsName.equals(pojo.pyzfnsName) : pojo.pyzfnsName != null) return false;
        if (pyzfnsSkill != null ? !pyzfnsSkill.equals(pojo.pyzfnsSkill) : pojo.pyzfnsSkill != null) return false;

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
        result = 31 * result + (zdcjfzghName != null ? zdcjfzghName.hashCode() : 0);
        result = 31 * result + (zdcjfzghStatus != null ? zdcjfzghStatus.hashCode() : 0);
        result = 31 * result + (xtzjxmType != null ? xtzjxmType.hashCode() : 0);
        result = 31 * result + (xtzjxmPurpose != null ? xtzjxmPurpose.hashCode() : 0);
        result = 31 * result + (pyzfnsName != null ? pyzfnsName.hashCode() : 0);
        result = 31 * result + (pyzfnsSkill != null ? pyzfnsSkill.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("ztjjId").append("='").append(getZtjjId()).append("', ");
        sb.append("tzDate").append("='").append(getTzDate()).append("', ");
        sb.append("groupPartyId").append("='").append(getGroupPartyId()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("', ");
        sb.append("zdcjfzghName").append("='").append(getZdcjfzghName()).append("', ");
        sb.append("zdcjfzghStatus").append("='").append(getZdcjfzghStatus()).append("', ");
        sb.append("xtzjxmType").append("='").append(getXtzjxmType()).append("', ");
        sb.append("xtzjxmPurpose").append("='").append(getXtzjxmPurpose()).append("', ");
        sb.append("pyzfnsName").append("='").append(getPyzfnsName()).append("', ");
        sb.append("pyzfnsSkill").append("='").append(getPyzfnsSkill()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
