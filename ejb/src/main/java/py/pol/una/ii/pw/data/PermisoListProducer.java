package py.pol.una.ii.pw.data;

import py.pol.una.ii.pw.model.Permisos;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RequestScoped
public class PermisoListProducer {

    @Inject
    private PermisoRepository permisoRepository;

    private List<Permisos> permisos;

    @Produces
    @Named
    public List<Permisos> getPermisos() {
        return permisos;
    }

    public void onPermisosListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Permisos permisos) {
        retrieveAllPermisosOrderedByName();
    }

    @PostConstruct
    public void retrieveAllPermisosOrderedByName() {
        permisos = permisoRepository.findAllOrderedByName();
    }
}
