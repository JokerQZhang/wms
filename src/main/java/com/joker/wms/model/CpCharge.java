package com.joker.wms.model;

import com.joker.wms.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import java.math.BigDecimal;
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
@Table(name="cp_charge",catalog="wms")
@Indexed
@XmlRootElement
public class CpCharge extends BaseObject implements Serializable {
    private Long cpChargeId;
    private String cpTitle;
    private Long operType;
    private Long accountType;
    private Long partyId;
    private Long ioType;
    private BigDecimal balance;
    private String memo;
    private Long relatePartyId;
    private String operPeople;
    private Long relateAccountType;
    private Date createdTime;
    private Long createdByUser;
    private Date lastUpdatedTime;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="cp_charge_id", unique=true, nullable=false)    
    public Long getCpChargeId() {
        return this.cpChargeId;
    }
    
    public void setCpChargeId(Long cpChargeId) {
        this.cpChargeId = cpChargeId;
    }
    
    @Column(name="cp_title", length=50)
    @Field
    public String getCpTitle() {
        return this.cpTitle;
    }
    
    public void setCpTitle(String cpTitle) {
        this.cpTitle = cpTitle;
    }
    
    @Column(name="oper_type")
    @Field
    public Long getOperType() {
        return this.operType;
    }
    
    public void setOperType(Long operType) {
        this.operType = operType;
    }
    
    @Column(name="account_type")
    @Field
    public Long getAccountType() {
        return this.accountType;
    }
    
    public void setAccountType(Long accountType) {
        this.accountType = accountType;
    }
    
    @Column(name="party_id")
    @Field
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    
    @Column(name="io_type")
    @Field
    public Long getIoType() {
        return this.ioType;
    }
    
    public void setIoType(Long ioType) {
        this.ioType = ioType;
    }
    
    @Column(name="balance", precision=16)
    @Field
    public BigDecimal getBalance() {
        return this.balance;
    }
    
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
    @Column(name="memo")
    @Field
    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
    
    @Column(name="relate_party_id")
    @Field
    public Long getRelatePartyId() {
        return this.relatePartyId;
    }
    
    public void setRelatePartyId(Long relatePartyId) {
        this.relatePartyId = relatePartyId;
    }
    
    @Column(name="oper_people", length=30)
    @Field
    public String getOperPeople() {
        return this.operPeople;
    }
    
    public void setOperPeople(String operPeople) {
        this.operPeople = operPeople;
    }
    
    @Column(name="relate_account_type")
    @Field
    public Long getRelateAccountType() {
        return this.relateAccountType;
    }
    
    public void setRelateAccountType(Long relateAccountType) {
        this.relateAccountType = relateAccountType;
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

        CpCharge pojo = (CpCharge) o;

        if (cpTitle != null ? !cpTitle.equals(pojo.cpTitle) : pojo.cpTitle != null) return false;
        if (operType != null ? !operType.equals(pojo.operType) : pojo.operType != null) return false;
        if (accountType != null ? !accountType.equals(pojo.accountType) : pojo.accountType != null) return false;
        if (partyId != null ? !partyId.equals(pojo.partyId) : pojo.partyId != null) return false;
        if (ioType != null ? !ioType.equals(pojo.ioType) : pojo.ioType != null) return false;
        if (balance != null ? !balance.equals(pojo.balance) : pojo.balance != null) return false;
        if (memo != null ? !memo.equals(pojo.memo) : pojo.memo != null) return false;
        if (relatePartyId != null ? !relatePartyId.equals(pojo.relatePartyId) : pojo.relatePartyId != null) return false;
        if (operPeople != null ? !operPeople.equals(pojo.operPeople) : pojo.operPeople != null) return false;
        if (relateAccountType != null ? !relateAccountType.equals(pojo.relateAccountType) : pojo.relateAccountType != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (cpTitle != null ? cpTitle.hashCode() : 0);
        result = 31 * result + (operType != null ? operType.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (ioType != null ? ioType.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (memo != null ? memo.hashCode() : 0);
        result = 31 * result + (relatePartyId != null ? relatePartyId.hashCode() : 0);
        result = 31 * result + (operPeople != null ? operPeople.hashCode() : 0);
        result = 31 * result + (relateAccountType != null ? relateAccountType.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("cpChargeId").append("='").append(getCpChargeId()).append("', ");
        sb.append("cpTitle").append("='").append(getCpTitle()).append("', ");
        sb.append("operType").append("='").append(getOperType()).append("', ");
        sb.append("accountType").append("='").append(getAccountType()).append("', ");
        sb.append("partyId").append("='").append(getPartyId()).append("', ");
        sb.append("ioType").append("='").append(getIoType()).append("', ");
        sb.append("balance").append("='").append(getBalance()).append("', ");
        sb.append("memo").append("='").append(getMemo()).append("', ");
        sb.append("relatePartyId").append("='").append(getRelatePartyId()).append("', ");
        sb.append("operPeople").append("='").append(getOperPeople()).append("', ");
        sb.append("relateAccountType").append("='").append(getRelateAccountType()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
