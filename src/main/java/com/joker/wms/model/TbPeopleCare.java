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
@Table(name="tb_people_care",catalog="wms")
@Indexed
@XmlRootElement
public class TbPeopleCare extends BaseObject implements Serializable {
    private Long careId;
    private Long peopleId;
    private Long enumId;
    private Date createdTime;
    private Long createdByUser;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="care_id", unique=true, nullable=false)    
    public Long getCareId() {
        return this.careId;
    }
    
    public void setCareId(Long careId) {
        this.careId = careId;
    }
    
    @Column(name="people_id")
    @Field
    public Long getPeopleId() {
        return this.peopleId;
    }
    
    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }
    
    @Column(name="enum_id")
    @Field
    public Long getEnumId() {
        return this.enumId;
    }
    
    public void setEnumId(Long enumId) {
        this.enumId = enumId;
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

        TbPeopleCare pojo = (TbPeopleCare) o;

        if (peopleId != null ? !peopleId.equals(pojo.peopleId) : pojo.peopleId != null) return false;
        if (enumId != null ? !enumId.equals(pojo.enumId) : pojo.enumId != null) return false;
        if (createdTime != null ? !createdTime.equals(pojo.createdTime) : pojo.createdTime != null) return false;
        if (createdByUser != null ? !createdByUser.equals(pojo.createdByUser) : pojo.createdByUser != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (peopleId != null ? peopleId.hashCode() : 0);
        result = 31 * result + (enumId != null ? enumId.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("careId").append("='").append(getCareId()).append("', ");
        sb.append("peopleId").append("='").append(getPeopleId()).append("', ");
        sb.append("enumId").append("='").append(getEnumId()).append("', ");
        sb.append("createdTime").append("='").append(getCreatedTime()).append("', ");
        sb.append("createdByUser").append("='").append(getCreatedByUser()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
