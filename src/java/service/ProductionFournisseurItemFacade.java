/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.ProductionFournisseurItem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ayoubmahrouj
 */
@Stateless
public class ProductionFournisseurItemFacade extends AbstractFacade<ProductionFournisseurItem> {

    @PersistenceContext(unitName = "poussinv1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductionFournisseurItemFacade() {
        super(ProductionFournisseurItem.class);
    }
    
}
