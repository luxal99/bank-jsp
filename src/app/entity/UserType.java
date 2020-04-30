/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author luxal
 */
@Entity
@Table(name = "user_type")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "UserType.findAll", query = "SELECT u FROM UserType u"),
        @NamedQuery(name = "UserType.findByIdUserType", query = "SELECT u FROM UserType u WHERE u.idUserType = :idUserType"),
        @NamedQuery(name = "UserType.findByTitle", query = "SELECT u FROM UserType u WHERE u.title = :title")})
public class UserType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user_type")
    private Integer idUserType;
    @Column(name = "title")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUserType", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> userList;

    public UserType() {
    }

    public UserType(Integer idUserType) {
        this.idUserType = idUserType;
    }

    public Integer getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(Integer idUserType) {
        this.idUserType = idUserType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserType != null ? idUserType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserType)) {
            return false;
        }
        UserType other = (UserType) object;
        return (this.idUserType != null || other.idUserType == null) && (this.idUserType == null || this.idUserType.equals(other.idUserType));
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.UserType[ idUserType=" + idUserType + " ]";
    }

}
