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
@Table(name="petition",catalog="wms")
@Indexed
@XmlRootElement
public class Petition extends BaseObject implements Serializable {
    private Long petitionId;
    private String reportPeople;
    private String reportDep;
    private String reportStatus;
    private String reportPConnect;
    private String reportPNum;
    private String reportMemo;
    private String reportType;
    private String reportedPeople;
    private String reportedDep;
    private String reportedStatus;
    private String reportedMemo;
    private String reportMethod;
    private String acceptName;
    private Date acceptTime;
    private Date expectEndTime;
    private Date realEndTime;
    private String reportContent;
    private String acceptContent;
    private String leaderContent;
    private Long statusId;
    private Long processPartyId;
    private Date createdTime;
    private Long createdByUser;
    private Date lastUpdatedTime;
    private Long lastUpdatedByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="petition_id", unique=true, nullable=false)    
    public Long getPetitionId() {
        return this.petitionId;
    }
    
    public void setPetitionId(Long petitionId) {
        this.petitionId = petitionId;
    }
    
    @Column(name="report_people", length=50)
    @Field
    public String getReportPeople() {
        return this.reportPeople;
    }
    
    public void setReportPeople(String reportPeople) {
        this.reportPeople = reportPeople;
    }
    
    @Column(name="report_dep", length=50)
    @Field
    public String getReportDep() {
        return this.reportDep;
    }
    
    public void setReportDep(String reportDep) {
        this.reportDep = reportDep;
    }
    
    @Column(name="report_status", length=50)
    @Field
    public String getReportStatus() {
        return this.reportStatus;
    }
    
    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }
    
    @Column(name="report_p_connect", length=50)
    @Field
    public String getReportPConnect() {
        return this.reportPConnect;
    }
    
    public void setReportPConnect(String reportPConnect) {
        this.reportPConnect = reportPConnect;
    }
    
    @Column(name="report_p_num", length=20)
    @Field
    public String getReportPNum() {
        return this.reportPNum;
    }
    
    public void setReportPNum(String reportPNum) {
        this.reportPNum = reportPNum;
    }
    
    @Column(name="report_memo")
    @Field
    public String getReportMemo() {
        return this.reportMemo;
    }
    
    public void setReportMemo(String reportMemo) {
        this.reportMemo = reportMemo;
    }
    
    @Column(name="report_type", length=10)
    @Field
    public String getReportType() {
        return this.reportType;
    }
    
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
    
    @Column(name="reported_people", length=50)
    @Field
    public String getReportedPeople() {
        return this.reportedPeople;
    }
    
    public void setReportedPeople(String reportedPeople) {
        this.reportedPeople = reportedPeople;
    }
    
    @Column(name="reported_dep", length=50)
    @Field
    public String getReportedDep() {
        return this.reportedDep;
    }
    
    public void setReportedDep(String reportedDep) {
        this.reportedDep = reportedDep;
    }
    
    @Column(name="reported_status", length=50)
    @Field
    public String getReportedStatus() {
        return this.reportedStatus;
    }
    
    public void setReportedStatus(String reportedStatus) {
        this.reportedStatus = reportedStatus;
    }
    
    @Column(name="reported_memo")
    @Field
    public String getReportedMemo() {
        return this.reportedMemo;
    }
    
    public void setReportedMemo(String reportedMemo) {
        this.reportedMemo = reportedMemo;
    }
    
    @Column(name="report_method", length=10)
    @Field
    public String getReportMethod() {
        return this.reportMethod;
    }
    
    public void setReportMethod(String reportMethod) {
        this.reportMethod = reportMethod;
    }
    
    @Column(name="accept_name", length=30)
    @Field
    public String getAcceptName() {
        return this.acceptName;
    }
    
    public void setAcceptName(String acceptName) {
        this.acceptName = acceptName;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="accept_time", length=19)
    @Field
    public Date getAcceptTime() {
        return this.acceptTime;
    }
    
    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="expect_end_time", length=19)
    @Field
    public Date getExpectEndTime() {
        return this.expectEndTime;
    }
    
    public void setExpectEndTime(Date expectEndTime) {
        this.expectEndTime = expectEndTime;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="real_end_time", length=19)
    @Field
    public Date getRealEndTime() {
        return this.realEndTime;
    }
    
    public void setRealEndTime(Date realEndTime) {
        this.realEndTime = realEndTime;
    }
    
    @Column(name="report_content", length=65535)
    @Field
    public String getReportContent() {
        return this.reportContent;
    }
    
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
    
    @Column(name="accept_content")
    @Field
    public String getAcceptContent() {
        return this.acceptContent;
    }
    
    public void setAcceptContent(String acceptContent) {
        this.acceptContent = acceptContent;
    }
    
    @Column(name="leader_content")
    @Field
    public String getLeaderContent() {
        return this.leaderContent;
    }
    
    public void setLeaderContent(String leaderContent) {
        this.leaderContent = leaderContent;
    }
    
    @Column(name="status_id")
    @Field
    public Long getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
    
    @Column(name="process_party_id")
    @Field
    public Long getProcessPartyId() {
        return this.processPartyId;
    }
    
    public void setProcessPartyId(Long processPartyId) {
        this.processPartyId = processPartyId;
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

        Petition pojo = (Petition) o;

        if (reportPeople != null ? !reportPeople.equals(pojo.reportPeople) : pojo.reportPeople != null) return false;
        if (reportDep != null ? !reportDep.equals(pojo.reportDep) : pojo.reportDep != null) return false;
        if (reportStatus != null ? !reportStatus.equals(pojo.reportStatus) : pojo.reportStatus != null) return false;
        if (reportPConnect != null ? !reportPConnect.equals(pojo.reportPConnect) : pojo.reportPConnect != null) return false;
        if (reportPNum != null ? !reportPNum.equals(pojo.reportPNum) : pojo.reportPNum != null) return false;
        if (reportMemo != null ? !reportMemo.equals(pojo.reportMemo) : pojo.reportMemo != null) return false;
        if (reportType != null ? !reportType.equals(pojo.reportType) : pojo.reportType != null) return false;
        if (reportedPeople != null ? !reportedPeople.equals(pojo.reportedPeople) : pojo.reportedPeople != null) return false;
        if (reportedDep != null ? !reportedDep.equals(pojo.reportedDep) : pojo.reportedDep != null) return false;
        if (reportedStatus != null ? !reportedStatus.equals(pojo.reportedStatus) : pojo.reportedStatus != null) return false;
        if (reportedMemo != null ? !reportedMemo.equals(pojo.reportedMemo) : pojo.reportedMemo != null) return false;
        if (reportMethod != null ? !reportMethod.equals(pojo.reportMethod) : pojo.reportMethod != null) return false;
        if (acceptName != null ? !acceptName.equals(pojo.acceptName) : pojo.acceptName != null) return false;
        if (acceptTime != null ? !acceptTime.equals(pojo.acceptTime) : pojo.acceptTime != null) return false;
        if (expectEndTime != null ? !expectEndTime.equals(pojo.expectEndTime) : pojo.expectEndTime != null) return false;
        if (realEndTime != null ? !realEndTime.equals(pojo.realEndTime) : pojo.realEndTime != null) return false;
        if (reportContent != null ? !reportContent.equals(pojo.reportContent) : pojo.reportContent != null) return false;
        if (acceptContent != null ? !acceptContent.equals(pojo.acceptContent) : pojo.acceptContent != null) return false;
        if (leaderContent != null ? !leaderContent.equals(pojo.leaderContent) : pojo.leaderContent != null) return false;
        if (statusId != null ? !statusId.equals(pojo.statusId) : pojo.statusId != null) return false;
        if (processPartyId != null ? !processPartyId.equals(pojo.processPartyId) : pojo.processPartyId != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (reportPeople != null ? reportPeople.hashCode() : 0);
        result = 31 * result + (reportDep != null ? reportDep.hashCode() : 0);
        result = 31 * result + (reportStatus != null ? reportStatus.hashCode() : 0);
        result = 31 * result + (reportPConnect != null ? reportPConnect.hashCode() : 0);
        result = 31 * result + (reportPNum != null ? reportPNum.hashCode() : 0);
        result = 31 * result + (reportMemo != null ? reportMemo.hashCode() : 0);
        result = 31 * result + (reportType != null ? reportType.hashCode() : 0);
        result = 31 * result + (reportedPeople != null ? reportedPeople.hashCode() : 0);
        result = 31 * result + (reportedDep != null ? reportedDep.hashCode() : 0);
        result = 31 * result + (reportedStatus != null ? reportedStatus.hashCode() : 0);
        result = 31 * result + (reportedMemo != null ? reportedMemo.hashCode() : 0);
        result = 31 * result + (reportMethod != null ? reportMethod.hashCode() : 0);
        result = 31 * result + (acceptName != null ? acceptName.hashCode() : 0);
        result = 31 * result + (acceptTime != null ? acceptTime.hashCode() : 0);
        result = 31 * result + (expectEndTime != null ? expectEndTime.hashCode() : 0);
        result = 31 * result + (realEndTime != null ? realEndTime.hashCode() : 0);
        result = 31 * result + (reportContent != null ? reportContent.hashCode() : 0);
        result = 31 * result + (acceptContent != null ? acceptContent.hashCode() : 0);
        result = 31 * result + (leaderContent != null ? leaderContent.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (processPartyId != null ? processPartyId.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("petitionId").append("='").append(getPetitionId()).append("', ");
        sb.append("reportPeople").append("='").append(getReportPeople()).append("', ");
        sb.append("reportDep").append("='").append(getReportDep()).append("', ");
        sb.append("reportStatus").append("='").append(getReportStatus()).append("', ");
        sb.append("reportPConnect").append("='").append(getReportPConnect()).append("', ");
        sb.append("reportPNum").append("='").append(getReportPNum()).append("', ");
        sb.append("reportMemo").append("='").append(getReportMemo()).append("', ");
        sb.append("reportType").append("='").append(getReportType()).append("', ");
        sb.append("reportedPeople").append("='").append(getReportedPeople()).append("', ");
        sb.append("reportedDep").append("='").append(getReportedDep()).append("', ");
        sb.append("reportedStatus").append("='").append(getReportedStatus()).append("', ");
        sb.append("reportedMemo").append("='").append(getReportedMemo()).append("', ");
        sb.append("reportMethod").append("='").append(getReportMethod()).append("', ");
        sb.append("acceptName").append("='").append(getAcceptName()).append("', ");
        sb.append("acceptTime").append("='").append(getAcceptTime()).append("', ");
        sb.append("expectEndTime").append("='").append(getExpectEndTime()).append("', ");
        sb.append("realEndTime").append("='").append(getRealEndTime()).append("', ");
        sb.append("reportContent").append("='").append(getReportContent()).append("', ");
        sb.append("acceptContent").append("='").append(getAcceptContent()).append("', ");
        sb.append("leaderContent").append("='").append(getLeaderContent()).append("', ");
        sb.append("statusId").append("='").append(getStatusId()).append("', ");
        sb.append("processPartyId").append("='").append(getProcessPartyId()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
