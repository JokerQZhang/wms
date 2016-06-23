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
@Table(name="tz_fwqz",catalog="wms")
@Indexed
@XmlRootElement
public class TzFwqz extends BaseObject implements Serializable {
    private Long fwqzId;
    private String tzDate;
    private Long groupPartyId;
    private Date createdTime;
    private Long createdByUser;
    private Date lastUpdatedTime;
    private Long lastUpdatedByUser;
    private String jjsjknNum;
    private String jjsjknProblem;
    private String jsjcssNum;
    private String jsjcssDtl;
    private String bmfuxxIsShow;
    private String bmfuxxShowType;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="fwqz_id", unique=true, nullable=false)    
    public Long getFwqzId() {
        return this.fwqzId;
    }
    
    public void setFwqzId(Long fwqzId) {
        this.fwqzId = fwqzId;
    }
    
    @Column(name="tz_date", length=20)
    @Field
    public String getTzDate() {
        return this.tzDate;
    }
    
    public void setTzDate(String tzDate) {
        this.tzDate = tzDate;
    }
    
    @Column(name="group_party_id")
    @Field
    public Long getGroupPartyId() {
        return this.groupPartyId;
    }
    
    public void setGroupPartyId(Long groupPartyId) {
        this.groupPartyId = groupPartyId;
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
    
    @Column(name="jjsjkn_num", length=20)
    @Field
    public String getJjsjknNum() {
        return this.jjsjknNum;
    }
    
    public void setJjsjknNum(String jjsjknNum) {
        this.jjsjknNum = jjsjknNum;
    }
    
    @Column(name="jjsjkn_problem")
    @Field
    public String getJjsjknProblem() {
        return this.jjsjknProblem;
    }
    
    public void setJjsjknProblem(String jjsjknProblem) {
        this.jjsjknProblem = jjsjknProblem;
    }
    
    @Column(name="jsjcss_num", length=20)
    @Field
    public String getJsjcssNum() {
        return this.jsjcssNum;
    }
    
    public void setJsjcssNum(String jsjcssNum) {
        this.jsjcssNum = jsjcssNum;
    }
    
    @Column(name="jsjcss_dtl")
    @Field
    public String getJsjcssDtl() {
        return this.jsjcssDtl;
    }
    
    public void setJsjcssDtl(String jsjcssDtl) {
        this.jsjcssDtl = jsjcssDtl;
    }
    
    @Column(name="bmfuxx_is_show", length=20)
    @Field
    public String getBmfuxxIsShow() {
        return this.bmfuxxIsShow;
    }
    
    public void setBmfuxxIsShow(String bmfuxxIsShow) {
        this.bmfuxxIsShow = bmfuxxIsShow;
    }
    
    @Column(name="bmfuxx_show_type")
    @Field
    public String getBmfuxxShowType() {
        return this.bmfuxxShowType;
    }
    
    public void setBmfuxxShowType(String bmfuxxShowType) {
        this.bmfuxxShowType = bmfuxxShowType;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TzFwqz pojo = (TzFwqz) o;

        if (tzDate != null ? !tzDate.equals(pojo.tzDate) : pojo.tzDate != null) return false;
        if (groupPartyId != null ? !groupPartyId.equals(pojo.groupPartyId) : pojo.groupPartyId != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;
        if (lastUpdatedTime != null ? !lastUpdatedTime.equals(pojo.lastUpdatedTime) : pojo.lastUpdatedTime != null) return false;
        if (lastUpdatedByUser != null ? !lastUpdatedByUser.equals(pojo.lastUpdatedByUser) : pojo.lastUpdatedByUser != null) return false;
        if (jjsjknNum != null ? !jjsjknNum.equals(pojo.jjsjknNum) : pojo.jjsjknNum != null) return false;
        if (jjsjknProblem != null ? !jjsjknProblem.equals(pojo.jjsjknProblem) : pojo.jjsjknProblem != null) return false;
        if (jsjcssNum != null ? !jsjcssNum.equals(pojo.jsjcssNum) : pojo.jsjcssNum != null) return false;
        if (jsjcssDtl != null ? !jsjcssDtl.equals(pojo.jsjcssDtl) : pojo.jsjcssDtl != null) return false;
        if (bmfuxxIsShow != null ? !bmfuxxIsShow.equals(pojo.bmfuxxIsShow) : pojo.bmfuxxIsShow != null) return false;
        if (bmfuxxShowType != null ? !bmfuxxShowType.equals(pojo.bmfuxxShowType) : pojo.bmfuxxShowType != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (tzDate != null ? tzDate.hashCode() : 0);
        result = 31 * result + (groupPartyId != null ? groupPartyId.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (lastUpdatedTime != null ? lastUpdatedTime.hashCode() : 0);
        result = 31 * result + (lastUpdatedByUser != null ? lastUpdatedByUser.hashCode() : 0);
        result = 31 * result + (jjsjknNum != null ? jjsjknNum.hashCode() : 0);
        result = 31 * result + (jjsjknProblem != null ? jjsjknProblem.hashCode() : 0);
        result = 31 * result + (jsjcssNum != null ? jsjcssNum.hashCode() : 0);
        result = 31 * result + (jsjcssDtl != null ? jsjcssDtl.hashCode() : 0);
        result = 31 * result + (bmfuxxIsShow != null ? bmfuxxIsShow.hashCode() : 0);
        result = 31 * result + (bmfuxxShowType != null ? bmfuxxShowType.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("fwqzId").append("='").append(getFwqzId()).append("', ");
        sb.append("tzDate").append("='").append(getTzDate()).append("', ");
        sb.append("groupPartyId").append("='").append(getGroupPartyId()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("', ");
        sb.append("lastUpdatedTime").append("='").append(getLastUpdatedTime()).append("', ");
        sb.append("lastUpdatedByUser").append("='").append(getLastUpdatedByUser()).append("', ");
        sb.append("jjsjknNum").append("='").append(getJjsjknNum()).append("', ");
        sb.append("jjsjknProblem").append("='").append(getJjsjknProblem()).append("', ");
        sb.append("jsjcssNum").append("='").append(getJsjcssNum()).append("', ");
        sb.append("jsjcssDtl").append("='").append(getJsjcssDtl()).append("', ");
        sb.append("bmfuxxIsShow").append("='").append(getBmfuxxIsShow()).append("', ");
        sb.append("bmfuxxShowType").append("='").append(getBmfuxxShowType()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
