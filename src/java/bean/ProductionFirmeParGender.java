/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class ProductionFirmeParGender implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal effectifDebutJour;
    private BigDecimal mortalite;
    private BigDecimal entree;
    private BigDecimal transfert;
    private BigDecimal vente;
    private BigDecimal effectifFinJour;
   

    public BigDecimal getEffectifDebutJour() {
        return effectifDebutJour;
    }

    public void setEffectifDebutJour(BigDecimal effectifDebutJour) {
        this.effectifDebutJour = effectifDebutJour;
    }

    public BigDecimal getMortalite() {
        return mortalite;
    }

    public void setMortalite(BigDecimal mortalite) {
        this.mortalite = mortalite;
    }

    public BigDecimal getEntree() {
        return entree;
    }

    public void setEntree(BigDecimal entree) {
        this.entree = entree;
    }

    public BigDecimal getTransfert() {
        return transfert;
    }

    public void setTransfert(BigDecimal transfert) {
        this.transfert = transfert;
    }

    public BigDecimal getVente() {
        return vente;
    }

    public void setVente(BigDecimal vente) {
        this.vente = vente;
    }

    public BigDecimal getEffectifFinJour() {
        return effectifFinJour;
    }

    public void setEffectifFinJour(BigDecimal effectifFinJour) {
        this.effectifFinJour = effectifFinJour;
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
        if (!(object instanceof ProductionFirmeParGender)) {
            return false;
        }
        ProductionFirmeParGender other = (ProductionFirmeParGender) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.ProductionOeufParGender[ id=" + id + " ]";
    }

}
