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
@Table(name="alarm_set",catalog="wms")
@Indexed
@XmlRootElement
public class AlarmSet extends BaseObject implements Serializable {
    private Long alarmSetId;
    private String kpiId;
    private String kpiName;
    private String alarmLevel;
    private String maxValue;
    private String minValue;
    private String memo;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="alarm_set_id", unique=true, nullable=false)    
    public Long getAlarmSetId() {
        return this.alarmSetId;
    }
    
    public void setAlarmSetId(Long alarmSetId) {
        this.alarmSetId = alarmSetId;
    }
    
    @Column(name="kpi_id", length=20)
    @Field
    public String getKpiId() {
        return this.kpiId;
    }
    
    public void setKpiId(String kpiId) {
        this.kpiId = kpiId;
    }
    
    @Column(name="kpi_name", length=50)
    @Field
    public String getKpiName() {
        return this.kpiName;
    }
    
    public void setKpiName(String kpiName) {
        this.kpiName = kpiName;
    }
    
    @Column(name="alarm_level", length=30)
    @Field
    public String getAlarmLevel() {
        return this.alarmLevel;
    }
    
    public void setAlarmLevel(String alarmLevel) {
        this.alarmLevel = alarmLevel;
    }
    
    @Column(name="max_value", length=100)
    @Field
    public String getMaxValue() {
        return this.maxValue;
    }
    
    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }
    
    @Column(name="min_value", length=100)
    @Field
    public String getMinValue() {
        return this.minValue;
    }
    
    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }
    
    @Column(name="memo", length=100)
    @Field
    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlarmSet pojo = (AlarmSet) o;

        if (kpiId != null ? !kpiId.equals(pojo.kpiId) : pojo.kpiId != null) return false;
        if (kpiName != null ? !kpiName.equals(pojo.kpiName) : pojo.kpiName != null) return false;
        if (alarmLevel != null ? !alarmLevel.equals(pojo.alarmLevel) : pojo.alarmLevel != null) return false;
        if (maxValue != null ? !maxValue.equals(pojo.maxValue) : pojo.maxValue != null) return false;
        if (minValue != null ? !minValue.equals(pojo.minValue) : pojo.minValue != null) return false;
        if (memo != null ? !memo.equals(pojo.memo) : pojo.memo != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (kpiId != null ? kpiId.hashCode() : 0);
        result = 31 * result + (kpiName != null ? kpiName.hashCode() : 0);
        result = 31 * result + (alarmLevel != null ? alarmLevel.hashCode() : 0);
        result = 31 * result + (maxValue != null ? maxValue.hashCode() : 0);
        result = 31 * result + (minValue != null ? minValue.hashCode() : 0);
        result = 31 * result + (memo != null ? memo.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("alarmSetId").append("='").append(getAlarmSetId()).append("', ");
        sb.append("kpiId").append("='").append(getKpiId()).append("', ");
        sb.append("kpiName").append("='").append(getKpiName()).append("', ");
        sb.append("alarmLevel").append("='").append(getAlarmLevel()).append("', ");
        sb.append("maxValue").append("='").append(getMaxValue()).append("', ");
        sb.append("minValue").append("='").append(getMinValue()).append("', ");
        sb.append("memo").append("='").append(getMemo()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
