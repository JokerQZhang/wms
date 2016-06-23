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
@Table(name="ship_car",catalog="wms")
@Indexed
@XmlRootElement
public class ShipCar extends BaseObject implements Serializable {
    private Long shipCarId;
    private String carCardId;
    private String conName;
    private String conPhone;
    private String typeName;
    private String loadWeight;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="ship_car_id", unique=true, nullable=false)    
    public Long getShipCarId() {
        return this.shipCarId;
    }
    
    public void setShipCarId(Long shipCarId) {
        this.shipCarId = shipCarId;
    }
    
    @Column(name="car_card_id", length=30)
    @Field
    public String getCarCardId() {
        return this.carCardId;
    }
    
    public void setCarCardId(String carCardId) {
        this.carCardId = carCardId;
    }
    
    @Column(name="con_name", length=30)
    @Field
    public String getConName() {
        return this.conName;
    }
    
    public void setConName(String conName) {
        this.conName = conName;
    }
    
    @Column(name="con_phone", length=20)
    @Field
    public String getConPhone() {
        return this.conPhone;
    }
    
    public void setConPhone(String conPhone) {
        this.conPhone = conPhone;
    }
    
    @Column(name="type_name", length=30)
    @Field
    public String getTypeName() {
        return this.typeName;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    @Column(name="load_weight", length=30)
    @Field
    public String getLoadWeight() {
        return this.loadWeight;
    }
    
    public void setLoadWeight(String loadWeight) {
        this.loadWeight = loadWeight;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShipCar pojo = (ShipCar) o;

        if (carCardId != null ? !carCardId.equals(pojo.carCardId) : pojo.carCardId != null) return false;
        if (conName != null ? !conName.equals(pojo.conName) : pojo.conName != null) return false;
        if (conPhone != null ? !conPhone.equals(pojo.conPhone) : pojo.conPhone != null) return false;
        if (typeName != null ? !typeName.equals(pojo.typeName) : pojo.typeName != null) return false;
        if (loadWeight != null ? !loadWeight.equals(pojo.loadWeight) : pojo.loadWeight != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (carCardId != null ? carCardId.hashCode() : 0);
        result = 31 * result + (conName != null ? conName.hashCode() : 0);
        result = 31 * result + (conPhone != null ? conPhone.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (loadWeight != null ? loadWeight.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("shipCarId").append("='").append(getShipCarId()).append("', ");
        sb.append("carCardId").append("='").append(getCarCardId()).append("', ");
        sb.append("conName").append("='").append(getConName()).append("', ");
        sb.append("conPhone").append("='").append(getConPhone()).append("', ");
        sb.append("typeName").append("='").append(getTypeName()).append("', ");
        sb.append("loadWeight").append("='").append(getLoadWeight()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
