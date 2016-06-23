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
@Table(name="facility",catalog="wms")
@Indexed
@XmlRootElement
public class Facility extends BaseObject implements Serializable {
    private Long facilityId;
    private Long parentId;
    private Long facilityTypeId;
    private Long ownerPartyId;
    private String facilityName;
    private String geoPointId;
    private Date createdTime;
    private Date lastUpdatedTime;
    private Long createdByUser;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="facility_id", unique=true, nullable=false)    
    public Long getFacilityId() {
        return this.facilityId;
    }
    
    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }
    
    @Column(name="parent_id")
    @Field
    public Long getParentId() {
        return this.parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    @Column(name="facility_type_id")
    @Field
    public Long getFacilityTypeId() {
        return this.facilityTypeId;
    }
    
    public void setFacilityTypeId(Long facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }
    
    @Column(name="owner_party_id")
    @Field
    public Long getOwnerPartyId() {
        return this.ownerPartyId;
    }
    
    public void setOwnerPartyId(Long ownerPartyId) {
        this.ownerPartyId = ownerPartyId;
    }
    
    @Column(name="facility_name", length=100)
    @Field
    public String getFacilityName() {
        return this.facilityName;
    }
    
    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }
    
    @Column(name="geo_point_id", length=100)
    @Field
    public String getGeoPointId() {
        return this.geoPointId;
    }
    
    public void setGeoPointId(String geoPointId) {
        this.geoPointId = geoPointId;
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

        Facility pojo = (Facility) o;

        if (parentId != null ? !parentId.equals(pojo.parentId) : pojo.parentId != null) return false;
        if (facilityTypeId != null ? !facilityTypeId.equals(pojo.facilityTypeId) : pojo.facilityTypeId != null) return false;
        if (ownerPartyId != null ? !ownerPartyId.equals(pojo.ownerPartyId) : pojo.ownerPartyId != null) return false;
        if (facilityName != null ? !facilityName.equals(pojo.facilityName) : pojo.facilityName != null) return false;
        if (geoPointId != null ? !geoPointId.equals(pojo.geoPointId) : pojo.geoPointId != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (facilityTypeId != null ? facilityTypeId.hashCode() : 0);
        result = 31 * result + (ownerPartyId != null ? ownerPartyId.hashCode() : 0);
        result = 31 * result + (facilityName != null ? facilityName.hashCode() : 0);
        result = 31 * result + (geoPointId != null ? geoPointId.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("facilityId").append("='").append(getFacilityId()).append("', ");
        sb.append("parentId").append("='").append(getParentId()).append("', ");
        sb.append("facilityTypeId").append("='").append(getFacilityTypeId()).append("', ");
        sb.append("ownerPartyId").append("='").append(getOwnerPartyId()).append("', ");
        sb.append("facilityName").append("='").append(getFacilityName()).append("', ");
        sb.append("geoPointId").append("='").append(getGeoPointId()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
