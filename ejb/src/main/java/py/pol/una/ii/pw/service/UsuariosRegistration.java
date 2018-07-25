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
        em.persist(usuario);
        memberEventSrc.fire(usuario);
    }

    public void delete(Long id) {
        Usuario usuario = em.find(Usuario.class, id);
        
        em.remove(usuario);
    }

    public void update(Long id, Usuario usuario) {
        Usuario u = em.find(Usuario.class, id);
        
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
