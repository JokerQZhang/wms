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
@Table(name="tb_care_people",catalog="wms")
@Indexed
@XmlRootElement
public class TbCarePeople extends BaseObject implements Serializable {
    private Long peopleId;
    private Long departmentId;
    private String peopleName;
    private String gender;
    private String nation;
    private String partyType;
    private String partyStatus;
    private String birthday;
    private String idCard;
    private String job;
    private String address;
    private String pensionInsurance;
    private Date createdTime;
    private Long createdByUser;
    private Date lastUpdatedTime;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="people_id", unique=true, nullable=false)    
    public Long getPeopleId() {
        return this.peopleId;
    }
    
    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }
    
    @Column(name="department_id")
    @Field
    public Long getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
    
    @Column(name="people_name", length=30)
    @Field
    public String getPeopleName() {
        return this.peopleName;
    }
    
    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }
    
    @Column(name="gender", length=10)
    @Field
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @Column(name="nation", length=20)
    @Field
    public String getNation() {
        return this.nation;
    }
    
    public void setNation(String nation) {
        this.nation = nation;
    }
    
    @Column(name="party_type", length=20)
    @Field
    public String getPartyType() {
        return this.partyType;
    }
    
    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }
    
    @Column(name="party_status", length=20)
    @Field
    public String getPartyStatus() {
        return this.partyStatus;
    }
    
    public void setPartyStatus(String partyStatus) {
        this.partyStatus = partyStatus;
    }
    
    @Column(name="birthday", length=20)
    @Field
    public String getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    @Column(name="id_card", length=20)
    @Field
    public String getIdCard() {
        return this.idCard;
    }
    
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    
    @Column(name="job", length=30)
    @Field
    public String getJob() {
        return this.job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }
    
    @Column(name="address")
    @Field
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="pension_insurance", length=30)
    @Field
    public String getPensionInsurance() {
        return this.pensionInsurance;
    }
    
    public void setPensionInsurance(String pensionInsurance) {
        this.pensionInsurance = pensionInsurance;
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

        TbCarePeople pojo = (TbCarePeople) o;

        if (departmentId != null ? !departmentId.equals(pojo.departmentId) : pojo.departmentId != null) return false;
        if (peopleName != null ? !peopleName.equals(pojo.peopleName) : pojo.peopleName != null) return false;
        if (gender != null ? !gender.equals(pojo.gender) : pojo.gender != null) return false;
        if (nation != null ? !nation.equals(pojo.nation) : pojo.nation != null) return false;
        if (partyType != null ? !partyType.equals(pojo.partyType) : pojo.partyType != null) return false;
        if (partyStatus != null ? !partyStatus.equals(pojo.partyStatus) : pojo.partyStatus != null) return false;
        if (birthday != null ? !birthday.equals(pojo.birthday) : pojo.birthday != null) return false;
        if (idCard != null ? !idCard.equals(pojo.idCard) : pojo.idCard != null) return false;
        if (job != null ? !job.equals(pojo.job) : pojo.job != null) return false;
        if (address != null ? !address.equals(pojo.address) : pojo.address != null) return false;
        if (pensionInsurance != null ? !pensionInsurance.equals(pojo.pensionInsurance) : pojo.pensionInsurance != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (departmentId != null ? departmentId.hashCode() : 0);
        result = 31 * result + (peopleName != null ? peopleName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        result = 31 * result + (partyType != null ? partyType.hashCode() : 0);
        result = 31 * result + (partyStatus != null ? partyStatus.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (idCard != null ? idCard.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (pensionInsurance != null ? pensionInsurance.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("peopleId").append("='").append(getPeopleId()).append("', ");
        sb.append("departmentId").append("='").append(getDepartmentId()).append("', ");
        sb.append("peopleName").append("='").append(getPeopleName()).append("', ");
        sb.append("gender").append("='").append(getGender()).append("', ");
        sb.append("nation").append("='").append(getNation()).append("', ");
        sb.append("partyType").append("='").append(getPartyType()).append("', ");
        sb.append("partyStatus").append("='").append(getPartyStatus()).append("', ");
        sb.append("birthday").append("='").append(getBirthday()).append("', ");
        sb.append("idCard").append("='").append(getIdCard()).append("', ");
        sb.append("job").append("='").append(getJob()).append("', ");
        sb.append("address").append("='").append(getAddress()).append("', ");
        sb.append("pensionInsurance").append("='").append(getPensionInsurance()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
