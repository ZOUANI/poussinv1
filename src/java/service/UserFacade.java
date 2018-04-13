/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.User;
import controller.util.SessionUtil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author YOUNES
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "poussinv1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }


    public int seConnecter(User user) {
        System.out.println("user "+user);
        if (user == null || user.getLogin() == null) {
            return -2;
        } else {
            User loadedUser = find(user.getLogin());
            if (loadedUser == null) {
                return 0;
            } else {
                if (loadedUser.getPassword().equals(user.getPassword())) {
                    SessionUtil.attachUserToSession(loadedUser);
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }

    public void seDeConnnecter() {
        SessionUtil.getSession().invalidate();
    }

}
