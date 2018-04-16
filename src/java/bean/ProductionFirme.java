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
public class ProductionFirme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Firme firme;
    @ManyToOne
    private EntreePoussinFerme entreePoussinFerme;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date adteProductionFirme;
    private int semaine;
    private int annee;
    private int numeroSemaine;
    @ManyToOne
    private ProductionFirmeParGender productionOeufMale;
    @ManyToOne
    private ProductionFirmeParGender productionOeufFemale;

    @ManyToOne
    private ProductionFirmeAliment productionOeufAlimentMale;
    @ManyToOne
    private ProductionFirmeAliment productionOeufAlimentFemale;

    private BigDecimal production;
    private BigDecimal poids;
    private BigDecimal age;
    private BigDecimal mortalite;
    private BigDecimal transfert;
    private BigDecimal vente;
    private BigDecimal reliquat;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EntreePoussinFerme getEntreePoussinFerme() {
        if(entreePoussinFerme==null){
            entreePoussinFerme=new EntreePoussinFerme();
        }
        return entreePoussinFerme;
    }

    public void setEntreePoussinFerme(EntreePoussinFerme entreePoussinFerme) {
        this.entreePoussinFerme = entreePoussinFerme;
    }
    

    public BigDecimal getReliquat() {
        return reliquat;
    }

    public void setReliquat(BigDecimal reliquat) {
        this.reliquat = reliquat;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
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

    public BigDecimal getPoids() {
        return poids;
    }

    public void setPoids(BigDecimal poids) {
        this.poids = poids;
    }

    public int getNumeroSemaine() {
        return numeroSemaine;
    }

    public void setNumeroSemaine(int numeroSemaine) {
        this.numeroSemaine = numeroSemaine;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getSemaine() {
        return semaine;
    }

    public void setSemaine(int semaine) {
        this.semaine = semaine;
    }

    public Firme getFirme() {
        return firme;
    }

    public void setFirme(Firme firme) {
        this.firme = firme;
    }

    public Date getAdteProductionFirme() {
        return adteProductionFirme;
    }

    public void setAdteProductionFirme(Date adteProductionFirme) {
        this.adteProductionFirme = adteProductionFirme;
    }

    public ProductionFirmeParGender getProductionOeufMale() {
        return productionOeufMale;
    }

    public void setProductionOeufMale(ProductionFirmeParGender productionOeufMale) {
        this.productionOeufMale = productionOeufMale;
    }

    public ProductionFirmeParGender getProductionOeufFemale() {
        return productionOeufFemale;
    }

    public void setProductionOeufFemale(ProductionFirmeParGender productionOeufFemale) {
        this.productionOeufFemale = productionOeufFemale;
    }

    public ProductionFirmeAliment getProductionOeufAlimentMale() {
        return productionOeufAlimentMale;
    }

    public void setProductionOeufAlimentMale(ProductionFirmeAliment productionOeufAlimentMale) {
        this.productionOeufAlimentMale = productionOeufAlimentMale;
    }

    public ProductionFirmeAliment getProductionOeufAlimentFemale() {
        return productionOeufAlimentFemale;
    }

    public void setProductionOeufAlimentFemale(ProductionFirmeAliment productionOeufAlimentFemale) {
        this.productionOeufAlimentFemale = productionOeufAlimentFemale;
    }

    public BigDecimal getProduction() {
        return production;
    }

    public void setProduction(BigDecimal production) {
        this.production = production;
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
        if (!(object instanceof ProductionFirme)) {
            return false;
        }
        ProductionFirme other = (ProductionFirme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.ProductionFirme[ id=" + id + " ]";
    }

}
