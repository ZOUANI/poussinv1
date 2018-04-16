/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author YOUNES
 */
@Entity
public class TransfertFirme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Firme firmeSource;
    @ManyToOne
    private Firme firmeDestination;
    private BigDecimal qte;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateTransfert;

    public Firme getFirmeSource() {
        return firmeSource;
    }

    public void setFirmeSource(Firme firmeSource) {
        this.firmeSource = firmeSource;
    }

    public Firme getFirmeDestination() {
        return firmeDestination;
    }

    public void setFirmeDestination(Firme firmeDestination) {
        this.firmeDestination = firmeDestination;
    }

    public BigDecimal getQte() {
        return qte;
    }

    public void setQte(BigDecimal qte) {
        this.qte = qte;
    }

    public Date getDateTransfert() {
        return dateTransfert;
    }

    public void setDateTransfert(Date dateTransfert) {
        this.dateTransfert = dateTransfert;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransfertFirme)) {
            return false;
        }
        TransfertFirme other = (TransfertFirme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.TransfertFirme[ id=" + id + " ]";
    }

}
