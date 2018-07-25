package py.pol.una.ii.pw.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto implements Serializable{

	private static final long serialVersionUID = -2443259594173869324L;

	private Long prodCodigo;
	private String descripcion;
	private Integer cantidad;
	private Integer tipo;
	private Integer compra;
	private Integer venta;
	private Date fechaAlta;
	private Date fechaBaja;
	private Proveedor proveedor;
	
	public Producto() {
		
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_codigo_seq")
    @SequenceGenerator(name = "prod_codigo_seq", sequenceName = "prod_codigo_seq", allocationSize = 1, initialValue = 1)
    @Column(name="prod_codigo")
	public Long getProdCodigo() {
		return prodCodigo;
	}

	public void setProdCodigo(Long prodCodigo) {
		this.prodCodigo = prodCodigo;
	}

	@Column(name="prod_descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name="prod_cantidad")
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name="prod_tipo")
	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	@Column(name="prod_compra")
	public Integer getCompra() {
		return compra;
	}

	public void setCompra(Integer compra) {
		this.compra = compra;
	}

	@Column(name="prod_venta")
	public Integer getVenta() {
		return venta;
	}

	public void setVenta(Integer venta) {
		this.venta = venta;
	}

	@Column(name="prod_fecha_alta")
	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Column(name="prod_fecha_baja")
	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="prod_prov_codigo")
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
}
