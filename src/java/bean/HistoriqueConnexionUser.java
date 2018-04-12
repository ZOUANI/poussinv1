/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Temporal;

/**
 *
 * @author abderrahmane
 */
@Entity
public class HistoriqueConnexionUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateAction;
    private Boolean connexion;

    public HistoriqueConnexionUser() {
    }

    public HistoriqueConnexionUser(User user, Date dateAction, Boolean connexion) {
        this.user = user;
        this.dateAction = dateAction;
        this.connexion = connexion;
    }

    public Date getDateAction() {
        return dateAction;
    }

    public void setDateAction(Date dateAction) {
        this.dateAction = dateAction;
    }

    public Boolean getConnexion() {
        return connexion;
    }

    public void setConnexion(Boolean connexion) {
        this.connexion = connexion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!(object instanceof HistoriqueConnexionUser)) {
            return false;
        }
        HistoriqueConnexionUser other = (HistoriqueConnexionUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.HistoriqueConnexion[ id=" + id + " ]";
    }

}