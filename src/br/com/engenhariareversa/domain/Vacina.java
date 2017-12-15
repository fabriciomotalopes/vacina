package br.com.engenhariareversa.domain;

import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "vacina")
@NamedQueries({ @NamedQuery(name = "Vacina.listar", query = "SELECT vacina FROM Vacina vacina"),
		@NamedQuery(name = "Vacina.buscarPorId", query = "SELECT vacina FROM Vacina vacina WHERE vacina.idVacina = :idVacina") })
public class Vacina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_vacina")
	private Long idVacina;

	@NotEmpty(message = "O campo nome da vacina é Obrigatório.")
	@Size(min = 1, max = 60, message = "Quanitidade de caracteres Inválido.")
	@Column(name = "nome_vaciana", length = 60, nullable = false)
	private String nomeVaciana;

	@NotEmpty(message = "O campo dosagem é Obrigatório.")
	@Size(min = 1, max = 6, message = "Quanitidade de caracteres Inválido.")
	@Column(name = "dosagem", length = 6, nullable = false)
	private String dosagem;

	@NotNull(message = "O campo data de validade é Obrigatório.")
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_validade", nullable = false)
	private Date dataValidade;

	@NotEmpty(message = "O campo especificação é Obrigatório.")
	@Size(min = 1, max = 60, message = "Quanitidade de caracteres Inválido.")
	@Column(name = "especificacao", length = 60, nullable = false)
	private String especificacao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario")
	private Usuario usuario;

	@OneToMany(mappedBy = "vacina", fetch = FetchType.LAZY)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<AnimalVacinacao> animalVacinacaos;

	public Long getIdVacina() {
		return idVacina;
	}

	public void setIdVacina(Long idVacina) {
		this.idVacina = idVacina;
	}

	public String getNomeVaciana() {
		return nomeVaciana;
	}

	public void setNomeVaciana(String nomeVaciana) {
		this.nomeVaciana = nomeVaciana;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<AnimalVacinacao> getAnimalVacinacaos() {
		return animalVacinacaos;
	}

	public void setAnimalVacinacaos(List<AnimalVacinacao> animalVacinacaos) {
		this.animalVacinacaos = animalVacinacaos;
	}

	@Override
	public String toString() {
		return "Vacina [idVacina=" + idVacina + ", nomeVaciana=" + nomeVaciana + ", dosagem=" + dosagem
				+ ", dataValidade=" + dataValidade + ", especificacao=" + especificacao + ", usuario=" + usuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVacina == null) ? 0 : idVacina.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacina other = (Vacina) obj;
		if (idVacina == null) {
			if (other.idVacina != null)
				return false;
		} else if (!idVacina.equals(other.idVacina))
			return false;
		return true;
	}
	
	
	
	

}
