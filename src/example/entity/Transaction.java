/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luxal
 */
@Entity
@Table(name = "transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t"),
    @NamedQuery(name = "Transaction.findByIdTransaction", query = "SELECT t FROM Transaction t WHERE t.idTransaction = :idTransaction"),
    @NamedQuery(name = "Transaction.findByDate", query = "SELECT t FROM Transaction t WHERE t.date = :date"),
    @NamedQuery(name = "Transaction.findByAmount", query = "SELECT t FROM Transaction t WHERE t.amount = :amount")})
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transaction")
    private Integer idTransaction;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @OneToMany(mappedBy = "idTransaction")
    @JsonIgnore
    private List<AccountTransaction> accountTransactionList;

    public Transaction() {
    }

    public Transaction(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Integer getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @XmlTransient
    public List<AccountTransaction> getAccountTransactionList() {
        return accountTransactionList;
    }

    public void setAccountTransactionList(List<AccountTransaction> accountTransactionList) {
        this.accountTransactionList = accountTransactionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaction != null ? idTransaction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.idTransaction == null && other.idTransaction != null) || (this.idTransaction != null && !this.idTransaction.equals(other.idTransaction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.Transaction[ idTransaction=" + idTransaction + " ]";
    }
    
}
