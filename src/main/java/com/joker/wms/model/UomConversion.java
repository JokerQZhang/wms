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
@Table(name="uom_conversion",catalog="wms")
@Indexed
@XmlRootElement
public class UomConversion extends BaseObject implements Serializable {
    private Long uomConversionId;
    private Long uomIdFrom;
    private Long uomIdTo;
    private Double conversionFactor;
    private String roundingMode;
    private Date createdTime;
    private Date lastUpdatedTime;
    private Long createdByUser;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="uom_conversion_id", unique=true, nullable=false)    
    public Long getUomConversionId() {
        return this.uomConversionId;
    }
    
    public void setUomConversionId(Long uomConversionId) {
        this.uomConversionId = uomConversionId;
    }
    
    @Column(name="uom_id_from")
    @Field
    public Long getUomIdFrom() {
        return this.uomIdFrom;
    }
    
    public void setUomIdFrom(Long uomIdFrom) {
        this.uomIdFrom = uomIdFrom;
    }
    
    @Column(name="uom_id_to")
    @Field
    public Long getUomIdTo() {
        return this.uomIdTo;
    }
    
    public void setUomIdTo(Long uomIdTo) {
        this.uomIdTo = uomIdTo;
    }
    
    @Column(name="conversion_factor", precision=22, scale=0)
    @Field
    public Double getConversionFactor() {
        return this.conversionFactor;
    }
    
    public void setConversionFactor(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
    
    @Column(name="rounding_mode", length=20)
    @Field
    public String getRoundingMode() {
        return this.roundingMode;
    }
    
    public void setRoundingMode(String roundingMode) {
        this.roundingMode = roundingMode;
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

        UomConversion pojo = (UomConversion) o;

        if (uomIdFrom != null ? !uomIdFrom.equals(pojo.uomIdFrom) : pojo.uomIdFrom != null) return false;
        if (uomIdTo != null ? !uomIdTo.equals(pojo.uomIdTo) : pojo.uomIdTo != null) return false;
        if (conversionFactor != null ? !conversionFactor.equals(pojo.conversionFactor) : pojo.conversionFactor != null) return false;
        if (roundingMode != null ? !roundingMode.equals(pojo.roundingMode) : pojo.roundingMode != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (uomIdFrom != null ? uomIdFrom.hashCode() : 0);
        result = 31 * result + (uomIdTo != null ? uomIdTo.hashCode() : 0);
        result = 31 * result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
        result = 31 * result + (roundingMode != null ? roundingMode.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("uomConversionId").append("='").append(getUomConversionId()).append("', ");
        sb.append("uomIdFrom").append("='").append(getUomIdFrom()).append("', ");
        sb.append("uomIdTo").append("='").append(getUomIdTo()).append("', ");
        sb.append("conversionFactor").append("='").append(getConversionFactor()).append("', ");
        sb.append("roundingMode").append("='").append(getRoundingMode()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
