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
@Table(name="monitor_data",catalog="wms")
@Indexed
@XmlRootElement
public class MonitorData extends BaseObject implements Serializable {
    private Long monitorId;
    private Long siteId;
    private Date monitorTime;
    private BigDecimal k1;
    private BigDecimal k2;
    private BigDecimal k3;
    private BigDecimal k4;
    private BigDecimal k5;
    private BigDecimal k6;
    private BigDecimal k7;
    private BigDecimal k8;
    private BigDecimal k9;
    private BigDecimal k10;
    private BigDecimal k11;
    private BigDecimal k12;
    private BigDecimal k13;
    private BigDecimal k14;
    private BigDecimal k15;
    private BigDecimal k16;
    private BigDecimal k17;
    private BigDecimal k18;
    private BigDecimal k19;
    private BigDecimal k20;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="monitor_id", unique=true, nullable=false)    
    public Long getMonitorId() {
        return this.monitorId;
    }
    
    public void setMonitorId(Long monitorId) {
        this.monitorId = monitorId;
    }
    
    @Column(name="site_id")
    @Field
    public Long getSiteId() {
        return this.siteId;
    }
    
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="monitor_time", length=19)
    @Field
    public Date getMonitorTime() {
        return this.monitorTime;
    }
    
    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }
    
    @Column(name="k1", precision=20, scale=8)
    @Field
    public BigDecimal getK1() {
        return this.k1;
    }
    
    public void setK1(BigDecimal k1) {
        this.k1 = k1;
    }
    
    @Column(name="k2", precision=20, scale=8)
    @Field
    public BigDecimal getK2() {
        return this.k2;
    }
    
    public void setK2(BigDecimal k2) {
        this.k2 = k2;
    }
    
    @Column(name="k3", precision=20, scale=8)
    @Field
    public BigDecimal getK3() {
        return this.k3;
    }
    
    public void setK3(BigDecimal k3) {
        this.k3 = k3;
    }
    
    @Column(name="k4", precision=20, scale=8)
    @Field
    public BigDecimal getK4() {
        return this.k4;
    }
    
    public void setK4(BigDecimal k4) {
        this.k4 = k4;
    }
    
    @Column(name="k5", precision=20, scale=8)
    @Field
    public BigDecimal getK5() {
        return this.k5;
    }
    
    public void setK5(BigDecimal k5) {
        this.k5 = k5;
    }
    
    @Column(name="k6", precision=20, scale=8)
    @Field
    public BigDecimal getK6() {
        return this.k6;
    }
    
    public void setK6(BigDecimal k6) {
        this.k6 = k6;
    }
    
    @Column(name="k7", precision=20, scale=8)
    @Field
    public BigDecimal getK7() {
        return this.k7;
    }
    
    public void setK7(BigDecimal k7) {
        this.k7 = k7;
    }
    
    @Column(name="k8", precision=20, scale=8)
    @Field
    public BigDecimal getK8() {
        return this.k8;
    }
    
    public void setK8(BigDecimal k8) {
        this.k8 = k8;
    }
    
    @Column(name="k9", precision=20, scale=8)
    @Field
    public BigDecimal getK9() {
        return this.k9;
    }
    
    public void setK9(BigDecimal k9) {
        this.k9 = k9;
    }
    
    @Column(name="k10", precision=20, scale=8)
    @Field
    public BigDecimal getK10() {
        return this.k10;
    }
    
    public void setK10(BigDecimal k10) {
        this.k10 = k10;
    }
    
    @Column(name="k11", precision=20, scale=8)
    @Field
    public BigDecimal getK11() {
        return this.k11;
    }
    
    public void setK11(BigDecimal k11) {
        this.k11 = k11;
    }
    
    @Column(name="k12", precision=20, scale=8)
    @Field
    public BigDecimal getK12() {
        return this.k12;
    }
    
    public void setK12(BigDecimal k12) {
        this.k12 = k12;
    }
    
    @Column(name="k13", precision=20, scale=8)
    @Field
    public BigDecimal getK13() {
        return this.k13;
    }
    
    public void setK13(BigDecimal k13) {
        this.k13 = k13;
    }
    
    @Column(name="k14", precision=20, scale=8)
    @Field
    public BigDecimal getK14() {
        return this.k14;
    }
    
    public void setK14(BigDecimal k14) {
        this.k14 = k14;
    }
    
    @Column(name="k15", precision=20, scale=8)
    @Field
    public BigDecimal getK15() {
        return this.k15;
    }
    
    public void setK15(BigDecimal k15) {
        this.k15 = k15;
    }
    
    @Column(name="k16", precision=20, scale=8)
    @Field
    public BigDecimal getK16() {
        return this.k16;
    }
    
    public void setK16(BigDecimal k16) {
        this.k16 = k16;
    }
    
    @Column(name="k17", precision=20, scale=8)
    @Field
    public BigDecimal getK17() {
        return this.k17;
    }
    
    public void setK17(BigDecimal k17) {
        this.k17 = k17;
    }
    
    @Column(name="k18", precision=20, scale=8)
    @Field
    public BigDecimal getK18() {
        return this.k18;
    }
    
    public void setK18(BigDecimal k18) {
        this.k18 = k18;
    }
    
    @Column(name="k19", precision=20, scale=8)
    @Field
    public BigDecimal getK19() {
        return this.k19;
    }
    
    public void setK19(BigDecimal k19) {
        this.k19 = k19;
    }
    
    @Column(name="k20", precision=20, scale=8)
    @Field
    public BigDecimal getK20() {
        return this.k20;
    }
    
    public void setK20(BigDecimal k20) {
        this.k20 = k20;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonitorData pojo = (MonitorData) o;

        if (siteId != null ? !siteId.equals(pojo.siteId) : pojo.siteId != null) return false;
        if (monitorTime != null ? !monitorTime.equals(pojo.monitorTime) : pojo.monitorTime != null) return false;
        if (k1 != null ? !k1.equals(pojo.k1) : pojo.k1 != null) return false;
        if (k2 != null ? !k2.equals(pojo.k2) : pojo.k2 != null) return false;
        if (k3 != null ? !k3.equals(pojo.k3) : pojo.k3 != null) return false;
        if (k4 != null ? !k4.equals(pojo.k4) : pojo.k4 != null) return false;
        if (k5 != null ? !k5.equals(pojo.k5) : pojo.k5 != null) return false;
        if (k6 != null ? !k6.equals(pojo.k6) : pojo.k6 != null) return false;
        if (k7 != null ? !k7.equals(pojo.k7) : pojo.k7 != null) return false;
        if (k8 != null ? !k8.equals(pojo.k8) : pojo.k8 != null) return false;
        if (k9 != null ? !k9.equals(pojo.k9) : pojo.k9 != null) return false;
        if (k10 != null ? !k10.equals(pojo.k10) : pojo.k10 != null) return false;
        if (k11 != null ? !k11.equals(pojo.k11) : pojo.k11 != null) return false;
        if (k12 != null ? !k12.equals(pojo.k12) : pojo.k12 != null) return false;
        if (k13 != null ? !k13.equals(pojo.k13) : pojo.k13 != null) return false;
        if (k14 != null ? !k14.equals(pojo.k14) : pojo.k14 != null) return false;
        if (k15 != null ? !k15.equals(pojo.k15) : pojo.k15 != null) return false;
        if (k16 != null ? !k16.equals(pojo.k16) : pojo.k16 != null) return false;
        if (k17 != null ? !k17.equals(pojo.k17) : pojo.k17 != null) return false;
        if (k18 != null ? !k18.equals(pojo.k18) : pojo.k18 != null) return false;
        if (k19 != null ? !k19.equals(pojo.k19) : pojo.k19 != null) return false;
        if (k20 != null ? !k20.equals(pojo.k20) : pojo.k20 != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (siteId != null ? siteId.hashCode() : 0);
        result = 31 * result + (monitorTime != null ? monitorTime.hashCode() : 0);
        result = 31 * result + (k1 != null ? k1.hashCode() : 0);
        result = 31 * result + (k2 != null ? k2.hashCode() : 0);
        result = 31 * result + (k3 != null ? k3.hashCode() : 0);
        result = 31 * result + (k4 != null ? k4.hashCode() : 0);
        result = 31 * result + (k5 != null ? k5.hashCode() : 0);
        result = 31 * result + (k6 != null ? k6.hashCode() : 0);
        result = 31 * result + (k7 != null ? k7.hashCode() : 0);
        result = 31 * result + (k8 != null ? k8.hashCode() : 0);
        result = 31 * result + (k9 != null ? k9.hashCode() : 0);
        result = 31 * result + (k10 != null ? k10.hashCode() : 0);
        result = 31 * result + (k11 != null ? k11.hashCode() : 0);
        result = 31 * result + (k12 != null ? k12.hashCode() : 0);
        result = 31 * result + (k13 != null ? k13.hashCode() : 0);
        result = 31 * result + (k14 != null ? k14.hashCode() : 0);
        result = 31 * result + (k15 != null ? k15.hashCode() : 0);
        result = 31 * result + (k16 != null ? k16.hashCode() : 0);
        result = 31 * result + (k17 != null ? k17.hashCode() : 0);
        result = 31 * result + (k18 != null ? k18.hashCode() : 0);
        result = 31 * result + (k19 != null ? k19.hashCode() : 0);
        result = 31 * result + (k20 != null ? k20.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("monitorId").append("='").append(getMonitorId()).append("', ");
        sb.append("siteId").append("='").append(getSiteId()).append("', ");
        sb.append("monitorTime").append("='").append(getMonitorTime()).append("', ");
        sb.append("k1").append("='").append(getK1()).append("', ");
        sb.append("k2").append("='").append(getK2()).append("', ");
        sb.append("k3").append("='").append(getK3()).append("', ");
        sb.append("k4").append("='").append(getK4()).append("', ");
        sb.append("k5").append("='").append(getK5()).append("', ");
        sb.append("k6").append("='").append(getK6()).append("', ");
        sb.append("k7").append("='").append(getK7()).append("', ");
        sb.append("k8").append("='").append(getK8()).append("', ");
        sb.append("k9").append("='").append(getK9()).append("', ");
        sb.append("k10").append("='").append(getK10()).append("', ");
        sb.append("k11").append("='").append(getK11()).append("', ");
        sb.append("k12").append("='").append(getK12()).append("', ");
        sb.append("k13").append("='").append(getK13()).append("', ");
        sb.append("k14").append("='").append(getK14()).append("', ");
        sb.append("k15").append("='").append(getK15()).append("', ");
        sb.append("k16").append("='").append(getK16()).append("', ");
        sb.append("k17").append("='").append(getK17()).append("', ");
        sb.append("k18").append("='").append(getK18()).append("', ");
        sb.append("k19").append("='").append(getK19()).append("', ");
        sb.append("k20").append("='").append(getK20()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
