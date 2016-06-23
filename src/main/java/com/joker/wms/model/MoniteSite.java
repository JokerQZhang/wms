package com.joker.wms.model;

import com.joker.wms.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="monite_site",catalog="wms")
@Indexed
@XmlRootElement
public class MoniteSite extends BaseObject implements Serializable {
    private Long siteId;
    private Long partyId;
    private String sitName;
    private String conPeople;
    private String telphone;
    private String phone;
    private String email;
    private String geopoint;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="site_id", unique=true, nullable=false)    
    public Long getSiteId() {
        return this.siteId;
    }
    
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }
    
    @Column(name="party_id")
    @Field
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    
    @Column(name="sit_name", length=50)
    @Field
    public String getSitName() {
        return this.sitName;
    }
    
    public void setSitName(String sitName) {
        this.sitName = sitName;
    }
    
    @Column(name="con_people", length=30)
    @Field
    public String getConPeople() {
        return this.conPeople;
    }
    
    public void setConPeople(String conPeople) {
        this.conPeople = conPeople;
    }
    
    @Column(name="telphone", length=20)
    @Field
    public String getTelphone() {
        return this.telphone;
    }
    
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
    
    @Column(name="phone", length=20)
    @Field
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Column(name="email", length=50)
    @Field
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="geopoint", length=100)
    @Field
    public String getGeopoint() {
        return this.geopoint;
    }
    
    public void setGeopoint(String geopoint) {
        this.geopoint = geopoint;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoniteSite pojo = (MoniteSite) o;

        if (partyId != null ? !partyId.equals(pojo.partyId) : pojo.partyId != null) return false;
        if (sitName != null ? !sitName.equals(pojo.sitName) : pojo.sitName != null) return false;
        if (conPeople != null ? !conPeople.equals(pojo.conPeople) : pojo.conPeople != null) return false;
        if (telphone != null ? !telphone.equals(pojo.telphone) : pojo.telphone != null) return false;
        if (phone != null ? !phone.equals(pojo.phone) : pojo.phone != null) return false;
        if (email != null ? !email.equals(pojo.email) : pojo.email != null) return false;
        if (geopoint != null ? !geopoint.equals(pojo.geopoint) : pojo.geopoint != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (sitName != null ? sitName.hashCode() : 0);
        result = 31 * result + (conPeople != null ? conPeople.hashCode() : 0);
        result = 31 * result + (telphone != null ? telphone.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (geopoint != null ? geopoint.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("siteId").append("='").append(getSiteId()).append("', ");
        sb.append("partyId").append("='").append(getPartyId()).append("', ");
        sb.append("sitName").append("='").append(getSitName()).append("', ");
        sb.append("conPeople").append("='").append(getConPeople()).append("', ");
        sb.append("telphone").append("='").append(getTelphone()).append("', ");
        sb.append("phone").append("='").append(getPhone()).append("', ");
        sb.append("email").append("='").append(getEmail()).append("', ");
        sb.append("geopoint").append("='").append(getGeopoint()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
