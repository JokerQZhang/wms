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
@Table(name="tb_provide",catalog="wms")
@Indexed
@XmlRootElement
public class TbProvide extends BaseObject implements Serializable {
    private Long provideId;
    private Long departmentId;
    private String provideName;
    private Date provideDate;
    private BigDecimal provideSum;
    private Long validFlag;
    private Date createdTime;
    private Long createdByUser;
    private Date lastUpdatedTime;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="provide_id", unique=true, nullable=false)    
    public Long getProvideId() {
        return this.provideId;
    }
    
    public void setProvideId(Long provideId) {
        this.provideId = provideId;
    }
    
    @Column(name="department_id")
    @Field
    public Long getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
    
    @Column(name="provide_name", length=50)
    @Field
    public String getProvideName() {
        return this.provideName;
    }
    
    public void setProvideName(String provideName) {
        this.provideName = provideName;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="provide_date", length=19)
    @Field
    public Date getProvideDate() {
        return this.provideDate;
    }
    
    public void setProvideDate(Date provideDate) {
        this.provideDate = provideDate;
    }
    
    @Column(name="provide_sum", precision=18)
    @Field
    public BigDecimal getProvideSum() {
        return this.provideSum;
    }
    
    public void setProvideSum(BigDecimal provideSum) {
        this.provideSum = provideSum;
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

        TbProvide pojo = (TbProvide) o;

        if (departmentId != null ? !departmentId.equals(pojo.departmentId) : pojo.departmentId != null) return false;
        if (provideName != null ? !provideName.equals(pojo.provideName) : pojo.provideName != null) return false;
        if (provideDate != null ? !provideDate.equals(pojo.provideDate) : pojo.provideDate != null) return false;
        if (provideSum != null ? !provideSum.equals(pojo.provideSum) : pojo.provideSum != null) return false;
        if (validFlag != null ? !validFlag.equals(pojo.validFlag) : pojo.validFlag != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (departmentId != null ? departmentId.hashCode() : 0);
        result = 31 * result + (provideName != null ? provideName.hashCode() : 0);
        result = 31 * result + (provideDate != null ? provideDate.hashCode() : 0);
        result = 31 * result + (provideSum != null ? provideSum.hashCode() : 0);
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
        sb.append("provideId").append("='").append(getProvideId()).append("', ");
        sb.append("departmentId").append("='").append(getDepartmentId()).append("', ");
        sb.append("provideName").append("='").append(getProvideName()).append("', ");
        sb.append("provideDate").append("='").append(getProvideDate()).append("', ");
        sb.append("provideSum").append("='").append(getProvideSum()).append("', ");
        sb.append("validFlag").append("='").append(getValidFlag()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
