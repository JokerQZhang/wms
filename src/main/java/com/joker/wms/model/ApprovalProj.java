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
@Table(name="approval_proj",catalog="wms")
@Indexed
@XmlRootElement
public class ApprovalProj extends BaseObject implements Serializable {
    private Long approvalProjId;
    private Long partyId;
    private String projName;
    private String projMaterial;
    private String projProcedure;
    private String timeLimit;
    private String chargeStandard;
    private String connectPerson;
    private String connectPhone;
    private String placeName;
    private String placeAddress;
    private String trafficWay;
    private String officeHour;
    private Long statisId;
    private Date createdTime;
    private Long createdByUser;
    private Date lastUpdatedTime;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="approval_proj_id", unique=true, nullable=false)    
    public Long getApprovalProjId() {
        return this.approvalProjId;
    }
    
    public void setApprovalProjId(Long approvalProjId) {
        this.approvalProjId = approvalProjId;
    }
    
    @Column(name="party_id")
    @Field
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    
    @Column(name="proj_name", length=50)
    @Field
    public String getProjName() {
        return this.projName;
    }
    
    public void setProjName(String projName) {
        this.projName = projName;
    }
    
    @Column(name="proj_material", length=500)
    @Field
    public String getProjMaterial() {
        return this.projMaterial;
    }
    
    public void setProjMaterial(String projMaterial) {
        this.projMaterial = projMaterial;
    }
    
    @Column(name="proj_procedure", length=500)
    @Field
    public String getProjProcedure() {
        return this.projProcedure;
    }
    
    public void setProjProcedure(String projProcedure) {
        this.projProcedure = projProcedure;
    }
    
    @Column(name="time_limit", length=50)
    @Field
    public String getTimeLimit() {
        return this.timeLimit;
    }
    
    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }
    
    @Column(name="charge_standard", length=50)
    @Field
    public String getChargeStandard() {
        return this.chargeStandard;
    }
    
    public void setChargeStandard(String chargeStandard) {
        this.chargeStandard = chargeStandard;
    }
    
    @Column(name="connect_person", length=50)
    @Field
    public String getConnectPerson() {
        return this.connectPerson;
    }
    
    public void setConnectPerson(String connectPerson) {
        this.connectPerson = connectPerson;
    }
    
    @Column(name="connect_phone", length=20)
    @Field
    public String getConnectPhone() {
        return this.connectPhone;
    }
    
    public void setConnectPhone(String connectPhone) {
        this.connectPhone = connectPhone;
    }
    
    @Column(name="place_name", length=50)
    @Field
    public String getPlaceName() {
        return this.placeName;
    }
    
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
    
    @Column(name="place_address")
    @Field
    public String getPlaceAddress() {
        return this.placeAddress;
    }
    
    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }
    
    @Column(name="traffic_way")
    @Field
    public String getTrafficWay() {
        return this.trafficWay;
    }
    
    public void setTrafficWay(String trafficWay) {
        this.trafficWay = trafficWay;
    }
    
    @Column(name="office_hour")
    @Field
    public String getOfficeHour() {
        return this.officeHour;
    }
    
    public void setOfficeHour(String officeHour) {
        this.officeHour = officeHour;
    }
    
    @Column(name="statis_id")
    @Field
    public Long getStatisId() {
        return this.statisId;
    }
    
    public void setStatisId(Long statisId) {
        this.statisId = statisId;
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

        ApprovalProj pojo = (ApprovalProj) o;

        if (partyId != null ? !partyId.equals(pojo.partyId) : pojo.partyId != null) return false;
        if (projName != null ? !projName.equals(pojo.projName) : pojo.projName != null) return false;
        if (projMaterial != null ? !projMaterial.equals(pojo.projMaterial) : pojo.projMaterial != null) return false;
        if (projProcedure != null ? !projProcedure.equals(pojo.projProcedure) : pojo.projProcedure != null) return false;
        if (timeLimit != null ? !timeLimit.equals(pojo.timeLimit) : pojo.timeLimit != null) return false;
        if (chargeStandard != null ? !chargeStandard.equals(pojo.chargeStandard) : pojo.chargeStandard != null) return false;
        if (connectPerson != null ? !connectPerson.equals(pojo.connectPerson) : pojo.connectPerson != null) return false;
        if (connectPhone != null ? !connectPhone.equals(pojo.connectPhone) : pojo.connectPhone != null) return false;
        if (placeName != null ? !placeName.equals(pojo.placeName) : pojo.placeName != null) return false;
        if (placeAddress != null ? !placeAddress.equals(pojo.placeAddress) : pojo.placeAddress != null) return false;
        if (trafficWay != null ? !trafficWay.equals(pojo.trafficWay) : pojo.trafficWay != null) return false;
        if (officeHour != null ? !officeHour.equals(pojo.officeHour) : pojo.officeHour != null) return false;
        if (statisId != null ? !statisId.equals(pojo.statisId) : pojo.statisId != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (projName != null ? projName.hashCode() : 0);
        result = 31 * result + (projMaterial != null ? projMaterial.hashCode() : 0);
        result = 31 * result + (projProcedure != null ? projProcedure.hashCode() : 0);
        result = 31 * result + (timeLimit != null ? timeLimit.hashCode() : 0);
        result = 31 * result + (chargeStandard != null ? chargeStandard.hashCode() : 0);
        result = 31 * result + (connectPerson != null ? connectPerson.hashCode() : 0);
        result = 31 * result + (connectPhone != null ? connectPhone.hashCode() : 0);
        result = 31 * result + (placeName != null ? placeName.hashCode() : 0);
        result = 31 * result + (placeAddress != null ? placeAddress.hashCode() : 0);
        result = 31 * result + (trafficWay != null ? trafficWay.hashCode() : 0);
        result = 31 * result + (officeHour != null ? officeHour.hashCode() : 0);
        result = 31 * result + (statisId != null ? statisId.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("approvalProjId").append("='").append(getApprovalProjId()).append("', ");
        sb.append("partyId").append("='").append(getPartyId()).append("', ");
        sb.append("projName").append("='").append(getProjName()).append("', ");
        sb.append("projMaterial").append("='").append(getProjMaterial()).append("', ");
        sb.append("projProcedure").append("='").append(getProjProcedure()).append("', ");
        sb.append("timeLimit").append("='").append(getTimeLimit()).append("', ");
        sb.append("chargeStandard").append("='").append(getChargeStandard()).append("', ");
        sb.append("connectPerson").append("='").append(getConnectPerson()).append("', ");
        sb.append("connectPhone").append("='").append(getConnectPhone()).append("', ");
        sb.append("placeName").append("='").append(getPlaceName()).append("', ");
        sb.append("placeAddress").append("='").append(getPlaceAddress()).append("', ");
        sb.append("trafficWay").append("='").append(getTrafficWay()).append("', ");
        sb.append("officeHour").append("='").append(getOfficeHour()).append("', ");
        sb.append("statisId").append("='").append(getStatisId()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
