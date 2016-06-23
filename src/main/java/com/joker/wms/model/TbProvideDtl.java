package com.joker.wms.model;

import com.joker.wms.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import java.math.BigDecimal;
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
@Table(name="tb_provide_dtl",catalog="wms")
@Indexed
@XmlRootElement
public class TbProvideDtl extends BaseObject implements Serializable {
    private Long provideDtlId;
    private Long peopleId;
    private Long enumId;
    private Long provideId;
    private BigDecimal provideMoney;
    private Long validFlag;
    private Date createdTime;
    private Long createdByUser;
    private Date lastUpdatedTime;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="provide_dtl_id", unique=true, nullable=false)    
    public Long getProvideDtlId() {
        return this.provideDtlId;
    }
    
    public void setProvideDtlId(Long provideDtlId) {
        this.provideDtlId = provideDtlId;
    }
    
    @Column(name="people_id")
    @Field
    public Long getPeopleId() {
        return this.peopleId;
    }
    
    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }
    
    @Column(name="enum_id")
    @Field
    public Long getEnumId() {
        return this.enumId;
    }
    
    public void setEnumId(Long enumId) {
        this.enumId = enumId;
    }
    
    @Column(name="provide_id")
    @Field
    public Long getProvideId() {
        return this.provideId;
    }
    
    public void setProvideId(Long provideId) {
        this.provideId = provideId;
    }
    
    @Column(name="provide_money", precision=20)
    @Field
    public BigDecimal getProvideMoney() {
        return this.provideMoney;
    }
    
    public void setProvideMoney(BigDecimal provideMoney) {
        this.provideMoney = provideMoney;
    }
    
    @Column(name="valid_flag")
    @Field
    public Long getValidFlag() {
        return this.validFlag;
    }
    
    public void setValidFlag(Long validFlag) {
        this.validFlag = validFlag;
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

        TbProvideDtl pojo = (TbProvideDtl) o;

        if (peopleId != null ? !peopleId.equals(pojo.peopleId) : pojo.peopleId != null) return false;
        if (enumId != null ? !enumId.equals(pojo.enumId) : pojo.enumId != null) return false;
        if (provideId != null ? !provideId.equals(pojo.provideId) : pojo.provideId != null) return false;
        if (provideMoney != null ? !provideMoney.equals(pojo.provideMoney) : pojo.provideMoney != null) return false;
        if (validFlag != null ? !validFlag.equals(pojo.validFlag) : pojo.validFlag != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (peopleId != null ? peopleId.hashCode() : 0);
        result = 31 * result + (enumId != null ? enumId.hashCode() : 0);
        result = 31 * result + (provideId != null ? provideId.hashCode() : 0);
        result = 31 * result + (provideMoney != null ? provideMoney.hashCode() : 0);
        result = 31 * result + (validFlag != null ? validFlag.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("provideDtlId").append("='").append(getProvideDtlId()).append("', ");
        sb.append("peopleId").append("='").append(getPeopleId()).append("', ");
        sb.append("enumId").append("='").append(getEnumId()).append("', ");
        sb.append("provideId").append("='").append(getProvideId()).append("', ");
        sb.append("provideMoney").append("='").append(getProvideMoney()).append("', ");
        sb.append("validFlag").append("='").append(getValidFlag()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
