/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.TrieOeufParCategorie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author YOUNES
 */
@Stateless
public class TrieOeufParCategorieFacade extends AbstractFacade<TrieOeufParCategorie> {

    @PersistenceContext(unitName = "poussinv1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrieOeufParCategorieFacade() {
        super(TrieOeufParCategorie.class);
    }
    
}
