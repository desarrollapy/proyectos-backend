package py.pol.una.ii.pw.data;

import py.pol.una.ii.pw.model.Roles;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Usuario on 02/08/2017.
 */
@ApplicationScoped
public class RolesRepository {
    @Inject
    private EntityManager em;

    public Roles findRolById(Long id) {
        return em.find(Roles.class, id);
    }

    public List<Roles> findAllOrderedByDescripcion() {
        TypedQuery<Roles> tq = em.createQuery("Select r from Roles r", Roles.class);
        return tq.getResultList();

    }

}
