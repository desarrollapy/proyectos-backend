package py.pol.una.ii.pw.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Juan Britez - Emilce Fernandez on 31/07/2017.
 */
@Entity
@XmlRootElement
@Table(name = "permisos")
public class Permisos implements Serializable {
	
	private static final long serialVersionUID = -4508758844538329652L;
	
	private Long idPermiso;
    private String recurso;
    private String accion;
    private String url;
    private String method;
    private Boolean activo;

    public Permisos(Long idPermiso, String recurso, String accion, Boolean activo) {
        this.idPermiso = idPermiso;
        this.recurso = recurso;
        this.accion = accion;
        this.activo = activo;
    }

    public Permisos() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_permiso_seq")
    @SequenceGenerator(name = "id_permiso_seq", sequenceName = "id_permiso_seq", allocationSize = 1, initialValue = 1)
    @Column(name="id_permiso")
    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    @Column(name="recurso")
    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    @Column(name="accion")
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    @Column(name="activo")
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Column(name="url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @Column(name="method")
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
