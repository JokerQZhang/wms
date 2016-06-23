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
@Table(name="tz_dhbz",catalog="wms")
@Indexed
@XmlRootElement
public class TzDhbz extends BaseObject implements Serializable {
    private Long dhbzId;
    private String tzDate;
    private Long groupPartyId;
    private Date createdTime;
    private Long createdByUser;
    private Date lastUpdatedTime;
    private Long lastUpdatedByUser;
    private String zdzzshTime;
    private String zdzzhyName;
    private String hbgbNum;
    private String bdfs;
    private String pyjjfzNum;
    private String pyjjfzName;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="dhbz_id", unique=true, nullable=false)    
    public Long getDhbzId() {
        return this.dhbzId;
    }
    
    public void setDhbzId(Long dhbzId) {
        this.dhbzId = dhbzId;
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
    
    @Column(name="zdzzsh_time", length=20)
    @Field
    public String getZdzzshTime() {
        return this.zdzzshTime;
    }
    
    public void setZdzzshTime(String zdzzshTime) {
        this.zdzzshTime = zdzzshTime;
    }
    
    @Column(name="zdzzhy_name")
    @Field
    public String getZdzzhyName() {
        return this.zdzzhyName;
    }
    
    public void setZdzzhyName(String zdzzhyName) {
        this.zdzzhyName = zdzzhyName;
    }
    
    @Column(name="hbgb_num", length=20)
    @Field
    public String getHbgbNum() {
        return this.hbgbNum;
    }
    
    public void setHbgbNum(String hbgbNum) {
        this.hbgbNum = hbgbNum;
    }
    
    @Column(name="bdfs")
    @Field
    public String getBdfs() {
        return this.bdfs;
    }
    
    public void setBdfs(String bdfs) {
        this.bdfs = bdfs;
    }
    
    @Column(name="pyjjfz_num", length=20)
    @Field
    public String getPyjjfzNum() {
        return this.pyjjfzNum;
    }
    
    public void setPyjjfzNum(String pyjjfzNum) {
        this.pyjjfzNum = pyjjfzNum;
    }
    
    @Column(name="pyjjfz_name")
    @Field
    public String getPyjjfzName() {
        return this.pyjjfzName;
    }
    
    public void setPyjjfzName(String pyjjfzName) {
        this.pyjjfzName = pyjjfzName;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TzDhbz pojo = (TzDhbz) o;

        if (tzDate != null ? !tzDate.equals(pojo.tzDate) : pojo.tzDate != null) return false;
        if (groupPartyId != null ? !groupPartyId.equals(pojo.groupPartyId) : pojo.groupPartyId != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;
        if (zdzzshTime != null ? !zdzzshTime.equals(pojo.zdzzshTime) : pojo.zdzzshTime != null) return false;
        if (zdzzhyName != null ? !zdzzhyName.equals(pojo.zdzzhyName) : pojo.zdzzhyName != null) return false;
        if (hbgbNum != null ? !hbgbNum.equals(pojo.hbgbNum) : pojo.hbgbNum != null) return false;
        if (bdfs != null ? !bdfs.equals(pojo.bdfs) : pojo.bdfs != null) return false;
        if (pyjjfzNum != null ? !pyjjfzNum.equals(pojo.pyjjfzNum) : pojo.pyjjfzNum != null) return false;
        if (pyjjfzName != null ? !pyjjfzName.equals(pojo.pyjjfzName) : pojo.pyjjfzName != null) return false;

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
        result = 31 * result + (zdzzshTime != null ? zdzzshTime.hashCode() : 0);
        result = 31 * result + (zdzzhyName != null ? zdzzhyName.hashCode() : 0);
        result = 31 * result + (hbgbNum != null ? hbgbNum.hashCode() : 0);
        result = 31 * result + (bdfs != null ? bdfs.hashCode() : 0);
        result = 31 * result + (pyjjfzNum != null ? pyjjfzNum.hashCode() : 0);
        result = 31 * result + (pyjjfzName != null ? pyjjfzName.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("dhbzId").append("='").append(getDhbzId()).append("', ");
        sb.append("tzDate").append("='").append(getTzDate()).append("', ");
        sb.append("groupPartyId").append("='").append(getGroupPartyId()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("', ");
        sb.append("zdzzshTime").append("='").append(getZdzzshTime()).append("', ");
        sb.append("zdzzhyName").append("='").append(getZdzzhyName()).append("', ");
        sb.append("hbgbNum").append("='").append(getHbgbNum()).append("', ");
        sb.append("bdfs").append("='").append(getBdfs()).append("', ");
        sb.append("pyjjfzNum").append("='").append(getPyjjfzNum()).append("', ");
        sb.append("pyjjfzName").append("='").append(getPyjjfzName()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
