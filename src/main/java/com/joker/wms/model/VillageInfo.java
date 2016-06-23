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
@Table(name="village_info",catalog="wms")
@Indexed
@XmlRootElement
public class VillageInfo extends BaseObject implements Serializable {
    private Long villageInfoId;
    private Long partyId;
    private String villageType;
    private Long peopleNum;
    private Long partyNum;
    private Long leaderNum;
    private String personIncome;
    private String groupIncome;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="village_info_id", unique=true, nullable=false)    
    public Long getVillageInfoId() {
        return this.villageInfoId;
    }
    
    public void setVillageInfoId(Long villageInfoId) {
        this.villageInfoId = villageInfoId;
    }
    
    @Column(name="party_id")
    @Field
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    
    @Column(name="village_type", length=30)
    @Field
    public String getVillageType() {
        return this.villageType;
    }
    
    public void setVillageType(String villageType) {
        this.villageType = villageType;
    }
    
    @Column(name="people_num")
    @Field
    public Long getPeopleNum() {
        return this.peopleNum;
    }
    
    public void setPeopleNum(Long peopleNum) {
        this.peopleNum = peopleNum;
    }
    
    @Column(name="party_num")
    @Field
    public Long getPartyNum() {
        return this.partyNum;
    }
    
    public void setPartyNum(Long partyNum) {
        this.partyNum = partyNum;
    }
    
    @Column(name="leader_num")
    @Field
    public Long getLeaderNum() {
        return this.leaderNum;
    }
    
    public void setLeaderNum(Long leaderNum) {
        this.leaderNum = leaderNum;
    }
    
    @Column(name="person_income", length=20)
    @Field
    public String getPersonIncome() {
        return this.personIncome;
    }
    
    public void setPersonIncome(String personIncome) {
        this.personIncome = personIncome;
    }
    
    @Column(name="group_income", length=20)
    @Field
    public String getGroupIncome() {
        return this.groupIncome;
    }
    
    public void setGroupIncome(String groupIncome) {
        this.groupIncome = groupIncome;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VillageInfo pojo = (VillageInfo) o;

        if (partyId != null ? !partyId.equals(pojo.partyId) : pojo.partyId != null) return false;
        if (villageType != null ? !villageType.equals(pojo.villageType) : pojo.villageType != null) return false;
        if (peopleNum != null ? !peopleNum.equals(pojo.peopleNum) : pojo.peopleNum != null) return false;
        if (partyNum != null ? !partyNum.equals(pojo.partyNum) : pojo.partyNum != null) return false;
        if (leaderNum != null ? !leaderNum.equals(pojo.leaderNum) : pojo.leaderNum != null) return false;
        if (personIncome != null ? !personIncome.equals(pojo.personIncome) : pojo.personIncome != null) return false;
        if (groupIncome != null ? !groupIncome.equals(pojo.groupIncome) : pojo.groupIncome != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (villageType != null ? villageType.hashCode() : 0);
        result = 31 * result + (peopleNum != null ? peopleNum.hashCode() : 0);
        result = 31 * result + (partyNum != null ? partyNum.hashCode() : 0);
        result = 31 * result + (leaderNum != null ? leaderNum.hashCode() : 0);
        result = 31 * result + (personIncome != null ? personIncome.hashCode() : 0);
        result = 31 * result + (groupIncome != null ? groupIncome.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("villageInfoId").append("='").append(getVillageInfoId()).append("', ");
        sb.append("partyId").append("='").append(getPartyId()).append("', ");
        sb.append("villageType").append("='").append(getVillageType()).append("', ");
        sb.append("peopleNum").append("='").append(getPeopleNum()).append("', ");
        sb.append("partyNum").append("='").append(getPartyNum()).append("', ");
        sb.append("leaderNum").append("='").append(getLeaderNum()).append("', ");
        sb.append("personIncome").append("='").append(getPersonIncome()).append("', ");
        sb.append("groupIncome").append("='").append(getGroupIncome()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
