package br.com.engenhariareversa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQueries({
		@NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario"),
		@NamedQuery(name = "Usuario.buscarPorId", query = "SELECT usuario FROM Usuario usuario WHERE usuario.idUsuario = :idUsuario")
})
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@Column(name = "nome", length = 60, nullable = false)
	private String nome;

	@Column(name = "cpf", length = 11, nullable = false)
	private String cpf;

	@Column(name = "email", length = 30, nullable = false)
	private String email;
	
	@Column(name = "senha", length = 20, nullable = false)
	private String senha;

	@Column(name = "endereco", length = 100, nullable = false)
	private String endereco;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha="
				+ senha + ", endereco=" + endereco + "]";
	}

	

}
