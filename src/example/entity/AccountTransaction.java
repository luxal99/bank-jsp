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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luxal
 */
@Entity
@Table(name = "account_transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountTransaction.findAll", query = "SELECT a FROM AccountTransaction a"),
    @NamedQuery(name = "AccountTransaction.findByIdAccountTransaction", query = "SELECT a FROM AccountTransaction a WHERE a.idAccountTransaction = :idAccountTransaction")})
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_account_transaction")
    private Integer idAccountTransaction;
    @JoinColumn(name = "id_account", referencedColumnName = "id_account")
    @ManyToOne
    private Account idAccount;
    @JoinColumn(name = "id_transaction", referencedColumnName = "id_transaction")
    @ManyToOne
    private Transaction idTransaction;
    @JoinColumn(name = "id_type_transaction", referencedColumnName = "id_type_of_transaction")
    @ManyToOne
    private TypeOfTransaction idTypeTransaction;

    public AccountTransaction() {
    }

    public AccountTransaction(Integer idAccountTransaction) {
        this.idAccountTransaction = idAccountTransaction;
    }

    public Integer getIdAccountTransaction() {
        return idAccountTransaction;
    }

    public void setIdAccountTransaction(Integer idAccountTransaction) {
        this.idAccountTransaction = idAccountTransaction;
    }

    public Account getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Account idAccount) {
        this.idAccount = idAccount;
    }

    public Transaction getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Transaction idTransaction) {
        this.idTransaction = idTransaction;
    }

    public TypeOfTransaction getIdTypeTransaction() {
        return idTypeTransaction;
    }

    public void setIdTypeTransaction(TypeOfTransaction idTypeTransaction) {
        this.idTypeTransaction = idTypeTransaction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccountTransaction != null ? idAccountTransaction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountTransaction)) {
            return false;
        }
        AccountTransaction other = (AccountTransaction) object;
        if ((this.idAccountTransaction == null && other.idAccountTransaction != null) || (this.idAccountTransaction != null && !this.idAccountTransaction.equals(other.idAccountTransaction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.AccountTransaction[ idAccountTransaction=" + idAccountTransaction + " ]";
    }
    
}
