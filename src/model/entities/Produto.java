package model.entities;

import java.util.Objects;

public class Produto {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String descricao;
	private Categoria categoria;
	
	public Produto() {	
	}

	public Produto(Integer id, String name, String descricao, Categoria categoria) {
		super();
		this.id = id;
		this.name = name;
		this.descricao = descricao;
		this.categoria = categoria;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		return "Produto [id=" + id + ", name=" + name + ", descricao=" + descricao + ", categoria=" + categoria + "]";
	}
	
	
}
