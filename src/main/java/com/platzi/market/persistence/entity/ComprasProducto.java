package com.platzi.market.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="compras_productos")
public class ComprasProducto {
	@EmbeddedId
	private ComprasProductoPk id;
	
	private Integer cantidad;
	private Double total;
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name="id_compra",insertable = false,updatable = false)
    private Compra compra;
	
	@ManyToOne
	@JoinColumn(name="id_producto", insertable = false,updatable = false)
	private Producto producto;
	
	public ComprasProductoPk getId() {
		return id;
	}
	public void setId(ComprasProductoPk id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	


}
