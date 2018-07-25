package py.pol.una.ii.pw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Usuario on 02/08/2017.
 */
@Entity
@XmlRootElement
@Table(name = "usuario")
public class Usuario implements Serializable{
    
	private static final long serialVersionUID = 1661689693653129956L;
	
	private Long usuCodigo;
    private String usuPass;
    private Date usuFechaAlta;
    private Empleado empleado;
    private TipoUsuario tipoUsuario;
    

    public Usuario() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usu_codigo_seq")
    @SequenceGenerator(name = "usu_codigo_seq", sequenceName = "usu_codigo_seq", allocationSize = 1, initialValue = 1)
    @Column(name="usu_codigo")
	public Long getUsuCodigo() {
		return usuCodigo;
	}


	public void setUsuCodigo(Long usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	@Column(name="usu_pass")
	public String getUsuPass() {
		return usuPass;
	}


	public void setUsuPass(String usuPass) {
		this.usuPass = usuPass;
	}

	@Column(name="usu_fecha_alta")
	public Date getUsuFechaAlta() {
		return usuFechaAlta;
	}


	public void setUsuFechaAlta(Date usuFechaAlta) {
		this.usuFechaAlta = usuFechaAlta;
	}

	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="usu_emp_cedula")
	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="usu_tusu_codigo")
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
