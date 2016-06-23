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
@Table(name="facility_transition",catalog="wms")
@Indexed
@XmlRootElement
public class FacilityTransition extends BaseObject implements Serializable {
    private Long facilityTransitionId;
    private Long facilityId;
    private Long inOutType;
    private Long productId;
    private BigDecimal num;
    private Long uomId;
    private Date tranDate;
    private Long bizType;
    private Long bizId;
    private Date createdTime;
    private Date lastUpdatedTime;
    private Long createdByUser;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="facility_transition_id", unique=true, nullable=false)    
    public Long getFacilityTransitionId() {
        return this.facilityTransitionId;
    }
    
    public void setFacilityTransitionId(Long facilityTransitionId) {
        this.facilityTransitionId = facilityTransitionId;
    }
    
    @Column(name="facility_id")
    @Field
    public Long getFacilityId() {
        return this.facilityId;
    }
    
    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }
    
    @Column(name="in_out_type")
    @Field
    public Long getInOutType() {
        return this.inOutType;
    }
    
    public void setInOutType(Long inOutType) {
        this.inOutType = inOutType;
    }
    
    @Column(name="product_id")
    @Field
    public Long getProductId() {
        return this.productId;
    }
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    @Column(name="num", precision=13)
    @Field
    public BigDecimal getNum() {
        return this.num;
    }
    
    public void setNum(BigDecimal num) {
        this.num = num;
    }
    
    @Column(name="uom_id")
    @Field
    public Long getUomId() {
        return this.uomId;
    }
    
    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="tran_date", length=10)
    @Field
    public Date getTranDate() {
        return this.tranDate;
    }
    
    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }
    
    @Column(name="biz_type")
    @Field
    public Long getBizType() {
        return this.bizType;
    }
    
    public void setBizType(Long bizType) {
        this.bizType = bizType;
    }
    
    @Column(name="biz_id")
    @Field
    public Long getBizId() {
        return this.bizId;
    }
    
    public void setBizId(Long bizId) {
        this.bizId = bizId;
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

        FacilityTransition pojo = (FacilityTransition) o;

        if (facilityId != null ? !facilityId.equals(pojo.facilityId) : pojo.facilityId != null) return false;
        if (inOutType != null ? !inOutType.equals(pojo.inOutType) : pojo.inOutType != null) return false;
        if (productId != null ? !productId.equals(pojo.productId) : pojo.productId != null) return false;
        if (num != null ? !num.equals(pojo.num) : pojo.num != null) return false;
        if (uomId != null ? !uomId.equals(pojo.uomId) : pojo.uomId != null) return false;
        if (tranDate != null ? !tranDate.equals(pojo.tranDate) : pojo.tranDate != null) return false;
        if (bizType != null ? !bizType.equals(pojo.bizType) : pojo.bizType != null) return false;
        if (bizId != null ? !bizId.equals(pojo.bizId) : pojo.bizId != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (facilityId != null ? facilityId.hashCode() : 0);
        result = 31 * result + (inOutType != null ? inOutType.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (uomId != null ? uomId.hashCode() : 0);
        result = 31 * result + (tranDate != null ? tranDate.hashCode() : 0);
        result = 31 * result + (bizType != null ? bizType.hashCode() : 0);
        result = 31 * result + (bizId != null ? bizId.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("facilityTransitionId").append("='").append(getFacilityTransitionId()).append("', ");
        sb.append("facilityId").append("='").append(getFacilityId()).append("', ");
        sb.append("inOutType").append("='").append(getInOutType()).append("', ");
        sb.append("productId").append("='").append(getProductId()).append("', ");
        sb.append("num").append("='").append(getNum()).append("', ");
        sb.append("uomId").append("='").append(getUomId()).append("', ");
        sb.append("tranDate").append("='").append(getTranDate()).append("', ");
        sb.append("bizType").append("='").append(getBizType()).append("', ");
        sb.append("bizId").append("='").append(getBizId()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
