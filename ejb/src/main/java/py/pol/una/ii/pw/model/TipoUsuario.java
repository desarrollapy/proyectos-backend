package py.pol.una.ii.pw.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario implements Serializable{

	private static final long serialVersionUID = -1366837213156327849L;
	
	private Long tUsuCodigo;
    private String tUsuDescripcion;
    private List<Permisos> permisosList = new ArrayList<Permisos>();
	
    
    
    public TipoUsuario() {
		
	}
    
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tusu_cod_seq")
    @SequenceGenerator(name = "tusu_cod_seq", sequenceName = "tusu_cod_seq", allocationSize = 1, initialValue = 1)
    @Column(name="tusu_codigo")
    public Long gettUsuCodigo() {
		return tUsuCodigo;
	}
	public void settUsuCodigo(Long tUsuCodigo) {
		this.tUsuCodigo = tUsuCodigo;
	}
	
	@Column(name="tusu_descripcion")
    public String gettUsuDescripcion() {
		return tUsuDescripcion;
	}
	public void settUsuDescripcion(String tUsuDescripcion) {
		this.tUsuDescripcion = tUsuDescripcion;
	}
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "rol_has_permiso",joinColumns = {@JoinColumn(name = "tusu_tusucodigo", referencedColumnName = "tusu_codigo")},
            inverseJoinColumns = {@JoinColumn(name = "permiso_idpermiso", referencedColumnName = "id_permiso")})
    public List<Permisos> getPermisosList() {
		return permisosList;
	}
	public void setPermisosList(List<Permisos> permisosList) {
		this.permisosList = permisosList;
	}

}
