package controller;

import bean.ProductionFournisseur;
import bean.ProductionFournisseurItem;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import service.ProductionFournisseurItemFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.event.CellEditEvent;
import service.ProductionFournisseurFacade;

@Named("productionFournisseurItemController")
@SessionScoped
public class ProductionFournisseurItemController implements Serializable {

    @EJB
    private service.ProductionFournisseurItemFacade ejbFacade;
    @EJB
    private ProductionFournisseurFacade productionFournisseurFacade;

    private List<ProductionFournisseurItem> items = null;
    private ProductionFournisseurItem selected;
    private List<ProductionFournisseurItem> panier;
    private ProductionFournisseur productionFournisseur;

    public ProductionFournisseurItemController() {
    }

    public ProductionFournisseur getProductionFournisseur() {
        if(productionFournisseur==null){
            productionFournisseur=new ProductionFournisseur();
        }
        return productionFournisseur;
    }

    public void setProductionFournisseur(ProductionFournisseur productionFournisseur) {
        this.productionFournisseur = productionFournisseur;
    }

    public ProductionFournisseurFacade getProductionFournisseurFacade() {
        return productionFournisseurFacade;
    }

    public void setProductionFournisseurFacade(ProductionFournisseurFacade productionFournisseurFacade) {
        this.productionFournisseurFacade = productionFournisseurFacade;
    }

    public ProductionFournisseurItemFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(ProductionFournisseurItemFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public List<ProductionFournisseurItem> getPanier() {
        if (panier == null) {
            panier = new ArrayList<>();
        }
        return panier;
    }

    public void setPanier(List<ProductionFournisseurItem> panier) {
        this.panier = panier;
    }

    public ProductionFournisseurItem getSelected() {
        if (selected == null) {
            selected = new ProductionFournisseurItem();
        }
        return selected;
    }

    public void setSelected(ProductionFournisseurItem selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProductionFournisseurItemFacade getFacade() {
        return ejbFacade;
    }

    public ProductionFournisseurItem prepareCreate() {
        selected = new ProductionFournisseurItem();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle1").getString("ProductionFournisseurItemCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle1").getString("ProductionFournisseurItemUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle1").getString("ProductionFournisseurItemDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ProductionFournisseurItem> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle1").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle1").getString("PersistenceErrorOccured"));
            }
        }
    }

    public ProductionFournisseurItem getProductionFournisseurItem(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<ProductionFournisseurItem> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ProductionFournisseurItem> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ProductionFournisseurItem.class)
    public static class ProductionFournisseurItemControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductionFournisseurItemController controller = (ProductionFournisseurItemController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productionFournisseurItemController");
            return controller.getProductionFournisseurItem(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ProductionFournisseurItem) {
                ProductionFournisseurItem o = (ProductionFournisseurItem) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProductionFournisseurItem.class.getName()});
                return null;
            }
        }

    }

    public Long generateIdProductionFournisseur() {
        return getProductionFournisseurFacade().generateId();
    }

    public Long generateIdProductionFournisseurItem() {
        return getEjbFacade().generateId();
    }

    public List<ProductionFournisseurItem> addToPanier() {
        getPanier().add(selected);
        selected=new ProductionFournisseurItem();
        return panier;
    }

    public void save() {
        ////////////////////////////////////////////////save ProductionFournisseur
        getProductionFournisseur().setId(generateIdProductionFournisseur());
        getProductionFournisseurFacade().create(getProductionFournisseur());

        ////////////////////////////////////////////////save ProductionFournisseurItem
        System.out.println("panier "+panier);
        for (ProductionFournisseurItem item : panier) {
            item.getProductionFournisseur().setId(productionFournisseur.getId());
            item.setId(generateIdProductionFournisseurItem());
            getFacade().create(item);
        }

        erase();
        JsfUtil.addSuccessMessage("L'opération a été bien effectuée");
    }

    
    public void erase() {
        selected = new ProductionFournisseurItem();
        productionFournisseur=new ProductionFournisseur();
        panier = null;
        panier = new ArrayList<>();
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
