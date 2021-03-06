/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.ProductionFournisseur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author YOUNES
 */
@Stateless
public class ProductionFournisseurFacade extends AbstractFacade<ProductionFournisseur> {

    @PersistenceContext(unitName = "poussinv1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductionFournisseurFacade() {
        super(ProductionFournisseur.class);
    }


    public Long generateId() {
        Long maxId = (Long) em.createQuery("SELECT MAX(tp.id) FROM ProductionFournisseur tp").getSingleResult();
        return (maxId == null ? 1l : maxId + 1);
    }
    
}
