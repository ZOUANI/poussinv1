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

/**
 *
 * @author YOUNES
 */
@Entity
public class ProductionFournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Fournisseur fournisseur;
    private BigDecimal numeroSemaine;
    private BigDecimal nbrOeuf;
    private BigDecimal poids;

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public BigDecimal getNumeroSemaine() {
        return numeroSemaine;
    }

    public void setNumeroSemaine(BigDecimal numeroSemaine) {
        this.numeroSemaine = numeroSemaine;
    }

    public BigDecimal getNbrOeuf() {
        return nbrOeuf;
    }

    public void setNbrOeuf(BigDecimal nbrOeuf) {
        this.nbrOeuf = nbrOeuf;
    }

    public BigDecimal getPoids() {
        return poids;
    }

    public void setPoids(BigDecimal poids) {
        this.poids = poids;
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
        if (!(object instanceof ProductionFournisseur)) {
            return false;
        }
        ProductionFournisseur other = (ProductionFournisseur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.ProdutionFournisseur[ id=" + id + " ]";
    }

}
