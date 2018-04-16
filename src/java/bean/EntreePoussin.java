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
public class EntreePoussin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ProductionFournisseur productionOeufFournisseur;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateEntree;
    private int semaine;
    private int annee;
    private int numeroSemaine;
    private String description;
    private BigDecimal totalMale;
    private BigDecimal totalFemale;
    private BigDecimal totale;
    private BigDecimal production;
    private BigDecimal poids;
    private BigDecimal mortalite;
    private BigDecimal transfert;
    private BigDecimal vente;
    private BigDecimal reliquat;

    public int getSemaine() {
        return semaine;
    }

    public void setSemaine(int semaine) {
        this.semaine = semaine;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getNumeroSemaine() {
        return numeroSemaine;
    }

    public void setNumeroSemaine(int numeroSemaine) {
        this.numeroSemaine = numeroSemaine;
    }

    public BigDecimal getProduction() {
        return production;
    }

    public void setProduction(BigDecimal production) {
        this.production = production;
    }

    public BigDecimal getPoids() {
        return poids;
    }

    public void setPoids(BigDecimal poids) {
        this.poids = poids;
    }

    public BigDecimal getMortalite() {
        return mortalite;
    }

    public void setMortalite(BigDecimal mortalite) {
        this.mortalite = mortalite;
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

    public BigDecimal getReliquat() {
        return reliquat;
    }

    public void setReliquat(BigDecimal reliquat) {
        this.reliquat = reliquat;
    }

    public ProductionFournisseur getProductionOeufFournisseur() {
        return productionOeufFournisseur;
    }

    public void setProductionOeufFournisseur(ProductionFournisseur productionOeufFournisseur) {
        this.productionOeufFournisseur = productionOeufFournisseur;
    }

    public Long getId() {
        return id;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public BigDecimal getTotale() {
        return totale;
    }

    public void setTotale(BigDecimal totale) {
        this.totale = totale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTotalMale() {
        return totalMale;
    }

    public void setTotalMale(BigDecimal totalMale) {
        this.totalMale = totalMale;
    }

    public BigDecimal getTotalFemale() {
        return totalFemale;
    }

    public void setTotalFemale(BigDecimal totalFemale) {
        this.totalFemale = totalFemale;
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
        if (!(object instanceof EntreePoussin)) {
            return false;
        }
        EntreePoussin other = (EntreePoussin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.EntreeAnimale[ id=" + id + " ]";
    }

}
