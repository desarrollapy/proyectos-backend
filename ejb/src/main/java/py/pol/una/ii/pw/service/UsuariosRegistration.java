package py.pol.una.ii.pw.service;
import py.pol.una.ii.pw.model.Usuario;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import java.security.MessageDigest;

/**
 * Created by Usuario on 02/08/2017.
 */
@Stateless
public class UsuariosRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Usuario> memberEventSrc;

    public void register(Usuario usuario) throws Exception {
        usuario.setPassword(toSHA(usuario.getPassword()));
        log.info("Registrando USuario " + usuario.getNombre() + " " +usuario.getApellido());
        em.persist(usuario);
        memberEventSrc.fire(usuario);
    }

    public void delete(Long id) {
        Usuario usuario = em.find(Usuario.class, id);
        log.info("Eliminando usuario: " + usuario.getApellido() + "," + usuario.getNombre());
        em.remove(usuario);
    }

    public void update(Long id, Usuario usuario) {
        Usuario u = em.find(Usuario.class, id);
        log.info("Actualizando usuario" + u.getNombre() + " " + u.getApellido());
        u.setNombre(usuario.getNombre());
        u.setApellido(usuario.getApellido());
        u.setEmail(usuario.getEmail());
        u.setRoles(usuario.getRoles());
        em.merge(u);
        em.flush();
    }

    public String toSHA(String password){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(password.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return  sb.toString();
    }

}
