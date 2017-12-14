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
@Table(name = "vacina")
@NamedQueries({
	@NamedQuery(name = "Vacina.listar", query = "SELECT vacina FROM Vacina vacina"),
	@NamedQuery(name = "Vacina.buscarPorId", query = "SELECT vacina FROM Vacina vacina WHERE vacina.idVacina = :idVacina")
})
public class Vacina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_vacina")
	private Long idVacina;
	
	@Column(name = "nome_vaciana", length = 60, nullable = false)
	private String nomeVaciana;
	
	@Column(name = "dosagem", length = 6, nullable = false)
	private String dosagem;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_validade", nullable = false)
	private Date dataValidade;
	
	@Column(name = "especificacao", length = 60, nullable = false)
	private String especificacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario")
	private Usuario usuario;

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

	@Override
	public String toString() {
		return "Vacina [idVacina=" + idVacina + ", nomeVaciana=" + nomeVaciana + ", dosagem=" + dosagem
				+ ", dataValidade=" + dataValidade + ", especificacao=" + especificacao + ", usuario=" + usuario + "]";
	}
	
}
