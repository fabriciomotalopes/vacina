package br.com.engenhariareversa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "animal")
@NamedQueries({
	@NamedQuery(name = "Animal.listar", query = "SELECT animal FROM Animal animal"),
	@NamedQuery(name = "Animal.buscarPorId", query = "SELECT animal FROM Animal animal WHERE animal.idAnimal = :idAnimal")
})
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_animal")
	private Long idAnimal;

	@Column(name = "classificacao", length = 8, nullable = false)
	private String classificacao;

	@Column(name = "genero", length = 4, nullable = false)
	private String genero;

	@Column(name = "peso", precision = 7, scale = 3, nullable = false)
	private Double peso;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_nasc", nullable = false)
	private Date dataNascimento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario")
	private Usuario usuario;

	public Long getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Long idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Animal [idAnimal=" + idAnimal + ", classificacao=" + classificacao + ", genero=" + genero + ", peso="
				+ peso + ", dataNascimento=" + dataNascimento + ", usuario=" + usuario + "]";
	}
	
}
