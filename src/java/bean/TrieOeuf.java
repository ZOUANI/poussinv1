/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author YOUNES
 */
@Entity
public class TrieOeuf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal reception;
    @ManyToOne
    private Couvoir couvoir;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateTrie;
    private int semaine;
    private int annee;
    private BigDecimal entree;
    private BigDecimal vente;
    private BigDecimal don;
    private BigDecimal perte;
    private BigDecimal reliquat;

    @OneToMany(mappedBy = "trieOeuf")
    private List<TrieOeufParCategorie> trieOeufParCategories;

    public BigDecimal getReliquat() {
        return reliquat;
    }

    public void setReliquat(BigDecimal reliquat) {
        this.reliquat = reliquat;
    }

    public BigDecimal getReception() {
        return reception;
    }

    public void setReception(BigDecimal reception) {
        this.reception = reception;
    }

    public Couvoir getCouvoir() {
        return couvoir;
    }

    public void setCouvoir(Couvoir couvoir) {
        this.couvoir = couvoir;
    }

    public Date getDateTrie() {
        return dateTrie;
    }

    public void setDateTrie(Date dateTrie) {
        this.dateTrie = dateTrie;
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

    public List<TrieOeufParCategorie> getTrieOeufParCategories() {
        return trieOeufParCategories;
    }

    public void setTrieOeufParCategories(List<TrieOeufParCategorie> trieOeufParCategories) {
        this.trieOeufParCategories = trieOeufParCategories;
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
        if (!(object instanceof TrieOeuf)) {
            return false;
        }
        TrieOeuf other = (TrieOeuf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.TrieOuef[ id=" + id + " ]";
    }

}
