package py.pol.una.ii.pw.data;

import py.pol.una.ii.pw.model.Roles;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Usuario on 02/08/2017.
 */
@RequestScoped
public class RolesListProducer {

    @Inject
    private RolesRepository rolesRepository;

    private List<Roles> roles;

    @Produces
    @Named
    public List<Roles> getRoles() {
        return roles;
    }

    public void onRolesListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Roles Roles) {
        retrieveAllRolesOrderedByName();
    }

    @PostConstruct
    public void retrieveAllRolesOrderedByName() {
        roles = rolesRepository.findAllOrderedByDescripcion();
    }
}
