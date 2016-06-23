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
@Table(name="geo",catalog="wms")
@Indexed
@XmlRootElement
public class Geo extends BaseObject implements Serializable {
    private Long geoId;
    private String geoType;
    private String geoName;
    private String geoNamePinyin;
    private String geoPoint;
    private Long parentGeoId;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="geo_id", unique=true, nullable=false)    
    public Long getGeoId() {
        return this.geoId;
    }
    
    public void setGeoId(Long geoId) {
        this.geoId = geoId;
    }
    
    @Column(name="geo_type", length=20)
    @Field
    public String getGeoType() {
        return this.geoType;
    }
    
    public void setGeoType(String geoType) {
        this.geoType = geoType;
    }
    
    @Column(name="geo_name", length=50)
    @Field
    public String getGeoName() {
        return this.geoName;
    }
    
    public void setGeoName(String geoName) {
        this.geoName = geoName;
    }
    
    @Column(name="geo_name_pinyin", length=50)
    @Field
    public String getGeoNamePinyin() {
        return this.geoNamePinyin;
    }
    
    public void setGeoNamePinyin(String geoNamePinyin) {
        this.geoNamePinyin = geoNamePinyin;
    }
    
    @Column(name="geo_point", length=50)
    @Field
    public String getGeoPoint() {
        return this.geoPoint;
    }
    
    public void setGeoPoint(String geoPoint) {
        this.geoPoint = geoPoint;
    }
    
    @Column(name="parent_geo_id")
    @Field
    public Long getParentGeoId() {
        return this.parentGeoId;
    }
    
    public void setParentGeoId(Long parentGeoId) {
        this.parentGeoId = parentGeoId;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Geo pojo = (Geo) o;

        if (geoType != null ? !geoType.equals(pojo.geoType) : pojo.geoType != null) return false;
        if (geoName != null ? !geoName.equals(pojo.geoName) : pojo.geoName != null) return false;
        if (geoNamePinyin != null ? !geoNamePinyin.equals(pojo.geoNamePinyin) : pojo.geoNamePinyin != null) return false;
        if (geoPoint != null ? !geoPoint.equals(pojo.geoPoint) : pojo.geoPoint != null) return false;
        if (parentGeoId != null ? !parentGeoId.equals(pojo.parentGeoId) : pojo.parentGeoId != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (geoType != null ? geoType.hashCode() : 0);
        result = 31 * result + (geoName != null ? geoName.hashCode() : 0);
        result = 31 * result + (geoNamePinyin != null ? geoNamePinyin.hashCode() : 0);
        result = 31 * result + (geoPoint != null ? geoPoint.hashCode() : 0);
        result = 31 * result + (parentGeoId != null ? parentGeoId.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("geoId").append("='").append(getGeoId()).append("', ");
        sb.append("geoType").append("='").append(getGeoType()).append("', ");
        sb.append("geoName").append("='").append(getGeoName()).append("', ");
        sb.append("geoNamePinyin").append("='").append(getGeoNamePinyin()).append("', ");
        sb.append("geoPoint").append("='").append(getGeoPoint()).append("', ");
        sb.append("parentGeoId").append("='").append(getParentGeoId()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
