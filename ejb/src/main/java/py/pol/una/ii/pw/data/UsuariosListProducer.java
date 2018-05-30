package py.pol.una.ii.pw.data;

import py.pol.una.ii.pw.model.Member;
import py.pol.una.ii.pw.model.Usuario;

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
public class UsuariosListProducer {
    @Inject
    private UsuariosRepository usuariosRepository;

    private List<Usuario> usuarios;

    // @Named provides access the return value via the EL variable name "members" in the UI (e.g.,
    // Facelets or JSP view)
    @Produces
    @Named
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void onUsuarioListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Usuario usuario) {
        retrieveAllUsuarioOrderedByName();
    }

    @PostConstruct
    public void retrieveAllUsuarioOrderedByName() {
        usuarios = usuariosRepository.findAllOrderedByName();
    }
}
