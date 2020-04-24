/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luxal
 */
@Entity
@Table(name = "type_of_transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeOfTransaction.findAll", query = "SELECT t FROM TypeOfTransaction t"),
    @NamedQuery(name = "TypeOfTransaction.findByIdTypeOfTransaction", query = "SELECT t FROM TypeOfTransaction t WHERE t.idTypeOfTransaction = :idTypeOfTransaction"),
    @NamedQuery(name = "TypeOfTransaction.findByTitle", query = "SELECT t FROM TypeOfTransaction t WHERE t.title = :title")})
public class TypeOfTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_type_of_transaction")
    private Integer idTypeOfTransaction;
    @Column(name = "title")
    private String title;

    public TypeOfTransaction() {
    }

    public TypeOfTransaction(Integer idTypeOfTransaction) {
        this.idTypeOfTransaction = idTypeOfTransaction;
    }

    public Integer getIdTypeOfTransaction() {
        return idTypeOfTransaction;
    }

    public void setIdTypeOfTransaction(Integer idTypeOfTransaction) {
        this.idTypeOfTransaction = idTypeOfTransaction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeOfTransaction != null ? idTypeOfTransaction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeOfTransaction)) {
            return false;
        }
        TypeOfTransaction other = (TypeOfTransaction) object;
        if ((this.idTypeOfTransaction == null && other.idTypeOfTransaction != null) || (this.idTypeOfTransaction != null && !this.idTypeOfTransaction.equals(other.idTypeOfTransaction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.TypeOfTransaction[ idTypeOfTransaction=" + idTypeOfTransaction + " ]";
    }
    
}
