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
 * @author ayoubmahrouj
 */
@Entity
public class EntreePoussinFerme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private EntreePoussin entreePoussin;
    private Date dateEntreePoussinFerme;
    private Firme firme;
    private BigDecimal qteMale;
    private BigDecimal qteFemale;
    private BigDecimal qteTotal;
    private int semaine;
    private int annee;
    private int numeroSemaine;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EntreePoussin getEntreePoussin() {
        if(entreePoussin==null){
            entreePoussin=new EntreePoussin();
        }
        return entreePoussin;
    }

    public void setEntreePoussin(EntreePoussin entreePoussin) {
        this.entreePoussin = entreePoussin;
    }

    public Date getDateEntreePoussinFerme() {
        return dateEntreePoussinFerme;
    }

    public void setDateEntreePoussinFerme(Date dateEntreePoussinFerme) {
        this.dateEntreePoussinFerme = dateEntreePoussinFerme;
    }

    public Firme getFirme() {
        if(firme==null){
            firme=new Firme();
        }
        return firme;
    }

    public void setFirme(Firme firme) {
        this.firme = firme;
    }

    public BigDecimal getQteMale() {
        return qteMale;
    }

    public void setQteMale(BigDecimal qteMale) {
        this.qteMale = qteMale;
    }

    public BigDecimal getQteFemale() {
        return qteFemale;
    }

    public void setQteFemale(BigDecimal qteFemale) {
        this.qteFemale = qteFemale;
    }

    public BigDecimal getQteTotal() {
        return qteTotal;
    }

    public void setQteTotal(BigDecimal qteTotal) {
        this.qteTotal = qteTotal;
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

    public int getNumeroSemaine() {
        return numeroSemaine;
    }

    public void setNumeroSemaine(int numeroSemaine) {
        this.numeroSemaine = numeroSemaine;
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
        if (!(object instanceof EntreePoussinFerme)) {
            return false;
        }
        EntreePoussinFerme other = (EntreePoussinFerme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.EntreePoussinFerme[ id=" + id + " ]";
    }
    
}
