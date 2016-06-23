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
@Table(name="party_group",catalog="wms")
@Indexed
@XmlRootElement
public class PartyGroup extends BaseObject implements Serializable {
    private Long pgId;
    private Long partyId;
    private String groupName;
    private String pinyinName;
    private Long numEmployees;
    private String address;
    private String phone;
    private String companyType;
    private Long geoid;
    private String geopoint;
    private Date createdTime;
    private Date lastUpdatedTime;
    private Long createdByUser;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="pg_id", unique=true, nullable=false)    
    public Long getPgId() {
        return this.pgId;
    }
    
    public void setPgId(Long pgId) {
        this.pgId = pgId;
    }
    
    @Column(name="party_id")
    @Field
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    
    @Column(name="group_name", length=50)
    @Field
    public String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    @Column(name="pinyin_name", length=50)
    @Field
    public String getPinyinName() {
        return this.pinyinName;
    }
    
    public void setPinyinName(String pinyinName) {
        this.pinyinName = pinyinName;
    }
    
    @Column(name="num_employees")
    @Field
    public Long getNumEmployees() {
        return this.numEmployees;
    }
    
    public void setNumEmployees(Long numEmployees) {
        this.numEmployees = numEmployees;
    }
    
    @Column(name="address", length=16777215)
    @Field
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="phone", length=20)
    @Field
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Column(name="company_type", length=20)
    @Field
    public String getCompanyType() {
        return this.companyType;
    }
    
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }
    
    @Column(name="geoid")
    @Field
    public Long getGeoid() {
        return this.geoid;
    }
    
    public void setGeoid(Long geoid) {
        this.geoid = geoid;
    }
    
    @Column(name="geopoint", length=100)
    @Field
    public String getGeopoint() {
        return this.geopoint;
    }
    
    public void setGeopoint(String geopoint) {
        this.geopoint = geopoint;
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

        PartyGroup pojo = (PartyGroup) o;

        if (partyId != null ? !partyId.equals(pojo.partyId) : pojo.partyId != null) return false;
        if (groupName != null ? !groupName.equals(pojo.groupName) : pojo.groupName != null) return false;
        if (pinyinName != null ? !pinyinName.equals(pojo.pinyinName) : pojo.pinyinName != null) return false;
        if (numEmployees != null ? !numEmployees.equals(pojo.numEmployees) : pojo.numEmployees != null) return false;
        if (address != null ? !address.equals(pojo.address) : pojo.address != null) return false;
        if (phone != null ? !phone.equals(pojo.phone) : pojo.phone != null) return false;
        if (companyType != null ? !companyType.equals(pojo.companyType) : pojo.companyType != null) return false;
        if (geoid != null ? !geoid.equals(pojo.geoid) : pojo.geoid != null) return false;
        if (geopoint != null ? !geopoint.equals(pojo.geopoint) : pojo.geopoint != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (pinyinName != null ? pinyinName.hashCode() : 0);
        result = 31 * result + (numEmployees != null ? numEmployees.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (companyType != null ? companyType.hashCode() : 0);
        result = 31 * result + (geoid != null ? geoid.hashCode() : 0);
        result = 31 * result + (geopoint != null ? geopoint.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("pgId").append("='").append(getPgId()).append("', ");
        sb.append("partyId").append("='").append(getPartyId()).append("', ");
        sb.append("groupName").append("='").append(getGroupName()).append("', ");
        sb.append("pinyinName").append("='").append(getPinyinName()).append("', ");
        sb.append("numEmployees").append("='").append(getNumEmployees()).append("', ");
        sb.append("address").append("='").append(getAddress()).append("', ");
        sb.append("phone").append("='").append(getPhone()).append("', ");
        sb.append("companyType").append("='").append(getCompanyType()).append("', ");
        sb.append("geoid").append("='").append(getGeoid()).append("', ");
        sb.append("geopoint").append("='").append(getGeopoint()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
