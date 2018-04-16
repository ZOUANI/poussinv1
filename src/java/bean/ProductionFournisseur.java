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

/**
 *
 * @author YOUNES
 */
@Entity
public class ProductionFournisseur implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code; 
    @ManyToOne
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "productionFournisseur")
    private List<ProductionFournisseurItem> productionFournisseurItems;
    private String description;
    

    
    public Fournisseur getFournisseur() {
        if(fournisseur==null){
            fournisseur=new Fournisseur();
        }
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ProductionFournisseurItem> getProductionFournisseurItems() {
        return productionFournisseurItems;
    }

    public void setProductionFournisseurItems(List<ProductionFournisseurItem> productionFournisseurItems) {
        this.productionFournisseurItems = productionFournisseurItems;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
