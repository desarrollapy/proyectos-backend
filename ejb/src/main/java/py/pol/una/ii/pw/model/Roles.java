package py.pol.una.ii.pw.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 31/07/2017.
 */
@Entity
@XmlRootElement
@Table(name = "roles")
public class Roles implements Serializable{
	
    private static final long serialVersionUID = 5593933027207123244L;
	
	private Long idRol;
    private String descripcion;
    private List<Permisos> permisosList = new ArrayList<Permisos>();

    public Roles(Long idRol, String descripcion, List<Permisos> permisosList) {
        this.idRol = idRol;
        this.descripcion = descripcion;
        this.permisosList = permisosList;
    }

    public Roles() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_rol_seq")
    @SequenceGenerator(name = "id_rol_seq", sequenceName = "id_rol_seq", allocationSize = 1, initialValue = 1)
    @Column(name="id_rol")
    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    @Column(name="descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "rol_has_permiso",joinColumns = {@JoinColumn(name = "rol_idrol", referencedColumnName = "id_rol")},
            inverseJoinColumns = {@JoinColumn(name = "permiso_idpermiso", referencedColumnName = "id_permiso")})
    public List<Permisos> getPermisosList() {
        return permisosList;
    }

    public void setPermisosList(List<Permisos> permisosList) {
        this.permisosList = permisosList;
    }
}
