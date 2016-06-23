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
@Table(name="reap_dtl",catalog="wms")
@Indexed
@XmlRootElement
public class ReapDtl extends BaseObject implements Serializable {
    private Long reapDtlId;
    private Long reapPartyId;
    private Long reapForPartyId;
    private Long productId;
    private BigDecimal num;
    private Long uomId;
    private Date reapDate;
    private Date createdTime;
    private Date lastUpdatedTime;
    private Long createdByUser;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="reap_dtl_id", unique=true, nullable=false)    
    public Long getReapDtlId() {
        return this.reapDtlId;
    }
    
    public void setReapDtlId(Long reapDtlId) {
        this.reapDtlId = reapDtlId;
    }
    
    @Column(name="reap_party_id")
    @Field
    public Long getReapPartyId() {
        return this.reapPartyId;
    }
    
    public void setReapPartyId(Long reapPartyId) {
        this.reapPartyId = reapPartyId;
    }
    
    @Column(name="reap_for_party_id")
    @Field
    public Long getReapForPartyId() {
        return this.reapForPartyId;
    }
    
    public void setReapForPartyId(Long reapForPartyId) {
        this.reapForPartyId = reapForPartyId;
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
    @Column(name="reap_date", length=10)
    @Field
    public Date getReapDate() {
        return this.reapDate;
    }
    
    public void setReapDate(Date reapDate) {
        this.reapDate = reapDate;
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

        ReapDtl pojo = (ReapDtl) o;

        if (reapPartyId != null ? !reapPartyId.equals(pojo.reapPartyId) : pojo.reapPartyId != null) return false;
        if (reapForPartyId != null ? !reapForPartyId.equals(pojo.reapForPartyId) : pojo.reapForPartyId != null) return false;
        if (productId != null ? !productId.equals(pojo.productId) : pojo.productId != null) return false;
        if (num != null ? !num.equals(pojo.num) : pojo.num != null) return false;
        if (uomId != null ? !uomId.equals(pojo.uomId) : pojo.uomId != null) return false;
        if (reapDate != null ? !reapDate.equals(pojo.reapDate) : pojo.reapDate != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (reapPartyId != null ? reapPartyId.hashCode() : 0);
        result = 31 * result + (reapForPartyId != null ? reapForPartyId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (uomId != null ? uomId.hashCode() : 0);
        result = 31 * result + (reapDate != null ? reapDate.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("reapDtlId").append("='").append(getReapDtlId()).append("', ");
        sb.append("reapPartyId").append("='").append(getReapPartyId()).append("', ");
        sb.append("reapForPartyId").append("='").append(getReapForPartyId()).append("', ");
        sb.append("productId").append("='").append(getProductId()).append("', ");
        sb.append("num").append("='").append(getNum()).append("', ");
        sb.append("uomId").append("='").append(getUomId()).append("', ");
        sb.append("reapDate").append("='").append(getReapDate()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
