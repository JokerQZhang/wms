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
@Table(name="dq_hui",catalog="wms")
@Indexed
@XmlRootElement
public class DqHui extends BaseObject implements Serializable {
    private Long huiId;
    private String title;
    private Long zhibuPartyId;
    private String huiType;
    private Date huiTime;
    private String huiAddress;
    private String huiMaster;
    private String huiRecorder;
    private Long numShould;
    private Long numReal;
    private Long numParty;
    private Long numAbsent;
    private Long numAbsentParty;
    private String nameComeIn;
    private String nameSiteIn;
    private String nameAbsent;
    private String huiContent;
    private Date createdTime;
    private Long createdByUser;
    private Date lastUpdatedTime;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="hui_id", unique=true, nullable=false)    
    public Long getHuiId() {
        return this.huiId;
    }
    
    public void setHuiId(Long huiId) {
        this.huiId = huiId;
    }
    
    @Column(name="title", length=100)
    @Field
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Column(name="zhibu_party_id")
    @Field
    public Long getZhibuPartyId() {
        return this.zhibuPartyId;
    }
    
    public void setZhibuPartyId(Long zhibuPartyId) {
        this.zhibuPartyId = zhibuPartyId;
    }
    
    @Column(name="hui_type", length=20)
    @Field
    public String getHuiType() {
        return this.huiType;
    }
    
    public void setHuiType(String huiType) {
        this.huiType = huiType;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="hui_time", length=19)
    @Field
    public Date getHuiTime() {
        return this.huiTime;
    }
    
    public void setHuiTime(Date huiTime) {
        this.huiTime = huiTime;
    }
    
    @Column(name="hui_address", length=100)
    @Field
    public String getHuiAddress() {
        return this.huiAddress;
    }
    
    public void setHuiAddress(String huiAddress) {
        this.huiAddress = huiAddress;
    }
    
    @Column(name="hui_master", length=20)
    @Field
    public String getHuiMaster() {
        return this.huiMaster;
    }
    
    public void setHuiMaster(String huiMaster) {
        this.huiMaster = huiMaster;
    }
    
    @Column(name="hui_recorder", length=20)
    @Field
    public String getHuiRecorder() {
        return this.huiRecorder;
    }
    
    public void setHuiRecorder(String huiRecorder) {
        this.huiRecorder = huiRecorder;
    }
    
    @Column(name="num_should")
    @Field
    public Long getNumShould() {
        return this.numShould;
    }
    
    public void setNumShould(Long numShould) {
        this.numShould = numShould;
    }
    
    @Column(name="num_real")
    @Field
    public Long getNumReal() {
        return this.numReal;
    }
    
    public void setNumReal(Long numReal) {
        this.numReal = numReal;
    }
    
    @Column(name="num_party")
    @Field
    public Long getNumParty() {
        return this.numParty;
    }
    
    public void setNumParty(Long numParty) {
        this.numParty = numParty;
    }
    
    @Column(name="num_absent")
    @Field
    public Long getNumAbsent() {
        return this.numAbsent;
    }
    
    public void setNumAbsent(Long numAbsent) {
        this.numAbsent = numAbsent;
    }
    
    @Column(name="num_absent_party")
    @Field
    public Long getNumAbsentParty() {
        return this.numAbsentParty;
    }
    
    public void setNumAbsentParty(Long numAbsentParty) {
        this.numAbsentParty = numAbsentParty;
    }
    
    @Column(name="name_come_in")
    @Field
    public String getNameComeIn() {
        return this.nameComeIn;
    }
    
    public void setNameComeIn(String nameComeIn) {
        this.nameComeIn = nameComeIn;
    }
    
    @Column(name="name_site_in")
    @Field
    public String getNameSiteIn() {
        return this.nameSiteIn;
    }
    
    public void setNameSiteIn(String nameSiteIn) {
        this.nameSiteIn = nameSiteIn;
    }
    
    @Column(name="name_absent")
    @Field
    public String getNameAbsent() {
        return this.nameAbsent;
    }
    
    public void setNameAbsent(String nameAbsent) {
        this.nameAbsent = nameAbsent;
    }
    
    @Column(name="hui_content", length=65535)
    @Field
    public String getHuiContent() {
        return this.huiContent;
    }
    
    public void setHuiContent(String huiContent) {
        this.huiContent = huiContent;
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

        DqHui pojo = (DqHui) o;

        if (title != null ? !title.equals(pojo.title) : pojo.title != null) return false;
        if (zhibuPartyId != null ? !zhibuPartyId.equals(pojo.zhibuPartyId) : pojo.zhibuPartyId != null) return false;
        if (huiType != null ? !huiType.equals(pojo.huiType) : pojo.huiType != null) return false;
        if (huiTime != null ? !huiTime.equals(pojo.huiTime) : pojo.huiTime != null) return false;
        if (huiAddress != null ? !huiAddress.equals(pojo.huiAddress) : pojo.huiAddress != null) return false;
        if (huiMaster != null ? !huiMaster.equals(pojo.huiMaster) : pojo.huiMaster != null) return false;
        if (huiRecorder != null ? !huiRecorder.equals(pojo.huiRecorder) : pojo.huiRecorder != null) return false;
        if (numShould != null ? !numShould.equals(pojo.numShould) : pojo.numShould != null) return false;
        if (numReal != null ? !numReal.equals(pojo.numReal) : pojo.numReal != null) return false;
        if (numParty != null ? !numParty.equals(pojo.numParty) : pojo.numParty != null) return false;
        if (numAbsent != null ? !numAbsent.equals(pojo.numAbsent) : pojo.numAbsent != null) return false;
        if (numAbsentParty != null ? !numAbsentParty.equals(pojo.numAbsentParty) : pojo.numAbsentParty != null) return false;
        if (nameComeIn != null ? !nameComeIn.equals(pojo.nameComeIn) : pojo.nameComeIn != null) return false;
        if (nameSiteIn != null ? !nameSiteIn.equals(pojo.nameSiteIn) : pojo.nameSiteIn != null) return false;
        if (nameAbsent != null ? !nameAbsent.equals(pojo.nameAbsent) : pojo.nameAbsent != null) return false;
        if (huiContent != null ? !huiContent.equals(pojo.huiContent) : pojo.huiContent != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (title != null ? title.hashCode() : 0);
        result = 31 * result + (zhibuPartyId != null ? zhibuPartyId.hashCode() : 0);
        result = 31 * result + (huiType != null ? huiType.hashCode() : 0);
        result = 31 * result + (huiTime != null ? huiTime.hashCode() : 0);
        result = 31 * result + (huiAddress != null ? huiAddress.hashCode() : 0);
        result = 31 * result + (huiMaster != null ? huiMaster.hashCode() : 0);
        result = 31 * result + (huiRecorder != null ? huiRecorder.hashCode() : 0);
        result = 31 * result + (numShould != null ? numShould.hashCode() : 0);
        result = 31 * result + (numReal != null ? numReal.hashCode() : 0);
        result = 31 * result + (numParty != null ? numParty.hashCode() : 0);
        result = 31 * result + (numAbsent != null ? numAbsent.hashCode() : 0);
        result = 31 * result + (numAbsentParty != null ? numAbsentParty.hashCode() : 0);
        result = 31 * result + (nameComeIn != null ? nameComeIn.hashCode() : 0);
        result = 31 * result + (nameSiteIn != null ? nameSiteIn.hashCode() : 0);
        result = 31 * result + (nameAbsent != null ? nameAbsent.hashCode() : 0);
        result = 31 * result + (huiContent != null ? huiContent.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("huiId").append("='").append(getHuiId()).append("', ");
        sb.append("title").append("='").append(getTitle()).append("', ");
        sb.append("zhibuPartyId").append("='").append(getZhibuPartyId()).append("', ");
        sb.append("huiType").append("='").append(getHuiType()).append("', ");
        sb.append("huiTime").append("='").append(getHuiTime()).append("', ");
        sb.append("huiAddress").append("='").append(getHuiAddress()).append("', ");
        sb.append("huiMaster").append("='").append(getHuiMaster()).append("', ");
        sb.append("huiRecorder").append("='").append(getHuiRecorder()).append("', ");
        sb.append("numShould").append("='").append(getNumShould()).append("', ");
        sb.append("numReal").append("='").append(getNumReal()).append("', ");
        sb.append("numParty").append("='").append(getNumParty()).append("', ");
        sb.append("numAbsent").append("='").append(getNumAbsent()).append("', ");
        sb.append("numAbsentParty").append("='").append(getNumAbsentParty()).append("', ");
        sb.append("nameComeIn").append("='").append(getNameComeIn()).append("', ");
        sb.append("nameSiteIn").append("='").append(getNameSiteIn()).append("', ");
        sb.append("nameAbsent").append("='").append(getNameAbsent()).append("', ");
        sb.append("huiContent").append("='").append(getHuiContent()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
