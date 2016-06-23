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
@Table(name="tz_hjmd",catalog="wms")
@Indexed
@XmlRootElement
public class TzHjmd extends BaseObject implements Serializable {
    private Long hjmdId;
    private String tzDate;
    private Long groupPartyId;
    private Date createdTime;
    private Long createdByUser;
    private Date lastUpdatedTime;
    private Long lastUpdatedByUser;
    private String zfqzTimes;
    private String zfqzPersonNum;
    private String hjmdjfNum;
    private String hjmdjfDtl;
    private String jjlsylwtNum;
    private String jjlsylwtDtl;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="hjmd_id", unique=true, nullable=false)    
    public Long getHjmdId() {
        return this.hjmdId;
    }
    
    public void setHjmdId(Long hjmdId) {
        this.hjmdId = hjmdId;
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
    
    @Column(name="zfqz_times", length=20)
    @Field
    public String getZfqzTimes() {
        return this.zfqzTimes;
    }
    
    public void setZfqzTimes(String zfqzTimes) {
        this.zfqzTimes = zfqzTimes;
    }
    
    @Column(name="zfqz_person_num", length=20)
    @Field
    public String getZfqzPersonNum() {
        return this.zfqzPersonNum;
    }
    
    public void setZfqzPersonNum(String zfqzPersonNum) {
        this.zfqzPersonNum = zfqzPersonNum;
    }
    
    @Column(name="hjmdjf_num", length=20)
    @Field
    public String getHjmdjfNum() {
        return this.hjmdjfNum;
    }
    
    public void setHjmdjfNum(String hjmdjfNum) {
        this.hjmdjfNum = hjmdjfNum;
    }
    
    @Column(name="hjmdjf_dtl")
    @Field
    public String getHjmdjfDtl() {
        return this.hjmdjfDtl;
    }
    
    public void setHjmdjfDtl(String hjmdjfDtl) {
        this.hjmdjfDtl = hjmdjfDtl;
    }
    
    @Column(name="jjlsylwt_num", length=20)
    @Field
    public String getJjlsylwtNum() {
        return this.jjlsylwtNum;
    }
    
    public void setJjlsylwtNum(String jjlsylwtNum) {
        this.jjlsylwtNum = jjlsylwtNum;
    }
    
    @Column(name="jjlsylwt_dtl")
    @Field
    public String getJjlsylwtDtl() {
        return this.jjlsylwtDtl;
    }
    
    public void setJjlsylwtDtl(String jjlsylwtDtl) {
        this.jjlsylwtDtl = jjlsylwtDtl;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TzHjmd pojo = (TzHjmd) o;

        if (tzDate != null ? !tzDate.equals(pojo.tzDate) : pojo.tzDate != null) return false;
        if (groupPartyId != null ? !groupPartyId.equals(pojo.groupPartyId) : pojo.groupPartyId != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;
        if (zfqzTimes != null ? !zfqzTimes.equals(pojo.zfqzTimes) : pojo.zfqzTimes != null) return false;
        if (zfqzPersonNum != null ? !zfqzPersonNum.equals(pojo.zfqzPersonNum) : pojo.zfqzPersonNum != null) return false;
        if (hjmdjfNum != null ? !hjmdjfNum.equals(pojo.hjmdjfNum) : pojo.hjmdjfNum != null) return false;
        if (hjmdjfDtl != null ? !hjmdjfDtl.equals(pojo.hjmdjfDtl) : pojo.hjmdjfDtl != null) return false;
        if (jjlsylwtNum != null ? !jjlsylwtNum.equals(pojo.jjlsylwtNum) : pojo.jjlsylwtNum != null) return false;
        if (jjlsylwtDtl != null ? !jjlsylwtDtl.equals(pojo.jjlsylwtDtl) : pojo.jjlsylwtDtl != null) return false;

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
        result = 31 * result + (zfqzTimes != null ? zfqzTimes.hashCode() : 0);
        result = 31 * result + (zfqzPersonNum != null ? zfqzPersonNum.hashCode() : 0);
        result = 31 * result + (hjmdjfNum != null ? hjmdjfNum.hashCode() : 0);
        result = 31 * result + (hjmdjfDtl != null ? hjmdjfDtl.hashCode() : 0);
        result = 31 * result + (jjlsylwtNum != null ? jjlsylwtNum.hashCode() : 0);
        result = 31 * result + (jjlsylwtDtl != null ? jjlsylwtDtl.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("hjmdId").append("='").append(getHjmdId()).append("', ");
        sb.append("tzDate").append("='").append(getTzDate()).append("', ");
        sb.append("groupPartyId").append("='").append(getGroupPartyId()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("', ");
        sb.append("zfqzTimes").append("='").append(getZfqzTimes()).append("', ");
        sb.append("zfqzPersonNum").append("='").append(getZfqzPersonNum()).append("', ");
        sb.append("hjmdjfNum").append("='").append(getHjmdjfNum()).append("', ");
        sb.append("hjmdjfDtl").append("='").append(getHjmdjfDtl()).append("', ");
        sb.append("jjlsylwtNum").append("='").append(getJjlsylwtNum()).append("', ");
        sb.append("jjlsylwtDtl").append("='").append(getJjlsylwtDtl()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
