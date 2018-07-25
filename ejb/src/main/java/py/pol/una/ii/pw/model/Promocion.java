package py.pol.una.ii.pw.model;

import java.io.Serializable;

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
@Table(name = "promocion")
public class Promocion implements Serializable {

	private static final long serialVersionUID = 3427994666477800527L;
	
	private Integer promCodigo;
	private String descripcion;
	private Integer cantidad;
	private Integer precio;
	private Producto producto;
	
	public Promocion() {
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prom_codigo_seq")
    @SequenceGenerator(name = "prom_codigo_seq", sequenceName = "prom_codigo_seq", allocationSize = 1, initialValue = 1)
    @Column(name="prom_codigo")
	public Integer getPromCodigo() {
		return promCodigo;
	}

	public void setPromCodigo(Integer promCodigo) {
		this.promCodigo = promCodigo;
	}

	@Column(name="prom_descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name="prom_cantidad")
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name="prom_precio")
	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="prom_prod_codigo")
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	
}
