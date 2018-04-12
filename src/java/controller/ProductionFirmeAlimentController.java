package controller;

import bean.ProductionFirmeAliment;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import service.ProductionFirmeAlimentFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("productionFirmeAlimentController")
@SessionScoped
public class ProductionFirmeAlimentController implements Serializable {

    @EJB
    private service.ProductionFirmeAlimentFacade ejbFacade;
    private List<ProductionFirmeAliment> items = null;
    private ProductionFirmeAliment selected;

    public ProductionFirmeAlimentController() {
    }

    public ProductionFirmeAliment getSelected() {
        return selected;
    }

    public void setSelected(ProductionFirmeAliment selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProductionFirmeAlimentFacade getFacade() {
        return ejbFacade;
    }

    public ProductionFirmeAliment prepareCreate() {
        selected = new ProductionFirmeAliment();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProductionFirmeAlimentCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProductionFirmeAlimentUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProductionFirmeAlimentDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ProductionFirmeAliment> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public ProductionFirmeAliment getProductionFirmeAliment(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<ProductionFirmeAliment> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ProductionFirmeAliment> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ProductionFirmeAliment.class)
    public static class ProductionFirmeAlimentControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductionFirmeAlimentController controller = (ProductionFirmeAlimentController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productionFirmeAlimentController");
            return controller.getProductionFirmeAliment(getKey(value));
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
            if (object instanceof ProductionFirmeAliment) {
                ProductionFirmeAliment o = (ProductionFirmeAliment) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProductionFirmeAliment.class.getName()});
                return null;
            }
        }

    }

}
