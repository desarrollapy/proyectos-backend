package py.pol.una.ii.pw.data;

import py.pol.una.ii.pw.model.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Usuario on 02/08/2017.
 */
@ApplicationScoped
public class UsuariosRepository {
    @Inject
    private EntityManager em;

    public Usuario findUsuarioById(Long id) {
        return em.find(Usuario.class, id);
    }

    public List<Usuario> findAllOrderedByName() {
        TypedQuery<Usuario> tq = em.createQuery("Select r from Usuario r", Usuario.class);
        return tq.getResultList();

    }
}
