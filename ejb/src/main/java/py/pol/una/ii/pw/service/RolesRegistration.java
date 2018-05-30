package py.pol.una.ii.pw.service;
import py.pol.una.ii.pw.model.Roles;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * Created by Usuario on 02/08/2017.
 */
@Stateless
public class RolesRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Roles> memberEventSrc;

    public void register(Roles roles) throws Exception {
        log.info("Registrando ROL " + roles.getDescripcion());
        em.persist(roles);
        memberEventSrc.fire(roles);
    }

    public void update(Long id, Roles rol) throws Exception {
        log.info("Actualizando rol " + rol.getDescripcion());
        Roles r = em.find(Roles.class, id);
        r.setDescripcion(rol.getDescripcion());
        r.setPermisosList(rol.getPermisosList());
        em.merge(r);
        em.flush();
    }

    public void delete(Long id) throws Exception {
        Roles rol = em.find(Roles.class, id);
        log.info("Eliminando rol " + rol.getDescripcion());
        em.remove(rol);
    }
}
