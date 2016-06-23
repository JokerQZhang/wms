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
@Table(name="person",catalog="wms")
@Indexed
@XmlRootElement
public class Person extends BaseObject implements Serializable {
    private Long personId;
    private Long partyId;
    private String name;
    private String pinyinName;
    private String personalTitle;
    private String gender;
    private String cardId;
    private String phone;
    private String birthday;
    private String nation;
    private String household;
    private String marriage;
    private String education;
    private String educationSchoole;
    private String educationSpeciality;
    private String familyAddress;
    private String qq;
    private String weixin;
    private String workDate;
    private String age;
    private Date createdTime;
    private Date lastUpdatedTime;
    private Long createdByUser;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="person_id", unique=true, nullable=false)    
    public Long getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(Long personId) {
        this.personId = personId;
    }
    
    @Column(name="party_id")
    @Field
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    
    @Column(name="name", length=20)
    @Field
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="pinyin_name", length=50)
    @Field
    public String getPinyinName() {
        return this.pinyinName;
    }
    
    public void setPinyinName(String pinyinName) {
        this.pinyinName = pinyinName;
    }
    
    @Column(name="personal_title", length=20)
    @Field
    public String getPersonalTitle() {
        return this.personalTitle;
    }
    
    public void setPersonalTitle(String personalTitle) {
        this.personalTitle = personalTitle;
    }
    
    @Column(name="gender", length=2)
    @Field
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @Column(name="card_id", length=20)
    @Field
    public String getCardId() {
        return this.cardId;
    }
    
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
    
    @Column(name="phone", length=20)
    @Field
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Column(name="birthday", length=20)
    @Field
    public String getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    @Column(name="nation", length=20)
    @Field
    public String getNation() {
        return this.nation;
    }
    
    public void setNation(String nation) {
        this.nation = nation;
    }
    
    @Column(name="household", length=150)
    @Field
    public String getHousehold() {
        return this.household;
    }
    
    public void setHousehold(String household) {
        this.household = household;
    }
    
    @Column(name="marriage", length=20)
    @Field
    public String getMarriage() {
        return this.marriage;
    }
    
    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }
    
    @Column(name="education", length=20)
    @Field
    public String getEducation() {
        return this.education;
    }
    
    public void setEducation(String education) {
        this.education = education;
    }
    
    @Column(name="education_schoole", length=100)
    @Field
    public String getEducationSchoole() {
        return this.educationSchoole;
    }
    
    public void setEducationSchoole(String educationSchoole) {
        this.educationSchoole = educationSchoole;
    }
    
    @Column(name="education_speciality", length=100)
    @Field
    public String getEducationSpeciality() {
        return this.educationSpeciality;
    }
    
    public void setEducationSpeciality(String educationSpeciality) {
        this.educationSpeciality = educationSpeciality;
    }
    
    @Column(name="family_address")
    @Field
    public String getFamilyAddress() {
        return this.familyAddress;
    }
    
    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress;
    }
    
    @Column(name="qq", length=50)
    @Field
    public String getQq() {
        return this.qq;
    }
    
    public void setQq(String qq) {
        this.qq = qq;
    }
    
    @Column(name="weixin", length=50)
    @Field
    public String getWeixin() {
        return this.weixin;
    }
    
    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }
    
    @Column(name="work_date", length=20)
    @Field
    public String getWorkDate() {
        return this.workDate;
    }
    
    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }
    
    @Column(name="age", length=20)
    @Field
    public String getAge() {
        return this.age;
    }
    
    public void setAge(String age) {
        this.age = age;
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

        Person pojo = (Person) o;

        if (partyId != null ? !partyId.equals(pojo.partyId) : pojo.partyId != null) return false;
        if (name != null ? !name.equals(pojo.name) : pojo.name != null) return false;
        if (pinyinName != null ? !pinyinName.equals(pojo.pinyinName) : pojo.pinyinName != null) return false;
        if (personalTitle != null ? !personalTitle.equals(pojo.personalTitle) : pojo.personalTitle != null) return false;
        if (gender != null ? !gender.equals(pojo.gender) : pojo.gender != null) return false;
        if (cardId != null ? !cardId.equals(pojo.cardId) : pojo.cardId != null) return false;
        if (phone != null ? !phone.equals(pojo.phone) : pojo.phone != null) return false;
        if (birthday != null ? !birthday.equals(pojo.birthday) : pojo.birthday != null) return false;
        if (nation != null ? !nation.equals(pojo.nation) : pojo.nation != null) return false;
        if (household != null ? !household.equals(pojo.household) : pojo.household != null) return false;
        if (marriage != null ? !marriage.equals(pojo.marriage) : pojo.marriage != null) return false;
        if (education != null ? !education.equals(pojo.education) : pojo.education != null) return false;
        if (educationSchoole != null ? !educationSchoole.equals(pojo.educationSchoole) : pojo.educationSchoole != null) return false;
        if (educationSpeciality != null ? !educationSpeciality.equals(pojo.educationSpeciality) : pojo.educationSpeciality != null) return false;
        if (familyAddress != null ? !familyAddress.equals(pojo.familyAddress) : pojo.familyAddress != null) return false;
        if (qq != null ? !qq.equals(pojo.qq) : pojo.qq != null) return false;
        if (weixin != null ? !weixin.equals(pojo.weixin) : pojo.weixin != null) return false;
        if (workDate != null ? !workDate.equals(pojo.workDate) : pojo.workDate != null) return false;
        if (age != null ? !age.equals(pojo.age) : pojo.age != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pinyinName != null ? pinyinName.hashCode() : 0);
        result = 31 * result + (personalTitle != null ? personalTitle.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (cardId != null ? cardId.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        result = 31 * result + (household != null ? household.hashCode() : 0);
        result = 31 * result + (marriage != null ? marriage.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (educationSchoole != null ? educationSchoole.hashCode() : 0);
        result = 31 * result + (educationSpeciality != null ? educationSpeciality.hashCode() : 0);
        result = 31 * result + (familyAddress != null ? familyAddress.hashCode() : 0);
        result = 31 * result + (qq != null ? qq.hashCode() : 0);
        result = 31 * result + (weixin != null ? weixin.hashCode() : 0);
        result = 31 * result + (workDate != null ? workDate.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("personId").append("='").append(getPersonId()).append("', ");
        sb.append("partyId").append("='").append(getPartyId()).append("', ");
        sb.append("name").append("='").append(getName()).append("', ");
        sb.append("pinyinName").append("='").append(getPinyinName()).append("', ");
        sb.append("personalTitle").append("='").append(getPersonalTitle()).append("', ");
        sb.append("gender").append("='").append(getGender()).append("', ");
        sb.append("cardId").append("='").append(getCardId()).append("', ");
        sb.append("phone").append("='").append(getPhone()).append("', ");
        sb.append("birthday").append("='").append(getBirthday()).append("', ");
        sb.append("nation").append("='").append(getNation()).append("', ");
        sb.append("household").append("='").append(getHousehold()).append("', ");
        sb.append("marriage").append("='").append(getMarriage()).append("', ");
        sb.append("education").append("='").append(getEducation()).append("', ");
        sb.append("educationSchoole").append("='").append(getEducationSchoole()).append("', ");
        sb.append("educationSpeciality").append("='").append(getEducationSpeciality()).append("', ");
        sb.append("familyAddress").append("='").append(getFamilyAddress()).append("', ");
        sb.append("qq").append("='").append(getQq()).append("', ");
        sb.append("weixin").append("='").append(getWeixin()).append("', ");
        sb.append("workDate").append("='").append(getWorkDate()).append("', ");
        sb.append("age").append("='").append(getAge()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
