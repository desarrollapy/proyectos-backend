package py.pol.una.ii.pw.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable{

	private static final long serialVersionUID = 7287785120734255245L;
	
	private Integer provCodigo;
	private String ruc;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private String web;
	private Date fechaAlta;
	
	public Proveedor() {
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prov_codigo_seq")
    @SequenceGenerator(name = "prov_codigo_seq", sequenceName = "prov_codigo_seq", allocationSize = 1, initialValue = 1)
    @Column(name="prov_codigo")
	public Integer getProvCodigo() {
		return provCodigo;
	}

	public void setProvCodigo(Integer provCodigo) {
		this.provCodigo = provCodigo;
	}

	@Column(name="prov_ruc")
	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	@Column(name="prov_nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name="prov_direccion")
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Column(name="prov_telefono")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name="prov_email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="prov_web")
	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}
	
	@Column(name="prov_fecha_alta")
	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
