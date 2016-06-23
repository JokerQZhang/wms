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
@Table(name="cp_dtl",catalog="wms")
@Indexed
@XmlRootElement
public class CpDtl extends BaseObject implements Serializable {
    private Long cpDtlId;
    private Long partyId;
    private Long statusId;
    private String bePartyDate;
    private String positiveDate;
    private String bePartyZhibu;
    private String beHereDate;
    private String outOfZhibu;
    private String partyStatus;
    private String occupation;
    private String workGroup;
    private String workStatus;
    private String householdAddress;
    private String flowOutDate;
    private String flowOutInfo;
    private String isHaveFlowCard;
    private String flowCardNum;
    private String flowInGroup;
    private String flowInGroupPerson;
    private String flowInGroupPhone;
    private String partyGroupType;
    private String outCountryDate;
    private String outCountryReason;
    private String outCountryConnect;
    private String outCountryDangji;
    private String outCountryBackdate;
    private String outCountryBacklife;
    private String RTitle1;
    private String RTitle2;
    private String RTitle3;
    private String RTitle4;
    private String RTitle5;
    private String RTitle6;
    private String RName1;
    private String RName2;
    private String RName3;
    private String RName4;
    private String RName5;
    private String RName6;
    private String RAge1;
    private String RAge2;
    private String RAge3;
    private String RAge4;
    private String RAge5;
    private String RAge6;
    private String RSocial1;
    private String RSocial2;
    private String RSocial3;
    private String RSocial4;
    private String RSocial5;
    private String RSocial6;
    private String RWorkeCompany1;
    private String RWorkeCompany2;
    private String RWorkeCompany3;
    private String RWorkeCompany4;
    private String RWorkeCompany5;
    private String RWorkeCompany6;
    private String RWorkeSatus1;
    private String RWorkeSatus2;
    private String RWorkeSatus3;
    private String RWorkeSatus4;
    private String RWorkeSatus5;
    private String RWorkeSatus6;
    private String rdzys;
    private String rdsqs;
    private String zzsccl;
    private String zzsqs;
    private String pykccl;
    private String otherCl;
    private String keepUnit;
    private Date createdTime;
    private Long createdByUser;
    private Date lastUpdatedTime;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="cp_dtl_id", unique=true, nullable=false)    
    public Long getCpDtlId() {
        return this.cpDtlId;
    }
    
    public void setCpDtlId(Long cpDtlId) {
        this.cpDtlId = cpDtlId;
    }
    
    @Column(name="party_id")
    @Field
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    
    @Column(name="status_id")
    @Field
    public Long getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
    
    @Column(name="be_party_date", length=20)
    @Field
    public String getBePartyDate() {
        return this.bePartyDate;
    }
    
    public void setBePartyDate(String bePartyDate) {
        this.bePartyDate = bePartyDate;
    }
    
    @Column(name="positive_date", length=20)
    @Field
    public String getPositiveDate() {
        return this.positiveDate;
    }
    
    public void setPositiveDate(String positiveDate) {
        this.positiveDate = positiveDate;
    }
    
    @Column(name="be_party_zhibu", length=50)
    @Field
    public String getBePartyZhibu() {
        return this.bePartyZhibu;
    }
    
    public void setBePartyZhibu(String bePartyZhibu) {
        this.bePartyZhibu = bePartyZhibu;
    }
    
    @Column(name="be_here_date", length=20)
    @Field
    public String getBeHereDate() {
        return this.beHereDate;
    }
    
    public void setBeHereDate(String beHereDate) {
        this.beHereDate = beHereDate;
    }
    
    @Column(name="out_of_zhibu", length=50)
    @Field
    public String getOutOfZhibu() {
        return this.outOfZhibu;
    }
    
    public void setOutOfZhibu(String outOfZhibu) {
        this.outOfZhibu = outOfZhibu;
    }
    
    @Column(name="party_status", length=100)
    @Field
    public String getPartyStatus() {
        return this.partyStatus;
    }
    
    public void setPartyStatus(String partyStatus) {
        this.partyStatus = partyStatus;
    }
    
    @Column(name="occupation", length=100)
    @Field
    public String getOccupation() {
        return this.occupation;
    }
    
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    @Column(name="work_group", length=100)
    @Field
    public String getWorkGroup() {
        return this.workGroup;
    }
    
    public void setWorkGroup(String workGroup) {
        this.workGroup = workGroup;
    }
    
    @Column(name="work_status", length=100)
    @Field
    public String getWorkStatus() {
        return this.workStatus;
    }
    
    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }
    
    @Column(name="household_address", length=100)
    @Field
    public String getHouseholdAddress() {
        return this.householdAddress;
    }
    
    public void setHouseholdAddress(String householdAddress) {
        this.householdAddress = householdAddress;
    }
    
    @Column(name="flow_out_date", length=20)
    @Field
    public String getFlowOutDate() {
        return this.flowOutDate;
    }
    
    public void setFlowOutDate(String flowOutDate) {
        this.flowOutDate = flowOutDate;
    }
    
    @Column(name="flow_out_info", length=100)
    @Field
    public String getFlowOutInfo() {
        return this.flowOutInfo;
    }
    
    public void setFlowOutInfo(String flowOutInfo) {
        this.flowOutInfo = flowOutInfo;
    }
    
    @Column(name="is_have_flow_card", length=20)
    @Field
    public String getIsHaveFlowCard() {
        return this.isHaveFlowCard;
    }
    
    public void setIsHaveFlowCard(String isHaveFlowCard) {
        this.isHaveFlowCard = isHaveFlowCard;
    }
    
    @Column(name="flow_card_num", length=20)
    @Field
    public String getFlowCardNum() {
        return this.flowCardNum;
    }
    
    public void setFlowCardNum(String flowCardNum) {
        this.flowCardNum = flowCardNum;
    }
    
    @Column(name="flow_in_group", length=50)
    @Field
    public String getFlowInGroup() {
        return this.flowInGroup;
    }
    
    public void setFlowInGroup(String flowInGroup) {
        this.flowInGroup = flowInGroup;
    }
    
    @Column(name="flow_in_group_person", length=50)
    @Field
    public String getFlowInGroupPerson() {
        return this.flowInGroupPerson;
    }
    
    public void setFlowInGroupPerson(String flowInGroupPerson) {
        this.flowInGroupPerson = flowInGroupPerson;
    }
    
    @Column(name="flow_in_group_phone", length=20)
    @Field
    public String getFlowInGroupPhone() {
        return this.flowInGroupPhone;
    }
    
    public void setFlowInGroupPhone(String flowInGroupPhone) {
        this.flowInGroupPhone = flowInGroupPhone;
    }
    
    @Column(name="party_group_type", length=20)
    @Field
    public String getPartyGroupType() {
        return this.partyGroupType;
    }
    
    public void setPartyGroupType(String partyGroupType) {
        this.partyGroupType = partyGroupType;
    }
    
    @Column(name="out_country_date", length=20)
    @Field
    public String getOutCountryDate() {
        return this.outCountryDate;
    }
    
    public void setOutCountryDate(String outCountryDate) {
        this.outCountryDate = outCountryDate;
    }
    
    @Column(name="out_country_reason")
    @Field
    public String getOutCountryReason() {
        return this.outCountryReason;
    }
    
    public void setOutCountryReason(String outCountryReason) {
        this.outCountryReason = outCountryReason;
    }
    
    @Column(name="out_country_connect")
    @Field
    public String getOutCountryConnect() {
        return this.outCountryConnect;
    }
    
    public void setOutCountryConnect(String outCountryConnect) {
        this.outCountryConnect = outCountryConnect;
    }
    
    @Column(name="out_country_dangji", length=20)
    @Field
    public String getOutCountryDangji() {
        return this.outCountryDangji;
    }
    
    public void setOutCountryDangji(String outCountryDangji) {
        this.outCountryDangji = outCountryDangji;
    }
    
    @Column(name="out_country_backdate", length=20)
    @Field
    public String getOutCountryBackdate() {
        return this.outCountryBackdate;
    }
    
    public void setOutCountryBackdate(String outCountryBackdate) {
        this.outCountryBackdate = outCountryBackdate;
    }
    
    @Column(name="out_country_backlife")
    @Field
    public String getOutCountryBacklife() {
        return this.outCountryBacklife;
    }
    
    public void setOutCountryBacklife(String outCountryBacklife) {
        this.outCountryBacklife = outCountryBacklife;
    }
    
    @Column(name="r_title1", length=20)
    @Field
    public String getRTitle1() {
        return this.RTitle1;
    }
    
    public void setRTitle1(String RTitle1) {
        this.RTitle1 = RTitle1;
    }
    
    @Column(name="r_title2", length=20)
    @Field
    public String getRTitle2() {
        return this.RTitle2;
    }
    
    public void setRTitle2(String RTitle2) {
        this.RTitle2 = RTitle2;
    }
    
    @Column(name="r_title3", length=20)
    @Field
    public String getRTitle3() {
        return this.RTitle3;
    }
    
    public void setRTitle3(String RTitle3) {
        this.RTitle3 = RTitle3;
    }
    
    @Column(name="r_title4", length=20)
    @Field
    public String getRTitle4() {
        return this.RTitle4;
    }
    
    public void setRTitle4(String RTitle4) {
        this.RTitle4 = RTitle4;
    }
    
    @Column(name="r_title5", length=20)
    @Field
    public String getRTitle5() {
        return this.RTitle5;
    }
    
    public void setRTitle5(String RTitle5) {
        this.RTitle5 = RTitle5;
    }
    
    @Column(name="r_title6", length=20)
    @Field
    public String getRTitle6() {
        return this.RTitle6;
    }
    
    public void setRTitle6(String RTitle6) {
        this.RTitle6 = RTitle6;
    }
    
    @Column(name="r_name1", length=20)
    @Field
    public String getRName1() {
        return this.RName1;
    }
    
    public void setRName1(String RName1) {
        this.RName1 = RName1;
    }
    
    @Column(name="r_name2", length=20)
    @Field
    public String getRName2() {
        return this.RName2;
    }
    
    public void setRName2(String RName2) {
        this.RName2 = RName2;
    }
    
    @Column(name="r_name3", length=20)
    @Field
    public String getRName3() {
        return this.RName3;
    }
    
    public void setRName3(String RName3) {
        this.RName3 = RName3;
    }
    
    @Column(name="r_name4", length=20)
    @Field
    public String getRName4() {
        return this.RName4;
    }
    
    public void setRName4(String RName4) {
        this.RName4 = RName4;
    }
    
    @Column(name="r_name5", length=20)
    @Field
    public String getRName5() {
        return this.RName5;
    }
    
    public void setRName5(String RName5) {
        this.RName5 = RName5;
    }
    
    @Column(name="r_name6", length=20)
    @Field
    public String getRName6() {
        return this.RName6;
    }
    
    public void setRName6(String RName6) {
        this.RName6 = RName6;
    }
    
    @Column(name="r_age1", length=20)
    @Field
    public String getRAge1() {
        return this.RAge1;
    }
    
    public void setRAge1(String RAge1) {
        this.RAge1 = RAge1;
    }
    
    @Column(name="r_age2", length=20)
    @Field
    public String getRAge2() {
        return this.RAge2;
    }
    
    public void setRAge2(String RAge2) {
        this.RAge2 = RAge2;
    }
    
    @Column(name="r_age3", length=20)
    @Field
    public String getRAge3() {
        return this.RAge3;
    }
    
    public void setRAge3(String RAge3) {
        this.RAge3 = RAge3;
    }
    
    @Column(name="r_age4", length=20)
    @Field
    public String getRAge4() {
        return this.RAge4;
    }
    
    public void setRAge4(String RAge4) {
        this.RAge4 = RAge4;
    }
    
    @Column(name="r_age5", length=20)
    @Field
    public String getRAge5() {
        return this.RAge5;
    }
    
    public void setRAge5(String RAge5) {
        this.RAge5 = RAge5;
    }
    
    @Column(name="r_age6", length=20)
    @Field
    public String getRAge6() {
        return this.RAge6;
    }
    
    public void setRAge6(String RAge6) {
        this.RAge6 = RAge6;
    }
    
    @Column(name="r_social1", length=20)
    @Field
    public String getRSocial1() {
        return this.RSocial1;
    }
    
    public void setRSocial1(String RSocial1) {
        this.RSocial1 = RSocial1;
    }
    
    @Column(name="r_social2", length=20)
    @Field
    public String getRSocial2() {
        return this.RSocial2;
    }
    
    public void setRSocial2(String RSocial2) {
        this.RSocial2 = RSocial2;
    }
    
    @Column(name="r_social3", length=20)
    @Field
    public String getRSocial3() {
        return this.RSocial3;
    }
    
    public void setRSocial3(String RSocial3) {
        this.RSocial3 = RSocial3;
    }
    
    @Column(name="r_social4", length=20)
    @Field
    public String getRSocial4() {
        return this.RSocial4;
    }
    
    public void setRSocial4(String RSocial4) {
        this.RSocial4 = RSocial4;
    }
    
    @Column(name="r_social5", length=20)
    @Field
    public String getRSocial5() {
        return this.RSocial5;
    }
    
    public void setRSocial5(String RSocial5) {
        this.RSocial5 = RSocial5;
    }
    
    @Column(name="r_social6", length=20)
    @Field
    public String getRSocial6() {
        return this.RSocial6;
    }
    
    public void setRSocial6(String RSocial6) {
        this.RSocial6 = RSocial6;
    }
    
    @Column(name="r_worke_company1", length=50)
    @Field
    public String getRWorkeCompany1() {
        return this.RWorkeCompany1;
    }
    
    public void setRWorkeCompany1(String RWorkeCompany1) {
        this.RWorkeCompany1 = RWorkeCompany1;
    }
    
    @Column(name="r_worke_company2", length=50)
    @Field
    public String getRWorkeCompany2() {
        return this.RWorkeCompany2;
    }
    
    public void setRWorkeCompany2(String RWorkeCompany2) {
        this.RWorkeCompany2 = RWorkeCompany2;
    }
    
    @Column(name="r_worke_company3", length=50)
    @Field
    public String getRWorkeCompany3() {
        return this.RWorkeCompany3;
    }
    
    public void setRWorkeCompany3(String RWorkeCompany3) {
        this.RWorkeCompany3 = RWorkeCompany3;
    }
    
    @Column(name="r_worke_company4", length=50)
    @Field
    public String getRWorkeCompany4() {
        return this.RWorkeCompany4;
    }
    
    public void setRWorkeCompany4(String RWorkeCompany4) {
        this.RWorkeCompany4 = RWorkeCompany4;
    }
    
    @Column(name="r_worke_company5", length=50)
    @Field
    public String getRWorkeCompany5() {
        return this.RWorkeCompany5;
    }
    
    public void setRWorkeCompany5(String RWorkeCompany5) {
        this.RWorkeCompany5 = RWorkeCompany5;
    }
    
    @Column(name="r_worke_company6", length=50)
    @Field
    public String getRWorkeCompany6() {
        return this.RWorkeCompany6;
    }
    
    public void setRWorkeCompany6(String RWorkeCompany6) {
        this.RWorkeCompany6 = RWorkeCompany6;
    }
    
    @Column(name="r_worke_satus1", length=50)
    @Field
    public String getRWorkeSatus1() {
        return this.RWorkeSatus1;
    }
    
    public void setRWorkeSatus1(String RWorkeSatus1) {
        this.RWorkeSatus1 = RWorkeSatus1;
    }
    
    @Column(name="r_worke_satus2", length=50)
    @Field
    public String getRWorkeSatus2() {
        return this.RWorkeSatus2;
    }
    
    public void setRWorkeSatus2(String RWorkeSatus2) {
        this.RWorkeSatus2 = RWorkeSatus2;
    }
    
    @Column(name="r_worke_satus3", length=50)
    @Field
    public String getRWorkeSatus3() {
        return this.RWorkeSatus3;
    }
    
    public void setRWorkeSatus3(String RWorkeSatus3) {
        this.RWorkeSatus3 = RWorkeSatus3;
    }
    
    @Column(name="r_worke_satus4", length=50)
    @Field
    public String getRWorkeSatus4() {
        return this.RWorkeSatus4;
    }
    
    public void setRWorkeSatus4(String RWorkeSatus4) {
        this.RWorkeSatus4 = RWorkeSatus4;
    }
    
    @Column(name="r_worke_satus5", length=50)
    @Field
    public String getRWorkeSatus5() {
        return this.RWorkeSatus5;
    }
    
    public void setRWorkeSatus5(String RWorkeSatus5) {
        this.RWorkeSatus5 = RWorkeSatus5;
    }
    
    @Column(name="r_worke_satus6", length=50)
    @Field
    public String getRWorkeSatus6() {
        return this.RWorkeSatus6;
    }
    
    public void setRWorkeSatus6(String RWorkeSatus6) {
        this.RWorkeSatus6 = RWorkeSatus6;
    }
    
    @Column(name="rdzys", length=10)
    @Field
    public String getRdzys() {
        return this.rdzys;
    }
    
    public void setRdzys(String rdzys) {
        this.rdzys = rdzys;
    }
    
    @Column(name="rdsqs", length=10)
    @Field
    public String getRdsqs() {
        return this.rdsqs;
    }
    
    public void setRdsqs(String rdsqs) {
        this.rdsqs = rdsqs;
    }
    
    @Column(name="zzsccl", length=10)
    @Field
    public String getZzsccl() {
        return this.zzsccl;
    }
    
    public void setZzsccl(String zzsccl) {
        this.zzsccl = zzsccl;
    }
    
    @Column(name="zzsqs", length=10)
    @Field
    public String getZzsqs() {
        return this.zzsqs;
    }
    
    public void setZzsqs(String zzsqs) {
        this.zzsqs = zzsqs;
    }
    
    @Column(name="pykccl", length=10)
    @Field
    public String getPykccl() {
        return this.pykccl;
    }
    
    public void setPykccl(String pykccl) {
        this.pykccl = pykccl;
    }
    
    @Column(name="other_cl", length=50)
    @Field
    public String getOtherCl() {
        return this.otherCl;
    }
    
    public void setOtherCl(String otherCl) {
        this.otherCl = otherCl;
    }
    
    @Column(name="keep_unit", length=50)
    @Field
    public String getKeepUnit() {
        return this.keepUnit;
    }
    
    public void setKeepUnit(String keepUnit) {
        this.keepUnit = keepUnit;
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

        CpDtl pojo = (CpDtl) o;

        if (partyId != null ? !partyId.equals(pojo.partyId) : pojo.partyId != null) return false;
        if (statusId != null ? !statusId.equals(pojo.statusId) : pojo.statusId != null) return false;
        if (bePartyDate != null ? !bePartyDate.equals(pojo.bePartyDate) : pojo.bePartyDate != null) return false;
        if (positiveDate != null ? !positiveDate.equals(pojo.positiveDate) : pojo.positiveDate != null) return false;
        if (bePartyZhibu != null ? !bePartyZhibu.equals(pojo.bePartyZhibu) : pojo.bePartyZhibu != null) return false;
        if (beHereDate != null ? !beHereDate.equals(pojo.beHereDate) : pojo.beHereDate != null) return false;
        if (outOfZhibu != null ? !outOfZhibu.equals(pojo.outOfZhibu) : pojo.outOfZhibu != null) return false;
        if (partyStatus != null ? !partyStatus.equals(pojo.partyStatus) : pojo.partyStatus != null) return false;
        if (occupation != null ? !occupation.equals(pojo.occupation) : pojo.occupation != null) return false;
        if (workGroup != null ? !workGroup.equals(pojo.workGroup) : pojo.workGroup != null) return false;
        if (workStatus != null ? !workStatus.equals(pojo.workStatus) : pojo.workStatus != null) return false;
        if (householdAddress != null ? !householdAddress.equals(pojo.householdAddress) : pojo.householdAddress != null) return false;
        if (flowOutDate != null ? !flowOutDate.equals(pojo.flowOutDate) : pojo.flowOutDate != null) return false;
        if (flowOutInfo != null ? !flowOutInfo.equals(pojo.flowOutInfo) : pojo.flowOutInfo != null) return false;
        if (isHaveFlowCard != null ? !isHaveFlowCard.equals(pojo.isHaveFlowCard) : pojo.isHaveFlowCard != null) return false;
        if (flowCardNum != null ? !flowCardNum.equals(pojo.flowCardNum) : pojo.flowCardNum != null) return false;
        if (flowInGroup != null ? !flowInGroup.equals(pojo.flowInGroup) : pojo.flowInGroup != null) return false;
        if (flowInGroupPerson != null ? !flowInGroupPerson.equals(pojo.flowInGroupPerson) : pojo.flowInGroupPerson != null) return false;
        if (flowInGroupPhone != null ? !flowInGroupPhone.equals(pojo.flowInGroupPhone) : pojo.flowInGroupPhone != null) return false;
        if (partyGroupType != null ? !partyGroupType.equals(pojo.partyGroupType) : pojo.partyGroupType != null) return false;
        if (outCountryDate != null ? !outCountryDate.equals(pojo.outCountryDate) : pojo.outCountryDate != null) return false;
        if (outCountryReason != null ? !outCountryReason.equals(pojo.outCountryReason) : pojo.outCountryReason != null) return false;
        if (outCountryConnect != null ? !outCountryConnect.equals(pojo.outCountryConnect) : pojo.outCountryConnect != null) return false;
        if (outCountryDangji != null ? !outCountryDangji.equals(pojo.outCountryDangji) : pojo.outCountryDangji != null) return false;
        if (outCountryBackdate != null ? !outCountryBackdate.equals(pojo.outCountryBackdate) : pojo.outCountryBackdate != null) return false;
        if (outCountryBacklife != null ? !outCountryBacklife.equals(pojo.outCountryBacklife) : pojo.outCountryBacklife != null) return false;
        if (RTitle1 != null ? !RTitle1.equals(pojo.RTitle1) : pojo.RTitle1 != null) return false;
        if (RTitle2 != null ? !RTitle2.equals(pojo.RTitle2) : pojo.RTitle2 != null) return false;
        if (RTitle3 != null ? !RTitle3.equals(pojo.RTitle3) : pojo.RTitle3 != null) return false;
        if (RTitle4 != null ? !RTitle4.equals(pojo.RTitle4) : pojo.RTitle4 != null) return false;
        if (RTitle5 != null ? !RTitle5.equals(pojo.RTitle5) : pojo.RTitle5 != null) return false;
        if (RTitle6 != null ? !RTitle6.equals(pojo.RTitle6) : pojo.RTitle6 != null) return false;
        if (RName1 != null ? !RName1.equals(pojo.RName1) : pojo.RName1 != null) return false;
        if (RName2 != null ? !RName2.equals(pojo.RName2) : pojo.RName2 != null) return false;
        if (RName3 != null ? !RName3.equals(pojo.RName3) : pojo.RName3 != null) return false;
        if (RName4 != null ? !RName4.equals(pojo.RName4) : pojo.RName4 != null) return false;
        if (RName5 != null ? !RName5.equals(pojo.RName5) : pojo.RName5 != null) return false;
        if (RName6 != null ? !RName6.equals(pojo.RName6) : pojo.RName6 != null) return false;
        if (RAge1 != null ? !RAge1.equals(pojo.RAge1) : pojo.RAge1 != null) return false;
        if (RAge2 != null ? !RAge2.equals(pojo.RAge2) : pojo.RAge2 != null) return false;
        if (RAge3 != null ? !RAge3.equals(pojo.RAge3) : pojo.RAge3 != null) return false;
        if (RAge4 != null ? !RAge4.equals(pojo.RAge4) : pojo.RAge4 != null) return false;
        if (RAge5 != null ? !RAge5.equals(pojo.RAge5) : pojo.RAge5 != null) return false;
        if (RAge6 != null ? !RAge6.equals(pojo.RAge6) : pojo.RAge6 != null) return false;
        if (RSocial1 != null ? !RSocial1.equals(pojo.RSocial1) : pojo.RSocial1 != null) return false;
        if (RSocial2 != null ? !RSocial2.equals(pojo.RSocial2) : pojo.RSocial2 != null) return false;
        if (RSocial3 != null ? !RSocial3.equals(pojo.RSocial3) : pojo.RSocial3 != null) return false;
        if (RSocial4 != null ? !RSocial4.equals(pojo.RSocial4) : pojo.RSocial4 != null) return false;
        if (RSocial5 != null ? !RSocial5.equals(pojo.RSocial5) : pojo.RSocial5 != null) return false;
        if (RSocial6 != null ? !RSocial6.equals(pojo.RSocial6) : pojo.RSocial6 != null) return false;
        if (RWorkeCompany1 != null ? !RWorkeCompany1.equals(pojo.RWorkeCompany1) : pojo.RWorkeCompany1 != null) return false;
        if (RWorkeCompany2 != null ? !RWorkeCompany2.equals(pojo.RWorkeCompany2) : pojo.RWorkeCompany2 != null) return false;
        if (RWorkeCompany3 != null ? !RWorkeCompany3.equals(pojo.RWorkeCompany3) : pojo.RWorkeCompany3 != null) return false;
        if (RWorkeCompany4 != null ? !RWorkeCompany4.equals(pojo.RWorkeCompany4) : pojo.RWorkeCompany4 != null) return false;
        if (RWorkeCompany5 != null ? !RWorkeCompany5.equals(pojo.RWorkeCompany5) : pojo.RWorkeCompany5 != null) return false;
        if (RWorkeCompany6 != null ? !RWorkeCompany6.equals(pojo.RWorkeCompany6) : pojo.RWorkeCompany6 != null) return false;
        if (RWorkeSatus1 != null ? !RWorkeSatus1.equals(pojo.RWorkeSatus1) : pojo.RWorkeSatus1 != null) return false;
        if (RWorkeSatus2 != null ? !RWorkeSatus2.equals(pojo.RWorkeSatus2) : pojo.RWorkeSatus2 != null) return false;
        if (RWorkeSatus3 != null ? !RWorkeSatus3.equals(pojo.RWorkeSatus3) : pojo.RWorkeSatus3 != null) return false;
        if (RWorkeSatus4 != null ? !RWorkeSatus4.equals(pojo.RWorkeSatus4) : pojo.RWorkeSatus4 != null) return false;
        if (RWorkeSatus5 != null ? !RWorkeSatus5.equals(pojo.RWorkeSatus5) : pojo.RWorkeSatus5 != null) return false;
        if (RWorkeSatus6 != null ? !RWorkeSatus6.equals(pojo.RWorkeSatus6) : pojo.RWorkeSatus6 != null) return false;
        if (rdzys != null ? !rdzys.equals(pojo.rdzys) : pojo.rdzys != null) return false;
        if (rdsqs != null ? !rdsqs.equals(pojo.rdsqs) : pojo.rdsqs != null) return false;
        if (zzsccl != null ? !zzsccl.equals(pojo.zzsccl) : pojo.zzsccl != null) return false;
        if (zzsqs != null ? !zzsqs.equals(pojo.zzsqs) : pojo.zzsqs != null) return false;
        if (pykccl != null ? !pykccl.equals(pojo.pykccl) : pojo.pykccl != null) return false;
        if (otherCl != null ? !otherCl.equals(pojo.otherCl) : pojo.otherCl != null) return false;
        if (keepUnit != null ? !keepUnit.equals(pojo.keepUnit) : pojo.keepUnit != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (bePartyDate != null ? bePartyDate.hashCode() : 0);
        result = 31 * result + (positiveDate != null ? positiveDate.hashCode() : 0);
        result = 31 * result + (bePartyZhibu != null ? bePartyZhibu.hashCode() : 0);
        result = 31 * result + (beHereDate != null ? beHereDate.hashCode() : 0);
        result = 31 * result + (outOfZhibu != null ? outOfZhibu.hashCode() : 0);
        result = 31 * result + (partyStatus != null ? partyStatus.hashCode() : 0);
        result = 31 * result + (occupation != null ? occupation.hashCode() : 0);
        result = 31 * result + (workGroup != null ? workGroup.hashCode() : 0);
        result = 31 * result + (workStatus != null ? workStatus.hashCode() : 0);
        result = 31 * result + (householdAddress != null ? householdAddress.hashCode() : 0);
        result = 31 * result + (flowOutDate != null ? flowOutDate.hashCode() : 0);
        result = 31 * result + (flowOutInfo != null ? flowOutInfo.hashCode() : 0);
        result = 31 * result + (isHaveFlowCard != null ? isHaveFlowCard.hashCode() : 0);
        result = 31 * result + (flowCardNum != null ? flowCardNum.hashCode() : 0);
        result = 31 * result + (flowInGroup != null ? flowInGroup.hashCode() : 0);
        result = 31 * result + (flowInGroupPerson != null ? flowInGroupPerson.hashCode() : 0);
        result = 31 * result + (flowInGroupPhone != null ? flowInGroupPhone.hashCode() : 0);
        result = 31 * result + (partyGroupType != null ? partyGroupType.hashCode() : 0);
        result = 31 * result + (outCountryDate != null ? outCountryDate.hashCode() : 0);
        result = 31 * result + (outCountryReason != null ? outCountryReason.hashCode() : 0);
        result = 31 * result + (outCountryConnect != null ? outCountryConnect.hashCode() : 0);
        result = 31 * result + (outCountryDangji != null ? outCountryDangji.hashCode() : 0);
        result = 31 * result + (outCountryBackdate != null ? outCountryBackdate.hashCode() : 0);
        result = 31 * result + (outCountryBacklife != null ? outCountryBacklife.hashCode() : 0);
        result = 31 * result + (RTitle1 != null ? RTitle1.hashCode() : 0);
        result = 31 * result + (RTitle2 != null ? RTitle2.hashCode() : 0);
        result = 31 * result + (RTitle3 != null ? RTitle3.hashCode() : 0);
        result = 31 * result + (RTitle4 != null ? RTitle4.hashCode() : 0);
        result = 31 * result + (RTitle5 != null ? RTitle5.hashCode() : 0);
        result = 31 * result + (RTitle6 != null ? RTitle6.hashCode() : 0);
        result = 31 * result + (RName1 != null ? RName1.hashCode() : 0);
        result = 31 * result + (RName2 != null ? RName2.hashCode() : 0);
        result = 31 * result + (RName3 != null ? RName3.hashCode() : 0);
        result = 31 * result + (RName4 != null ? RName4.hashCode() : 0);
        result = 31 * result + (RName5 != null ? RName5.hashCode() : 0);
        result = 31 * result + (RName6 != null ? RName6.hashCode() : 0);
        result = 31 * result + (RAge1 != null ? RAge1.hashCode() : 0);
        result = 31 * result + (RAge2 != null ? RAge2.hashCode() : 0);
        result = 31 * result + (RAge3 != null ? RAge3.hashCode() : 0);
        result = 31 * result + (RAge4 != null ? RAge4.hashCode() : 0);
        result = 31 * result + (RAge5 != null ? RAge5.hashCode() : 0);
        result = 31 * result + (RAge6 != null ? RAge6.hashCode() : 0);
        result = 31 * result + (RSocial1 != null ? RSocial1.hashCode() : 0);
        result = 31 * result + (RSocial2 != null ? RSocial2.hashCode() : 0);
        result = 31 * result + (RSocial3 != null ? RSocial3.hashCode() : 0);
        result = 31 * result + (RSocial4 != null ? RSocial4.hashCode() : 0);
        result = 31 * result + (RSocial5 != null ? RSocial5.hashCode() : 0);
        result = 31 * result + (RSocial6 != null ? RSocial6.hashCode() : 0);
        result = 31 * result + (RWorkeCompany1 != null ? RWorkeCompany1.hashCode() : 0);
        result = 31 * result + (RWorkeCompany2 != null ? RWorkeCompany2.hashCode() : 0);
        result = 31 * result + (RWorkeCompany3 != null ? RWorkeCompany3.hashCode() : 0);
        result = 31 * result + (RWorkeCompany4 != null ? RWorkeCompany4.hashCode() : 0);
        result = 31 * result + (RWorkeCompany5 != null ? RWorkeCompany5.hashCode() : 0);
        result = 31 * result + (RWorkeCompany6 != null ? RWorkeCompany6.hashCode() : 0);
        result = 31 * result + (RWorkeSatus1 != null ? RWorkeSatus1.hashCode() : 0);
        result = 31 * result + (RWorkeSatus2 != null ? RWorkeSatus2.hashCode() : 0);
        result = 31 * result + (RWorkeSatus3 != null ? RWorkeSatus3.hashCode() : 0);
        result = 31 * result + (RWorkeSatus4 != null ? RWorkeSatus4.hashCode() : 0);
        result = 31 * result + (RWorkeSatus5 != null ? RWorkeSatus5.hashCode() : 0);
        result = 31 * result + (RWorkeSatus6 != null ? RWorkeSatus6.hashCode() : 0);
        result = 31 * result + (rdzys != null ? rdzys.hashCode() : 0);
        result = 31 * result + (rdsqs != null ? rdsqs.hashCode() : 0);
        result = 31 * result + (zzsccl != null ? zzsccl.hashCode() : 0);
        result = 31 * result + (zzsqs != null ? zzsqs.hashCode() : 0);
        result = 31 * result + (pykccl != null ? pykccl.hashCode() : 0);
        result = 31 * result + (otherCl != null ? otherCl.hashCode() : 0);
        result = 31 * result + (keepUnit != null ? keepUnit.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("cpDtlId").append("='").append(getCpDtlId()).append("', ");
        sb.append("partyId").append("='").append(getPartyId()).append("', ");
        sb.append("statusId").append("='").append(getStatusId()).append("', ");
        sb.append("bePartyDate").append("='").append(getBePartyDate()).append("', ");
        sb.append("positiveDate").append("='").append(getPositiveDate()).append("', ");
        sb.append("bePartyZhibu").append("='").append(getBePartyZhibu()).append("', ");
        sb.append("beHereDate").append("='").append(getBeHereDate()).append("', ");
        sb.append("outOfZhibu").append("='").append(getOutOfZhibu()).append("', ");
        sb.append("partyStatus").append("='").append(getPartyStatus()).append("', ");
        sb.append("occupation").append("='").append(getOccupation()).append("', ");
        sb.append("workGroup").append("='").append(getWorkGroup()).append("', ");
        sb.append("workStatus").append("='").append(getWorkStatus()).append("', ");
        sb.append("householdAddress").append("='").append(getHouseholdAddress()).append("', ");
        sb.append("flowOutDate").append("='").append(getFlowOutDate()).append("', ");
        sb.append("flowOutInfo").append("='").append(getFlowOutInfo()).append("', ");
        sb.append("isHaveFlowCard").append("='").append(getIsHaveFlowCard()).append("', ");
        sb.append("flowCardNum").append("='").append(getFlowCardNum()).append("', ");
        sb.append("flowInGroup").append("='").append(getFlowInGroup()).append("', ");
        sb.append("flowInGroupPerson").append("='").append(getFlowInGroupPerson()).append("', ");
        sb.append("flowInGroupPhone").append("='").append(getFlowInGroupPhone()).append("', ");
        sb.append("partyGroupType").append("='").append(getPartyGroupType()).append("', ");
        sb.append("outCountryDate").append("='").append(getOutCountryDate()).append("', ");
        sb.append("outCountryReason").append("='").append(getOutCountryReason()).append("', ");
        sb.append("outCountryConnect").append("='").append(getOutCountryConnect()).append("', ");
        sb.append("outCountryDangji").append("='").append(getOutCountryDangji()).append("', ");
        sb.append("outCountryBackdate").append("='").append(getOutCountryBackdate()).append("', ");
        sb.append("outCountryBacklife").append("='").append(getOutCountryBacklife()).append("', ");
        sb.append("RTitle1").append("='").append(getRTitle1()).append("', ");
        sb.append("RTitle2").append("='").append(getRTitle2()).append("', ");
        sb.append("RTitle3").append("='").append(getRTitle3()).append("', ");
        sb.append("RTitle4").append("='").append(getRTitle4()).append("', ");
        sb.append("RTitle5").append("='").append(getRTitle5()).append("', ");
        sb.append("RTitle6").append("='").append(getRTitle6()).append("', ");
        sb.append("RName1").append("='").append(getRName1()).append("', ");
        sb.append("RName2").append("='").append(getRName2()).append("', ");
        sb.append("RName3").append("='").append(getRName3()).append("', ");
        sb.append("RName4").append("='").append(getRName4()).append("', ");
        sb.append("RName5").append("='").append(getRName5()).append("', ");
        sb.append("RName6").append("='").append(getRName6()).append("', ");
        sb.append("RAge1").append("='").append(getRAge1()).append("', ");
        sb.append("RAge2").append("='").append(getRAge2()).append("', ");
        sb.append("RAge3").append("='").append(getRAge3()).append("', ");
        sb.append("RAge4").append("='").append(getRAge4()).append("', ");
        sb.append("RAge5").append("='").append(getRAge5()).append("', ");
        sb.append("RAge6").append("='").append(getRAge6()).append("', ");
        sb.append("RSocial1").append("='").append(getRSocial1()).append("', ");
        sb.append("RSocial2").append("='").append(getRSocial2()).append("', ");
        sb.append("RSocial3").append("='").append(getRSocial3()).append("', ");
        sb.append("RSocial4").append("='").append(getRSocial4()).append("', ");
        sb.append("RSocial5").append("='").append(getRSocial5()).append("', ");
        sb.append("RSocial6").append("='").append(getRSocial6()).append("', ");
        sb.append("RWorkeCompany1").append("='").append(getRWorkeCompany1()).append("', ");
        sb.append("RWorkeCompany2").append("='").append(getRWorkeCompany2()).append("', ");
        sb.append("RWorkeCompany3").append("='").append(getRWorkeCompany3()).append("', ");
        sb.append("RWorkeCompany4").append("='").append(getRWorkeCompany4()).append("', ");
        sb.append("RWorkeCompany5").append("='").append(getRWorkeCompany5()).append("', ");
        sb.append("RWorkeCompany6").append("='").append(getRWorkeCompany6()).append("', ");
        sb.append("RWorkeSatus1").append("='").append(getRWorkeSatus1()).append("', ");
        sb.append("RWorkeSatus2").append("='").append(getRWorkeSatus2()).append("', ");
        sb.append("RWorkeSatus3").append("='").append(getRWorkeSatus3()).append("', ");
        sb.append("RWorkeSatus4").append("='").append(getRWorkeSatus4()).append("', ");
        sb.append("RWorkeSatus5").append("='").append(getRWorkeSatus5()).append("', ");
        sb.append("RWorkeSatus6").append("='").append(getRWorkeSatus6()).append("', ");
        sb.append("rdzys").append("='").append(getRdzys()).append("', ");
        sb.append("rdsqs").append("='").append(getRdsqs()).append("', ");
        sb.append("zzsccl").append("='").append(getZzsccl()).append("', ");
        sb.append("zzsqs").append("='").append(getZzsqs()).append("', ");
        sb.append("pykccl").append("='").append(getPykccl()).append("', ");
        sb.append("otherCl").append("='").append(getOtherCl()).append("', ");
        sb.append("keepUnit").append("='").append(getKeepUnit()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
