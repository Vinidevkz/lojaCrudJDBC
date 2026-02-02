package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String email;
	private List<Produto> produtos = new ArrayList<>();  
	
	public Cliente() {	
	}

	public Cliente(Integer id, String name, String email, List<Produto> produtos) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.produtos = produtos;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", name=" + name + ", email=" + email + ", produtos=" + produtos + "]";
	}
	
	
}
