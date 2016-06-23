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
@Table(name="petition_flow",catalog="wms")
@Indexed
@XmlRootElement
public class PetitionFlow extends BaseObject implements Serializable {
    private Long petitionFlowId;
    private Long petitionId;
    private Long partyId;
    private Long svcId;
    private String memo;
    private Date createdTime;
    private Long createdByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="petition_flow_id", unique=true, nullable=false)    
    public Long getPetitionFlowId() {
        return this.petitionFlowId;
    }
    
    public void setPetitionFlowId(Long petitionFlowId) {
        this.petitionFlowId = petitionFlowId;
    }
    
    @Column(name="petition_id")
    @Field
    public Long getPetitionId() {
        return this.petitionId;
    }
    
    public void setPetitionId(Long petitionId) {
        this.petitionId = petitionId;
    }
    
    @Column(name="party_id")
    @Field
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    
    @Column(name="svc_id")
    @Field
    public Long getSvcId() {
        return this.svcId;
    }
    
    public void setSvcId(Long svcId) {
        this.svcId = svcId;
    }
    
    @Column(name="memo")
    @Field
    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PetitionFlow pojo = (PetitionFlow) o;

        if (petitionId != null ? !petitionId.equals(pojo.petitionId) : pojo.petitionId != null) return false;
        if (partyId != null ? !partyId.equals(pojo.partyId) : pojo.partyId != null) return false;
        if (svcId != null ? !svcId.equals(pojo.svcId) : pojo.svcId != null) return false;
        if (memo != null ? !memo.equals(pojo.memo) : pojo.memo != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (petitionId != null ? petitionId.hashCode() : 0);
        result = 31 * result + (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (svcId != null ? svcId.hashCode() : 0);
        result = 31 * result + (memo != null ? memo.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("petitionFlowId").append("='").append(getPetitionFlowId()).append("', ");
        sb.append("petitionId").append("='").append(getPetitionId()).append("', ");
        sb.append("partyId").append("='").append(getPartyId()).append("', ");
        sb.append("svcId").append("='").append(getSvcId()).append("', ");
        sb.append("memo").append("='").append(getMemo()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
