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
@Table(name="cp_positive",catalog="wms")
@Indexed
@XmlRootElement
public class CpPositive extends BaseObject implements Serializable {
    private Long cpPositiveId;
    private Long partyId;
    private String firstApplyTime;
    private String bePositiveTime;
    private String conPeople1;
    private String conPeople2;
    private String fzdxNum;
    private String fzdxPositiveNum;
    private String ybdyNum;
    private String yndyPositiveNum;
    private String zsdyNum;
    private String zsdyPositiveNum;
    private Date createdTime;
    private Long createdByUser;
    private Date lastUpdatedTime;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="cp_positive_id", unique=true, nullable=false)    
    public Long getCpPositiveId() {
        return this.cpPositiveId;
    }
    
    public void setCpPositiveId(Long cpPositiveId) {
        this.cpPositiveId = cpPositiveId;
    }
    
    @Column(name="party_id")
    @Field
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    
    @Column(name="first_apply_time", length=30)
    @Field
    public String getFirstApplyTime() {
        return this.firstApplyTime;
    }
    
    public void setFirstApplyTime(String firstApplyTime) {
        this.firstApplyTime = firstApplyTime;
    }
    
    @Column(name="be_positive_time", length=30)
    @Field
    public String getBePositiveTime() {
        return this.bePositiveTime;
    }
    
    public void setBePositiveTime(String bePositiveTime) {
        this.bePositiveTime = bePositiveTime;
    }
    
    @Column(name="con_people1", length=30)
    @Field
    public String getConPeople1() {
        return this.conPeople1;
    }
    
    public void setConPeople1(String conPeople1) {
        this.conPeople1 = conPeople1;
    }
    
    @Column(name="con_people2", length=30)
    @Field
    public String getConPeople2() {
        return this.conPeople2;
    }
    
    public void setConPeople2(String conPeople2) {
        this.conPeople2 = conPeople2;
    }
    
    @Column(name="fzdx_num", length=30)
    @Field
    public String getFzdxNum() {
        return this.fzdxNum;
    }
    
    public void setFzdxNum(String fzdxNum) {
        this.fzdxNum = fzdxNum;
    }
    
    @Column(name="fzdx_positive_num", length=30)
    @Field
    public String getFzdxPositiveNum() {
        return this.fzdxPositiveNum;
    }
    
    public void setFzdxPositiveNum(String fzdxPositiveNum) {
        this.fzdxPositiveNum = fzdxPositiveNum;
    }
    
    @Column(name="ybdy_num", length=30)
    @Field
    public String getYbdyNum() {
        return this.ybdyNum;
    }
    
    public void setYbdyNum(String ybdyNum) {
        this.ybdyNum = ybdyNum;
    }
    
    @Column(name="yndy_positive_num", length=30)
    @Field
    public String getYndyPositiveNum() {
        return this.yndyPositiveNum;
    }
    
    public void setYndyPositiveNum(String yndyPositiveNum) {
        this.yndyPositiveNum = yndyPositiveNum;
    }
    
    @Column(name="zsdy_num", length=30)
    @Field
    public String getZsdyNum() {
        return this.zsdyNum;
    }
    
    public void setZsdyNum(String zsdyNum) {
        this.zsdyNum = zsdyNum;
    }
    
    @Column(name="zsdy_positive_num", length=30)
    @Field
    public String getZsdyPositiveNum() {
        return this.zsdyPositiveNum;
    }
    
    public void setZsdyPositiveNum(String zsdyPositiveNum) {
        this.zsdyPositiveNum = zsdyPositiveNum;
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CpPositive pojo = (CpPositive) o;

        if (partyId != null ? !partyId.equals(pojo.partyId) : pojo.partyId != null) return false;
        if (firstApplyTime != null ? !firstApplyTime.equals(pojo.firstApplyTime) : pojo.firstApplyTime != null) return false;
        if (bePositiveTime != null ? !bePositiveTime.equals(pojo.bePositiveTime) : pojo.bePositiveTime != null) return false;
        if (conPeople1 != null ? !conPeople1.equals(pojo.conPeople1) : pojo.conPeople1 != null) return false;
        if (conPeople2 != null ? !conPeople2.equals(pojo.conPeople2) : pojo.conPeople2 != null) return false;
        if (fzdxNum != null ? !fzdxNum.equals(pojo.fzdxNum) : pojo.fzdxNum != null) return false;
        if (fzdxPositiveNum != null ? !fzdxPositiveNum.equals(pojo.fzdxPositiveNum) : pojo.fzdxPositiveNum != null) return false;
        if (ybdyNum != null ? !ybdyNum.equals(pojo.ybdyNum) : pojo.ybdyNum != null) return false;
        if (yndyPositiveNum != null ? !yndyPositiveNum.equals(pojo.yndyPositiveNum) : pojo.yndyPositiveNum != null) return false;
        if (zsdyNum != null ? !zsdyNum.equals(pojo.zsdyNum) : pojo.zsdyNum != null) return false;
        if (zsdyPositiveNum != null ? !zsdyPositiveNum.equals(pojo.zsdyPositiveNum) : pojo.zsdyPositiveNum != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (firstApplyTime != null ? firstApplyTime.hashCode() : 0);
        result = 31 * result + (bePositiveTime != null ? bePositiveTime.hashCode() : 0);
        result = 31 * result + (conPeople1 != null ? conPeople1.hashCode() : 0);
        result = 31 * result + (conPeople2 != null ? conPeople2.hashCode() : 0);
        result = 31 * result + (fzdxNum != null ? fzdxNum.hashCode() : 0);
        result = 31 * result + (fzdxPositiveNum != null ? fzdxPositiveNum.hashCode() : 0);
        result = 31 * result + (ybdyNum != null ? ybdyNum.hashCode() : 0);
        result = 31 * result + (yndyPositiveNum != null ? yndyPositiveNum.hashCode() : 0);
        result = 31 * result + (zsdyNum != null ? zsdyNum.hashCode() : 0);
        result = 31 * result + (zsdyPositiveNum != null ? zsdyPositiveNum.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("cpPositiveId").append("='").append(getCpPositiveId()).append("', ");
        sb.append("partyId").append("='").append(getPartyId()).append("', ");
        sb.append("firstApplyTime").append("='").append(getFirstApplyTime()).append("', ");
        sb.append("bePositiveTime").append("='").append(getBePositiveTime()).append("', ");
        sb.append("conPeople1").append("='").append(getConPeople1()).append("', ");
        sb.append("conPeople2").append("='").append(getConPeople2()).append("', ");
        sb.append("fzdxNum").append("='").append(getFzdxNum()).append("', ");
        sb.append("fzdxPositiveNum").append("='").append(getFzdxPositiveNum()).append("', ");
        sb.append("ybdyNum").append("='").append(getYbdyNum()).append("', ");
        sb.append("yndyPositiveNum").append("='").append(getYndyPositiveNum()).append("', ");
        sb.append("zsdyNum").append("='").append(getZsdyNum()).append("', ");
        sb.append("zsdyPositiveNum").append("='").append(getZsdyPositiveNum()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
