package model.entities;

import java.util.Objects;

public class Pedidos {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer idCLiente;
	private Integer idProduto;
	
	public Pedidos() {
	}

	public Pedidos(Integer id, Integer idCLiente, Integer idProduto) {
		super();
		this.id = id;
		this.idCLiente = idCLiente;
		this.idProduto = idProduto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCLiente() {
		return idCLiente;
	}

	public void setIdCLiente(Integer idCLiente) {
		this.idCLiente = idCLiente;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, idCLiente, idProduto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedidos other = (Pedidos) obj;
		return Objects.equals(id, other.id) && Objects.equals(idCLiente, other.idCLiente)
				&& Objects.equals(idProduto, other.idProduto);
	}

	@Override
	public String toString() {
		return "Pedidos [id=" + id + ", idCLiente=" + idCLiente + ", idProduto=" + idProduto + "]";
	}
	
	
}
