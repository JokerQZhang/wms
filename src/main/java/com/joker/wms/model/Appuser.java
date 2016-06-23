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
@Table(name="appuser",catalog="wms")
@Indexed
@XmlRootElement
public class Appuser extends BaseObject implements Serializable {
    private Long userId;
    private String username;
    private String password;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId     @Column(name="user_id", unique=true, nullable=false)    
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    @Column(name="username", length=50)
    @Field
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="password", length=50)
    @Field
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appuser pojo = (Appuser) o;

        if (username != null ? !username.equals(pojo.username) : pojo.username != null) return false;
        if (password != null ? !password.equals(pojo.password) : pojo.password != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("userId").append("='").append(getUserId()).append("', ");
        sb.append("username").append("='").append(getUsername()).append("', ");
        sb.append("password").append("='").append(getPassword()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
