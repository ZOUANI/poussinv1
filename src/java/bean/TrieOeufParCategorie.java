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
public class TrieOeufParCategorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private CategorieOeuf categorieOeuf;
    private BigDecimal miseEnIncubation;
    private BigDecimal totalEclosion;
 
    private BigDecimal situationInitiale;
    private BigDecimal entree;
    private BigDecimal vente;
    private BigDecimal don;
    private BigDecimal perte;
    private BigDecimal situationFinale;
    private BigDecimal pourcentage;
    @ManyToOne
    private TrieOeuf trieOeuf;

    public BigDecimal getTotalEclosion() {
        return totalEclosion;
    }

    public void setTotalEclosion(BigDecimal totalEclosion) {
        this.totalEclosion = totalEclosion;
    }

 

    public TrieOeuf getTrieOeuf() {
        if(trieOeuf==null){
            trieOeuf=new TrieOeuf();
        }
        return trieOeuf;
    }

    public void setTrieOeuf(TrieOeuf trieOeuf) {
        this.trieOeuf = trieOeuf;
    }

    public BigDecimal getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(BigDecimal pourcentage) {
        this.pourcentage = pourcentage;
    }

    public CategorieOeuf getCategorieOeuf() {
        return categorieOeuf;
    }

    public void setCategorieOeuf(CategorieOeuf categorieOeuf) {
        this.categorieOeuf = categorieOeuf;
    }

    public BigDecimal getMiseEnIncubation() {
        return miseEnIncubation;
    }

    public void setMiseEnIncubation(BigDecimal miseEnIncubation) {
        this.miseEnIncubation = miseEnIncubation;
    }

    public BigDecimal getSituationInitiale() {
        return situationInitiale;
    }

    public void setSituationInitiale(BigDecimal situationInitiale) {
        this.situationInitiale = situationInitiale;
    }

    public BigDecimal getEntree() {
        return entree;
    }

    public void setEntree(BigDecimal entree) {
        this.entree = entree;
    }

    public BigDecimal getVente() {
        return vente;
    }

    public void setVente(BigDecimal vente) {
        this.vente = vente;
    }

    public BigDecimal getDon() {
        return don;
    }

    public void setDon(BigDecimal don) {
        this.don = don;
    }

    public BigDecimal getPerte() {
        return perte;
    }

    public void setPerte(BigDecimal perte) {
        this.perte = perte;
    }

    public BigDecimal getSituationFinale() {
        return situationFinale;
    }

    public void setSituationFinale(BigDecimal situationFinale) {
        this.situationFinale = situationFinale;
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
        if (!(object instanceof TrieOeufParCategorie)) {
            return false;
        }
        TrieOeufParCategorie other = (TrieOeufParCategorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.TrieOeufParCategorie[ id=" + id + " ]";
    }

}
