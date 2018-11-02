package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Componentes;
import edu.sv.uesocc.facades.ComponentesFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@Named(value = "componentesMB")
@SessionScoped
public class ComponentesMB implements Serializable {

    @EJB
    private ComponentesFacadeLocal compf;

    private Componentes comp;
    private Componentes compSeleccionado;
    private LazyDataModel<Componentes> compList;

    public ComponentesMB() {
    }

    @PostConstruct
    private void init() {
        comp = new Componentes();
        compSeleccionado = new Componentes();

        this.compList = new LazyDataModel<Componentes>() {

            @Override
            public Object getRowKey(Componentes componente) {
                if (componente != null) {
                    return componente.getIdComponente();
                }
                return null;
            }

            @Override
            public Componentes getRowData(String rowkey) {
                if (this.getWrappedData() != null && rowkey != null) {
                    List<Componentes> lista = (List<Componentes>) getWrappedData();
                    if (!lista.isEmpty()) {
                        for (Componentes c : lista) {
                            if (c.getIdComponente().toString().compareToIgnoreCase(rowkey) == 0) {
                                return c;
                            }
                        }
                    }
                }
                return null;
            }

            @Override
            public List<Componentes> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                List<Componentes> lista = new ArrayList<>();
                String order = null;

                if (sortOrder == SortOrder.ASCENDING) {
                    order = "Asc";
                } else if (sortOrder == SortOrder.DESCENDING) {
                    order = "Des";
                }

                try {
                    if (compf != null) {
                        lista = compf.findByDataFilter(first, pageSize, sortField, order, filters);
                        this.setRowCount(compf.countByDataFilter(filters));
                    } else {
                        lista = compf.findRange(new int[]{first, first + pageSize});
                        this.setRowCount(compf.count());
                    }
                } catch (Exception e) {
                    System.out.println("Error " + e.getMessage());
                }
                return lista;
            }
        };

    }

    public Componentes getComp() {
        return comp;
    }

    public void setComp(Componentes comp) {
        this.comp = comp;
    }

    public Componentes getCompSeleccionado() {
        return compSeleccionado;
    }

    public void setCompSeleccionado(Componentes compSeleccionado) {
        this.compSeleccionado = compSeleccionado;
    }

    public LazyDataModel<Componentes> getCompList() {
        return compList;
    }

    public void setCompList(LazyDataModel<Componentes> compList) {
        this.compList = compList;
    }

    public void crearComponente() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean creado = false;
        try {
            creado = compf.create(comp);
            if (creado) {
                contexto.addMessage(null, new FacesMessage("Registro guardado"));

                comp = new Componentes();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro"));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
    }

    public void modificarComponente() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean modificado = false;
        try {
            modificado = compf.edit(compSeleccionado);
            if (modificado) {
                contexto.addMessage(null, new FacesMessage("Registro modificado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo modificar el registro"));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
    }

    public void eliminarComponente() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean eliminado = false;
        try {
            eliminado = compf.remove(compSeleccionado);
            if (eliminado) {
                contexto.addMessage(null, new FacesMessage("Registro eliminado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo eliminar el registro"));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
    }

}
