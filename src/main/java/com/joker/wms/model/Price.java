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
@Table(name="price",catalog="wms")
@Indexed
@XmlRootElement
public class Price extends BaseObject implements Serializable {
    private Long priceId;
    private Long productId;
    private Long partyId;
    private Date fromDate;
    private Date thruDate;
    private String priceType;
    private BigDecimal price;
    private Long priceUomId;
    private Date createdTime;
    private Date lastUpdatedTime;
    private Long createdByUser;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="price_id", unique=true, nullable=false)    
    public Long getPriceId() {
        return this.priceId;
    }
    
    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }
    
    @Column(name="product_id")
    @Field
    public Long getProductId() {
        return this.productId;
    }
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    @Column(name="party_id")
    @Field
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="from_date", length=19)
    @Field
    public Date getFromDate() {
        return this.fromDate;
    }
    
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="thru_date", length=19)
    @Field
    public Date getThruDate() {
        return this.thruDate;
    }
    
    public void setThruDate(Date thruDate) {
        this.thruDate = thruDate;
    }
    
    @Column(name="price_type", length=30)
    @Field
    public String getPriceType() {
        return this.priceType;
    }
    
    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }
    
    @Column(name="price", precision=18, scale=3)
    @Field
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    @Column(name="price_uom_id")
    @Field
    public Long getPriceUomId() {
        return this.priceUomId;
    }
    
    public void setPriceUomId(Long priceUomId) {
        this.priceUomId = priceUomId;
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

        Price pojo = (Price) o;

        if (productId != null ? !productId.equals(pojo.productId) : pojo.productId != null) return false;
        if (partyId != null ? !partyId.equals(pojo.partyId) : pojo.partyId != null) return false;
        if (fromDate != null ? !fromDate.equals(pojo.fromDate) : pojo.fromDate != null) return false;
        if (thruDate != null ? !thruDate.equals(pojo.thruDate) : pojo.thruDate != null) return false;
        if (priceType != null ? !priceType.equals(pojo.priceType) : pojo.priceType != null) return false;
        if (price != null ? !price.equals(pojo.price) : pojo.price != null) return false;
        if (priceUomId != null ? !priceUomId.equals(pojo.priceUomId) : pojo.priceUomId != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (thruDate != null ? thruDate.hashCode() : 0);
        result = 31 * result + (priceType != null ? priceType.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (priceUomId != null ? priceUomId.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("priceId").append("='").append(getPriceId()).append("', ");
        sb.append("productId").append("='").append(getProductId()).append("', ");
        sb.append("partyId").append("='").append(getPartyId()).append("', ");
        sb.append("fromDate").append("='").append(getFromDate()).append("', ");
        sb.append("thruDate").append("='").append(getThruDate()).append("', ");
        sb.append("priceType").append("='").append(getPriceType()).append("', ");
        sb.append("price").append("='").append(getPrice()).append("', ");
        sb.append("priceUomId").append("='").append(getPriceUomId()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
