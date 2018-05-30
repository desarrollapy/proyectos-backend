package py.pol.una.ii.pw.data;


import py.pol.una.ii.pw.model.Permisos;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@ApplicationScoped
public class PermisoRepository {
    @Inject
    private EntityManager em;

    public List<Permisos> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Permisos> criteria = cb.createQuery(Permisos.class);
        Root<Permisos> permisos = criteria.from(Permisos.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(permisos).orderBy(cb.asc(permisos.get("recurso")));
        return em.createQuery(criteria).getResultList();
    }

}
