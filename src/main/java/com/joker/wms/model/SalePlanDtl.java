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
@Table(name="sale_plan_dtl",catalog="wms")
@Indexed
@XmlRootElement
public class SalePlanDtl extends BaseObject implements Serializable {
    private Long salePlanDtlId;
    private Long salePlanId;
    private Long facilityIdFrom;
    private Long facilityIdTo;
    private Long toSequenceId;
    private Long productId;
    private BigDecimal num;
    private Long uomId;
    private Date createdTime;
    private Date lastUpdatedTime;
    private Long createdByUser;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="sale_plan_dtl_id", unique=true, nullable=false)    
    public Long getSalePlanDtlId() {
        return this.salePlanDtlId;
    }
    
    public void setSalePlanDtlId(Long salePlanDtlId) {
        this.salePlanDtlId = salePlanDtlId;
    }
    
    @Column(name="sale_plan_id")
    @Field
    public Long getSalePlanId() {
        return this.salePlanId;
    }
    
    public void setSalePlanId(Long salePlanId) {
        this.salePlanId = salePlanId;
    }
    
    @Column(name="facility_id_from")
    @Field
    public Long getFacilityIdFrom() {
        return this.facilityIdFrom;
    }
    
    public void setFacilityIdFrom(Long facilityIdFrom) {
        this.facilityIdFrom = facilityIdFrom;
    }
    
    @Column(name="facility_id_to")
    @Field
    public Long getFacilityIdTo() {
        return this.facilityIdTo;
    }
    
    public void setFacilityIdTo(Long facilityIdTo) {
        this.facilityIdTo = facilityIdTo;
    }
    
    @Column(name="to_sequence_id")
    @Field
    public Long getToSequenceId() {
        return this.toSequenceId;
    }
    
    public void setToSequenceId(Long toSequenceId) {
        this.toSequenceId = toSequenceId;
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

        SalePlanDtl pojo = (SalePlanDtl) o;

        if (salePlanId != null ? !salePlanId.equals(pojo.salePlanId) : pojo.salePlanId != null) return false;
        if (facilityIdFrom != null ? !facilityIdFrom.equals(pojo.facilityIdFrom) : pojo.facilityIdFrom != null) return false;
        if (facilityIdTo != null ? !facilityIdTo.equals(pojo.facilityIdTo) : pojo.facilityIdTo != null) return false;
        if (toSequenceId != null ? !toSequenceId.equals(pojo.toSequenceId) : pojo.toSequenceId != null) return false;
        if (productId != null ? !productId.equals(pojo.productId) : pojo.productId != null) return false;
        if (num != null ? !num.equals(pojo.num) : pojo.num != null) return false;
        if (uomId != null ? !uomId.equals(pojo.uomId) : pojo.uomId != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (salePlanId != null ? salePlanId.hashCode() : 0);
        result = 31 * result + (facilityIdFrom != null ? facilityIdFrom.hashCode() : 0);
        result = 31 * result + (facilityIdTo != null ? facilityIdTo.hashCode() : 0);
        result = 31 * result + (toSequenceId != null ? toSequenceId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (uomId != null ? uomId.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("salePlanDtlId").append("='").append(getSalePlanDtlId()).append("', ");
        sb.append("salePlanId").append("='").append(getSalePlanId()).append("', ");
        sb.append("facilityIdFrom").append("='").append(getFacilityIdFrom()).append("', ");
        sb.append("facilityIdTo").append("='").append(getFacilityIdTo()).append("', ");
        sb.append("toSequenceId").append("='").append(getToSequenceId()).append("', ");
        sb.append("productId").append("='").append(getProductId()).append("', ");
        sb.append("num").append("='").append(getNum()).append("', ");
        sb.append("uomId").append("='").append(getUomId()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
