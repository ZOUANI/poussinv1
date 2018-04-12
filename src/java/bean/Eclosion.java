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
public class Eclosion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private TrieOeufParCategorie trieOeufParCategorie;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateEclosion;
    private int semaine;
    private int numeroSemaine;
    private int annee;
    private BigDecimal ecartTrie;
    private BigDecimal ecartEclosion;
    private BigDecimal commercialise;

    public int getNumeroSemaine() {
        return numeroSemaine;
    }

    public void setNumeroSemaine(int numeroSemaine) {
        this.numeroSemaine = numeroSemaine;
    }

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

    public TrieOeufParCategorie getTrieOeufParCategorie() {
        return trieOeufParCategorie;
    }

    public void setTrieOeufParCategorie(TrieOeufParCategorie trieOeufParCategorie) {
        this.trieOeufParCategorie = trieOeufParCategorie;
    }

    public Date getDateEclosion() {
        return dateEclosion;
    }

    public void setDateEclosion(Date dateEclosion) {
        this.dateEclosion = dateEclosion;
    }

    public BigDecimal getCommercialise() {
        return commercialise;
    }

    public void setCommercialise(BigDecimal commercialise) {
        this.commercialise = commercialise;
    }

    public BigDecimal getEcartTrie() {
        return ecartTrie;
    }

    public void setEcartTrie(BigDecimal ecartTrie) {
        this.ecartTrie = ecartTrie;
    }

    public BigDecimal getEcartEclosion() {
        return ecartEclosion;
    }

    public void setEcartEclosion(BigDecimal ecartEclosion) {
        this.ecartEclosion = ecartEclosion;
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
        if (!(object instanceof Eclosion)) {
            return false;
        }
        Eclosion other = (Eclosion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Eclosion[ id=" + id + " ]";
    }

}
