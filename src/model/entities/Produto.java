package model.entities;

import java.util.Objects;

public class Produto {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String descricao;
	private Double preco;
	private Integer idCategoria;
	
	public Produto() {	
	}



	public Produto(Integer id, String name, String descricao, Double preco, Integer idCategoria) {
		super();
		this.id = id;
		this.name = name;
		this.descricao = descricao;
		this.preco = preco;
		this.idCategoria = idCategoria;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", name=" + name + ", descricao=" + descricao + ", idCategoria=" + idCategoria + "]";
	}
	
	
}
