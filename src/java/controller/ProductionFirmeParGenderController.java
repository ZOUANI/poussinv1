package controller;

import bean.ProductionFirmeParGender;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import service.ProductionFirmeParGenderFacade;

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

@Named("productionFirmeParGenderController")
@SessionScoped
public class ProductionFirmeParGenderController implements Serializable {

    @EJB
    private service.ProductionFirmeParGenderFacade ejbFacade;
    private List<ProductionFirmeParGender> items = null;
    private ProductionFirmeParGender selected;

    public ProductionFirmeParGenderController() {
    }

    public ProductionFirmeParGender getSelected() {
        return selected;
    }

    public void setSelected(ProductionFirmeParGender selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProductionFirmeParGenderFacade getFacade() {
        return ejbFacade;
    }

    public ProductionFirmeParGender prepareCreate() {
        selected = new ProductionFirmeParGender();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProductionFirmeParGenderCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProductionFirmeParGenderUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProductionFirmeParGenderDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ProductionFirmeParGender> getItems() {
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

    public ProductionFirmeParGender getProductionFirmeParGender(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<ProductionFirmeParGender> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ProductionFirmeParGender> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ProductionFirmeParGender.class)
    public static class ProductionFirmeParGenderControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductionFirmeParGenderController controller = (ProductionFirmeParGenderController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productionFirmeParGenderController");
            return controller.getProductionFirmeParGender(getKey(value));
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
            if (object instanceof ProductionFirmeParGender) {
                ProductionFirmeParGender o = (ProductionFirmeParGender) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProductionFirmeParGender.class.getName()});
                return null;
            }
        }

    }

}
